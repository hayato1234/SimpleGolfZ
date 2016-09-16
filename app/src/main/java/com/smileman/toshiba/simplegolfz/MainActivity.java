package com.smileman.toshiba.simplegolfz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CourseInfo courses = new CourseInfo();
    courseDataBase coursedb = new courseDataBase(this);
    String courseName;
    int courseId;
    boolean full;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedpreference = getSharedPreferences("course", MODE_PRIVATE);
        Boolean check = sharedpreference.getBoolean("set",false);

        if (!check){
            coursedb.createTable();
            SharedPreferences.Editor editor = sharedpreference.edit();
            editor.putBoolean("set",true);
            editor.commit();
        }

        Toast.makeText(this, "Please choose a course", Toast.LENGTH_SHORT).show();
        Button play = (Button) findViewById(R.id.PlayButton);
        play.setEnabled(false);


        ItemFragment itemFragment = (ItemFragment) getFragmentManager().findFragmentById(R.id.list);
        ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, courses);

        itemFragment.setListAdapter(adapter);

        final ProductFragment productFragment = (ProductFragment) getFragmentManager().findFragmentById(R.id.product);
        productFragment.setCourse(courses.get(0));

        new setItemClickListener().execute();
    }

    private class setItemClickListener extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            ItemFragment itemFragment = (ItemFragment) getFragmentManager().findFragmentById(R.id.list);

            final ProductFragment productFragment = (ProductFragment) getFragmentManager().findFragmentById(R.id.product);
            itemFragment.setOnCourseItemClickListener(new ItemFragment.OnCourseItemClickListener() {
                @Override
                public void onCourseItemClicked(int position) {
                    Course course = courses.get(position);
                    productFragment.setCourse(course);
                    courseName = course.toString();
                    courseId = course.getcourseId();
                    full = course.getFull();
                    Button play = (Button) findViewById(R.id.PlayButton);
                    play.setText("Play at: " + courseName);
                    play.setEnabled(true);
                    play.setOnClickListener(MainActivity.this);
                }
            });
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent i = new Intent(MainActivity.this, ResultPageZ.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(MainActivity.this, PlayingCourse.class);
        i.putExtra("tag1", courseName);
        i.putExtra("tag2", full);
        startActivity(i);
    }

    public void infoButtonClicked(View view) {
        Intent i = new Intent(MainActivity.this, ShowCourseInfo.class);
        i.putExtra("tag1", courseId);
        startActivity(i);
    }
}
