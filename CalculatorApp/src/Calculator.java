import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;
    private JButton addButton, subButton, mulButton, divButton, modButton, clearButton;

    public Calculator() {
        createView();
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300); // Adjusted size for better layout
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel(new GridBagLayout());
        getContentPane().add(panel);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4, 4, 4, 4); // Margin around components

        // First Number
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("First Number:"), constraints);

        firstNumberField = new JTextField(10);
        constraints.gridx = 1; // Move text field to the right of label
        panel.add(firstNumberField, constraints);

        // Second Number
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Second Number:"), constraints);

        secondNumberField = new JTextField(10);
        constraints.gridx = 1; // Move text field to the right of label
        panel.add(secondNumberField, constraints);

        // Result
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Result:"), constraints);

        resultField = new JTextField(10);
        resultField.setEditable(false);
        constraints.gridx = 1; // Move text field to the right of label
        panel.add(resultField, constraints);

        // Configuring the button layout
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        clearButton = new JButton("Clear");

        // First column of buttons
        constraints.gridx = 0; // Aligning buttons under the first label
        constraints.gridy = 3;
        panel.add(addButton, constraints);
        constraints.gridy = 4;
        panel.add(mulButton, constraints);
        constraints.gridy = 5;
        panel.add(modButton, constraints);

        // Second column of buttons
        constraints.gridx = 1; // Aligning buttons under the text field
        constraints.gridy = 3;
        panel.add(subButton, constraints);
        constraints.gridy = 4;
        panel.add(divButton, constraints);
        constraints.gridy = 5;
        panel.add(clearButton, constraints);

        // Action listeners for the buttons
        addButton.addActionListener(e -> calculate('+'));
        subButton.addActionListener(e -> calculate('-'));
        mulButton.addActionListener(e -> calculate('*'));
        divButton.addActionListener(e -> calculate('/'));
        modButton.addActionListener(e -> calculate('%'));
        clearButton.addActionListener(e -> clearFields());
    }

    private void calculate(char operator) {
        double result = 0;
        double firstNumber = Double.parseDouble(firstNumberField.getText());
        double secondNumber = Double.parseDouble(secondNumberField.getText());

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
        }

        resultField.setText(String.valueOf(result));
    }

    private void clearFields() {
        firstNumberField.setText("");
        secondNumberField.setText("");
        resultField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
    }
}
