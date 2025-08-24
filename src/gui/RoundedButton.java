
package gui;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JButton;


public class RoundedButton extends JButton{
    
    public RoundedButton(){
        init();
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:30");
    }
    
}
