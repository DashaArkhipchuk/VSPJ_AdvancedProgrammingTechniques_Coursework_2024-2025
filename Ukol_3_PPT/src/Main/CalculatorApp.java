package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * A simple and elegant calculator GUI using Java Swing.
 * Allows basic arithmetic operations (+, -, *, /) with two decimal rounding.
 */
public class CalculatorApp {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 220);
        frame.setLocationRelativeTo(null); // Center the window

        // Create a panel with GridBagLayout for better control
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 250)); // Soft background color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input fields
        JTextField num1Field = new JTextField(10);
        num1Field.setName("num1Field");

        JTextField num2Field = new JTextField(10);
        num2Field.setName("num2Field");

        // Operation selection
        JComboBox<String> operationBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        operationBox.setName("operationBox");

        // Calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBackground(new Color(70, 130, 180));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.setName("calculateButton");

        // Result label
        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        resultLabel.setName("resultLabel");

        // Add components to panel
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Number 1:"), gbc);
        gbc.gridx = 1;
        panel.add(num1Field, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Operation:"), gbc);
        gbc.gridx = 1;
        panel.add(operationBox, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Number 2:"), gbc);
        gbc.gridx = 1;
        panel.add(num2Field, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panel.add(calculateButton, gbc);

        gbc.gridy = 4;
        panel.add(resultLabel, gbc);

        // Add button logic
        calculateButton.addActionListener((ActionEvent e) -> {
            try {
                double a = Double.parseDouble(num1Field.getText());
                double b = Double.parseDouble(num2Field.getText());
                String op = (String) operationBox.getSelectedItem();

                double result = switch (op) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> (b != 0) ? a / b : Double.NaN;
                    default -> 0;
                };
                resultLabel.setText("Result: " + Math.round(result * 100.0) / 100.0);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input! Please enter numbers.");
            }
        });

        // Finalize frame
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}