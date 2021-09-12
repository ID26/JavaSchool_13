package lesson_8.cashingproxy.calulator.garbage;

import lesson_8.cashingproxy.calulator.work.Service;
import lesson_8.cashingproxy.calulator.work.ServiceImpl;

import java.io.*;

public class ServiceFileCache implements Service {
    private EntityInteger entity;
    private Service service;

    public ServiceFileCache(Service service) {
        this.service = service;
    }

    @Override
    public int doHardWork(int key) {
        int res = service.doHardWork(key);
        this.entity = new EntityInteger(key, res);
        try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Иван\\YandexDisk\\JavaSchool_13\\lesson_8.cashingproxy\\src\\main\\resources\\cash.ser", true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(entity);
            objectOutputStream.writeObject("\r\n");
        } catch (IOException e) {
            System.err.println("Path is incorrect " + e);;
        }
        return res;
    }

    public static void main(String[] args) {
        Service service = new ServiceFileCache(new ServiceImpl());
        service.doHardWork(4);

        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Иван\\YandexDisk\\JavaSchool_13\\lesson_8.cashingproxy\\src\\main\\resources\\cash.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                EntityInteger entityInteger = (EntityInteger) objectInputStream.readObject();

                    System.out.println(entityInteger);


        } catch (IOException e) {
            System.err.println("Trouble, is where file? " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Class is hz " + e);;
        }
    }
}
