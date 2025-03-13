import javax.swing.*;
import java.awt.event.ActionListener;

class View {
    private JFrame frame;
    private JLabel nameLabel, durationLabel, singersLabel, scoreLabel;
    private JTextField nameField, durationField, singersField;
    private JButton submitButton;

    public View() {
        frame = new JFrame("Karaoke Score Calculator");
        frame.setLayout(null);
        frame.setSize(400, 300);

        nameLabel = new JLabel("Song Name:");
        nameLabel.setBounds(50, 50, 100, 20);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 20);
        frame.add(nameField);

        durationLabel = new JLabel("Duration (seconds):");
        durationLabel.setBounds(50, 80, 100, 20);
        frame.add(durationLabel);

        durationField = new JTextField();
        durationField.setBounds(150, 80, 200, 20);
        frame.add(durationField);

        singersLabel = new JLabel("Singers (comma-separated):");
        singersLabel.setBounds(50, 110, 150, 20);
        frame.add(singersLabel);

        singersField = new JTextField();
        singersField.setBounds(200, 110, 150, 20);
        frame.add(singersField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 150, 100, 30);
        frame.add(submitButton);

        scoreLabel = new JLabel("");
        scoreLabel.setBounds(150, 200, 150, 20);
        frame.add(scoreLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public String[] getSongDetails() {
        String name = nameField.getText();
        String duration = durationField.getText();
        String singer = singersField.getText();
        return new String[]{name, duration, singer};
    }

    public void displayScore(int score) {
        scoreLabel.setText("Song score: " + score);
    }
}
