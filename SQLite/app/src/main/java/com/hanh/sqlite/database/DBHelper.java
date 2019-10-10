package com.hanh.sqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME ="USER";
    public static final int DB_VERSION=1;

    public static String TABLE_NAME ="TBL_USER";
    public static String ID ="_id";
    public static String NAME ="name";
    public static String GENDER ="gender";
    public static String DES ="des";

    public DBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + "(" + ID + "INTEGER PRIMARY KEY, " +
                NAME + " TEXT, " +
                GENDER + " TEXT, " +
                DES + " TEXT)";


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);

    }

    public String addUser(String user, String gender, String des){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,user);
        contentValues.put(GENDER,gender);
        contentValues.put(DES,des);
        long isAdd = db.insert(TABLE_NAME,null, contentValues);
        if (isAdd == -1){
            return "Add fail";
        }
        db.close();
        return "Add Success";

    }
    public String updateUser(int id, String user, String gender, String des){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,user);
        contentValues.put(GENDER,gender);
        contentValues.put(DES,des);
        long isUpdate = db.update(TABLE_NAME, contentValues, ID+" = ? ", new String[] {id+""});
        if (isUpdate >0){
            return "Update Success";
        }
        db.close();
        return "Fail";

    }

    public String delateUser(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        int isDelete = db.delete(TABLE_NAME, ID+" = ? ", new String[] {id+""});
        if (isDelete >0){
            return "Delete Success";
        }
        db.close();
        return " Delete Fail";
    }

    public Cursor getAllUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(sql, null);
        return c;

    }
}
