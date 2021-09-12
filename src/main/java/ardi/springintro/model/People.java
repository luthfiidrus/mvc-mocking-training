package ardi.springintro.model;

public class People {
    String name;
    int height;
    int mass;
    String gender;

    public People() {
    }

    public People(String name, int height, int mass, String gender) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
