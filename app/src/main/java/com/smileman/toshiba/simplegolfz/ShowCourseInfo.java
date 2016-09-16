package com.smileman.toshiba.simplegolfz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ShowCourseInfo extends AppCompatActivity {

    private CourseInfo courses = new CourseInfo();
    private String courseUrl;
    private String rateUrl;
    private String hourUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_course_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);

        Bundle extras = getIntent().getExtras();
        int courseId = extras.getInt("tag1");
        Course course = courses.get(courseId);
        String courseName = course.getTitle().toString();
        toolbar.setTitle(courseName);
        courseUrl = course.getCoursePage();
        rateUrl = course.getCourseRate();
        hourUrl = course.getCourseHours();

        TextView range = (TextView)findViewById(R.id.range);
        range.setText(course.getRange());
        TextView other = (TextView)findViewById(R.id.otherInfo);
        other.setText(course.getOther());

    }

    public void goToWebSite(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void couseClicked(View view) {
        goToWebSite(courseUrl);
    }

    public void ratesClicked(View view) {
        goToWebSite(rateUrl);
    }

    public void hoursClicked(View view) {
        goToWebSite(hourUrl);
    }
}
