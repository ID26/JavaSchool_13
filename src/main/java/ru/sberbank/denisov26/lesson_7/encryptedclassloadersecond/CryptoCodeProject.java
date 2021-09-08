package ru.sberbank.denisov26.lesson_7.encryptedclassloadersecond;

import java.lang.reflect.Method;
import java.util.Arrays;

public class CryptoCodeProject {
    public static void main(String[] args) throws Exception{
        String path = "C:\\Users\\Иван\\YandexDisk\\JavaSchool_13\\target\\classes\\ru\\sberbank\\denisov26\\lesson_7\\encryptedclassloadersecond";
        String className = "CoreClass";
        String algorithm = "AES";
        byte[] key = {75, 110, -45, -61, 101, -103, -26, -25, 55, -70, 19, 51, 66, -91, -35, 19}; //128 bit key
//        byte[] key = ClassEncryption.getKey();
        System.out.println(Arrays.toString(key));

        EncryptedClassLoader myClassLoader = new EncryptedClassLoader();
        Class dynamicClass = myClassLoader.findClass(path, className, algorithm, key);

        Method m = dynamicClass.getMethod("main", String[].class);
        m.invoke(null, new Object[] {null});
    }
}
