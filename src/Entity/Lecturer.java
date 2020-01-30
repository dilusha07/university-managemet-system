package Entity;


import java.util.ArrayList;

public class Lecturer {
    private int id;
    private String name;
    private int age;
    private String userName;
    private String password;
    private ArrayList<Subject> subjectList;

    public Lecturer() {
    }

    public Lecturer(int id, String name, int age, String userName, String password, ArrayList<Subject> subjectList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userName = userName;
        this.password = password;
        this.subjectList = subjectList;
    }

    public Lecturer(String name, int age, String userName, String password, ArrayList<Subject> subjectList) {
        this.name = name;
        this.age = age;
        this.userName = userName;
        this.password = password;
        this.subjectList = subjectList;
    }

    public Lecturer(int id, String name, int age, String userName, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userName = userName;
        this.password = password;
    }
    

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(ArrayList<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
