package main;
import javax.persistence.*;

@Entity
@Table(name = "person")

public class Person{
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "salary")
    private double salary;

    public Person(){}

    public Person(String surname, int age, String address, double salary){
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public double getSalary() {return salary;}
    public void setSalary(double salary) {this.salary = salary;}

    @Override
    public String toString(){
        return id + "\t" + surname + "\t" + age +
                "\t" + address + "\t" + salary;
    }
}