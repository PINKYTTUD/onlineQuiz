/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ResultDAO {

    public void saveResult(int userId,
                           int courseId,
                           int score,
                           int total,
                           double percentage){

        try{

            Connection con = DatabaseConnection.getConnection();

            String sql="INSERT INTO results(user_id,course_id,score,total,percentage) VALUES(?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1,userId);
            pst.setInt(2,courseId);
            pst.setInt(3,score);
            pst.setInt(4,total);
            pst.setDouble(5,percentage);

            pst.executeUpdate();

            con.close();

        }
        catch(Exception e){

            e.printStackTrace();

        }

    }

}