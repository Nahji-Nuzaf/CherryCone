
package gui;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JTextField;


public class RoundedTextfields extends JTextField{
    
    public RoundedTextfields(){
        init();
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:20");
    }
    
    
}
