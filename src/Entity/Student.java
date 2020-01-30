package Entity;


import java.util.ArrayList;

public class Student
{
    
    private int id;
    private String stdName;
    private int stdAge;
    private String userName;
    private String passowrd;
    private ArrayList<Subject> subjectList;
  

    public Student() {
    }

    public Student(int id, String stdName, int stdAge, String userName, String passowrd, ArrayList<Subject> subjectList) {
        this.id = id;
        this.stdName = stdName;
        this.stdAge = stdAge;
        this.userName = userName;
        this.passowrd = passowrd;
        this.subjectList = subjectList;
    }

    public Student(String stdName, int stdAge, String userName, String passowrd, ArrayList<Subject> subjectList) {
        this.stdName = stdName;
        this.stdAge = stdAge;
        this.userName = userName;
        this.passowrd = passowrd;
        this.subjectList = subjectList;
    }

    public Student(int id, String stdName, int stdAge, String userName, String passowrd) {
        this.id = id;
        this.stdName = stdName;
        this.stdAge = stdAge;
        this.userName = userName;
        this.passowrd = passowrd;
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

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdAge() {
        return stdAge;
    }

    public void setStdAge(int stdAge) {
        this.stdAge = stdAge;
    }


}
