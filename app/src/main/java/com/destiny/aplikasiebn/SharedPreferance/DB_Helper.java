package com.destiny.aplikasiebn.SharedPreferance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.destiny.aplikasiebn.Model.Model;

import java.util.LinkedList;
import java.util.List;

public class DB_Helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "batik.db";
    private static final int DATABASE_VERSION = 3;
    public static final String TABLE_NAME = "batik";
    public static final String TABLE_NAME_CARA = "cara";
    public static final String COLUMN_GAMBAR = "gambar";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_DESKRIPSI = "deskripsi";
    public static final String COLUMN_CARA_NO = "no";
    public static final String COLUMN_CARA_GAMBAR = "caragambar";
    public static final String COLUMN_CARA_NAMA = "caranama";
    public static final String COLUMN_CARA_DESKRIPSI = "caradeskripsi";


    public DB_Helper(Context context){super(
            context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (" +
                COLUMN_GAMBAR+" TEXT NOT NULL, "+
                COLUMN_NAMA+" TEXT NOT NULL,"+
                COLUMN_DESKRIPSI+" TEXT NOT NULL);"
        );
        db.execSQL("CREATE TABLE "+TABLE_NAME_CARA+" (" +
                COLUMN_CARA_NO+" TEXT NOT NULL, "+
                COLUMN_CARA_GAMBAR+" TEXT NOT NULL, "+
                COLUMN_CARA_NAMA+" TEXT NOT NULL,"+
                COLUMN_CARA_DESKRIPSI+" TEXT NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CARA);
        this.onCreate(db);
    }
    public List<Model> modelList() {
        String query = "SELECT  * FROM " + TABLE_NAME;
        List<Model> modelLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Model model;

        if (cursor.moveToFirst()) {
            do {
                model = new Model();
                model.setGambar(cursor.getString(cursor.getColumnIndex(COLUMN_GAMBAR)));
                model.setNama(cursor.getString(cursor.getColumnIndex(COLUMN_NAMA)));
                model.setDeskripsi(cursor.getString(cursor.getColumnIndex(COLUMN_DESKRIPSI)));
                modelLinkedList.add(model);
            } while (cursor.moveToNext());
        }
        return modelLinkedList;
    }
    public List<Model> modelListCara() {
        String query = "SELECT  * FROM " + TABLE_NAME_CARA;
        List<Model> modelLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Model model;

        if (cursor.moveToFirst()) {
            do {
                model = new Model();
                model.setNo(cursor.getString(cursor.getColumnIndex(COLUMN_CARA_NO)));
                model.setCaragambar(cursor.getString(cursor.getColumnIndex(COLUMN_CARA_GAMBAR)));
                model.setCaranama(cursor.getString(cursor.getColumnIndex(COLUMN_CARA_NAMA)));
                model.setCaradeskripsi(cursor.getString(cursor.getColumnIndex(COLUMN_CARA_DESKRIPSI)));
                modelLinkedList.add(model);
            } while (cursor.moveToNext());
        }
        return modelLinkedList;
    }
    public void FavoriteCara(Model models){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CARA_NO,models.getNo());
        values.put(COLUMN_CARA_GAMBAR,models.getCaragambar());
        values.put(COLUMN_CARA_NAMA,models.getCaranama());
        values.put(COLUMN_CARA_DESKRIPSI,models.getCaradeskripsi());
        db.insert(TABLE_NAME_CARA,null, values);
        db.close();
    }
    public void FavoriteBatik(Model models) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_GAMBAR, models.getGambar());
        values.put(COLUMN_NAMA,models.getNama());
        values.put(COLUMN_DESKRIPSI,models.getDeskripsi());
        db.insert(TABLE_NAME,null, values);
        db.close();
    }
    public void deleteBatikRecord(String nama, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE nama ='"+nama+"'");
        Toast.makeText(context, "Hapus Favorit Berhasil", Toast.LENGTH_SHORT).show();
    }
    public void deleteCaraRecord(String nama, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME_CARA+" WHERE caranama ='"+nama+"'");
        Toast.makeText(context, "Hapus Favorit Berhasil", Toast.LENGTH_SHORT).show();
    }
    public Cursor checkBatik(String nama){
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="SELECT * FROM "+TABLE_NAME+" WHERE nama = '"+nama+"'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
    public Cursor checkCara(String nama){
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="SELECT * FROM "+TABLE_NAME_CARA+" WHERE caranama = '"+nama+"'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }

}


