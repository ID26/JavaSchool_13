package profiles.interfaces;

import load.interfaces.LoadViewPhoto;

import java.util.Objects;


public class User {
    private static long countId = 0;
    private long id;
    private String name;
    private String surname;
    private int age;
    private String city;
    private LoadViewPhoto loadViewPhoto;

    public User(String name, String surname, int age, String city, LoadViewPhoto loadViewPhoto) {
        this.id = countId++;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.loadViewPhoto = loadViewPhoto;
    }

    public User(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public User(String name, LoadViewPhoto loadViewPhoto) {
        this.name = name;
        this.loadViewPhoto = loadViewPhoto;
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User() {
        this.id = countId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LoadViewPhoto getLoadViewPhoto() {
        return loadViewPhoto;
    }

    public void setLoadViewPhoto(LoadViewPhoto loadViewPhoto) {
        this.loadViewPhoto = loadViewPhoto;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(city, user.city) &&
                Objects.equals(loadViewPhoto, user.loadViewPhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, city, loadViewPhoto);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", loadViewPhoto=" + loadViewPhoto +
                '}';
    }
}
