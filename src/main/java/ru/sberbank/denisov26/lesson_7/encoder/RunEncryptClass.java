package ru.sberbank.denisov26.lesson_7.encoder;

import java.security.NoSuchAlgorithmException;

public class RunEncryptClass {
    public static void main(String[] args) {
        String path = "C:\\Users\\Иван\\YandexDisk\\JavaSchool_13\\target\\classes\\ru\\sberbank\\denisov26\\lesson_7\\encoder";
        String className = "ClassForEncoding";
        String algorithm = "AES";
        try {
            EncryptImpl encryption = new EncryptImpl(path, className, algorithm);
            encryption.encrypt();
//            System.out.println(Files.readAllBytes(Paths.get(path + "/newFolder/" + className + ".class" )));
//            System.out.println(Files.readAllBytes(Paths.get(path + "/newFolder/key.txt" )));
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Trouble with algorithm type " + e);
        } /*catch (IOException e) {
            System.err.println("Trouble reading encrypted file");
        }*/

    }
}
