package com.gransoft.geoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "GeofencingLocations.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "my_locations";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_MESSAGE = "message";
    private static final String COLUMN_MESSAGE_BODY = "message_body";
    private static final String COLUMN_FREE_USE = "free_use";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " + TABLE_NAME +
                " ( " +
                COLUMN_ID     + " integer primary key autoincrement, " +
                COLUMN_MESSAGE + " text, " +
                COLUMN_MESSAGE_BODY + " text, " +
                COLUMN_FREE_USE + " integer" +
                " ); ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public void addBook(String message, String messageBody, int freeUse){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_MESSAGE, message);
        contentValues.put(COLUMN_MESSAGE_BODY, messageBody);
        contentValues.put(COLUMN_FREE_USE, freeUse);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
