package Controller;


import Entity.Lecturer;
import Entity.Subject;
import DBConnection.DBConnection;
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
public class LecturerController {
     public void lecSignUp(int id,String lecName, int lecAge, String userName, String passowrd, ArrayList<Subject> subjectList) throws ClassNotFoundException, SQLException{
        JFrame frame=new JFrame();
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert Into Lecturer Values(?,?,?,?,?);");

       
                        stm.setObject(1, id);
                        stm.setObject(2, lecName);
                        stm.setObject(3, lecAge);
                        stm.setObject(4, userName);
                        stm.setObject(5, passowrd);
                        
        stm.executeUpdate();
   
        for(Subject subject:subjectList){
            PreparedStatement st=connection.prepareStatement("Insert Into lec_sub Values(?,?)");
            st.setObject(1, subject.getId());
            st.setObject(2, id);
            
            st.executeUpdate();
        }
        JOptionPane.showMessageDialog(frame, "Lecturer Details Successfully saved");
        
                        
    }
    
    public Lecturer lecSignIn(String userName,String password) throws ClassNotFoundException, SQLException{
       
        Lecturer lecturer=new Lecturer();
        Connection connection=DBConnection.getInstance().getConnection();
        Statement  stmt=connection.createStatement();
        ResultSet rst=stmt.executeQuery( "select * from Lecturer where userName='"+userName+"'and password='"+password+"';");
        
        if(rst.next()){
            lecturer=new Lecturer(rst.getInt("id"), rst.getString("name"), rst.getInt("age"), rst.getString("userName"), rst.getString("password"));
            return lecturer;
        }else{
            return null;
        }
    }
    public ArrayList<Subject> lecRegedSubjects(String userName,String password) throws SQLException, ClassNotFoundException{
        Connection connection=DBConnection.getInstance().getConnection();
        Statement  stmt=connection.createStatement();
        ArrayList<Subject> subList=new ArrayList<>();
        ResultSet rst=stmt.executeQuery("SELECT * from subject where id in (SELECT subId from lec_sub where lecId=(Select id from lecturer where userName='"+userName+"'and password='"+password+"'));");
        while(rst.next()){
            Subject subject=new Subject();
            subject.setId(rst.getInt("id"));
            subject.setSubName(rst.getString("subName"));
            subList.add(subject);
        }
        return subList;
    }
}
