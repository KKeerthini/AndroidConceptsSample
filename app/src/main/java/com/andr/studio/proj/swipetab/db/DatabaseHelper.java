package com.andr.studio.proj.swipetab.db;

/**
 * Created by CIPL310 on 9/28/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "JunkApp.db";
    private static final String TABLE_NAMEDETAILS = "namedetails";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_MONTH="Month";
    public static final String COLUMN_YEAR="Year";

    private SQLiteDatabase dbDatabase;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DETAILS_TABLE = "CREATE TABLE " +
                TABLE_NAMEDETAILS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME
                + " TEXT," + COLUMN_DATE + " INTEGER," +COLUMN_MONTH
                + " INTEGER," + COLUMN_YEAR + "  INTEGER " + ")";
        db.execSQL(CREATE_DETAILS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMEDETAILS);
        onCreate(db);
    }

    public void addName(String name,int date,int month,int year) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DATE,date);
        values.put(COLUMN_MONTH,month);
        values.put(COLUMN_YEAR,year);

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_NAMEDETAILS, null, values);
        db.close();
    }

    public AppModel displayName(String name_bundle) {

        String query = "SELECT * from namedetails WHERE Name='" + name_bundle + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        AppModel app_model= new AppModel();

        if (cursor.moveToFirst())
        {
            cursor.moveToFirst();
            app_model.setName_model(cursor.getString(1));
            cursor.close();
        }
        else
        {
            app_model = null;
        }
        db.close();
        return app_model;
    }

    public AppModel fetch_Name() {

        String query = "SELECT * from namedetails";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        AppModel app_model= new AppModel();

        if (cursor.moveToLast())
        {
            cursor.moveToLast();
            app_model.setName_model(cursor.getString(1));
            app_model.setDate_model(cursor.getInt(2));
            app_model.setMonth_model(cursor.getInt(3));
            app_model.setYear_model(cursor.getInt(4));
            cursor.close();
        }
        else
        {
            app_model = null;
        }
        db.close();
        return app_model;
    }

    public Cursor getAllData() {

        SQLiteDatabase db = this.getWritableDatabase();

        String buildSQL = "SELECT * FROM " + TABLE_NAMEDETAILS;

        Log.d("", "getAllData SQL: " + buildSQL);

        return db.rawQuery(buildSQL, null);
    }

    public ArrayList<String> getAllName() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<String> List = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM namedetails ";
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                List.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return List;
    }


}