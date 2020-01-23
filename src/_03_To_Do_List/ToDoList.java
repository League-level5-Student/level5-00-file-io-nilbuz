package _03_To_Do_List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	JFrame frame = new JFrame();
//	JFrame frame2 = new JFrame();
	JPanel panel = new JPanel();
//	JPanel panel2 = new JPanel();
	JLabel label = new JLabel();
	JButton addTask = new JButton();
	JButton viewTasks = new JButton();
	JButton removeTask = new JButton();
	JButton saveList = new JButton();
	JButton loadList = new JButton();

	ArrayList<String> tasks = new ArrayList<String>();

	ToDoList() {

		panel.setName("To-do list");

		addTask.setText("Add a task");
		viewTasks.setText("Update tasks");
		removeTask.setText("Remove a task");
		saveList.setText("Save list");
		loadList.setText("Load list");

		addTask.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);

		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);

		frame.add(panel);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		loadList("/Users/league/Desktop/level5-00-file-io-nilbuz/src/_03_To_Do_List/list.txt");

	}

	public static void main(String[] args) {

		ToDoList list = new ToDoList();

	}

	public void viewTasks() {
		// System.out.println("view tasks");
		label.setText("");
		for (int i = 0; i < tasks.size(); i++) {
			label.setText(label.getText() + " " + (i + 1) + ". " + tasks.get(i));
		}

		if (label.getText() == "") {
			label.setText("List empty.");
		}

		panel.add(label);
		frame.pack();

//		panel2.add(label);
//		frame2.add(panel2);
//		frame2.pack();
//		panel2.setVisible(true);
//		frame2.setVisible(true);
	}

	public void loadList(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			tasks.clear();
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				tasks.add(line);
				line = br.readLine();

			}

			br.close();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "File not found");

		} catch (IOException ex) {

		}

		viewTasks();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addTask) {
			String task = JOptionPane.showInputDialog("Please write the task");
			tasks.add(task);
			viewTasks();
		}
		if (e.getSource() == viewTasks) {

			viewTasks();

		}
		if (e.getSource() == removeTask) {

			viewTasks();
			try {
				int taskRemoved = Integer.parseInt(JOptionPane.showInputDialog("Which task would you like to remove?"));
				tasks.remove(taskRemoved - 1);
				viewTasks();
			} catch (NumberFormatException ex) {

			} catch (IndexOutOfBoundsException ex) {

				JOptionPane.showMessageDialog(null, "That task isn't on the list!");

			}
		}
		if (e.getSource() == saveList) {

			try {
				FileWriter fw = new FileWriter(
						"/Users/league/Desktop/level5-00-file-io-nilbuz/src/_03_To_Do_List/list.txt");
				for (int i = 0; i < tasks.size(); i++) {
					fw.write(tasks.get(i) + "\n");
				}
				fw.close();

				label.setText(label.getText() + " List saved!");
				frame.pack();

			} catch (IOException e1) {

			}

		}

		if (e.getSource() == loadList) {

			String fileName = "";

			JFileChooser chooser = new JFileChooser();
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fileName = chooser.getSelectedFile().getAbsolutePath();
				System.out.println(fileName);
			}

			loadList(fileName);

		}

	}
}
