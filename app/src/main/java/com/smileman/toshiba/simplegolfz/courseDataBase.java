package com.smileman.toshiba.simplegolfz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by hayatomoritani on 6/8/16.
 */
public class courseDataBase extends SQLiteOpenHelper {


    private static String DB_NAME = "couse.db";
    private static String DB = "courseData3";

    public courseDataBase(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE \"courseData3\" (\n" +
                "\t`_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`courseName`\tTEXT,\n" +
                "\t`teePosition`\tTEXT,\n" +
                "\t`hole1dist`\tINTEGER,\n" +
                "\t`hole1par`\tINTEGER,\n" +
                "\t`hole2dist`\tINTEGER,\n" +
                "\t`hole2par`\tINTEGER,\n" +
                "\t`hole3dist`\tINTEGER,\n" +
                "\t`hole3par`\tINTEGER,\n" +
                "\t`hole4dist`\tINTEGER,\n" +
                "\t`hole4par`\tINTEGER,\n" +
                "\t`hole5dist`\tINTEGER,\n" +
                "\t`hole5par`\tINTEGER,\n" +
                "\t`hole6dist`\tINTEGER,\n" +
                "\t`hole6par`\tINTEGER,\n" +
                "\t`hole7dist`\tINTEGER,\n" +
                "\t`hole7par`\tINTEGER,\n" +
                "\t`hole8dist`\tINTEGER,\n" +
                "\t`hole8par`\tINTEGER,\n" +
                "\t`hole9dist`\tINTEGER,\n" +
                "\t`hole9par`\tINTEGER,\n" +
                "\t`outDist`\tINTEGER,\n" +
                "\t`outPar`\tINTEGER,\n" +
                "\t`hole10dist`\tINTEGER,\n" +
                "\t`hole10par`\tINTEGER,\n" +
                "\t`hole11dist`\tINTEGER,\n" +
                "\t`hole11par`\tINTEGER,\n" +
                "\t`hole12dist`\tINTEGER,\n" +
                "\t`hole12par`\tINTEGER,\n" +
                "\t`hole13dist`\tINTEGER,\n" +
                "\t`hole13par`\tINTEGER,\n" +
                "\t`hole14dist`\tINTEGER,\n" +
                "\t`hole14par`\tINTEGER,\n" +
                "\t`hole15dist`\tINTEGER,\n" +
                "\t`hole15par`\tINTEGER,\n" +
                "\t`hole16dist`\tINTEGER,\n" +
                "\t`hole16par`\tINTEGER,\n" +
                "\t`hole17dist`\tINTEGER,\n" +
                "\t`hole17par`\tINTEGER,\n" +
                "\t`hole18dist`\tINTEGER,\n" +
                "\t`hole18par`\tINTEGER,\n" +
                "\t`inDist`\tINTEGER,\n" +
                "\t`inPar`\tINTEGER,\n" +
                "\t`totalDist`\tINTEGER,\n" +
                "\t`totalPar`\tINTEGER\n" +
                ");";
        sqLiteDatabase.execSQL(sql);

    }

