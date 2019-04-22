package com.example.abc.androiduidesign.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ABC on 27-12-2018.
 */

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "employeedatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "employees";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DEPT = "department";
    private static final String COLUMN_JOIN_DATE = "joiningdate";
    private static final String COLUMN_SALARY = "salary";


    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (\n" +
                "    " + COLUMN_ID + " INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
                "    " + COLUMN_NAME + " varchar(200) NOT NULL,\n" +
                "    " + COLUMN_DEPT + " varchar(200) NOT NULL,\n" +
                "    " + COLUMN_JOIN_DATE + " datetime NOT NULL,\n" +
                "    " + COLUMN_SALARY + " double NOT NULL\n" +
                ");";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    boolean addEmployee(String name, String department, String joiningDate, Double salary) {

        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DEPT, department);
        values.put(COLUMN_JOIN_DATE, joiningDate);
        values.put(COLUMN_SALARY, String.valueOf(salary));

        return database.insert(TABLE_NAME, null, values) != -1;

    }


    Cursor getAllEmployee() {

        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

    }


    boolean updateEmployee(int id, String name, String department, Double salary) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DEPT, department);
        values.put(COLUMN_SALARY, String.valueOf(salary));
        return database.update(TABLE_NAME, values, COLUMN_ID + "=?", new String[]{String.valueOf(id)}) > 0;
    }


    boolean deleteemployee(int id) {
        SQLiteDatabase database = getWritableDatabase();
        return database.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{String.valueOf(id)}) > 0;

    }
}
