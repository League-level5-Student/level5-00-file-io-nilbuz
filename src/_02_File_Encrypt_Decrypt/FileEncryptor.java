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
		System.out.println(msg);

		char[] msgArray = msg.toCharArray();
		for (int i = 0 ; i < msgArray.length;i++) {

			msgArray[i]++;

		}

		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/msg.txt");

			System.out.println(msgArray);
			
			fw.write(msgArray);
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
