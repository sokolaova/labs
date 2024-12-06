import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket socket;
    private static PrintWriter out;
    private static BufferedReader in;
    private static JTextArea textArea;
    private static JTextField textField;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Клиент");
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        textField = new JTextField(50);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.getContentPane().add(textField, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(textField.getText());
                textField.setText("");
            }
        });

        try {
            socket = new Socket("localhost", 8080);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                textArea.append(message + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(String message) {
        if (message != null && !message.trim().isEmpty()) {
            out.println(message);
            textArea.append(message + "\n");
        }
    }
}
