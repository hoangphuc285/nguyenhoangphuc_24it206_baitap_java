import javax.swing.*;
import java.awt.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.*;

 class PasswordHasher {
    public static String hashPassword(String password, String algorithm) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] hashBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
 interface Encryptable {
    String encrypt(String data) throws Exception;
    String decrypt(String encryptedData) throws Exception;
}

class AESEncryption implements Encryptable {
    private final SecretKey secretKey;

    public AESEncryption() throws Exception {
        byte[] keyBytes = "1234567890123456".getBytes(); // 16-byte key
        this.secretKey = new SecretKeySpec(keyBytes, "AES");
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    public String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }
}

 class RSAEncryption implements Encryptable {
    private final KeyPair keyPair;

    public RSAEncryption() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        keyPair = kpg.generateKeyPair();
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    public String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }
}

class EncryptionGUI extends JFrame {
    private final JTextArea inputArea = new JTextArea(5, 30);
    private final JComboBox<String> algorithmBox = new JComboBox<>(new String[]{"AES", "RSA"});
    private final JTextArea resultArea = new JTextArea(10, 30);

    public EncryptionGUI() {
        setTitle("Encryption Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Nhập dữ liệu:"));
        add(new JScrollPane(inputArea));
        add(new JLabel("Thuật toán:"));
        add(algorithmBox);
        JButton startButton = new JButton("Bắt đầu mã hóa");
        add(startButton);
        add(new JScrollPane(resultArea));

        startButton.addActionListener(e -> runEncryption());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void runEncryption() {
        String data = inputArea.getText();
        String algo = (String) algorithmBox.getSelectedItem();

        resultArea.setText("Đang xử lý...\n");

        new Thread(() -> {
            try {
                Encryptable encryptor = algo.equals("AES") ? new AESEncryption() : new RSAEncryption();
                String encrypted = encryptor.encrypt(data);
                String decrypted = encryptor.decrypt(encrypted);

                SwingUtilities.invokeLater(() -> {
                    resultArea.setText("Encrypted:\n" + encrypted + "\n\nDecrypted:\n" + decrypted);
                });
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EncryptionGUI::new);
    }
}
/*javac --release 8 EncryptionGUI.java
java EncryptionGUI
*/