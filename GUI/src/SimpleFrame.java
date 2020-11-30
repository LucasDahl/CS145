import javax.swing.*;
import java.awt.*;

public class SimpleFrame {

    public static void main(String[] args) {

        JFrame myFrame = new JFrame();
        // What happens when it closes.
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("My program");
        myFrame.setSize(new Dimension(300, 300));
        myFrame.setVisible(true);

    }
}
