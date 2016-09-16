package com.smileman.toshiba.simplegolfz;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ResultPageZ extends AppCompatActivity {

    private ScoreDataBase db = new ScoreDataBase(this);
    protected static final String DATE = "date played";
    protected static final String TIME = "time played";
    protected static final String TITLE = "Score List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page_z);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(TITLE);

        setListView();
        ListView listView = (ListView) findViewById(R.id.listz);

        assert listView != null;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView dateFromTextView = (TextView)view.findViewById(R.id.textViewDate);
                String date = dateFromTextView.getText().toString();
                TextView timeFromTextView = (TextView)view.findViewById(R.id.playTime);
                String time = timeFromTextView.getText().toString();
                Intent j = new Intent(ResultPageZ.this,ShowDetailData.class);
                j.putExtra(DATE,date);
                j.putExtra(TIME,time);
                startActivity(j);
            }
        });
    }

    private void setListView() {

        Cursor cursor = db.getAllRowsFromPreviewTable();
        cursor.moveToFirst();

        String[] dataFromDB = new String[]{db.ID, db.COURSE_NAME, db.DATE,db.TIME,db.DURATION,db.TEMP,db.WEATHER, db.NAME1, db.SUM1, db.NAME2, db.SUM2, db.NAME3, db.SUM3, db.NAME4, db.SUM4};
        int[] viewID = new int[]{R.id.invisibleId, R.id.textViewCourse, R.id.textViewDate,R.id.playTime,R.id.playDuration,R.id.temp,R.id.weather, R.id.textViewName, R.id.textViewSum, R.id.textViewName2, R.id.textViewSum2, R.id.textViewName3, R.id.textViewSum3, R.id.textViewName4, R.id.textViewSum4};
        final SimpleCursorAdapter simpleCursorAdapter;
        simpleCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.item_layout, cursor, dataFromDB, viewID, 0);

        ListView listView = (ListView) findViewById(R.id.listz);
        assert listView != null;
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder adb=new AlertDialog.Builder(ResultPageZ.this);
                adb.setTitle("Delete?");
                TextView trueID = (TextView)view.findViewById(R.id.invisibleId);
                final int truePostion = Integer.parseInt(trueID.getText().toString());
                TextView dateFromTextView = (TextView)view.findViewById(R.id.textViewDate);
                final String date = dateFromTextView.getText().toString();
                TextView timeFromTextView = (TextView)view.findViewById(R.id.playTime);
                final String time = timeFromTextView.getText().toString();
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        db.deleteScore(truePostion,date,time);
                        setListView();
                    }});
                adb.show();
                return true;
            }

        });

        listView.setAdapter(simpleCursorAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.result_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.go_back) {
            Intent i = new Intent(ResultPageZ.this, MainActivity.class);
            startActivity(i);
        }
        if(id == R.id.delete_all){
            AlertDialog.Builder adb=new AlertDialog.Builder(this);
            adb.setTitle("Delete?");
            adb.setMessage("Are you sure you want to delete all data?");
            adb.setNegativeButton("Cancel",null);
            adb.setPositiveButton("Yes",new AlertDialog.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    db.deleteAll();
                    setListView();
                }
            });
            adb.show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void openYahoo(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.yahoo.com/?ilc=401"));
        startActivity(intent);
    }
}
