import javax.swing.*; // Storage for most of the GUI stuff
import java.awt.*; // Used for some parts of GUI
import java.awt.event.*; // Basic event handling class, Note that it is not auto added when you add java.awt.*
import java.util.*;
/**
 *
 *
 * @author Lucas D. Dahl
 * @version 12/3/2020
 */
public class CardHeadGUI implements ActionListener {

    // **************************** Fields ****************************

    // GUI elements
    private JFrame cardGUIFrame;
    private JButton addButton;
    private JButton popButton;
    private JButton clearButton;
    private JLabel cardLabel;
    private JLabel lastRemovedLabel;
    private JLabel removedCardLabel;

    // Properties
    private CardHeap cards;
    private boolean flag = true;


    /**
     * This is the main method.
     * @param args the passed in arguments.
     */
    public static void main(String[] args) {
        CardHeadGUI gui = new CardHeadGUI();
    }


    // ************************** Constructors ************************

    /**
     * This is the default constructor.
     */
    public CardHeadGUI() {
        cards = new CardHeap();
        setUpGUI();
    }

    // **************************** Methods ***************************

    // Sets up the the GUI
    private void setUpGUI() {

        // Setup the frame.
        cardGUIFrame = new JFrame();
        cardGUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardGUIFrame.setTitle("CS 145 GUI Assignment Lucas Dahl");
        cardGUIFrame.setSize(new Dimension(1000, 225));
        cardGUIFrame.setLocation(new Point(700, 350));

        // Setup the buttons

        // Add button
        addButton = new JButton();
        addButton.setText("Add");
        addButton.setBounds(10,100,150, 25);
        addButton.addActionListener(this);
        addButton.setActionCommand("add");

        // Pop button
        popButton = new JButton();
        popButton.setText("Pop");
        popButton.setBounds(165,100,150, 25);
        popButton.addActionListener(this);
        popButton.setActionCommand("pop");

        // Clear button
        clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setBounds(310,100,150, 25);
        clearButton.addActionListener(this);
        clearButton.setActionCommand("clear");

        // Setup the labels

        cardLabel = new JLabel();
        cardLabel.setText(cards.toString());
        cardLabel.setBounds(75, 30, 1000, 25);

        lastRemovedLabel = new JLabel();
        lastRemovedLabel.setText("Last Removed: ");
        lastRemovedLabel.setBounds(75, 60, 100, 25);

        removedCardLabel = new JLabel();
        removedCardLabel.setText("");
        removedCardLabel.setBounds(170, 60, 100, 25);

        // Add the elements to the frame
        cardGUIFrame.add(addButton);
        cardGUIFrame.add(popButton);
        cardGUIFrame.add(clearButton);
        cardGUIFrame.add(cardLabel);
        cardGUIFrame.add(lastRemovedLabel);
        cardGUIFrame.add(removedCardLabel);

        // Change the layout - null is for full control.
        cardGUIFrame.setLayout(null);

        // Make it visible
        cardGUIFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) { // Needed for interface
        if(e.getActionCommand().equals("add")) addPressed();
        else if(e.getActionCommand().equals("pop")) popPressed();
        else if(e.getActionCommand().equals("clear")) clearPressed();
    }

    // Actions

    // Adding a card
    private void addPressed() {

        Card temp = new Card();
        cards.add(temp);
        cardLabel.setText(cards.toString());

    }

    // Popping a card
    private void popPressed() {

    }

    // Clearing the cards
    private void clearPressed() {

        cards = new CardHeap();
        cardLabel.setText("[]");
        removedCardLabel.setText("cleared");

    }

}
