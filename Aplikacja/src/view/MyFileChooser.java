package view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyFileChooser {

    private int response;

    private JFrame frame;
    private JFileChooser fileChooser;
    private String path;
    
    public MyFileChooser(JFrame frame) {

        this.frame = frame;
        fileChooser = new JFileChooser();
    }
    
    public void showFileChooser(){
        
        response = fileChooser.showSaveDialog(frame);
        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            path = fileChooser.getSelectedFile().getAbsolutePath();
        }
    }
    
    public boolean isChoosen(){
        
        return (response == JFileChooser.APPROVE_OPTION);
    }

    public String getPath() {
        return path;
    }
    

}
