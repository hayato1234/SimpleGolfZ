package com.smileman.toshiba.simplegolfz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by toshiba on 2016/05/02.
 */
public class ScoreDataBase extends SQLiteOpenHelper {

    protected static final String ID = "_id";
    private static final String SCORE_TABLE = "golf_score_table";
    private static final String PREVIEW_TABLE = "preview_table";
    protected static final String PERSON_NAME = "name";
    protected static final String NUMBER_OF_PLAYER = "number_of_player";
    protected static final String COURSE_NAME = "course";
    protected static final String TEE_POS = "tee_position";
    protected static final String DATE = "date";
    protected static final String TIME = "time";
    protected static final String TIMEENDED = "timeedned";
    protected static final String STARTEDTIME = "timeStarted";
    protected static final String DURATION = "timeDuration";
    protected static final String WEATHER = "weather";
    protected static final String TEMP = "temperature";
    protected static final String SUM = "total";
    protected static final String FULL = "ifFull";
    protected static final String OUT = "out";
    protected static final String IN = "inValue";
    protected static final String NAME1 = "name1";
    protected static final String NAME2 = "name2";
    protected static final String NAME3 = "name3";
    protected static final String NAME4 = "name4";
    protected static final String SUM1 = "sum1";
    protected static final String SUM2 = "sum2";
    protected static final String SUM3 = "sum3";
    protected static final String SUM4 = "sum4";
    int eighteen =0;

    public ScoreDataBase(Context context) {
        super(context, "database.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("CREATE TABLE %s(%s integer primary key, %s text, %s text, %s text, %s text,%s text,%s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER,%s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER,%s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER);", SCORE_TABLE, ID, PERSON_NAME, COURSE_NAME,DATE, TIME,STARTEDTIME,
                PlayingCourse.HOLENUMS[0],PlayingCourse.HOLENUMS[1],PlayingCourse.HOLENUMS[2],PlayingCourse.HOLENUMS[3],PlayingCourse.HOLENUMS[4],PlayingCourse.HOLENUMS[5],PlayingCourse.HOLENUMS[6],PlayingCourse.HOLENUMS[7],PlayingCourse.HOLENUMS[8],PlayingCourse.HOLENUMS[9],FULL,OUT,PlayingCourse.HOLENUMS[10],PlayingCourse.HOLENUMS[11],PlayingCourse.HOLENUMS[12],PlayingCourse.HOLENUMS[13],PlayingCourse.HOLENUMS[14],PlayingCourse.HOLENUMS[15],PlayingCourse.HOLENUMS[16],PlayingCourse.HOLENUMS[17],IN, SUM);
        db.execSQL(sql);
        String sql2 = String.format("CREATE TABLE %s(%s integer primary key, %s text, %s text,%s text, %s text, %s text, %s text, %s text, %s text, %s text, %s text, %s text, %s text, %s text, %s text, %s text, %s text, %s text);",
                PREVIEW_TABLE,ID,COURSE_NAME,TEE_POS,DATE,TIME,DURATION,WEATHER,TEMP,NUMBER_OF_PLAYER,NAME1,SUM1,NAME2,SUM2,NAME3,SUM3,NAME4,SUM4,TIMEENDED);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String addTimeEnded = String.format("ALTER TABLE %s ADD COLUMN %s TEXT",PREVIEW_TABLE,TIMEENDED);
        if (oldVersion == 1 && newVersion ==2){
            db.execSQL(addTimeEnded);
        }
    }

