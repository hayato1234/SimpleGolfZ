package com.smileman.toshiba.simplegolfz;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.smileman.toshiba.simplegolfz.data.Channel;
import com.smileman.toshiba.simplegolfz.data.Item;
import com.smileman.toshiba.simplegolfz.service.CallBack;
import com.smileman.toshiba.simplegolfz.service.YahooWeatherService;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import net.arnx.jsonic.JSON;

public class PlayingCourse extends AppCompatActivity implements CallBack{
    public static final int NUMBER = 2;
    public static final String[] HOLENUMS = new String[]{"hole1", "hole2", "hole3", "hole4", "hole5", "hole6", "hole7", "hole8", "hole9", "hole10", "hole11", "hole12", "hole13", "hole14", "hole15", "hole16", "hole17", "hole18"};
    public static final int[] BUTTONIDS = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9,R.id.button10, R.id.button11,R.id.button12, R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17, R.id.button18};
    public static final int[] BUTTONIDS2 = new int[]{R.id.button19, R.id.button20, R.id.button21, R.id.button22,R.id.button23, R.id.button24, R.id.button25, R.id.button26, R.id.button27, R.id.button28, R.id.button29,R.id.button30,R.id.button31, R.id.button32, R.id.button33, R.id.button34, R.id.button35, R.id.button36};
    public static final int[] BUTTONIDS3 = new int[]{R.id.button37, R.id.button38, R.id.button39, R.id.button40,R.id.button41, R.id.button42, R.id.button43, R.id.button44, R.id.button45,R.id.button46, R.id.button47, R.id.button48, R.id.button49,R.id.button50,R.id.button51, R.id.button52, R.id.button53, R.id.button54};
    public static final int[] BUTTONIDS4 = new int[]{R.id.button55, R.id.button56, R.id.button57, R.id.button58,R.id.button59, R.id.button60, R.id.button61, R.id.button62, R.id.button63, R.id.button64, R.id.button65, R.id.button66, R.id.button67, R.id.button68, R.id.button69,R.id.button70,R.id.button71, R.id.button72};
    public static final int[] holeNumbers = new int[]{R.id.textView20,R.id.textView21,R.id.textView22,R.id.textView23,R.id.textView24,R.id.textView25,R.id.textView26,R.id.textView27,R.id.textView28};
    public static final int[] COURSEDATADIS = new int[]{R.id.textView198,R.id.textView203,R.id.textView204,R.id.textView205,R.id.textView206,R.id.textView207,R.id.textView217,R.id.textView220,R.id.textView221,R.id.textView231,R.id.textView230,R.id.textView232,R.id.textView233,R.id.textView234,R.id.textView235,R.id.textView236,R.id.textView237,R.id.textView238,R.id.textView239,R.id.textView240,R.id.textView241};
    public static final int[] COURSEDATAPAR = new int[]{R.id.textView202,R.id.textView222,R.id.textView223,R.id.textView224,R.id.textView225,R.id.textView226,R.id.textView227,R.id.textView228,R.id.textView229,R.id.textView242,R.id.textView243,R.id.textView244,R.id.textView245,R.id.textView246,R.id.textView247,R.id.textView248,R.id.textView249,R.id.textView250,R.id.textView251,R.id.textView252,R.id.textView253};
    public static final int[] ROWS = new int[]{R.id.outRow,R.id.Row10,R.id.Row11,R.id.Row12,R.id.Row13,R.id.Row14,R.id.Row15,R.id.Row16,R.id.Row17,R.id.Row18,R.id.inRow};
    public static final String PERSON1 = "person1";
    public static final String PERSON2 = "person2";
    public static final String PERSON3 = "person3";
    public static final String PERSON4 = "person4";
    public static final String HOLETAG = "holeTag";
    public static final String PLAYING = "playing";
    public static final String PERSONNUMTAG = "personNumTag";
    public static final String PERSONNAMEMTAG = "personNameTag";
    private ScoreDataBase db = new ScoreDataBase(this);
    private PersonDataBase pdb = new PersonDataBase(this);
    private YahooWeatherService service;
    int out1;int in1;int sum1;
    int out2;int in2;int sum2s;
    int out3;int in3;int sum3s;
    int out4;int in4;int sum4s;
    Time timeStarted;
    String courseName;
    String teeName;
    String temp;
    String condition;
    int playerNumber = 1;
    boolean full;
    private ArrayList<String> arraySpinner;
    String name = "";

    @Override
    public void onBackPressed() {

        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Do you want to discard round?");
        adb.setNegativeButton("Cancel",null);
        adb.setPositiveButton("Yes",new AlertDialog.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(PlayingCourse.this,MainActivity.class);
                startActivity(intent);
            }
        }).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_course);

        service = new YahooWeatherService(this);
        service.weather("Seattle, WA");
        timeStarted = new Time(System.currentTimeMillis());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Save Result?", Snackbar.LENGTH_LONG)
                            .setAction("Save", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    saveButtonClicked();
                                }
                            }).show();
                }
            });
        }
        Bundle extras = getIntent().getExtras();
        courseName = extras.getString("tag1");

        full = extras.getBoolean("tag2");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(courseName);
        setSupportActionBar(toolbar);

        arraySpinner = new ArrayList<>();
        arraySpinner.add("Guest");
        arraySpinner.add("New Name");

        nameSetter();
        setTeePosition();

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arraySpinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1){
                    addPersonName(1);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1){
                    addPersonName(2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner3.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1){
                    addPersonName(3);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinner4 = (Spinner)findViewById(R.id.spinner4);
        spinner4.setAdapter(adapter);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1){
                    addPersonName(4);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SharedPreferences prefs = getSharedPreferences(PERSON1, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            map.put(HOLENUMS[i], 0);
        }

        SharedPreferences prefs2 = getSharedPreferences(PERSON2, MODE_PRIVATE);
        SharedPreferences.Editor editor2 = prefs2.edit();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            map2.put(HOLENUMS[i], 0);
        }

        SharedPreferences pref3 = getSharedPreferences(PERSON3, MODE_PRIVATE);
        SharedPreferences.Editor editor3 = pref3.edit();
        Map<String, Integer> map3 = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            map3.put(HOLENUMS[i], 0);
        }
        SharedPreferences pref4 = getSharedPreferences(PERSON4, MODE_PRIVATE);
        SharedPreferences.Editor editor4 = pref4.edit();
        Map<String, Integer> map4 = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            map4.put(HOLENUMS[i], 0);
        }
        String scoreOndisplay = JSON.encode(map);
        editor.putString("temp", scoreOndisplay);
        editor.commit();
        String scoreOndisplay2 = JSON.encode(map2);
        editor2.putString("temp2", scoreOndisplay2);
        editor2.commit();
        String scoreOnDisplay3 = JSON.encode(map3);
        editor3.putString("temp3", scoreOnDisplay3);
        editor3.commit();
        String scoreOnDisplay4 = JSON.encode(map4);
        editor4.putString("temp4", scoreOnDisplay4);
        editor4.commit();

        if (full){
            addHoles();
        } else{
            diplayer();
        }
    }

    private void setTeePosition(){
        courseDataBase coursedatabase = new courseDataBase(this);
        ArrayList<String > teeData = coursedatabase.getTeeInfo(courseName);
        final Spinner teeChoice = (Spinner)findViewById(R.id.teePos);
        ArrayAdapter<String> teeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, teeData);
        teeChoice.setAdapter(teeAdapter);
        String tee = teeChoice.getSelectedItem().toString();
        teeName = tee;
        teeChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tee = teeChoice.getSelectedItem().toString();
                teeName = tee;
                setCourseData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        setCourseData();
    }

    private void setCourseData() {
        courseDataBase coursedatabase = new courseDataBase(this);
        ArrayList<String > courseData = coursedatabase.getCourseInfo(courseName,teeName);

        if(courseData.size() != 0){
            for (int i = 0;i<9;i++ ){
                TextView dist = (TextView)findViewById(COURSEDATADIS[i]);
                TextView pa = (TextView)findViewById(COURSEDATAPAR[i]);
                dist.setText(courseData.get(i*2+3));
                pa.setText(courseData.get(i*2+4));
            }
            if (full){
                for (int i = 9;i<21;i++ ){
                    TextView dist = (TextView)findViewById(COURSEDATADIS[i]);
                    TextView pa = (TextView)findViewById(COURSEDATAPAR[i]);
                    dist.setText(courseData.get(i*2+3));
                    pa.setText(courseData.get(i*2+4));
                }
            }else{
                TextView dist = (TextView)findViewById(COURSEDATADIS[20]);
                TextView pa = (TextView)findViewById(COURSEDATAPAR[20]);
                dist.setText(courseData.get(21));
                pa.setText(courseData.get(22));
            }
        }

    }

    private void nameSetter(){
        ArrayList<String> nameList = pdb.getNames();
        for (String object: nameList){
            arraySpinner.add(object);
        }
    }

    private void addPersonName(final int spinnerNum) {
        View view = (LayoutInflater.from(PlayingCourse.this)).inflate(R.layout.user_input,null);

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(PlayingCourse.this);
        alertBuilder.setView(view);
        final EditText userInput = (EditText)view.findViewById(R.id.userinput);
        alertBuilder.setCancelable(true);
        alertBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                name = userInput.getText().toString();
                pdb.addName(name);
                arraySpinner.add(name);
                switch (spinnerNum){
                    case 1:
                        Spinner spinner = (Spinner)findViewById(R.id.spinner);
                        ArrayAdapter myAdap = (ArrayAdapter) spinner.getAdapter(); //cast to an ArrayAdapter
                        int spinnerPosition = myAdap.getPosition(name);
                        spinner.setSelection(spinnerPosition);
                    case 2:
                        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
                        ArrayAdapter myAdap2 = (ArrayAdapter) spinner2.getAdapter(); //cast to an ArrayAdapter
                        int spinnerPosition2 = myAdap2.getPosition(name);
                        spinner2.setSelection(spinnerPosition2);
                    case 3:
                        Spinner spinner3 = (Spinner)findViewById(R.id.spinner3);
                        ArrayAdapter myAdap3 = (ArrayAdapter) spinner3.getAdapter(); //cast to an ArrayAdapter
                        int spinnerPosition3 = myAdap3.getPosition(name);
                        spinner3.setSelection(spinnerPosition3);
                    case 4:
                        Spinner spinner4 = (Spinner)findViewById(R.id.spinner4);
                        ArrayAdapter myAdap4 = (ArrayAdapter) spinner4.getAdapter(); //cast to an ArrayAdapter
                        int spinnerPosition4 = myAdap4.getPosition(name);
                        spinner4.setSelection(spinnerPosition4);
                }
            }
        });
        Dialog dialog = alertBuilder.create();
        dialog.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.playing_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.go_back) {
            Intent i = new Intent(PlayingCourse.this, MainActivity.class);
            startActivity(i);
        }
        if (id ==R.id.see_result){
            Intent i = new Intent(PlayingCourse.this, ResultPageZ.class);
            startActivity(i);
        }
        if (id == R.id.change_hole_number){

            reduceHoles();
            full = false;

        }
        if (id == R.id.change_hole_number2){

            addHoles();
            full = true;
        }
        if (id == R.id.reset_socre){
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle(getString(R.string.ask_reset));
            adb.setNegativeButton("Cancel",null);
            adb.setPositiveButton("Yes",new AlertDialog.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    resetScore();
                    diplayer();
                }
            }).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void reduceHoles() {

        for (int i = 0; i<11;i++){
            TableRow tableRow = (TableRow) findViewById(ROWS[i]);
            tableRow.setVisibility(View.GONE);
        }


        TextView textViewO2 = (TextView)findViewById(R.id.out2);
        textViewO2.setVisibility(View.GONE);
        TextView textViewI2 = (TextView)findViewById(R.id.in2);
        textViewI2.setVisibility(View.GONE);

        TextView textViewO3 = (TextView)findViewById(R.id.out3);
        textViewO3.setVisibility(View.GONE);
        TextView textViewI3 = (TextView)findViewById(R.id.in3);
        textViewI3.setVisibility(View.GONE);

        TextView textViewO4 = (TextView)findViewById(R.id.out4);
        textViewO4.setVisibility(View.GONE);
        TextView textViewI4 = (TextView)findViewById(R.id.in4);
        textViewI4.setVisibility(View.GONE);

        for (int i = 9; i<18;i++){
            Button button = (Button)findViewById(BUTTONIDS2[i]);
            button.setVisibility(View.GONE);
        }
        for (int i = 9; i<18;i++){
            Button button = (Button)findViewById(BUTTONIDS3[i]);
            button.setVisibility(View.GONE);
        }
        for (int i = 9; i<18;i++){
            Button button = (Button)findViewById(BUTTONIDS4[i]);
            button.setVisibility(View.GONE);
        }
        for (int i = 0; i<9;i++){
            TextView textView = (TextView)findViewById(holeNumbers[i]);
            textView.setVisibility(View.GONE);
        }

        full = false;
        setCourseData();
        diplayer();
    }

    private void addHoles() {
        full = true;
        for (int i = 0; i<11;i++){
            TableRow tableRow = (TableRow) findViewById(ROWS[i]);
            tableRow.setVisibility(View.VISIBLE);
        }
        setCourseData();
        if (playerNumber >= 2){
            for (int i = 9; i<18;i++){
                Button button = (Button)findViewById(BUTTONIDS2[i]);
                button.setVisibility(View.VISIBLE);
            }
            TextView textViewO2 = (TextView)findViewById(R.id.out2);
            textViewO2.setVisibility(View.VISIBLE);
            TextView textViewI2 = (TextView)findViewById(R.id.in2);
            textViewI2.setVisibility(View.VISIBLE);
            if (playerNumber >=3){
                for (int i = 9; i<18;i++){
                    Button button = (Button)findViewById(BUTTONIDS3[i]);
                    button.setVisibility(View.VISIBLE);
                }
                TextView textViewO3 = (TextView)findViewById(R.id.out3);
                textViewO3.setVisibility(View.VISIBLE);
                TextView textViewI3 = (TextView)findViewById(R.id.in3);
                textViewI3.setVisibility(View.VISIBLE);
                if (playerNumber == 4){
                    for (int i = 9; i<18;i++){
                        Button button = (Button)findViewById(BUTTONIDS4[i]);
                        button.setVisibility(View.VISIBLE);
                    }
                    TextView textViewO4 = (TextView)findViewById(R.id.out4);
                    textViewO4.setVisibility(View.VISIBLE);
                    TextView textViewI4 = (TextView)findViewById(R.id.in4);
                    textViewI4.setVisibility(View.VISIBLE);
                }
            }
        }

        for (int i = 0; i<9;i++){
            TextView textView = (TextView)findViewById(holeNumbers[i]);
            textView.setVisibility(View.VISIBLE);
        }

    }

    private void diplayer() {

        SharedPreferences prefs = getSharedPreferences(PERSON1, MODE_PRIVATE);
        String value = prefs.getString("temp", "missing");
        Map map = JSON.decode(value);
        out1 = 0;
        in1 =0;
        for (int i = 0; i < 9; i++) {
            String hole = map.get(HOLENUMS[i]).toString();
            int ho = Integer.parseInt(hole);
            Button button = (Button) findViewById(BUTTONIDS[i]);
            button.setText(hole);
            out1 = out1+ho;
        }
        for (int i = 9; i < 18; i++) {
            String hole = map.get(HOLENUMS[i]).toString();
            int ho = Integer.parseInt(hole);
            Button button = (Button) findViewById(BUTTONIDS[i]);
            button.setText(hole);
            in1 = in1+ho;
        }

        SharedPreferences prefs2 = getSharedPreferences(PERSON2, MODE_PRIVATE);
        String value2 = prefs2.getString("temp2", "missing");
        Map map2 = JSON.decode(value2);
        out2 = 0;
        in2 = 0;
        for (int i = 0; i < 9; i++) {
            String hole = map2.get(HOLENUMS[i]).toString();
            int ho = Integer.parseInt(hole);
            Button button = (Button) findViewById(BUTTONIDS2[i]);
            button.setText(hole);
            out2 = out2+ho;
        }
        for (int i = 9; i < 18; i++) {
            String hole = map2.get(HOLENUMS[i]).toString();
            int ho = Integer.parseInt(hole);
            Button button = (Button) findViewById(BUTTONIDS2[i]);
            button.setText(hole);
            in2 = in2+ho;
        }

        SharedPreferences prefs3 = getSharedPreferences(PERSON3, MODE_PRIVATE);
        String value3 = prefs3.getString("temp3", "missing");
        Map map3 = JSON.decode(value3);
        out3 = 0;
        in3 = 0;
        for (int i = 0; i < 9; i++) {
            String hole = map3.get(HOLENUMS[i]).toString();
            int ho = Integer.parseInt(hole);
            Button button = (Button) findViewById(BUTTONIDS3[i]);
            button.setText(hole);
            out3 = out3+ho;
        }
        for (int i = 9; i < 18; i++) {
            String hole = map3.get(HOLENUMS[i]).toString();
            int ho = Integer.parseInt(hole);
            Button button = (Button) findViewById(BUTTONIDS3[i]);
            button.setText(hole);
            in3 = in3+ho;
        }

        SharedPreferences prefs4 = getSharedPreferences(PERSON4, MODE_PRIVATE);
        String value4 = prefs4.getString("temp4", "missing");
        Map map4 = JSON.decode(value4);
        out4 = 0;
        in4 = 0;
        for (int i = 0; i < 9; i++) {
            String hole = map4.get(HOLENUMS[i]).toString();
            int ho = Integer.parseInt(hole);
            Button button = (Button) findViewById(BUTTONIDS4[i]);
            button.setText(hole);
            out4 = out4+ho;
        }
        for (int i = 9; i < 18; i++) {
            String hole = map4.get(HOLENUMS[i]).toString();
            int ho = Integer.parseInt(hole);
            Button button = (Button) findViewById(BUTTONIDS4[i]);
            button.setText(hole);
            in4 = in4+ho;
        }



        if (full){
            sum1 = out1 + in1;
            sum2s = out2 + in2;
            sum3s = out3 + in3;
            sum4s = out4 + in4;
        } else {
            sum1 = out1;
            sum2s = out2;
            sum3s = out3;
            sum4s = out4;
        }

        String sum = String.valueOf(sum1);
        TextView textview = (TextView) findViewById(R.id.textView);
        textview.setText(sum);

        if (full){
            String out = String.valueOf(out1);
            String in = String.valueOf(in1);
            TextView textviewO = (TextView) findViewById(R.id.out1);
            textviewO.setText(out);
            TextView textviewI = (TextView) findViewById(R.id.in1);
            textviewI.setText(in);
        }

        String sum2 = String.valueOf(sum2s);
        TextView textview2 = (TextView) findViewById(R.id.textView2);
        textview2.setText(sum2);
        if (full){
            String out = String.valueOf(out2);
            String in = String.valueOf(in2);
            TextView textviewO = (TextView) findViewById(R.id.out2);
            textviewO.setText(out);
            TextView textviewI = (TextView) findViewById(R.id.in2);
            textviewI.setText(in);
        }

        String sum3 = String.valueOf(sum3s);
        TextView textview3 = (TextView) findViewById(R.id.textView3s);
        textview3.setText(sum3);
        if (full){
            String out = String.valueOf(out3);
            String in = String.valueOf(in3);
            TextView textviewO = (TextView) findViewById(R.id.out3);
            textviewO.setText(out);
            TextView textviewI = (TextView) findViewById(R.id.in3);
            textviewI.setText(in);
        }

        String sum4 = String.valueOf(sum4s);
        TextView textview4 = (TextView) findViewById(R.id.textView4s);
        textview4.setText(sum4);
        if (full){
            String out = String.valueOf(out4);
            String in = String.valueOf(in4);
            TextView textviewO = (TextView) findViewById(R.id.out4);
            textviewO.setText(out);
            TextView textviewI = (TextView) findViewById(R.id.in4);
            textviewI.setText(in);
        }

    }

    private void resetScore(){

        service = new YahooWeatherService(this);
        service.weather("Seattle, WA");
        timeStarted = new Time(System.currentTimeMillis());

        SharedPreferences prefs = getSharedPreferences(PERSON1, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            map.put(HOLENUMS[i], 0);
        }

        SharedPreferences prefs2 = getSharedPreferences(PERSON2, MODE_PRIVATE);
        SharedPreferences.Editor editor2 = prefs2.edit();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            map2.put(HOLENUMS[i], 0);
        }

        SharedPreferences pref3 = getSharedPreferences(PERSON3, MODE_PRIVATE);
        SharedPreferences.Editor editor3 = pref3.edit();
        Map<String, Integer> map3 = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            map3.put(HOLENUMS[i], 0);
        }
        SharedPreferences pref4 = getSharedPreferences(PERSON4, MODE_PRIVATE);
        SharedPreferences.Editor editor4 = pref4.edit();
        Map<String, Integer> map4 = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            map4.put(HOLENUMS[i], 0);
        }
        String scoreOndisplay = JSON.encode(map);
        editor.putString("temp", scoreOndisplay);
        editor.commit();
        String scoreOndisplay2 = JSON.encode(map2);
        editor2.putString("temp2", scoreOndisplay2);
        editor2.commit();
        String scoreOnDisplay3 = JSON.encode(map3);
        editor3.putString("temp3", scoreOnDisplay3);
        editor3.commit();
        String scoreOnDisplay4 = JSON.encode(map4);
        editor4.putString("temp4", scoreOnDisplay4);
        editor4.commit();
    }

    public void buttonOnClick(View view) {
        ArrayList<String> nameList = new ArrayList<>();
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner);
        String personName1 = spinner1.getSelectedItem().toString();
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        String personName2 = spinner2.getSelectedItem().toString();
        Spinner spinner3 = (Spinner)findViewById(R.id.spinner3);
        String personName3 = spinner3.getSelectedItem().toString();
        Spinner spinner4 = (Spinner)findViewById(R.id.spinner4);
        String personName4 = spinner4.getSelectedItem().toString();
        nameList.add(personName1);
        nameList.add(personName2);
        nameList.add(personName3);
        nameList.add(personName4);
        Intent i = new Intent(PlayingCourse.this, ScoreEditor.class);
        i.putExtra(PERSONNUMTAG,playerNumber);
        i.putExtra(PERSONNAMEMTAG,nameList);
        for (int j = 0;j<18;j++){
            if (view.getId() == BUTTONIDS[j]){
                i.putExtra(HOLETAG, HOLENUMS[j]);
                startActivityForResult(i, NUMBER);
                break;
            }
        }
        for (int j = 0;j<18;j++){
            if (view.getId() == BUTTONIDS2[j]){
                i.putExtra(HOLETAG, HOLENUMS[j]);
                startActivityForResult(i, NUMBER);
                break;
            }
        }
        for (int j = 0;j<18;j++){
            if (view.getId() == BUTTONIDS3[j]){
                i.putExtra(HOLETAG, HOLENUMS[j]);
                startActivityForResult(i, NUMBER);
                break;
            }
        }
        for (int j = 0;j<18;j++){
            if (view.getId() == BUTTONIDS4[j]){
                i.putExtra(HOLETAG, HOLENUMS[j]);
                startActivityForResult(i, NUMBER);
                break;
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        diplayer();
    }

    public void saveButtonClicked() {

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        final String courseName = (String) tb.getTitle();

        Time now = new Time(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        final String date = dateFormat.format(now);
        final String shuryoTime = timeFormat.format(now);

        long timeEnded = now.getTime();
        long timeStart = timeStarted.getTime();
        long diff = (timeEnded-timeStart);
        String hours = String.valueOf(TimeUnit.MILLISECONDS.toHours(diff));
        long onlymin;
        if (TimeUnit.MILLISECONDS.toHours(diff) ==0){
            onlymin = TimeUnit.MILLISECONDS.toMinutes(diff);
        } else {
            onlymin = (TimeUnit.MILLISECONDS.toMinutes(diff))%(60);

        }
        final String startTimeString = String.valueOf(timeStarted);

        String mins = String.valueOf(onlymin);
        final String duration = hours+" hrs "+mins+" mins";


        Spinner spinner1 = (Spinner)findViewById(R.id.spinner);
        final String personName = spinner1.getSelectedItem().toString();

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        final String personName2 = spinner2.getSelectedItem().toString();

        Spinner spinner3 = (Spinner)findViewById(R.id.spinner3);
        final String personName3 = spinner3.getSelectedItem().toString();

        Spinner spinner4 = (Spinner)findViewById(R.id.spinner4);
        final String personName4 = spinner4.getSelectedItem().toString();

        final String[] previewList = new String[]{null,null,null,null,null,null,null,null};

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {

                SharedPreferences prefs = getSharedPreferences(PERSON1, MODE_PRIVATE);
                String value = prefs.getString("temp", "missing");
                Map map = JSON.decode(value);
                db.saveScore(personName, courseName, map, date, startTimeString,duration, out1, in1,sum1,full);

                String qpersonName = "'"+personName+"'"; String qsum1 = "' score: "+sum1+"'";
                previewList[0]= qpersonName; previewList[1]=String.valueOf(qsum1);
                if (playerNumber >= 2){
                    SharedPreferences prefs2 = getSharedPreferences(PERSON2, MODE_PRIVATE);
                    String value2 = prefs2.getString("temp2", "missing");
                    Map map2 = JSON.decode(value2);
                    db.saveScore(personName2, courseName, map2, date, startTimeString,duration, out2, in2,sum2s,full);
                    String qpersonName2 = "'"+personName2+"'"; String qsum2 = "' score: "+sum2s+"'";
                    previewList[2]= qpersonName2; previewList[3]=String.valueOf(qsum2);
                    if (playerNumber >=3){
                        SharedPreferences prefs3 = getSharedPreferences(PERSON3, MODE_PRIVATE);
                        String value3 = prefs3.getString("temp3", "missing");
                        Map map3 = JSON.decode(value3);
                        db.saveScore(personName3, courseName, map3, date, startTimeString,duration,out3, in3, sum3s,full);
                        String qpersonName3 = "'"+personName3+"'"; String qsum3 = "' score: "+sum3s+"'";
                        previewList[4]= qpersonName3; previewList[5]=String.valueOf(qsum3);
                        if (playerNumber == 4){
                            SharedPreferences prefs4 = getSharedPreferences(PERSON4, MODE_PRIVATE);
                            String value4 = prefs4.getString("temp4", "missing");
                            Map map4 = JSON.decode(value4);
                            db.saveScore(personName4, courseName, map4, date, startTimeString,duration,out4, in4, sum4s,full);
                            String qpersonName4 = "'"+personName4+"'"; String qsum4 = "' score: "+sum4s+"'";
                            previewList[6]= qpersonName4; previewList[7]=String.valueOf(qsum4);
                        }
                    }
                }
                db.saveScoreForPreview(courseName,teeName,date, startTimeString,shuryoTime,duration,condition,temp,String.valueOf(playerNumber),previewList);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(PlayingCourse.this,"SCORE SAVED",Toast.LENGTH_SHORT).show();
                SharedPreferences prefs = getSharedPreferences(PLAYING, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("check", false);
                editor.commit();
                Intent i = new Intent(PlayingCourse.this,MainActivity.class);
                startActivity(i);
            }
        }.execute();
    }

    public void addPlayer(View view) {

        if (playerNumber == 1){
            Spinner spinner = (Spinner)findViewById(R.id.spinner2);
            spinner.setVisibility(View.VISIBLE);
            for (int i = 0; i<9;i++){
                Button button = (Button)findViewById(BUTTONIDS2[i]);
                button.setVisibility(View.VISIBLE);
            }
            TextView textView = (TextView)findViewById(R.id.textView2);
            textView.setVisibility(View.VISIBLE);
            playerNumber = 2;
            Button removeButton = (Button)findViewById(R.id.removePlayerButton);
            removeButton.setVisibility(View.VISIBLE);
            if (full){
                for (int i = 9; i<18;i++){
                    Button button = (Button)findViewById(BUTTONIDS2[i]);
                    button.setVisibility(View.VISIBLE);
                }
                TextView textViewO2 = (TextView)findViewById(R.id.out2);
                textViewO2.setVisibility(View.VISIBLE);
                TextView textViewI2 = (TextView)findViewById(R.id.in2);
                textViewI2.setVisibility(View.VISIBLE);

            }
            return;
        }
        if (playerNumber == 2){
            Spinner spinner = (Spinner)findViewById(R.id.spinner3);
            spinner.setVisibility(View.VISIBLE);
            for (int i = 0; i<9;i++){
                Button button = (Button)findViewById(BUTTONIDS3[i]);
                button.setVisibility(View.VISIBLE);
            }
            TextView textView = (TextView)findViewById(R.id.textView3s);
            textView.setVisibility(View.VISIBLE);
            if (full){
                for (int i = 9; i<18;i++){
                    Button button = (Button)findViewById(BUTTONIDS3[i]);
                    button.setVisibility(View.VISIBLE);
                }
                TextView textViewO3 = (TextView)findViewById(R.id.out3);
                textViewO3.setVisibility(View.VISIBLE);
                TextView textViewI3 = (TextView)findViewById(R.id.in3);
                textViewI3.setVisibility(View.VISIBLE);
            }
            playerNumber = 3;
            return;
        }
        if (playerNumber == 3){
            Spinner spinner = (Spinner)findViewById(R.id.spinner4);
            spinner.setVisibility(View.VISIBLE);
            for (int i = 0; i<9;i++){
                Button button = (Button)findViewById(BUTTONIDS4[i]);
                button.setVisibility(View.VISIBLE);
            }
            TextView textView = (TextView)findViewById(R.id.textView4s);
            textView.setVisibility(View.VISIBLE);
            if (full){
                for (int i = 9; i<18;i++){
                    Button button = (Button)findViewById(BUTTONIDS4[i]);
                    button.setVisibility(View.VISIBLE);
                }
                TextView textViewO4 = (TextView)findViewById(R.id.out4);
                textViewO4.setVisibility(View.VISIBLE);
                TextView textViewI4 = (TextView)findViewById(R.id.in4);
                textViewI4.setVisibility(View.VISIBLE);
            }
            playerNumber = 4;
            Button addButton = (Button)findViewById(R.id.addPlayerbutton);
            addButton.setVisibility(View.GONE);
            return;
        }




    }

    public void removePlayer(View view) {
        if (playerNumber == 4){
            Spinner spinner = (Spinner)findViewById(R.id.spinner4);
            spinner.setVisibility(View.GONE);
            for (int i = 0; i<9;i++){
                Button button = (Button)findViewById(BUTTONIDS4[i]);
                button.setVisibility(View.GONE);
            }
            if (full){
                for (int i = 9; i<18;i++){
                    Button button = (Button)findViewById(BUTTONIDS4[i]);
                    button.setVisibility(View.GONE);
                }
                TextView textViewO4 = (TextView)findViewById(R.id.out4);
                textViewO4.setVisibility(View.GONE);
                TextView textViewI4 = (TextView)findViewById(R.id.in4);
                textViewI4.setVisibility(View.GONE);
            }
            TextView textView = (TextView)findViewById(R.id.textView4s);
            textView.setVisibility(View.GONE);
            playerNumber = 3;
            Button addButton = (Button)findViewById(R.id.addPlayerbutton);
            addButton.setVisibility(View.VISIBLE);
            return;
        }
        if (playerNumber == 3){
            Spinner spinner = (Spinner)findViewById(R.id.spinner3);
            spinner.setVisibility(View.GONE);
            for (int i = 0; i<9;i++){
                Button button = (Button)findViewById(BUTTONIDS3[i]);
                button.setVisibility(View.GONE);
            }
            if (full){
                for (int i = 9; i<18;i++){
                    Button button = (Button)findViewById(BUTTONIDS3[i]);
                    button.setVisibility(View.GONE);
                }
                TextView textViewO3 = (TextView)findViewById(R.id.out3);
                textViewO3.setVisibility(View.GONE);
                TextView textViewI3 = (TextView)findViewById(R.id.in3);
                textViewI3.setVisibility(View.GONE);
            }
            TextView textView = (TextView)findViewById(R.id.textView3s);
            textView.setVisibility(View.GONE);

            playerNumber = 2;
            return;
        }
        if (playerNumber == 2){
            Spinner spinner = (Spinner)findViewById(R.id.spinner2);
            spinner.setVisibility(View.GONE);
            for (int i = 0; i<9;i++){
                Button button = (Button)findViewById(BUTTONIDS2[i]);
                button.setVisibility(View.GONE);
            }
            if (full){
                for (int i = 9; i<18;i++){
                    Button button = (Button)findViewById(BUTTONIDS2[i]);
                    button.setVisibility(View.GONE);
                }
                TextView textViewO2 = (TextView)findViewById(R.id.out2);
                textViewO2.setVisibility(View.GONE);
                TextView textViewI2 = (TextView)findViewById(R.id.in2);
                textViewI2.setVisibility(View.GONE);
            }
            TextView textView = (TextView)findViewById(R.id.textView2);
            textView.setVisibility(View.GONE);
            playerNumber = 1;
            Button removeButton = (Button)findViewById(R.id.removePlayerButton);
            removeButton.setVisibility(View.GONE);
            return;
        }
    }

    @Override
    public void serviceSuccess(Channel channel) {

        Item item = channel.getItem();

        temp = String.valueOf(item.getCondition().getTemp());
        condition = item.getCondition().getText();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(timeStarted);


        TextView showTime = (TextView)findViewById(R.id.dateInPlayingCourse);
        showTime.setText(time);
        TextView showTemp = (TextView)findViewById(R.id.tempInPlayingCourse);
        showTemp.setText(temp);

    }

    @Override
    public void serviceFailure(Exception e) {

        Toast.makeText(this,"couldn't get weather data",Toast.LENGTH_SHORT).show();

    }
}
