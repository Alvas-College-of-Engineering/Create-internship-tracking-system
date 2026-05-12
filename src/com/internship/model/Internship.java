package com.internship.model;

import java.io.Serializable;

public class Internship implements Serializable {
    private String studentName;
    private String studentId;
    private String companyName;
    private int durationWeeks;
    private double progress;

    public Internship() {
        this.progress = 0.0;
    }

    public Internship(String studentName, String studentId, String companyName, int durationWeeks) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.companyName = companyName;
        this.durationWeeks = durationWeeks;
        this.progress = 0.0;
        System.out.println("Internship created: " + studentName + " (" + studentId + ") at " + companyName + " for " + durationWeeks + " weeks");
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getDurationWeeks() {
        return durationWeeks;
    }

    public void setDurationWeeks(int durationWeeks) {
        this.durationWeeks = durationWeeks;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        double oldProgress = this.progress;
        if (progress < 0) {
            this.progress = 0;
        } else if (progress > 100) {
            this.progress = 100;
        } else {
            this.progress = progress;
        }
        System.out.println("Progress updated from " + oldProgress + "% to " + this.progress + "%");
    }

    public boolean isCompleted() {
        return this.progress >= 100.0;
    }
}
