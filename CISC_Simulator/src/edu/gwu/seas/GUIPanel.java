package GUI;


import Simulator.Instructions;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Siyuan Zhang on 09/15/2019
 */
public class GUIPanel extends JFrame {
    private JPanel panelView;
    private JList console;
    private DefaultListModel consoleMode;

    private JTextField inputConsole;

    private JButton runButton;


//  class main to start the GUI
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUIPanel panel = new GUIPanel();
            panel.setVisible(true);
        });
    }

    public GUIPanel() {
        // Container Initializer
        this.setTitle("CISC Simulator");
        this.setBounds(0, 0, 1200, 750);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Panel View Initializer
        this.panelView = new JPanel();
        this.panelView.setBounds(10, 10, 10, 10);
        this.setContentPane(panelView);
        this.panelView.setLayout(null);

        // Title Label Initializer
        JLabel titleLabel = new JLabel("CISC Simulator");
        titleLabel.setFont(new Font("Avenir", 0, 45));
        titleLabel.setHorizontalAlignment(0);
        titleLabel.setBounds(13, 35, 350, 45);
        this.panelView.add(titleLabel);

        // Console Initializer
        InitConsole();
        // Input Console Initializer
        InitInputConsole("Please type 16 bits instruction", true);
        // Buttons Initializer
        InitButton();
        // CPU Initializer
//        InitCPU();

//        this.OPCodeTag = false;
//        this.Program2Tag = false;
//        this.Program4Tag = false;
    }

    /*
     * Initialize all buttons on the panel view
     */
    private void InitButton() {
        // Run button initializer
        runButton = new JButton("Run");
        runButton.setFont(new Font("Avenir", 0, 15));
        runButton.setBounds(30, 640, 100, 50);
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panelView.add(runButton);
    }


    /*
     * Initialize all separators on the panel view
     */
    private void InitSeparator() {
        // Separator-1 Initializer
        JSeparator separator1 = new JSeparator();
        separator1.setBounds(0, 100, 1200, 10);
        separator1.setBackground(Color.gray);
        this.panelView.add(separator1);

        // Separator 2 Initializer
        JSeparator separator2 = new JSeparator();
        separator2.setBounds(0, 450, 1200, 10);
        separator2.setBackground(Color.gray);
        panelView.add(separator2);
    }

    /*
     * Set message in the console
     */
    private void setMessage(String msg) {
        msg = "CISC SimulatorX Console: " + msg;
        consoleMode.addElement(msg);
        console.ensureIndexIsVisible(console.getModel().getSize() - 1);
    }

    /*
     * Initialize console on the panel view
     */
    private void InitConsole() {
        consoleMode = new DefaultListModel();
        console = new JList(consoleMode);
        console.setFont(new Font("Menlo", 0, 12));
        console.setForeground(Color.black);
        console.setBackground(Color.white);
        console.setOpaque(true);
        console.setBounds(150, 480, 1030, 160);
        console.setLayoutOrientation(0);

        JScrollPane test = new JScrollPane(console);
        test.setBounds(150, 480, 1030, 160);
        test.getVerticalScrollBar().addAdjustmentListener(
                e -> e.getAdjustable().setValue(e.getAdjustable().getValue()));
        panelView.add(test);
    }

    /*
     * Initialize input console on panel view
     */
    private void InitInputConsole(String hint, boolean editable) {
        if (inputConsole != null) {
            panelView.remove(inputConsole);
        }
        inputConsole = new JTextField(hint);
        inputConsole.setEditable(editable);
        inputConsole.setFont(new Font("Menlo", 0, 12));
        inputConsole.setCaretColor(Color.black);
        inputConsole.setForeground(Color.black);
        inputConsole.setBackground(Color.white);
        inputConsole.setOpaque(true);
        inputConsole.setBounds(150, 640, 1030, 40);
        panelView.add(inputConsole);
        setMessage("Please type 16 bits instruction");

        /*
         * MouseListener to clear the hint
         */
        inputConsole.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (inputConsole.isEditable()) {
                    inputConsole.setText("");
                }
            }
        });
        /*
         * ActionListener for data input
         */
        inputConsole.addActionListener(e -> {
            if (inputConsole.getText().length() != 16) {
                setMessage("Invalid Instruction, please type again.");
            } else {
                Instructions instruction = new Instructions(inputConsole.getText());
                String opCode = instruction.getOpCode();
                String r = instruction.getR();
                String ix = instruction.getIx();
                String i = instruction.getI();
                String address = instruction.getAddress();
                //need implement more.....
            }
        });

    }
}