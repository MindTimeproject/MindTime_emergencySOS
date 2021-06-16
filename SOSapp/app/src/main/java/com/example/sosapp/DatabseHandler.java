package com.example.sosapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.jar.Attributes;

public class DatabseHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="mylist.db" ;
    public static final String TABLE_NAME = "mylist_data";
    public static final String COL1 ="ID";
    public static final String COL2 ="ITEM1";

    public DatabseHandler(Context context) {super(context,DATABASE_NAME,null,1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE"+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+"ITEM1 TEXT)";
        db.execSQL( createTable );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String a="DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL( a );
        onCreate( db );
    }
    public boolean addData (String item1 ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(  );
        contentValues.put( COL2,item1 );

        long result = db.insert( TABLE_NAME,null,contentValues );

        if (result==-1) {
            return false;
        }
        else {
            return true;
        }
    }
}