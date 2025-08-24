
package components;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JFormattedTextField;


public class RoundedFormattedTextField extends JFormattedTextField {
    
    public RoundedFormattedTextField(){
        init();
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:20");
    }
    
    
}
