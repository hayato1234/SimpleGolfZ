package com.smileman.toshiba.simplegolfz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import net.arnx.jsonic.JSON;
/**
 * Created by toshiba on 2016/04/29.
 */
public class ScoreEditor extends AppCompatActivity {

    int par = 3;
    int intScore;
    int intScore2;
    int intScore3;
    int intScore4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_editor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Bundle extras = getIntent().getExtras();
        String holeNumber = extras.getString(PlayingCourse.HOLETAG);

        toolbar.setTitle(holeNumber);
        ArrayList<String> nameList = extras.getStringArrayList(PlayingCourse.PERSONNAMEMTAG);
        TextView textView = (TextView)findViewById(R.id.numberPickerName1);
        textView.setText(nameList.get(0));

        NumberPicker strokeEdit = (NumberPicker)findViewById(R.id.numberPicker1);
        strokeEdit.setMinValue(0);
        strokeEdit.setMaxValue(30);
        strokeEdit.setWrapSelectorWheel(false);
        SharedPreferences prefs = getSharedPreferences(PlayingCourse.PERSON1, MODE_PRIVATE);
        String maps = prefs.getString("temp", "no map found");
        Map map = JSON.decode(maps);
        String score = map.get(holeNumber).toString();
        intScore = Integer.parseInt(score);
        if (intScore == 0){
            strokeEdit.setValue(par);
        } else {
            strokeEdit.setValue(intScore);
        }

        int numberOfPerson = extras.getInt(PlayingCourse.PERSONNUMTAG);
        if (numberOfPerson >=  2){
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.pickerLayout2);
            linearLayout.setVisibility(View.VISIBLE);
            TextView textView2 = (TextView)findViewById(R.id.numberPickerName2);
            textView2.setText(nameList.get(1));

            NumberPicker strokeEdit2 = (NumberPicker)findViewById(R.id.numberPicker2);
            strokeEdit2.setMinValue(0);
            strokeEdit2.setMaxValue(30);
            strokeEdit2.setWrapSelectorWheel(false);
            SharedPreferences prefs2 = getSharedPreferences(PlayingCourse.PERSON2, MODE_PRIVATE);
            String maps2 = prefs2.getString("temp2", "no map found");
            Map map2 = JSON.decode(maps2);
            String score2 = map2.get(holeNumber).toString();
            intScore2 = Integer.parseInt(score2);

            if (intScore2 == 0){
                strokeEdit2.setValue(par);
            } else {
                strokeEdit2.setValue(intScore2);
            }

            if (numberOfPerson >=  3){
                LinearLayout linearLayout2 = (LinearLayout)findViewById(R.id.pickerLayout3);
                linearLayout2.setVisibility(View.VISIBLE);
                TextView textView3 = (TextView)findViewById(R.id.numberPickerName3);
                textView3.setText(nameList.get(2));

                NumberPicker strokeEdit3 = (NumberPicker)findViewById(R.id.numberPicker3);
                strokeEdit3.setMinValue(0);
                strokeEdit3.setMaxValue(30);
                strokeEdit3.setWrapSelectorWheel(false);
                SharedPreferences prefs3 = getSharedPreferences(PlayingCourse.PERSON3, MODE_PRIVATE);
                String maps3 = prefs3.getString("temp3", "no map found");
                Map map3 = JSON.decode(maps3);
                String score3 = map3.get(holeNumber).toString();
                intScore3 = Integer.parseInt(score3);

                if (intScore3 == 0){
                    strokeEdit3.setValue(par);
                } else {
                    strokeEdit3.setValue(intScore3);
                }

                if (numberOfPerson >=  4){
                    LinearLayout linearLayout3 = (LinearLayout)findViewById(R.id.pickerLayout4);
                    linearLayout3.setVisibility(View.VISIBLE);
                    TextView textView4 = (TextView)findViewById(R.id.numberPickerName4);
                    textView4.setText(nameList.get(3));

                    NumberPicker strokeEdit4 = (NumberPicker)findViewById(R.id.numberPicker4);
                    strokeEdit4.setMinValue(0);
                    strokeEdit4.setMaxValue(30);
                    strokeEdit4.setWrapSelectorWheel(false);
                    SharedPreferences prefs4 = getSharedPreferences(PlayingCourse.PERSON4, MODE_PRIVATE);
                    String maps4 = prefs4.getString("temp4", "no map found");
                    Map map4 = JSON.decode(maps4);
                    String score4 = map4.get(holeNumber).toString();
                    intScore4 = Integer.parseInt(score4);
                    if (intScore4 == 0){
                        strokeEdit4.setValue(par);
                    } else {
                        strokeEdit4.setValue(intScore4);
                    }
                }
            }
        }
    }

    public void saveStrokeButton(View view) {
        Bundle extras = getIntent().getExtras();
        String holeNumber = extras.getString(PlayingCourse.HOLETAG);
        int personNum = extras.getInt(PlayingCourse.PERSONNUMTAG);

        NumberPicker strokeEdit = (NumberPicker)findViewById(R.id.numberPicker1);
        int score = strokeEdit.getValue();
        SharedPreferences prefs1 = getSharedPreferences(PlayingCourse.PERSON1, MODE_PRIVATE);
        String maps1 = prefs1.getString("temp", "no map found");
        Map map1 = JSON.decode(maps1);
        map1.put(holeNumber, score);
        String tst1 = JSON.encode(map1);
        SharedPreferences.Editor editor1 = prefs1.edit();
        editor1.putString("temp", tst1);
        editor1.commit();

        if (personNum >= 2){
            NumberPicker strokeEdit2 = (NumberPicker)findViewById(R.id.numberPicker2);
            int score2 = strokeEdit2.getValue();
            SharedPreferences prefs = getSharedPreferences(PlayingCourse.PERSON2, MODE_PRIVATE);
            String maps = prefs.getString("temp2", "no map found");
            Map map = JSON.decode(maps);
            map.put(holeNumber, score2);
            String tst = JSON.encode(map);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("temp2", tst);
            editor.commit();
            if (personNum >=3){
                NumberPicker strokeEdit3 = (NumberPicker)findViewById(R.id.numberPicker3);
                int score3 = strokeEdit3.getValue();
                SharedPreferences prefs3 = getSharedPreferences(PlayingCourse.PERSON3, MODE_PRIVATE);
                String maps3 = prefs3.getString("temp3", "no map found");
                Map map3 = JSON.decode(maps3);
                map3.put(holeNumber, score3);
                String tst3 = JSON.encode(map3);
                SharedPreferences.Editor editor3 = prefs3.edit();
                editor3.putString("temp3", tst3);
                editor3.commit();
            }
            if (personNum == 4){
                NumberPicker strokeEdit4 = (NumberPicker)findViewById(R.id.numberPicker4);
                int score4 = strokeEdit4.getValue();
                SharedPreferences prefs4 = getSharedPreferences(PlayingCourse.PERSON4, MODE_PRIVATE);
                String maps4 = prefs4.getString("temp4", "no map found");
                Map map4 = JSON.decode(maps4);
                map4.put(holeNumber, score4);
                String tst4 = JSON.encode(map4);
                SharedPreferences.Editor editor4 = prefs4.edit();
                editor4.putString("temp4", tst4);
                editor4.commit();
            }
        }

        setResult(RESULT_OK);
        finish();
    }
}
