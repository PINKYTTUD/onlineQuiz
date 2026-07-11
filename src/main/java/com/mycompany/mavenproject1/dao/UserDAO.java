package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.DatabaseConnection;
import com.mycompany.mavenproject1.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UserDAO {

    public boolean register(User user) {

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql = "INSERT INTO users(fullname,email,password,gender) VALUES(?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, user.getFullname());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getGender());

            int rows = pst.executeUpdate();

            con.close();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(
                null,
                "Please ensure you have MySQL database running or XAMPP.\n\n" + e.getMessage(),
                "Database Connection Error",
                JOptionPane.ERROR_MESSAGE
            );


        }

        return false;
    }

    public boolean login(String email, String password) {

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            boolean found = rs.next();

            con.close();

            return found;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }
}