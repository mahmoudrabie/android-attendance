package attendance.project;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MDCalculator {
        private String msgDigest;
        public MDCalculator(String pass){
                msgDigest = "";
                try {
                        MessageDigest md5 = MessageDigest.getInstance("MD5");
                        md5.update(pass.getBytes());
                        BigInteger hash = new BigInteger(1,md5.digest());
                        msgDigest = hash.toString(16);
                } catch (NoSuchAlgorithmException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
        public String getMD(){
                return msgDigest;
        }
}