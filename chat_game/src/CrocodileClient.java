import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class CrocodileClient {
    private static final String SERVER_ADDRESS = "localhost"; // Замените на адрес сервера
    private static final int SERVER_PORT = 8080;
    private static Socket socket;
    private static PrintWriter out;
    private static BufferedReader in;
    private static JTextArea textArea;
    private static JTextField textField;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Крокодил");
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        textField = new JTextField(50);
        JButton sendButton = new JButton("Отправить");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.getContentPane().add(textField, BorderLayout.SOUTH);
        frame.getContentPane().add(sendButton, BorderLayout.EAST);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                textArea.append(message + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage() {
        String message = textField.getText();
        if (!message.isEmpty()) {
            out.println(message);
            textField.setText("");
        }
    }
}
