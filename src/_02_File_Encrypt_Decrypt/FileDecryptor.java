package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.

	static String fileName = "";
	static int charCount = 0;
	static char[] msgArray;
	static ArrayList<Character> msgArrayList = new ArrayList<Character>();

	FileDecryptor() {

	}

	public static void main(String[] args) {

		System.out.println("started");

		JFileChooser chooser = new JFileChooser();
		System.out.println("a");
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = chooser.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}

		try {
			FileReader fr = new FileReader(fileName);

			int c = fr.read();
			while (c != -1) {
				System.out.println((char) c);
				charCount++;
				msgArrayList.add((char) c);
				c = fr.read();
			}
			
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		msgArray = new char[charCount];
		
		for (int i = 0 ; i < msgArrayList.size(); i++) {
			
			msgArray[i] = msgArrayList.get(i);
			msgArray[i]--;
			System.out.println(msgArray[i]);
			
		}
		
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.append("\n");
			fw.write(msgArray);
			fw.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
