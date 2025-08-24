package gui;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Font;
import javax.swing.JLabel;

public class RoundedLabel extends JLabel {

    public RoundedLabel() {
        init();
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:999");
        setFont(new Font("Arial", Font.BOLD, 14));
    }

}
