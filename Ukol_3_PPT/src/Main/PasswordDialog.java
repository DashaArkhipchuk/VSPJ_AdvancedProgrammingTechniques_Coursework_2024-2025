package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * A GUI dialog for secure password input with a show/hide toggle and password strength analysis.
 */
public class PasswordDialog {
    public static void main(String[] args) {
        // Create main window
        JFrame frame = new JFrame("Enter Password");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null); // Center the window

        // Panel with layout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(250, 250, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Password input
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setName("passwordField");

        // Checkbox to toggle visibility
        JCheckBox showPassword = new JCheckBox("Show Password");
        showPassword.setName("showPassword");

        // Label for strength feedback
        JLabel strengthLabel = new JLabel("Password Strength: ");
        strengthLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        strengthLabel.setName("strengthLabel");

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(70, 130, 180));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setName("submitButton");

        // Add components to panel
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(showPassword, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(submitButton, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(strengthLabel, gbc);

        // Toggle password visibility
        showPassword.addActionListener((ActionEvent e) -> {
            passwordField.setEchoChar(showPassword.isSelected() ? (char) 0 : '\u2022');
        });

        // Analyze password strength
        submitButton.addActionListener((ActionEvent e) -> {
            String password = new String(passwordField.getPassword());
            strengthLabel.setText("Password Strength: " + analyzeStrength(password));
        });

        // Finalize UI
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    /**
     * Analyzes the strength of the entered password based on character variety and length.
     *
     * @param password The entered password.
     * @return A string describing the strength: "Weak", "Medium", "Strong", "Very Strong".
     */
    private static String analyzeStrength(String password) {
        if (password.length() < 6) return "Weak";

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()].*");

        int score = (hasUpper ? 1 : 0) + (hasLower ? 1 : 0) + (hasDigit ? 1 : 0) + (hasSpecial ? 1 : 0);

        return switch (score) {
            case 4 -> "Very Strong";
            case 3 -> "Strong";
            case 2 -> "Medium";
            default -> "Weak";
        };
    }
}