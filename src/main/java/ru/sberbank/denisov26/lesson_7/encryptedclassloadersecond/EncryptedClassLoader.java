package ru.sberbank.denisov26.lesson_7.encryptedclassloadersecond;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EncryptedClassLoader extends ClassLoader {

    public Class findClass(String path, String name, String algorithm, byte[] key) throws Exception{
        byte[] b = loadClassData(path, name, algorithm, key);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String path, String name, String algorithm, byte[] key) throws Exception {
        Path file = Paths.get(String.format("%s\\%s.class", path, name));
        byte[] encryptedContent = Files.readAllBytes(file);
        System.out.println(new String(encryptedContent));

        Cipher decryption = Cipher.getInstance(algorithm);
        decryption.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, 0, key.length, algorithm));
        byte[] decryptedContent = decryption.doFinal(encryptedContent);
        System.out.println(new String(decryptedContent));

        return decryptedContent;
    }
}
