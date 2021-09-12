package ru.sberbank.denisov26.lesson_7.encoder;

import javax.crypto.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptImpl implements Encrypt{
    private final String path;
    private final String className;
    private final SecretKey key;
    private final String algorithm;

    public EncryptImpl(String path, String className, String algorithm) throws NoSuchAlgorithmException {
        this.path = path;
        this.className = className;
        this.key = getSecretKey(algorithm);
        this.algorithm = algorithm;
    }

    private SecretKey getSecretKey(String algorithm) throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        generator.init(128); //generate 128 bit key
        SecretKey secretKey = generator.generateKey();
        try {
            FileLog.writeToFile(secretKey.getEncoded());
        } catch (IOException e) {
            System.err.println("Trouble during logToFile " + e);
        }
        return secretKey;
//        return secretKey.getEncoded();
    }

    @Override
    public void encrypt () {
        Path fileToEncrypt = Paths.get(String.format("%s/%s.class", path, className));
        try {
            byte[] bytes = Files.readAllBytes(fileToEncrypt);
            FileLog.writeToFile(bytes);
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(bytes);
            FileLog.writeToFile(encryptedBytes);
            writeToFile(path, className, "class", encryptedBytes);
            writeToFile(path, "key", "txt", key.getEncoded());
        } catch (IOException e) {
            System.err.println("Ошибка чтения из файла " + e);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Trouble algorithm " + e);
        } catch (NoSuchPaddingException e) {
            System.err.println("Read this thing 1 " + e);
        } catch (InvalidKeyException e) {
            System.err.println("Trouble key " + e);
        } catch (BadPaddingException e) {
            System.err.println("Read this thing 2 " + e);
        } catch (IllegalBlockSizeException e) {
            System.err.println("Read this thing 3 " + e);
        }
    }

    private void writeToFile(String path, String className, String typeFile, byte[] encryptedBytes) {
        String newPath = String.format("%s/newFolder", path);
        File file = new File(newPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String goalPath = String.format("%s/%s.%s", newPath, className, typeFile);
//        System.out.println(goalPath);
        try (FileOutputStream out = new FileOutputStream(goalPath)){
            out.write(encryptedBytes);
        } catch (IOException e) {
            System.err.println("Trouble during write file");;
        }
    }
}
