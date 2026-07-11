/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.DatabaseConnection;
import com.mycompany.mavenproject1.models.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QuestionDAO {

    public ArrayList<Question> getQuestionsByCourse(int courseId){

        ArrayList<Question> questions = new ArrayList<>();

        try{

            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM questions WHERE course_id=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, courseId);

            ResultSet rs = pst.executeQuery();

            while(rs.next()){

                Question q = new Question(

                        rs.getInt("id"),
                        rs.getInt("course_id"),
                        rs.getString("question"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getString("correct_answer")

                );

                questions.add(q);

            }

            con.close();

        }
        catch(Exception e){

            e.printStackTrace();

        }

        return questions;

    }

}
