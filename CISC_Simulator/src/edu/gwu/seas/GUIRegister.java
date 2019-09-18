package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Siyuan Zhang on 09/14/2019
 */
public class GUIRegister extends JComponent {
    private JLabel titleLabel;
    public JLabel[] registers;

    public GUIRegister(String name, int count, int x, int y) {
        // GUIRegister Title Initializer
        this.titleLabel = new JLabel(name);
        this.titleLabel.setBounds(x - 60, y, 35, 25);
        this.titleLabel.setFont(new Font("Avenir", 0, 15));
        this.titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.titleLabel.setVerticalAlignment(SwingConstants.CENTER);

    }

    public void setValue(String in) {
        assert in.length() == registers.length;

        for (int i = 0; i < in.length(); i++) {
            registers[i].setText(String.valueOf(in.charAt(i)));
        }
    }

    public void resetValue() {
        for (int i = 0; i < registers.length; i++) {
            registers[i].setText("0");
        }
    }

    /***
     * @param view The superview which to be added the target component
     */
    public void addToView(JPanel view) {
        view.add(titleLabel);
        for (int i = 0; i < registers.length; i++) {
            view.add(registers[i]);
        }
    }


}