package keranjang.silencebeat.com.keranjangbelanja.Supports

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import keranjang.silencebeat.com.keranjangbelanja.Modules.DatabaseHelper

/**
 * Created by Candra Triyadi on 30/12/2017.
 */
class LocalData (context: Context): SQLiteOpenHelper(context, "keranjang", null, 1 ) {

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE " + DatabaseHelper.TABLE_KERANJANG +
                "("+ DatabaseHelper.ID+" TEXT PRIMARY KEY,"+
                DatabaseHelper.IDRESTO+" TEXT, "+
                DatabaseHelper.NAME+" TEXT,"+
                DatabaseHelper.PRICE+" INTEGER,"+
                DatabaseHelper.IMGURL+" TEXT,"+
                DatabaseHelper.QUANTITY+" INTEGER,"+
                DatabaseHelper.TOTALPRICE+" INTEGER)"
        db!!.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS "+DatabaseHelper.TABLE_KERANJANG)
        onCreate(db)
    }


}