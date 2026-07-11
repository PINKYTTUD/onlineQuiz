/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.models;

/**
 *
 * @author LENOVO
 */
public class Result {
     private int id;
    private int userId;
    private int courseId;
    private int score;
    private int total;
    private double percentage;

    public Result() {
    }

    public Result(int id, int userId, int courseId,
                  int score, int total, double percentage) {

        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.score = score;
        this.total = total;
        this.percentage = percentage;
    }

    public int getScore() {
        return score;
    }

    public int getTotal() {
        return total;
    }

    public double getPercentage() {
        return percentage;
    }
    
}
