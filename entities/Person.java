package entities;

public class Person {
    int id;
    String name;
    String sex;
    String nationality;
    int age;


    public Person() {
    }
    public Person(String name) {
        this.name=name;
    }
    public Person(String name, String sex) {
        this.name=name;
        this.sex=sex;
    }

    public void laugh() {
        System.out.println( name + " jejeje!");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    
    
}
