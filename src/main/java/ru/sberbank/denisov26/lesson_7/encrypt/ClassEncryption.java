package ru.sberbank.denisov26.lesson_7.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ClassEncryption {
    public static void main(String[] args) throws Exception{
        String path = "C:\\crypto";
        String classname = "CoreClass";
        String algorithm = "AES";
        byte[] key = {75, 110, -45, -61, 101, -103, -26, -25, 55, -70, 19, 51, 66, -91, -35, 19}; //128 bit key

        System.out.println(Arrays.toString(key));
        encrypt(path, classname, algorithm, key);
    }
    public static void encrypt(String path, String classname, String algorithm, byte[] key) throws Exception{
        Path file = Paths.get(path+"\\"+classname+".class");
        byte[] content = Files.readAllBytes(file);
        Cipher encryption = Cipher.getInstance(algorithm);
        encryption.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, 0, key.length, algorithm));
        byte[] encryptedContent = encryption.doFinal(content);
        writeToFile(path, classname, encryptedContent);
    }
    public static void writeToFile(String path, String filename, byte[] content) throws Exception{
        FileOutputStream out = new FileOutputStream(path+"\\encrypted\\"+filename+".class");
        out.write(content);
        out.close();
    }
}