    public void saveScoreForPreview(String courseName,String teePosition, String date, String startTime, String endTime, String duration, String weather, String temp,String numOfPlayer,String[] nameNsum){
        String box = String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)",PREVIEW_TABLE,COURSE_NAME,TEE_POS,DATE,TIME,DURATION,WEATHER,TEMP,NUMBER_OF_PLAYER,NAME1,SUM1,NAME2,SUM2,NAME3,SUM3,NAME4,SUM4,TIMEENDED);
        String inside = String.format("('%s','%s','%s','%s','%s','%s','%s','%s',%s,%s,%s,%s,%s,%s,%s,%s,'%s');",courseName,teePosition,date,startTime,duration,weather,temp,numOfPlayer,nameNsum[0],nameNsum[1],nameNsum[2],nameNsum[3],nameNsum[4],nameNsum[5],nameNsum[6],nameNsum[7],endTime);
        String sql = box + " VALUES " + inside;

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }


    public void saveScore(String name, String courseName, Map scores, String date, String time, String duration, int out, int in, int sum, boolean full) {
        ArrayList<Integer> ho = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String hole = scores.get(PlayingCourse.HOLENUMS[i]).toString();
            ho.add(Integer.parseInt(hole));
        }
        if (full) {
            eighteen = 1;
            ho.add(eighteen);
        } else{
            ho.add(eighteen);
        }
        for (int i =9; i < 18; i++) {
            String hole = scores.get(PlayingCourse.HOLENUMS[i]).toString();
            ho.add(Integer.parseInt(hole)); ;
        }

        SQLiteDatabase db = getWritableDatabase();

        String box = String.format("INSERT INTO %s( %s,%s, %s ,%s, %s , %s , %s, %s , %s , %s , %s , %s , %s , %s , %s, %s , %s, %s ,%s , %s , %s , %s , %s , %s , %s , %s, %s )", SCORE_TABLE, PERSON_NAME, COURSE_NAME, DATE, TIME,STARTEDTIME,
                PlayingCourse.HOLENUMS[0],PlayingCourse.HOLENUMS[1],PlayingCourse.HOLENUMS[2],PlayingCourse.HOLENUMS[3],PlayingCourse.HOLENUMS[4],PlayingCourse.HOLENUMS[5],PlayingCourse.HOLENUMS[6],PlayingCourse.HOLENUMS[7],PlayingCourse.HOLENUMS[8],FULL,OUT,PlayingCourse.HOLENUMS[9],
                PlayingCourse.HOLENUMS[10],PlayingCourse.HOLENUMS[11],PlayingCourse.HOLENUMS[12],PlayingCourse.HOLENUMS[13],PlayingCourse.HOLENUMS[14],PlayingCourse.HOLENUMS[15],PlayingCourse.HOLENUMS[16],PlayingCourse.HOLENUMS[17],IN, SUM);
        String inside = String.format("('%s','%s','%s','%s','%s' , %s , %s , %s , %s , %s , %s , %s , %s , %s,%s , %s , %s , %s , %s , %s , %s , %s , %s ,%s , %s , %s , %s );", name, courseName, date, time,duration, ho.get(0), ho.get(1), ho.get(2), ho.get(3), ho.get(4), ho.get(5), ho.get(6), ho.get(7),ho.get(8),ho.get(9),out,ho.get(10), ho.get(11), ho.get(12), ho.get(13), ho.get(14), ho.get(15), ho.get(16), ho.get(17), ho.get(18),in, sum);

        String sql = box + " VALUES " + inside;

        db.execSQL(sql);
        db.close();
    }

    public Cursor getAllRowsFromPreviewTable() {
        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("SELECT * from %s order by %s", PREVIEW_TABLE, DATE);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public ArrayList<String> getPlayFromPreview(String date, String time){
        ArrayList<String> courseInfo = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("SELECT * from %s where %s = '%s'and %s = '%s'", PREVIEW_TABLE, DATE,date,TIME,time);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            for (int i = 2;i<8;i++){
                courseInfo.add(cursor.getString(i));
            }
            courseInfo.add(cursor.getString(17));
        }
        db.close();
        return courseInfo;
    }


    public ArrayList<String> getScore(String date, String time) {
        ArrayList<String> scoreTable = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("SELECT * from %s where %s = '%s' and %s = '%s'", SCORE_TABLE, DATE, date,TIME,time);
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            for (int i = 1; i < 28; i++) {
                String a = cursor.getString(i);
                scoreTable.add(a);
            }
            if (cursor.moveToNext()){
                scoreTable.add("1");
                for (int i = 1; i < 28; i++) {
                    String a = cursor.getString(i);
                    scoreTable.add(a);
                }
                if (cursor.moveToNext()){
                    scoreTable.add("1");
                    for (int i = 1; i < 28; i++) {
                        String a = cursor.getString(i);
                        scoreTable.add(a);
                    }
                    if (cursor.moveToNext()){
                        scoreTable.add("1");
                        for (int i = 1; i < 28; i++) {
                            String a = cursor.getString(i);
                            scoreTable.add(a);
                        }
                    }else scoreTable.add("0");
                }else scoreTable.add("0");
            } else scoreTable.add("0");
        }
        db.close();
        return scoreTable;
    }

    public void deleteScore(int id, String date, String time) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = String.format("DELETE from %s where %s = '%s' and %s = '%s' ", SCORE_TABLE, DATE, date, TIME, time);
        db.execSQL(sql);
        String sql2 = String.format("DELETE from %s where %s = %s", PREVIEW_TABLE, ID, id);
        db.execSQL(sql2);
        db.close();
    }
    public void deleteAll(){
        SQLiteDatabase db = getWritableDatabase();
        String sql = String.format("DELETE from %s", SCORE_TABLE);
        db.execSQL(sql);
        String sql2 = String.format("DELETE from %s", PREVIEW_TABLE);
        db.execSQL(sql2);
        db.close();
    }
}
