package _03_To_Do_List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

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
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
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
		viewTasks.setText("View tasks");
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
		frame.pack();
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		ToDoList list = new ToDoList();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addTask) {
			String task = JOptionPane.showInputDialog("Please write the task");
			tasks.add(task);
		}
		if (e.getSource() == viewTasks) {
			
			
			panel2.add(label);
			frame.add(panel2);
		}
		if (e.getSource() == removeTask) {

		}
		if (e.getSource() == saveList) {

		}
		if (e.getSource() == loadList) {

		}

	}
}
