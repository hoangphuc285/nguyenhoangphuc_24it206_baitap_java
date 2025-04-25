import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Client extends Application {
    private TextArea messageArea;
    private TextField inputField;
    private TextField ipField, portField;
    private Button connectButton, sendButton;

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        messageArea = new TextArea();
        messageArea.setEditable(false);

        inputField = new TextField();
        inputField.setPromptText("Nhập tin nhắn...");

        ipField = new TextField("127.0.0.1");
        ipField.setPromptText("IP Server");

        portField = new TextField("12345");
        portField.setPromptText("Port Server");

        connectButton = new Button("Kết nối");
        connectButton.setOnAction(e -> connectToServer());

        sendButton = new Button("Gửi");
        sendButton.setOnAction(e -> sendMessage());
        sendButton.setDisable(true);

        HBox connectBox = new HBox(10, ipField, portField, connectButton);
        HBox sendBox = new HBox(10, inputField, sendButton);

        VBox root = new VBox(10, messageArea, connectBox, sendBox);
        Scene scene = new Scene(root, 500, 400);

        primaryStage.setTitle("Client Chat");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void connectToServer() {
        String ip = ipField.getText();
        int port = Integer.parseInt(portField.getText());
        try {
            socket = new Socket(ip, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            sendButton.setDisable(false);
            connectButton.setDisable(true);
            messageArea.appendText("Kết nối thành công!\n");

            new Thread(this::receiveMessages).start();
        } catch (IOException e) {
            messageArea.appendText("Kết nối thất bại!\n");
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = inputField.getText();
        if (message.isEmpty()) return;
        out.println(message);
        messageArea.appendText("Bạn: " + message + "\n");
        inputField.clear();
    }

    private void receiveMessages() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                String msg = message;
                Platform.runLater(() -> messageArea.appendText("Người khác: " + msg + "\n"));
            }
        } catch (IOException e) {
            Platform.runLater(() -> messageArea.appendText("Mất kết nối với server!\n"));
            e.printStackTrace();
        }
    }
}
