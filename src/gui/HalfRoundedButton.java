
package gui;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JButton;


public class HalfRoundedButton  extends JButton{
    
    
    public HalfRoundedButton(){
        init();
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:15");
    }
 
}
