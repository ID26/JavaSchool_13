package ru.sberbank.denisov26.lesson_7.encryptedclassloadersecond;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ClassEncryption {

    public static void main(String[] args) throws Exception {

        String path = "C:\\Users\\Иван\\YandexDisk\\JavaSchool_13\\target\\classes\\ru\\sberbank\\denisov26\\lesson_7\\encryptedclassloadersecond";
        String className = "CoreClass";
        String algorithm = "AES";
        byte[] key = {75, 110, -45, -61, 101, -103, -26, -25, 55, -70, 19, 51, 66, -91, -35, 19}; //128 bit key

//        byte[] key = getSecretKey(algorithm);

        System.out.println(Arrays.toString(key));
        encrypt(path, className, algorithm, key);
    }

//    public static byte[] getSecretKey(String algorithm) throws NoSuchAlgorithmException {
//        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
//        generator.init(128); //generate 128 bit key
//        SecretKey secretKey = generator.generateKey();
//        return secretKey.getEncoded();
//    }

    public static void encrypt(String path, String className, String algorithm, byte[] key) throws Exception {
        Path file = Paths.get(String.format("%s\\%s.class", path, className));
        byte[] content = Files.readAllBytes(file);
        Cipher encryption = Cipher.getInstance(algorithm);
        encryption.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, 0, key.length, algorithm));
        byte[] encryptedContent = encryption.doFinal(content);
        writeToFile(path, className, encryptedContent);
    }

    public static void writeToFile(String path, String className, byte[] encryptedContent) throws Exception {
//        System.out.println(String.format("%s\\%s.class", path, className));
        FileOutputStream fos = new FileOutputStream(String.format("%s\\%s.class", path, className));
        fos.write(encryptedContent);
        fos.flush();
        fos.close();
    }
}
