import javax.swing.*; // Storage for most of the GUI stuff
import java.awt.*; // Used for some parts of GUI
import java.awt.event.*; // Basic event handling class, Note that it is not auto added when you add java.awt.*
import java.util.*;


public class SimpleFrame implements ActionListener {


    private JFrame myFrame;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel text1;
    private JTextField field1;

    private java.util.List<Integer> allQuizzes;
    private double quizGrade;

    public static void main(String[] args) {
        SimpleFrame gui = new SimpleFrame();
    }

    public SimpleFrame() {
        setup();
        allQuizzes = new ArrayList<Integer>();
    }

    public void setup() {

        // Usually add everything THEn make it visible

        JFrame myFrame = new JFrame();// Set up the frame
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// What happens when it closes.
        myFrame.setTitle("My program"); // Title
        myFrame.setSize(new Dimension(300, 300)); // Size of the window
        myFrame.setLocation(new Point(700, 350)); // Location it pops up

        // Setup buttons

        // Button 1
        button1 = new JButton();
        button1.setText("Add quiz to list");
        button1.setBounds(10,10,150, 25);
        button1.addActionListener(this);
        button1.setActionCommand("Button 1 pressed");

        // Button 2
        button2 = new JButton("Find average");
        button2.setBounds(10,45,150, 25);
        button2.addActionListener(this);
        button2.setActionCommand("Button 2 pressed");

        // Button 3
        button3 = new JButton("Reset");
        button3.setBounds(10,80,200, 25);
        button3.addActionListener(this);
        button3.setActionCommand("Button 3 pressed");


        // Setup labels
        text1 = new JLabel();
        text1.setText("Hello word!");
        text1.setBounds(10, 200, 100, 25);

        // Setup textField
        field1 = new JTextField();
        field1.setBounds(110, 200, 100, 25);

        // Add them to the frame
        myFrame.add(button1);
        myFrame.add(button2);
        myFrame.add(button3);
        myFrame.add(text1);
        myFrame.add(field1);

        // Change the layout - null is for full control.
        myFrame.setLayout(null);

        myFrame.setVisible(true); // Make it visible
    }

    public void actionPerformed(ActionEvent e) { // Needed for interface
        if(e.getActionCommand().equals("Button 1 pressed")) button1Pressed();
        else if(e.getActionCommand().equals("Button 2 pressed")) button2Pressed();
        else if(e.getActionCommand().equals("Button 3 pressed")) button3Pressed();
    }

    private void button1Pressed() {
        String temp = field1.getText();
        // Turn the string into an int
        int i = Integer.parseInt(temp);
        allQuizzes.add(i);
    }

    private void button2Pressed() {
         int total = 0;

         for(int i: allQuizzes) {
             total += i;
         }

         quizGrade = total * 1.0 / allQuizzes.size();

         text1.setText("" + quizGrade);
    }

    private void button3Pressed() {
        quizGrade = 0;
        allQuizzes.clear();
    }

}
