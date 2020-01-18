package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file

	public static void main(String[] args) {

		String msg = JOptionPane.showInputDialog("Please type your message");

		char[] msgArray = msg.toCharArray();
		for (Character c : msgArray) {

			c++;
			
		}
		
		
		
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/msg.txt");

			
			
			fw.write(msgArray);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
