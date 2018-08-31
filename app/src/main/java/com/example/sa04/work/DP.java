package com.example.sa04.work;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DP extends SQLiteOpenHelper {
    private static String CREATE_TABLE1;
    static String DATABASE_NAME = "EmployeeRecords";
    public static final String TABLE1_NAME = "employee";
    public static final String PASSWORD = "password";
    public static final String NAME = "fname";

    private ContentValues cValues;
    private SQLiteDatabase dataBase = null;
    public DP(Context context) {
        super(context, context.getExternalFilesDir(null).getAbsolutePath()
                + "/" + DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CREATE_TABLE1 = "CREATE TABLE " + TABLE1_NAME + "(" + PASSWORD
                + " TEXT, " + NAME + " TEXT)";
        db.execSQL(CREATE_TABLE1);
        System.out.println("Table is created...........................!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void inserRecord(Context context, String name,String password) {

        dataBase = getWritableDatabase();
        cValues = new ContentValues();
        cValues.put(NAME, name);
        cValues.put(PASSWORD, password);
        dataBase.insert(TABLE1_NAME, null, cValues);
        Toast.makeText(context, "Sign up successfully.", Toast.LENGTH_SHORT).show();
        dataBase.close();
    }
}
