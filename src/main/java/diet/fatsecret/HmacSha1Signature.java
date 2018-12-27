package diet.fatsecret;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
 
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
 
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public class HmacSha1Signature {
     
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
      
    /**
     * @description byte 배열을 16진수로 변환한다.
     */
    private static String toHexString(byte[] bytes) {
         
        Formatter formatter = new Formatter();
         
        for (byte b : bytes) {
            formatter.format("% xx", b);
        }
  
        return formatter.toString();
         
    }
  
    /**
     * @description byte 배열을 Base64로 인코딩한다.
     */
    public static String toBase64String(byte[] bytes){
         
        byte[] byteArray = Base64.encodeBase64(bytes);
        return new String(byteArray);
         
    }
     
    /**
     * @description HmacSHA1로 암호화한다. (HmacSHA1은 hash algorism이라서 복호화는 불가능)
     */
    public static String encryption(String data, String key) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
         
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
         
        return toBase64String(mac.doFinal(data.getBytes()));
         
    }
     
    public static void main(String[] args) throws Exception {
         
        String encryptedStr = encryption("hi there~", "1b8d7a0366c64c74a5d723039aab3598");
        System.out.println("encryptedStr : " + encryptedStr);
         
    }
     
}
