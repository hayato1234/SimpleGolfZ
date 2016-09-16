package com.smileman.toshiba.simplegolfz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by hayatomoritani on 5/19/16.
 */
public class PersonDataBase extends SQLiteOpenHelper {

    protected static final String TABLENAME = "personInfo";
    protected static final String PERSON = "personName";

    private static final String pID = "_id";

    public PersonDataBase(Context context) {
        super(context, "database2.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("CREATE TABLE %s(%s integer primary key, %s text)", TABLENAME, pID, PERSON);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addName(String name) {
        SQLiteDatabase db = getWritableDatabase();
        String box = String.format("INSERT INTO %s(%s)", TABLENAME, PERSON);
        String inside = String.format("('%s' );", name);
        String sql = box + " VALUES " + inside;
        db.execSQL(sql);
    }

    public ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("SELECT %s from %s", PERSON, TABLENAME);
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String a = cursor.getString(0);
            names.add(a);
        }
        db.close();
        return names;
    }

}
