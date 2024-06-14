package com.example.t8_assist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class  DBConfig extends SQLiteOpenHelper {

    // Nama database dan versi database
    private static final String DATABASE_NAME = "database-8";
    private static final int DATABASE_VERSION = 1;

    // Nama tabel dan kolom-kolom dalam tabel
    private static final String TABLE_NAME = "pertemuan_8";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_JUDUL = "judul";
    private static final String COLUMN_DESKRIPSI = "deskripsi";
    private static final String COLUMN_CREATED_AT = "created_at";
    private static final String COLUMN_UPDATED_AT = "updated_at";

//Konstruktor ini memanggil konstruktor superclass (SQLiteOpenHelper) dengan nama database, versi, dan context aplikasi.
    public DBConfig(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    Pembuatan tabel.
//    Ini menciptakan tabel pertemuan_8 dengan kolom id, judul, deskripsi, created_at, dan updated_at.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_JUDUL + " TEXT,"
                + COLUMN_DESKRIPSI + " TEXT,"
                + COLUMN_CREATED_AT + " TEXT,"
                + COLUMN_UPDATED_AT + " TEXT)");
    }

//    Metode ini menambahkan data baru ke tabel.
//    Menggunakan ContentValues untuk menyimpan pasangan kolom dan nilai. Juga menambahkan waktu saat ini ke kolom created_at dan updated_at
    public void insertData(String judul, String deskripsi) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_JUDUL, judul);
        values.put(COLUMN_DESKRIPSI, deskripsi);
        String currentTime = getCurrentDateTime();
        values.put(COLUMN_CREATED_AT, currentTime);
        values.put(COLUMN_UPDATED_AT, currentTime);
        db.insert(TABLE_NAME, null, values);
        db.close();
    } //ContentValues adalah sebuah kelas di Android yang digunakan untuk menyimpan pasangan kunci-nilai (key-value pairs). Kelas ini biasanya digunakan saat berinteraksi dengan database SQLite, terutama saat melakukan operasi insert, update, atau delete.
    //COLUMN_JUDUL, COLUMN_DESKRIPSI, COLUMN_CREATED_AT, dan COLUMN_UPDATED_AT adalah kunci (nama kolom dalam tabel).
    //judul, deskripsi, dan currentTime adalah nilai yang akan dimasukkan ke dalam kolom yang sesuai.

//    Mendapatkan semua data
//    Metode ini mengembalikan semua data dari tabel sebagai Cursor.
    public Cursor getAllRecords() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }


//Metode ini mencari data dalam tabel berdasarkan judul yang sesuai dengan parameter yang diberikan menggunakan klausa LIKE
    public Cursor searchByTitle(String judul) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_JUDUL + " LIKE ?", new String[]{"%" + judul + "%"});
    } //?) digunakan sebagai placeholder untuk nilai yang akan diisikan kemudian. Misalnya, jika judul adalah "Android", maka "%Android%" akan mencocokkan semua teks yang mengandung kata "Android" di dalamnya.
//    Metode ini memperbarui data dalam tabel berdasarkan ID yang diberikan.
//    Menggunakan ContentValues untuk menyimpan pasangan kolom dan nilai yang baru.
    public void updateRecord(int id, String judul, String deskripsi) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_JUDUL, judul);
        values.put(COLUMN_DESKRIPSI, deskripsi);
        values.put(COLUMN_UPDATED_AT, getCurrentDateTime());
        db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    } //String.valueOf(id) mengonversi 1 menjadi string "1". WHERE
//new String[]{"1"} membuat array string dengan satu elemen, yaitu "1".
//    Metode ini menghapus data dari tabel berdasarkan ID yang diberikan.
    public void deleteRecords(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }
//Metode ini dijalankan ketika versi database berubah. Namun, saat ini tidak melakukan apa-apa.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
//Metode ini mengembalikan waktu saat ini dalam format yyyy-MM-dd HH:mm:ss.
    private String getCurrentDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

//    Metode getter untuk mendapatkan nama tabel dan kolom-kolom tabel.
    public String getTableName() {
        return TABLE_NAME;
    }

    public String getColumnId() {
        return COLUMN_ID;
    }

    public String getColumnJudul() {
        return COLUMN_JUDUL;
    }

    public String getColumnDeskripsi() {
        return COLUMN_DESKRIPSI;
    }

    public String getColumnCreatedAt() {
        return COLUMN_CREATED_AT;
    }

    public String getColumnUpdatedAt() {
        return COLUMN_UPDATED_AT;
    }
}
