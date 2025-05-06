import javax.swing.*; // Importing Swing package for GUI
import java.awt.*; // Importing AWT package for layouts and colors
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Final_Code {

    int x=365;
    int y=60;

    Assignment2()
    {
        // Font Uploading ( Name it Custom Font
        Font customFont;
        try
        {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Tektur-Regular.ttf")).deriveFont(14f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        }
        catch (Exception e) {
            e.printStackTrace();
            customFont = new Font("SansSerif", Font.PLAIN, 14); // In error --> Upload Basic Font
        }



        // Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Daredevil");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setLayout(null);
        ImageIcon icon = new ImageIcon("5198971.png");
        frame.setIconImage(icon.getImage());

        // Panel
        JPanel panel1 = new JPanel();
        panel1.setLayout(null); // Absolute layout
        panel1.setBounds(0, 0, 500, 500);
        panel1.setBackground(Color.DARK_GRAY);

        // Component
        JLabel adding = new JLabel("    Evaluate My Assignment out of 5 ( Bouns Prefered )");
        adding.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        adding.setFont(customFont);
        adding.setForeground(Color.white);
        panel1.add(adding);
        adding.setBounds(10, 10, 400, 30);

        JTextField area = new JTextField();
        area.setBounds(10, 60, 30, 30);
        area.setFont(customFont);
        area.setForeground(Color.BLACK);
        panel1.add(area);

        JButton evaluate = new JButton("Evaluate");
        evaluate.setBounds(65, 60, 100, 30);
        evaluate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        evaluate.setBackground(Color.WHITE);
        evaluate.setForeground(Color.BLACK);
        panel1.add(evaluate);

        JLabel rate = new JLabel("Rate of Evaluation = ");
        rate.setForeground(Color.WHITE);
        rate.setFont(customFont.deriveFont(18f));
        rate.setBounds(180, 60, 500, 30);
        panel1.add(rate);

        JLabel resultrate = new JLabel("");
        resultrate.setForeground(Color.WHITE);
        resultrate.setFont(customFont.deriveFont(16f));
        resultrate.setBounds(x, y, 500, 30);
        panel1.add(resultrate);


        evaluate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int number = Integer.parseInt(area.getText().trim());
                    resultrate.setText(String.valueOf(number));

                    if (number > 5)
                    {
                        ImageIcon icon12 = new ImageIcon("558ea8f9ca6b8e7d05c8f74ce5b87fde.jpg");
                        JOptionPane.showMessageDialog(null, "Thanks For The Bonus <3", "Bonus!", JOptionPane.INFORMATION_MESSAGE, icon12);
                    }
                    else if(number < 5)
                    {
                        ImageIcon icon22 = new ImageIcon("7dfe415e53d89c988978e054d5df0f9f.jpg");
                        JOptionPane.showMessageDialog(null, "Any Chance For Bouns ?", "Bonus?", JOptionPane.INFORMATION_MESSAGE, icon22);
                    }

                } catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number!");
                }
            }
        });

        JLabel Ask = new JLabel("Do You Want To Evaluate My Assignment out of 5 ?");
        Ask.setFont(customFont.deriveFont(16f));
        Ask.setForeground(Color.WHITE);
        Ask.setBounds(10, 110, 500, 30);
        panel1.add(Ask);


        JRadioButton enable = new JRadioButton("Enable");
        enable.setForeground(Color.BLACK);
        enable.setFont(customFont.deriveFont(16f));
        enable.setBackground(Color.YELLOW);
        enable.setBounds(10, 150, 80, 30);
        panel1.add(enable);
        JRadioButton disable = new JRadioButton("Disable");
        disable.setForeground(Color.BLACK);
        disable.setFont(customFont.deriveFont(16f));
        disable.setBackground(Color.YELLOW);
        disable.setBounds(200, 150, 80, 30);
        panel1.add(disable);
        ButtonGroup group = new ButtonGroup(); // To Select one from ( enable or disable )
        group.add(enable);
        group.add(disable);

        enable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setEditable(true);
            }
        });

        disable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setEditable(false);
            }
        });

        JLabel Fonts = new JLabel("Fonts Type");
        Fonts.setFont(customFont.deriveFont(20f));
        Fonts.setForeground(Color.WHITE);
        Fonts.setBounds(180, 200, 500, 30);
        panel1.add(Fonts);

        JCheckBox Bold = new JCheckBox("Bold");
        Bold.setForeground(Color.BLACK);
        Bold.setFont(customFont.deriveFont(16f));
        Bold.setBackground(Color.cyan);
        Bold.setBounds(10, 250, 80, 30);
        panel1.add(Bold);
        JCheckBox Italic = new JCheckBox("Italic");
        Italic.setForeground(Color.BLACK);
        Italic.setFont(customFont.deriveFont(16f));
        Italic.setBackground(Color.cyan);
        Italic.setBounds(120, 250, 80, 30);
        panel1.add(Italic);
        JCheckBox Plain = new JCheckBox("Plain");
        Plain.setForeground(Color.BLACK);
        Plain.setFont(customFont.deriveFont(16f));
        Plain.setBackground(Color.cyan);
        Plain.setBounds(220, 250, 80, 30);
        panel1.add(Plain);
        JCheckBox Underline = new JCheckBox("Underline");
        Underline.setForeground(Color.BLACK);
        Underline.setFont(customFont.deriveFont(18f));
        Underline.setBackground(Color.cyan);
        Underline.setBounds(340, 250, 120, 30);
        panel1.add(Underline);

        ActionListener updateFont = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // If Plain is selected, reset all others
                if (Plain.isSelected()) {
                    Bold.setSelected(false);
                    Italic.setSelected(false);
                    Underline.setSelected(false);
                    resultrate.setFont(new Font("SansSerif", Font.PLAIN, 14));
                    resultrate.setText(resultrate.getText().replaceAll("<[^>]*>", ""));
                    return;
                }

                int style = Font.PLAIN;

                if (Bold.isSelected())
                {
                    style |= Font.BOLD;
                }
                if (Italic.isSelected())
                {
                    style |= Font.ITALIC;
                }

                Font combinedFont = new Font("SansSerif", style, 14);
                resultrate.setFont(combinedFont);

                String cleanText = resultrate.getText().replaceAll("<[^>]*>", "");
                if (Underline.isSelected()) {
                    resultrate.setText("<html><u>" + cleanText + "</u></html>");
                } else {
                    resultrate.setText(cleanText);
                }
            }
        };

        Bold.addActionListener(updateFont);
        Italic.addActionListener(updateFont);
        Underline.addActionListener(updateFont);
        Plain.addActionListener(updateFont);


        JLabel label = new JLabel("Click Here To Be RED");
        label.setFont(customFont.deriveFont(16f));
        label.setForeground(Color.WHITE);
        label.setBounds(10, 340, 600, 100);
        panel1.add(label);

        JButton button = new JButton("");
        button.setFont(customFont.deriveFont(16f));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.RED);
        button.setBounds(10, 340, 170, 30);
        panel1.add(button);

        JLabel label2 = new JLabel("Click Here To Be GREEN");
        label2.setFont(customFont.deriveFont(16f));
        label2.setForeground(Color.WHITE);
        button.setBackground(Color.RED);
        label2.setBounds(250, 340, 600, 100);
        panel1.add(label2);

        JButton button2 = new JButton("");
        button2.setFont(customFont.deriveFont(16f));
        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.GREEN);
        button2.setBounds(250, 340, 170, 30);
        panel1.add(button2);


        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                resultrate.setForeground(Color.RED);
            }
        });

        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                resultrate.setForeground(Color.GREEN);
            }
        });

        JButton Button3 = new JButton("SAVE");
        Button3.setFont(customFont.deriveFont(16f));
        Button3.setForeground(Color.WHITE);
        Button3.setBackground(Color.BLACK);
        Button3.setBounds(170, 420, 120, 20);
        panel1.add(Button3);

        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Saved Successfully <3");
            }
        });

        panel1.setFocusable(true);
        panel1.requestFocusInWindow(); // Make sure the panel has focus when the frame is shown.

        evaluate.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                // Handle key typed event if needed
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Check if the right arrow key is pressed
                if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    // Move the JLabel resultrate by 5 pixels to the right
                    x += 20; // Increase x-coordinate for resultrate
                    resultrate.setBounds(x, y, 500, 30); // Update position of resultrate
                }
                else if(e.getKeyCode() == KeyEvent.VK_LEFT)
                {
                    x -= 20;
                    resultrate.setBounds(x, y, 500, 30);
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP)
                {
                    y -= 20;
                    resultrate.setBounds(x, y, 500, 30);
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN)
                {
                    y += 20;
                    resultrate.setBounds(x, y, 500, 30);
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                // Handle key release if needed
            }
        });

// Ensure focusable behavior
        panel1.setFocusable(true);
        panel1.requestFocusInWindow();

        // Add panel to frame
        frame.add(panel1);

        // Make frame visible *after* everything is added
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Final_Code();
    }
}
