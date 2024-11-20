import java.io.Serializable;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HelpArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String header;
    private String title;
    private String shortDescription;
    private String body; // This will be encrypted if it's in a special access group
    private List<String> keywords;
    private long groupId;

    // Encryption method
    public static String encrypt(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // Decryption method
    public static String decrypt(String encryptedData, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }

    // Getters and Setters remain the same
    
    // Encrypted article body getter
    public String getBody() {
        return body;
    }

    // Set encrypted body
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "HelpArticle{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", body='" + body + '\'' +
                ", keywords=" + keywords +
                ", groupId=" + groupId +
                '}';
    }
}
