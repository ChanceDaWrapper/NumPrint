package hw5;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class NumPrint {

	private JFrame frame;
	private static JTextArea outputValue;
	private static String str;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumPrint window = new NumPrint();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NumPrint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 629, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		outputValue = new JTextArea();
		outputValue.setBounds(149, 56, 321, 100);
		frame.getContentPane().add(outputValue);
		
		JLabel lblNewLabel = new JLabel("The file included the numbers:");
		lblNewLabel.setBounds(228, 31, 144, 14);
		frame.getContentPane().add(lblNewLabel);

		//Calling our function to get everything going.
		grabFile();
		
		
	}
	
	public void grabFile() {

		//Creating our JFileChooser
		JFileChooser file = new JFileChooser();
		file.showOpenDialog(frame);
        
        //Calling a separate function so this is cleaner
        loadFile(file.getSelectedFile());

	}
	
	private void loadFile(File file) {
		//Creating the linked list
		Queue listData = new Queue();
        
		//try catch exception with the BufferedReader 
        try {
        	//Creating the BufferedReader
            BufferedReader reader = new BufferedReader(new FileReader(file));
            //Creating a string to read the line from the BufferedReader
            String line;
            //Reading the line, and adding each number to the linked list
            while ((line = reader.readLine()) != null) {
            	listData.enqueue(Integer.parseInt(line));
            }
            reader.close();
        //If it's unable to read the file
        } catch (Exception e) {
            System.out.println("Unable to read the file");
            e.printStackTrace();
        }
        
		//putting the numbers from the linked list to the text reader
		while(listData.isEmpty() != true) {
			int i = listData.dequeue();
			
			//There was a small error where the first value would return as null2. This fixes that as str did not exist yet.
			if(str == null)
				str = "" + i + ", ";
			else
				str += i + ", ";
		}
		//Setting the text box to the string we've created from the text file.
		outputValue.setText(str);;
	}
}
