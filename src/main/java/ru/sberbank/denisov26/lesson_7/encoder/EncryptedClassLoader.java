package ru.sberbank.denisov26.lesson_7.encoder;

import javax.crypto.SecretKey;

public class EncryptedClassLoader extends ClassLoader {

    public Class<?> findClass(String path, String name, String algorithm, SecretKey key) throws Exception {
        byte[] b = loadClass(path, name, algorithm, key);
        FileLog.writeToFile(b);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClass(String path, String name, String algorithm, SecretKey key) throws Exception {
        DecryptImpl decrypt = new DecryptImpl(path, name, key, algorithm);
        return decrypt.decrypt();
    }
}
