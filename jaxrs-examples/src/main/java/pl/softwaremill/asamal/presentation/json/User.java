package pl.softwaremill.asamal.presentation.json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class User {

    private String name;
    private String lastName;
    private int shoeNumber;

    public User() {
    }

    public User(String name, String lastName, int shoeNumber) {
        this.name = name;
        this.lastName = lastName;
        this.shoeNumber = shoeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getShoeNumber() {
        return shoeNumber;
    }

    public void setShoeNumber(int shoeNumber) {
        this.shoeNumber = shoeNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "shoeNumber=" + shoeNumber +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
