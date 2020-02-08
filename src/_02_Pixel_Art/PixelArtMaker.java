package _02_Pixel_Art;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;

public class PixelArtMaker implements MouseListener {
	private JFrame window;
	private GridInputPanel gip;
	public GridPanel gp = new GridPanel(500, 500, 3, 3);
	ColorSelectionPanel csp;

	public void start() {

		gip = new GridInputPanel(this);
		window = new JFrame("Pixel Art");
		window.setLayout(new FlowLayout());
		window.setResizable(false);

		window.add(gip);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public void submitGridData(int w, int h, int r, int c) {

		csp = new ColorSelectionPanel();
		window.remove(gip);
		window.add(gp);
		window.add(csp);
		gp.repaint();
		gp.addMouseListener(this);
		window.pack();
	}

	public void save() {
		try (FileOutputStream fos = new FileOutputStream(new File("src/_02_Pixel_Art/art.dat"));
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(gp);
			System.out.println("saved");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		try (FileInputStream fis = new FileInputStream(new File("src/_02_Pixel_Art/art.dat"));
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			gp = (GridPanel) ois.readObject();
			gp.repaint();
			System.out.println("loaded");
		} catch (IOException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		new PixelArtMaker().start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		gp.setColor(csp.getSelectedColor());
		// System.out.println(csp.getSelectedColor());
		gp.clickPixel(e.getX(), e.getY());
		gp.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
