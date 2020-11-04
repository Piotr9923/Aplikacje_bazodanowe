package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {

    private JFrame frame;
    private MenuPanel menu;

    public MainView() {
        frame = new JFrame();

        frame.setTitle("Biblioteka");
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setVisible(true);
        
        menu = new MenuPanel(frame.getWidth());

        frame.getContentPane().setLayout(null);

        frame.add(menu);

    }

    public MenuPanel getMenuPanel(){
        
        return menu;
    }

}
