import javax.swing.*; // Storage for most of the GUI stuff
import java.awt.*; // Used for some parts of GUI
import java.awt.event.*; // Basic event handling class, Note that it is not auto added when you add java.awt.*

public class SimpleFrame implements ActionListener {

    private JFrame myFrame;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel text1;
    private JTextField field1;

    public static void main(String[] args) {
        SimpleFrame gui = new SimpleFrame();
    }

    public SimpleFrame() {
        setup();
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
        JButton button1 = new JButton();
        button1.setText("Button #1");
        button1.setOpaque(true);
        button1.setBounds(10,10,150, 25);

        // Button 2
        JButton button2 = new JButton("Button #2");
        button2.setBounds(10,45,150, 25);

        // Button 3
        JButton button3 = new JButton("Button #3");
        button3.setBounds(10,80,200, 25);


        // Setup labels
        JLabel text1 = new JLabel();
        text1.setText("Hello word!");
        text1.setBounds(10, 200, 100, 25);

        // Setup textField
        JTextField field1 = new JTextField();
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
        // Fill in later
    }

}