    public void createTable(){
        ArrayList<String> sqlite = new ArrayList<>();
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Foster','Blue',324 ,4,300,4, 295,4, 302,4, 144,3, 420,4, 334,4, 268,4, 124,3, 2511,34, 445,5, 135,3, 326,4, 290,4, 248,4, 224,4, 120,3, 220,3, 285,4, 2293,34, 4804,68);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Foster','Red',314 ,4,290,4, 285,4, 288,4, 134,3, 402,5, 316,4, 252,4, 114,3, 2395,35, 435,5, 121,3, 297,4, 277,4, 223,4, 202,4, 104,3, 252,4, 265,4, 2134,35, 4529,70);");

        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Interbay Golf Course','Back',290,4,150,3,100,3,108,3,130,3,175,3,172,3,111,3,130,3,1366,28,290,4,150,3,100,3,108,3,130,3,175,3,172,3,111,3,130,3,1366,28,2544,56);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Interbay Golf Course','Middle',270,4,140,3,96,3,100,3,120,3,163,3,160,3,103,3,120,3,1272,28,270,4,140,3,96,3,100,3,120,3,163,3,160,3,103,3,120,3,1272,28,2544,56);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Interbay Golf Course','Front',250,4,130,3,92,3,92,3,110,3,151,3,148,3,95,3,110,3,1178,28,250,4,130,3,92,3,92,3,110,3,151,3,148,3,95,3,110,3,1178,28,2356,56);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Interbay Golf Course','Junior',168,4,93,3,68,3,66,3,76,3,107,3,103,3,84,3,78,3,843,28,168,4,93,3,68,3,66,3,76,3,107,3,103,3,84,3,78,3,843,28,1686,56);");

        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Jackson Park','Blue',458,5,114,3,339,4,287,4,523,5,450,4,183,3,412,4,401,4,3167,36,267,4,163,3,552,5,192,3,402,4,443,4,311,4,174,3,414,4,2918,34,6085,70);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Jackson Park','White',424,5,103,3,316,4,256,4,467,5,440,4,178,3,358,4,394,4,2936,36,236,4,148,3,528,5,170,3,358,4,426,4,293,4,135,3,383,4,2677,34,5613,70);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Jackson Park','Gold',380,5,95,3,293,4,216,4,433,5,395,5,173,3,332,4,332,4,2639,37,226,4,117,3,502,5,154,3,321,4,414,5,267,4,102,3,315,4,2418,35,5057,70);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Jackson Park','Green',200,5,95,3,195,4,128,4,257,5,260,5,173,3,206,4,239,4,1753,37,226,5,115,3,332,5,110,3,180,4,241,5,170,4,102,3,168,4,2418,36,5057,70);");

        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Jackson Park 9 Hole Course','Adult',105,3,81,3,78,3,136,3,117,3,138,3,142,3,81,3,154,3,1032,27,105,3,81,3,78,3,136,3,117,3,138,3,142,3,81,3,154,3,1032,27,2064,54);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Jackson Park 9 Hole Course','Junior',105,3,81,3,78,3,136,4,117,3,138,4,142,4,81,3,154,4,1032,27,105,3,81,3,78,3,136,4,117,3,138,4,142,4,81,3,154,4,1032,27,2064,54);");

        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Jefferson Park','Blue',446,4, 407,4, 176,3, 325,4, 347,4, 167,3, 455,4, 487,5, 495,5,3305,36, 182,3, 463,4, 197,3, 341,4, 389,4, 361,4, 138,3, 490,5, 412,4,2973,34,6278,70);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Jefferson Park','White',365,4, 370,4, 156,3, 308,4, 316,4, 138,3, 418,4, 475,5, 467,5,3013,36, 167,3, 436,4, 168,3, 335,4, 375,4, 324,4, 125,3, 480,5, 377,4,2787,34,5800,70);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Jefferson Park','Red',327,4, 338,4, 138,3, 248,4, 281,4, 102,3, 373,4, 452,5, 421,5,2680,36, 142,3, 396,4, 144,3, 327,4, 346,4, 282,4, 112,3, 447,5, 333,4,2528,34,5208,70);");

        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Jefferson Park 9 Hole','White',93,3, 86,3, 123,3, 129,3, 155,3, 149,3, 142,3, 212,3, 136,3, 1225,27,93,3, 86,3, 123,3, 129,3, 155,3, 149,3, 142,3, 212,3, 136,3, 1225,27,2450,54);");

        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Lynnwood','White',375,4,189,3,	280,4,	118,3,	358,4,	370,4,	350,4,	215,3,	305,4,	2560,33, 295,4, 131,3, 115,3, 378,4,	379,4,	309,4,	160,3,	126,3,	288,4,	2181,33, 4741,65);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Lynnwood','Red',337,4,	157,3,	260,4,	93,3,	325,4,	310,4,	290,4,	188,3,	253,4,	2213,33, 277,4, 108,3,  79,3, 309,4,	336,4,	286,4,	137,3,	99,3,	250,4,	1881,33, 4094,65);");

        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Riverbend 18-Hole','Blue',347,4, 423,4, 504,5, 438,4, 136,3, 544,5, 314,4, 210,3, 359,4,3275,36, 371,4, 396,4, 364,4, 166,3, 573,5, 413,4, 195,3, 383,4, 565,5,3426,36,6701,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Riverbend 18-Hole','White',329,4, 404,4, 487,5, 422,4, 124,3, 530,5, 305,4, 185,3, 349,4,3135,36, 359,4, 380,4, 338,4, 145,3, 511,5, 392,4, 176,3, 364,4, 528,5,3193,36,6328,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Riverbend 18-Hole','Red',286,4, 355,4, 434,5, 333,4, 103,3, 445,5, 278,4, 166,3, 331,4,2731,36, 317,4, 339,4, 297,4, 108,3, 452,5, 360,4, 152,3, 321,4, 464,5,2810,36,5541,72);");

        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Riverbend Par 3','Adult',102,3, 128,3, 162,3, 152,3, 137,3, 127,3, 161,3, 83,3, 122,3, 1174,27,102,3, 128,3, 162,3, 152,3, 137,3, 127,3, 161,3, 83,3, 122,3, 1174,27,2348,54);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Riverbend Par 3','Jr Intermediate',102,3, 128,3, 162,4, 152,4, 137,3, 127,3, 161,4, 83,3, 122,3, 1174,30,102,3, 128,3, 162,4, 152,4, 137,3, 127,3, 161,4, 83,3, 122,3, 1174,30,2348,60);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Riverbend Par 3','Jr Beginner',102,4, 128,4, 162,4, 152,4, 137,4, 127,4, 161,4, 83,3, 122,4, 1174,35,102,4, 128,4, 162,4, 152,4, 137,4, 127,4, 161,4, 83,3, 122,4, 1174,35,2348,70);");

        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'West Seattle','Black',551,5, 349,4, 124,3, 548,5, 454,4, 198,3, 328,4, 412,4, 569,5, 3533,37, 378,4, 183,3, 517,5, 193,3, 469,4, 418,4, 389,4, 370,4, 355,4, 3272,35, 6805,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'West Seattle','Blue',544,5, 320,4, 121,3, 524,5, 432,4, 170,3, 322,4, 401,4, 551,5, 3385,37, 363,4, 156,3, 489,5, 175,3, 378,4, 387,4, 368,4, 360,4, 341,4, 3017,35, 6402,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'West Seattle','White',513,5, 301,4, 118,3, 495,5, 393,4, 144,3, 309,4, 372,4, 523,5, 3168,37, 340,4, 150,3, 480,5, 155,3, 358,4, 372,4, 344,4, 342,4, 310,4, 2851,35, 6019,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'West Seattle','Green',479,5, 278,4, 115,3, 442,5, 369,4, 121,3, 305,4, 345,4, 485,5, 2939,37, 319,4, 140,3, 458,5, 166,3, 337,4, 347,4, 304,4, 325,4, 289,4, 2685,35, 5624,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'West Seattle','Purple',479,5, 278,4, 115,3, 442,5, 369,4, 121,3, 220,4, 345,4, 396,5, 2765,37, 319,4, 140,3, 368,5,  81,3, 224,4, 277,4, 219,4, 325,4, 289,4, 2242,35, 5007,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'West Seattle','Gold',394,5, 275,4, 110,3, 387,5, 309,4,  96,3, 220,4, 301,4, 396,5, 2488,37, 221,4, 127,3, 368,5,  81,3, 224,4, 277,4, 219,4, 320,4, 285,4, 2122,35, 4610,72);");

        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Willows Run (Eagle’s Talon)','Blue', 386 ,4, 557,5, 368, 4, 423, 4, 449, 4, 401, 4, 178,3, 350,4, 169,3,3281,35, 551, 5, 482, 5, 359, 4, 376,4, 198,3, 441, 4, 415,4 ,174,3, 566,5,3562,37,6843,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Willows Run (Eagle’s Talon)','White', 350,4,520,5,355,4,397,4,411,4,357,4, 143, 3, 319, 4, 138, 2990,35,3, 521, 5, 444, 5, 325, 4, 356, 4, 171, 3, 394,4, 383, 4, 155, 3, 555, 5 ,3304,37,6294,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Willows Run (Eagle’s Talon)','WhGr Combo', 350,4,449,5,288,4,341,4,343,4,357,4,143 ,3 ,319, 4, 138, 2728,35, 3,449,5,   400,5, 325,4, 356,4, 143, 3, 336, 4, 307, 4,155,3, 449,5 ,3054,37,5782,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Willows Run (Eagle’s Talon)','Green',278,4,449,5,288,4,341,4,343,4,311,4,111 ,3 ,283, 4,  98 ,2502,35,  3,449,5,   400,5,  264,4,  299,4,  143,3,  336,4,  307,4,  117,3,  449,5 ,2764,37,5266,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Willows Run (Coyote Creek)','Blue',365,4, 530,5, 398,4, 373 ,4,183,3, 331,4, 306,4, 460,5, 135,3,3086,36, 548 ,5,379,4, 410,4, 150,3, 377,4, 436,4, 299,4, 165,3, 499,5,3258,36,6344,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Willows Run (Coyote Creek)','White',326,4, 499,5, 360,4, 344,4, 147,3, 308,4, 279,4, 436,5, 109,3,2808,36, 506,5, 327,4, 388,4, 120,3, 324,4, 397,4, 278,4, 165,3, 483,5,2988,36,5796,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Willows Run (Coyote Creek)','Green',301,4, 482,5, 336,4, 321,4, 116,3, 284,4, 279,4, 409,5, 109,3,2637,36, 479,5, 323,4, 372,4,  85,3, 281,4, 355,4, 278,4, 146,3, 443,5,2637,36,2762,72);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Willows Run Heron Links','Adult',86,3, 125,3, 95,3, 147,3, 98,3, 158,3, 170,3, 127,3, 101,3,1107,27,86,3, 125,3, 95,3, 147,3, 98,3, 158,3, 170,3, 127,3, 101,3,1107,27,2214,54);");
        sqlite.add("INSERT INTO `courseData3` VALUES (Null,'Willows Run Heron Links','Junior',86,4, 125,4, 95,4, 147,4, 98,4, 158,4, 170,4, 127,4, 101,4,1107,36,86,4, 125,4, 95,4, 147,4, 98,4, 158,4, 170,4, 127,4, 101,4,1107,36,2214,72);");

        SQLiteDatabase db = getWritableDatabase();
        for (String sql : sqlite){
            db.execSQL(sql);
        }
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<String> getTeeInfo(String courseN){
        ArrayList<String> teeList = new ArrayList<>();
        SQLiteDatabase sdb = getReadableDatabase();
        String sql = String.format("SELECT teePosition from %s where courseName = '%s'", DB,courseN);
        Cursor cursor = sdb.rawQuery(sql,null);
        while (cursor.moveToNext()){
            String tee = cursor.getString(0);
            teeList.add(tee);
        }
        return teeList;
    }

    public ArrayList<String > getCourseInfo(String courseN, String teePos){

        ArrayList<String> courseInfomation = new ArrayList<>();

        SQLiteDatabase sdb = getReadableDatabase();
        String sql = String.format("SELECT * from %s where courseName = '%s' and teePosition = '%s'", DB,courseN,teePos);
        Cursor cursor = sdb.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            for (int i = 0;i<45;i++){
                String a = cursor.getString(i);
                courseInfomation.add(a);
            }
        }
        sdb.close();
        return courseInfomation;
    }

}
