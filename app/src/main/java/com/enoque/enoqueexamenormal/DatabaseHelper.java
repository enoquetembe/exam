package com.enoque.enoqueexamenormal;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ExamNormalDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_CANDIDATE = "candidate";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_BI = "bi";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_TYPE_CATEGORY = "typeCategory";
    private static final String COLUMN_TYPE= "type";
    private static final String COLUMN_ADRESS = "adress";
    private static final String COLUMN_CONTACT = "contact";

    private static final String CREATE_TABLE_CANDIDATE =
            "CREATE TABLE " + TABLE_CANDIDATE + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_AGE + " INTEGER," +
                    COLUMN_BI + " TEXT," +
                    COLUMN_ADRESS + " TEXT," +
                    COLUMN_TYPE_CATEGORY + " TEXT," +
                    COLUMN_TYPE+ " TEXT," +
                    COLUMN_CONTACT+ " TEXT" +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CANDIDATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CANDIDATE);
        onCreate(db);
    }

    public void save(String name, String typeCategory, String type, String bi, int age, String address, int  contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_TYPE_CATEGORY, typeCategory);
        values.put(COLUMN_TYPE, type);
        values.put(COLUMN_BI, bi);
        values.put(COLUMN_AGE, age);
        values.put(COLUMN_ADRESS, address);
        values.put(COLUMN_CONTACT, contact);

        db.insert(TABLE_CANDIDATE, null, values);
        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<Candidate> getAllCandidates() {
        ArrayList<Candidate> candidates = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_CANDIDATE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Candidate candidate = new Candidate();
                candidate.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                candidate.setExamTypeCategory(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE_CATEGORY)));
                candidate.setExamType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                candidate.setBi(cursor.getString(cursor.getColumnIndex(COLUMN_BI)));
                candidate.setAge(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)));
                candidate.setAdress(cursor.getString(cursor.getColumnIndex(COLUMN_ADRESS)));
                candidate.setContact(cursor.getInt(cursor.getColumnIndex(COLUMN_CONTACT)));

                candidates.add(candidate);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return candidates;
    }

    @SuppressLint("Range")
    public ArrayList<Candidate> getTheoreticalHeavyVehicleCandidates() {
        ArrayList<Candidate> candidates = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_CANDIDATE +
                " WHERE " + COLUMN_TYPE_CATEGORY + " = 'Pesados' AND " + COLUMN_TYPE + " = 'Teoricos'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Candidate candidate = new Candidate();
                candidate.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                candidate.setExamTypeCategory(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE_CATEGORY)));
                candidate.setExamType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                candidate.setBi(cursor.getString(cursor.getColumnIndex(COLUMN_BI)));
                candidate.setAge(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)));
                candidate.setAdress(cursor.getString(cursor.getColumnIndex(COLUMN_ADRESS)));
                //candidate.setAddress(cursor.getString(cursor.getColumnIndex(COLUMN_ADRESS)));
                candidate.setContact(cursor.getInt(cursor.getColumnIndex(COLUMN_CONTACT)));

                candidates.add(candidate);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return candidates;
    }


    public void delete(String name) {
        SQLiteDatabase db = getWritableDatabase();

        String whereClause = "name = ?";
        String[] whereArgs = { name };
        db.delete(TABLE_CANDIDATE, whereClause, whereArgs);
    }

}


