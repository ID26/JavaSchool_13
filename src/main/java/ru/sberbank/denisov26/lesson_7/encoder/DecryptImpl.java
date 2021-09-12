package ru.sberbank.denisov26.lesson_7.encoder;

import javax.crypto.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DecryptImpl implements Decrypt {

    private final String path;
    private final String className;
    private final SecretKey key;
    private final String algorithm;

    public DecryptImpl (String path, String className, SecretKey key, String algorithm) {
        this.path = path;
        this.className = className;
        this.key = key;
        this.algorithm = algorithm;
    }

    @Override
    public byte[] decrypt() throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String root = String.format("%s/%s.class", path, className);
        Path pathToContent = Paths.get(root);
        byte[] bytes = Files.readAllBytes(pathToContent);
        FileLog.writeToFile(bytes);
        Cipher decrypt = Cipher.getInstance(algorithm);
        decrypt.init(Cipher.DECRYPT_MODE, key);
        return decrypt.doFinal(bytes);
    }
}
