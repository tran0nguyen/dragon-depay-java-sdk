package io.dragon.depay.util;

import io.dragon.depay.exception.DepaySDKException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SignUtil {
    public static String sign(String secretKey,String msg) throws DepaySDKException {
        try{
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            sha256_HMAC.update(msg.getBytes());
            byte[] array = sha256_HMAC.doFinal();
            return Base64.getEncoder().encodeToString(array);
        }catch (Exception e){
            throw new DepaySDKException(String.format("verify message failed: %s",e.getMessage()));
        }
    }
}
