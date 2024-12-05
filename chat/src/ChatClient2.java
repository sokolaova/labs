import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ChatClient2 extends JFrame {
    private static final String SERVER_ADDRESS = "localhost"; // Адрес сервера
    private static final int SERVER_PORT = 12345; // Порт сервера

    private JTextArea textArea;
    private JTextField textField;
    private PrintWriter out;
    private String userName; // Имя пользователя

    public ChatClient2() {
        setTitle("Чат-клиент");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        textField = new JTextField();
        add(textField, BorderLayout.SOUTH);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        setVisible(true);
    }

    public void start() {
        // Запрос имени пользователя
        userName = JOptionPane.showInputDialog(this, "Введите ваше имя:", "Имя пользователя", JOptionPane.PLAIN_MESSAGE);
        if (userName == null || userName.trim().isEmpty()) {
            userName = "Неизвестный"; // Если имя не введено, устанавливаем "Неизвестный"
        }

        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Подключено к серверу " + SERVER_ADDRESS + " на порту " + SERVER_PORT);

            out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Создаем поток для чтения сообщений от сервера
            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        displayMessage(message); // Отображаем полученные сообщения
                    }
                } catch (IOException e) {
                    System.err.println("Ошибка при чтении сообщения: " + e.getMessage());
                }
            }).start();
        } catch (IOException e) {
            System.err.println("Ошибка подключения к серверу: " + e.getMessage());
        }
    }

    private void sendMessage() {
        String message = textField.getText();
        if (!message.isEmpty()) {
            out.println(userName + ": " + message); // Отправляем сообщение с именем пользователя
            textField.setText(""); // Очищаем поле ввода
        }
    }

    private void displayMessage(String message) {
        textArea.append(message + "\n"); // Добавляем сообщение в текстовую область
        textArea.setCaretPosition(textArea.getDocument().getLength()); // Прокручиваем вниз
    }

    public static void main(String[] args) {
        ChatClient2 client = new ChatClient2();
        client.start();
    }
}
