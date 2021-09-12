package ru.sberbank.denisov26.lesson_7.encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class LoadDecryptClass {
    public static void main(String[] args) {
        String path = "C:\\Users\\Иван\\YandexDisk\\JavaSchool_13\\target\\classes\\ru\\sberbank\\denisov26\\lesson_7\\encoder\\newFolder";
        String className = "ClassForEncoding";
        String algorithm = "AES";

        try {
            String fileWithKey = String.format("%s/key.txt", path); // путь к ключу
            byte[] byteKey = Files.readAllBytes(Paths.get(fileWithKey)); // ключ в байтах
            FileLog.writeToFile(byteKey);
            SecretKey key = new SecretKeySpec(byteKey, 0, byteKey.length, "AES"); // объект секретный ключ
            EncryptedClassLoader encryptedClassLoader = new EncryptedClassLoader(); // создаем наш класслоадер

            Class<?> loaderClass = encryptedClassLoader.findClass(path, className, algorithm, key);// у нашего класслоадера вызываем метод поиска класса
            Method m = loaderClass.getMethod("main", String[].class);
            m.invoke(null, new Object[] {null});

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Ошибка чтения из файла or with keyReader" + e);
        } catch (NoSuchPaddingException e) {
            System.err.println("Read this thing 1 " + e);
        } catch (InvalidKeyException e) {
            System.err.println("Trouble key " + e);
        } catch (BadPaddingException e) {
            System.err.println("Read this thing 2 " + e);
        } catch (IllegalBlockSizeException e) {
            System.err.println("Read this thing 3 " + e);
        } catch (Exception e) {
            System.err.println("Trouble with classLoader " + e);
        }

    }
}
