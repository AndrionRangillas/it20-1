package topic_3_stack_calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class StackCalculator extends JFrame {
    private Stack<Double> stack;
    private JTextField inputField;

    public StackCalculator() {
        // Initialize the stack
        stack = new Stack<>();
        
        /// Create the user interface
        setTitle("Stack Calculator");
        setSize(400, 400);  // Increase size to give more space for the answer
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

     // Input field for displaying the result at the bottom
        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setHorizontalAlignment(JTextField.RIGHT);  // Align text to the right
        inputField.setFont(new Font("Arial", Font.BOLD, 40));  // Increase the font size to make the result display bigger
        add(inputField, BorderLayout.SOUTH);  // Place the input field at the bottom (South)

        
     // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4)); // Updated layout to fit more buttons
        addButtons(buttonPanel);
        
        // Add button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void addButtons(JPanel panel) {
        // Create number buttons
        for (int i = 0; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new NumberButtonListener());
            panel.add(button);
        }

        // Create operation buttons
        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");

        addButton.addActionListener(new OperationButtonListener('+'));
        subtractButton.addActionListener(new OperationButtonListener('-'));
        multiplyButton.addActionListener(new OperationButtonListener('*'));
        divideButton.addActionListener(new OperationButtonListener('/'));

        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);

        // Add equals, delete, and clear buttons
        JButton equalsButton = new JButton("=");
        JButton deleteButton = new JButton("DEL");
        JButton clearButton = new JButton("C");

        equalsButton.addActionListener(new EqualsButtonListener());
        deleteButton.addActionListener(new DeleteButtonListener());
        clearButton.addActionListener(new ClearButtonListener());

        panel.add(equalsButton);
        panel.add(deleteButton);
        panel.add(clearButton);
    }

    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            inputField.setText(inputField.getText() + command);
        }
    }

    private class OperationButtonListener implements ActionListener {
        private char operation;

        public OperationButtonListener(char operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!inputField.getText().isEmpty()) {
                double value = Double.parseDouble(inputField.getText());
                stack.push(value);
                inputField.setText("");

                if (stack.size() >= 2) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = performOperation(a, b, operation);
                    stack.push(result);
                    inputField.setText(String.valueOf(result));
                }
            }
        }
    }

    private double performOperation(double a, double b, char operation) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0) {
                    return a / b;
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                    stack.push(a); // push back the value
                    stack.push(b);
                    return 0;
                }
            default:
                return 0;
        }
    }

    // Equals Button: Perform operation or push final value
    private class EqualsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!inputField.getText().isEmpty()) {
                double value = Double.parseDouble(inputField.getText());
                stack.push(value);  // Push the final value onto the stack
                inputField.setText(""); // Clear input after pressing equals

                if (stack.size() >= 2) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = performOperation(a, b, '+');  // Default to addition after "="
                    stack.push(result);
                    inputField.setText(String.valueOf(result)); // Show the result
                }
            }
        }
    }

    // Delete Button: Remove the last character from the input field
    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = inputField.getText();
            if (!currentText.isEmpty()) {
                inputField.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
    }

    // Clear Button: Clear the input field and reset the stack
    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            inputField.setText("");
            stack.clear();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StackCalculator calculator = new StackCalculator();
            calculator.setVisible(true);
        });
    }
}
