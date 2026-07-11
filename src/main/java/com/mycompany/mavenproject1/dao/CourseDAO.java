/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.dao;

/**
 *
 * @author LENOVO
 */
import com.mycompany.mavenproject1.DatabaseConnection;
import com.mycompany.mavenproject1.models.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CourseDAO {

    public ArrayList<Course> getAllCourses() {

        ArrayList<Course> courses = new ArrayList<>();

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM courses";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while(rs.next()){

                Course course = new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("code")
                );

                courses.add(course);

            }

            con.close();

        } catch(Exception e){

            e.printStackTrace();

        }

        return courses;

    }
}
