package com.smileman.toshiba.simplegolfz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowDetailData extends AppCompatActivity {

    public static final int[] SCOREROW1 = new int[]{R.id.textView62,R.id.textView44,R.id.textView53,R.id.textView113,R.id.textView65,R.id.textView117,R.id.textView102,R.id.textView121,R.id.textView106,R.id.textView125};
    public static final int[] SCOREROW1s = new int[]{R.id.textViewOUT,R.id.textView162,R.id.textView11hole1,R.id.textView153,R.id.textView1113,R.id.textView165,R.id.textView1117,R.id.textView1102,R.id.textView1121,R.id.textView1106,R.id.textView1125};
    public static final int[] SCOREROW2 = new int[]{R.id.textView59,R.id.textView45,R.id.textView110,R.id.textView54,R.id.textView114,R.id.textView99,R.id.textView118,R.id.textView103,R.id.textView122,R.id.textView107,R.id.textViewSum2};
    public static final int[] SCOREROW2s = new int[]{R.id.textViewOUT2,R.id.textView10hole2,R.id.textView11hole2,R.id.textView12hole2,R.id.textView13hole2,R.id.textView14hole2,R.id.textView15hole2,R.id.textView16hole2,R.id.textView17hole2,R.id.textView18hole2,R.id.textViewIn2};
    public static final int[] SCOREROW3 = new int[]{R.id.textView60,R.id.textView46,R.id.textView111,R.id.textView63,R.id.textView115,R.id.textView100,R.id.textView119,R.id.textView104,R.id.textView123,R.id.textView108,R.id.textViewSum3};
    public static final int[] SCOREROW3s = new int[]{R.id.textViewOUT3,R.id.textView10hole3,R.id.textView11hole3,R.id.textView12hole3,R.id.textView13hole3,R.id.textView14hole3,R.id.textView15hole3,R.id.textView16hole3,R.id.textView17hole3,R.id.textView18hole3,R.id.textViewIn3};
    public static final int[] SCOREROW4 = new int[]{R.id.textView61,R.id.textView47,R.id.textView112,R.id.textView64,R.id.textView116,R.id.textView101,R.id.textView120,R.id.textView105,R.id.textView124,R.id.textView109,R.id.textViewSum4};
    public static final int[] SCOREROW4s = new int[]{R.id.textViewOUT4,R.id.textView10hole4,R.id.textView11hole4,R.id.textView12hole4,R.id.textView13hole4,R.id.textView14hole4,R.id.textView15hole4,R.id.textView16hole4,R.id.textView17hole4,R.id.textView18hole4,R.id.textViewIn4};
    public static final int[][] rowList = new int[][]{SCOREROW1,SCOREROW1s,SCOREROW2,SCOREROW2s,SCOREROW3,SCOREROW3s,SCOREROW4,SCOREROW4s};
    public static final int[] TABLEROW = new int[]{R.id.tableRow2,R.id.tableRow2s,R.id.tableRow3,R.id.tableRow3s,R.id.tableRow4,R.id.tableRow4s};
    public static final int[] dis = new int[]{R.id.textView86,R.id.textView48,R.id.textView170,R.id.textView174,R.id.textView171,R.id.textView175,R.id.textView172,R.id.textView176,R.id.textView173,R.id.textView157,R.id.textView51,R.id.textView180,R.id.textView126,R.id.textView181,R.id.textView177,R.id.textView182,R.id.textView178,R.id.textView185,R.id.textView179,R.id.textView197,R.id.textView183,R.id.textView39};
    public static final int[] par = new int[]{R.id.textView38,R.id.textView43,R.id.textView129,R.id.textView134,R.id.textView131,R.id.textView135,R.id.textView132,R.id.textView136,R.id.textView133,R.id.textView98,R.id.textView156,R.id.textView151,R.id.textView127,R.id.textView152,R.id.textView128,R.id.textView154,R.id.textView145,R.id.textView155,R.id.textView149,R.id.textView76,R.id.textView137};
    courseDataBase coursedatabase = new courseDataBase(this);
    ScoreDataBase db = new ScoreDataBase(this);
    ArrayList<String> scorelist;
    boolean full = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Bundle extras = getIntent().getExtras();
        String date = extras.getString(ResultPageZ.DATE);
        String time = extras.getString(ResultPageZ.TIME);
        scorelist = db.getScore(date,time);
        String courseName = scorelist.get(1);
        ArrayList<String> playInfo = db.getPlayFromPreview(date,time);
        String teePlayed = playInfo.get(0);
        ArrayList<String > courseData = coursedatabase.getCourseInfo(courseName,teePlayed);
        TextView teeOnScreen = (TextView)findViewById(dis[21]);
        teeOnScreen.setText(teePlayed);
        for (int i = 0;i<21;i++ ){
            TextView dist = (TextView)findViewById(dis[i]);
            TextView pa = (TextView)findViewById(par[i]);
            dist.setText(courseData.get(i*2+3));
            pa.setText(courseData.get(i*2+4));
        }

        toolbar.setTitle(courseName);
        TextView textViewDate = (TextView)findViewById(R.id.dateInDetail);
        textViewDate.setText(playInfo.get(1));
        TextView textViewTime = (TextView)findViewById(R.id.timeInDetail);
        textViewTime.setText(playInfo.get(2));
        TextView textViewEnd = (TextView)findViewById(R.id.endTimeIndetail);
        textViewEnd.setText(playInfo.get(6));
        TextView textViewDua = (TextView)findViewById(R.id.duarationInDetail);
        textViewDua.setText(playInfo.get(3));
        TextView textViewCond = (TextView)findViewById(R.id.conditionInDetail);
        textViewCond.setText(playInfo.get(4));
        TextView textViewTemp = (TextView)findViewById(R.id.tempInDetail);
        textViewTemp.setText(playInfo.get(5));

        TextView textViewN = (TextView)findViewById(R.id.textView58);
        textViewN.setText(scorelist.get(0));

        for (int i=0;i<9;i++){
            TextView textView = (TextView)findViewById(SCOREROW1[i]);
            textView.setText(scorelist.get(i+5));
        }

        if ((scorelist.get(15)).equals("0")){
            TextView textView = (TextView)findViewById(SCOREROW1[9]);
            textView.setText(scorelist.get(16));

        } else {
            full = true;
            TableLayout tableLayout = (TableLayout)findViewById(R.id.tableLayoutFor18);
            tableLayout.setVisibility(textViewN.VISIBLE);
            TextView textView1 = (TextView)findViewById(SCOREROW1s[0]);
            textView1.setText(scorelist.get(16));
            TextView textView2 = (TextView)findViewById(SCOREROW1s[1]);
            textView2.setText(scorelist.get(14));
            for (int i = 2; i<11;i++){
                TextView textView3 = (TextView)findViewById(SCOREROW1s[i]);
                textView3.setText(scorelist.get(i+15));
            }
            TextView textView = (TextView)findViewById(SCOREROW1[9]);
            textView.setText(scorelist.get(26));
        }
        if (scorelist.get(27) == "1"){
            scoreForNextPerson(0,0,2);
            if (scorelist.get(55)=="1"){
                scoreForNextPerson(1,2,4);
                if (scorelist.get(83)=="1"){
                    scoreForNextPerson(2,4,6);
                }
            }
        }
    }

    private void scoreForNextPerson(int x,int a, int b){
        int y = 28*x;
        TableRow tableRow2 = (TableRow)findViewById(TABLEROW[a]);
        tableRow2.setVisibility(View.VISIBLE);
        TextView textViewName2 = (TextView)findViewById(rowList[b][0]);
        textViewName2.setText(scorelist.get(28+y));

        for (int i=1;i<10;i++){
            TextView textView = (TextView)findViewById(rowList[b][i]);
            textView.setText(scorelist.get(i+32+y));
        }
        TextView scoreSum2 = (TextView)findViewById(rowList[b][10]);
        scoreSum2.setVisibility(View.VISIBLE);
        scoreSum2.setText(scorelist.get(54+y));
        if (full){
            TableRow tableRow2s = (TableRow)findViewById(TABLEROW[a+1]);
            tableRow2s.setVisibility(View.VISIBLE);
            TextView textViewForOut2 = (TextView)findViewById(rowList[b+1][0]);
            textViewForOut2.setText(scorelist.get(44+y));
            TextView textViewHole10s = (TextView)findViewById(rowList[b+1][1]);
            textViewHole10s.setText(scorelist.get(42+y));
            for (int i = 2; i<11;i++){
                TextView textView3 = (TextView)findViewById(rowList[b+1][i]);
                textView3.setText(scorelist.get(i+43+y));
            }
        }
    }
}
