package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.

	static String fileName = "";
	static int charCount = 0;
	static char[] msgArray;

	FileDecryptor() {
		
	}

	public static void main(String[] args) {

		
		JFileChooser chooser = new JFileChooser();
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
				c = fr.read();
			}

			msgArray = new char[charCount];

			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
