package com.smileman.toshiba.simplegolfz;

/**
 * Created by toshiba on 2016/04/29.
 */
public class Course {
    private int imageId;
    private int courseId;
    private String title;
    private String coursePage;
    private String courseRate;
    private String courseHours;
    private boolean full;
    private String range;
    private String other;


    public String getRange() {
        return range;
    }

    public String getOther() {
        return other;
    }

    public Course(int courseId, int imageId, String title, String coursePage, String courseRate , String courseHours, boolean full, String range, String other) {
        this.courseId = courseId;
        this.imageId = imageId;
        this.title = title;
        this.coursePage = coursePage;
        this.courseRate = courseRate;
        this.courseHours = courseHours;
        this.full = full;
        this.range = range;
        this.other = other;
    }

    public int getImageId() {
        return imageId;
    }
    public boolean getFull() {
        return full;
    }
    public int getcourseId() {
        return courseId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoursePage() {
        return coursePage;
    }

    public String getCourseRate() {
        return courseRate;
    }

    public String getCourseHours() {
        return courseHours;
    }

    @Override
    public String toString() {
        return title;
    }
}
