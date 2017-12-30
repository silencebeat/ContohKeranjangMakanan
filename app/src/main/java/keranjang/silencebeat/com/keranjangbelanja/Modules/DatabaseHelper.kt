package keranjang.silencebeat.com.keranjangbelanja.Modules

import android.content.ContentValues
import android.content.Context
import keranjang.silencebeat.com.keranjangbelanja.Entities.Models.Keranjang
import keranjang.silencebeat.com.keranjangbelanja.Supports.LocalData
import java.util.ArrayList

/**
 * Created by Candra Triyadi on 30/12/2017.
 */
class DatabaseHelper(context: Context) {

    val localData = LocalData(context)
    companion object {
        val TABLE_KERANJANG = "table_keranjang"
        val ID = "id"
        val IDRESTO = "idRestoran"
        val NAME = "name"
        val PRICE = "price"
        val IMGURL = "imgUrl"
        val QUANTITY = "quantity"
        val TOTALPRICE = "totalPrice"
    }


    fun updateKeranjang(keranjang: Keranjang): Boolean {

        val db = localData.writableDatabase
        val list = getAllKeranjang()
        if (list.isEmpty()){
            val values = ContentValues()
            values.put(ID, keranjang.idMenu)
            values.put(IDRESTO, keranjang.idRestoran)
            values.put(NAME, keranjang.name)
            values.put(PRICE, keranjang.price)
            values.put(IMGURL, keranjang.imgUrl)
            values.put(QUANTITY, keranjang.quantity)
            values.put(TOTALPRICE, keranjang.totalPrice)
            db.insert(TABLE_KERANJANG, null, values)
            db.close()
            return true
        }else{
            if (list[0].idRestoran.equals(keranjang.idRestoran)){
                val values = ContentValues()
                values.put(ID, keranjang.idMenu)
                values.put(IDRESTO, keranjang.idRestoran)
                values.put(NAME, keranjang.name)
                values.put(PRICE, keranjang.price)
                values.put(IMGURL, keranjang.imgUrl)
                values.put(QUANTITY, keranjang.quantity)
                values.put(TOTALPRICE, keranjang.totalPrice)
                val tempKeranjang = getDataById(keranjang.idMenu)
                if (tempKeranjang.idMenu.isEmpty()){
                    db.insert(TABLE_KERANJANG, null, values)
                }else{
                    db.update(TABLE_KERANJANG, values, ID+ " =?", arrayOf(keranjang.idMenu))
                }
                db.close()
                return true
            }else{
                return false
            }
        }
    }

    fun getAllKeranjang(): List<Keranjang> {
        val db = localData.writableDatabase
        val list = ArrayList<Keranjang>()
        val selectQuery = "SELECT * FROM " + TABLE_KERANJANG
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {

                val keranjang = Keranjang(cursor.getString(0), cursor.getString(1), cursor.getString(2)
                        ,cursor.getInt(3),cursor.getString(4),cursor.getInt(5), cursor.getInt(6))
                list.add(keranjang)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return list
    }

    fun deleteKeranjang() {
        val db = localData.writableDatabase
        db.delete(TABLE_KERANJANG, null, null)
        db.close()
    }

    fun deleteKeranjanById(id: String) {
        val db = localData.writableDatabase
        db.delete(TABLE_KERANJANG, ID + " = ?", arrayOf(id))
        db.close()
    }

    fun getDataById(id: String): Keranjang {
        var keranjang: Keranjang? = null
        val db = localData.readableDatabase
        val cursor = db.query(TABLE_KERANJANG, null, ID + " =?",
                arrayOf(id), null, null, null, null)

        if (cursor.moveToFirst()) {
            keranjang = Keranjang(cursor.getString(0), cursor.getString(1), cursor.getString(2)
                    ,cursor.getInt(3),cursor.getString(4),cursor.getInt(5), cursor.getInt(6))
        } else {
            return Keranjang("", "", "", 0, "", 0, 0)
        }

        cursor.close()
        return keranjang
    }
}