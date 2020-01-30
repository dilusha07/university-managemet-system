package Controller;


import Entity.Student;
import Entity.Subject;
import DBConnection.DBConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class StudentController {
//    String stdName;
//    int stdAge;
//    String userName;
//    String passowrd;
//    Subject subject;
    public void stdSignUp(int id,String stdName, int stdAge, String userName, String passowrd, ArrayList<Subject> subjectList) throws ClassNotFoundException, SQLException{
        JFrame frame=new JFrame();
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert Into Student Values(?,?,?,?,?);");

       
                        stm.setObject(1, id);
                        stm.setObject(2, stdName);
                        stm.setObject(3, stdAge);
                        stm.setObject(4, userName);
                        stm.setObject(5, passowrd);
                        
        stm.executeUpdate();
   
        for(Subject subject:subjectList){
            PreparedStatement st=connection.prepareStatement("Insert Into std_sub Values(?,?)");
            st.setObject(1, subject.getId());
            st.setObject(2, id);
            
            st.executeUpdate();
        }
        JOptionPane.showMessageDialog(frame, "Student Details Successfully saved");
        
                        
    }
    
    public Student stdSignIn(String userName,String password) throws ClassNotFoundException, SQLException{
       
        Student student=new Student();
        Connection connection=DBConnection.getInstance().getConnection();
        Statement  stmt=connection.createStatement();
        ResultSet rst=stmt.executeQuery( "select * from Student where userName='"+userName+"'and password='"+password+"';");
        
        if(rst.next()){
            student=new Student(rst.getInt("id"), rst.getString("name"), rst.getInt("age"), rst.getString("userName"), rst.getString("password"));
            return student;
        }else{
            return null;
        }
    }
    public ArrayList<Subject> stdRegedSubjects(String userName,String password) throws SQLException, ClassNotFoundException{
        Connection connection=DBConnection.getInstance().getConnection();
        Statement  stmt=connection.createStatement();
        ArrayList<Subject> subList=new ArrayList<>();
        ResultSet rst=stmt.executeQuery("SELECT * from subject where id in (SELECT subId from std_sub where stdId=(Select id from student where userName='"+userName+"'and password='"+password+"'));");
        while(rst.next()){
            Subject subject=new Subject();
            subject.setId(rst.getInt("id"));
            subject.setSubName(rst.getString("subName"));
            subList.add(subject);
        }
        return subList;
    }
}
