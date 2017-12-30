package keranjang.silencebeat.com.keranjangbelanja.Modules

import keranjang.silencebeat.com.keranjangbelanja.Entities.Models.Keranjang

/**
 * Created by Candra Triyadi on 30/12/2017.
 */

interface DatabaseInput{
    fun updateData(data: Keranjang)
    fun getData()
    fun deleteDataById(id: String)
    fun deleteAllData()
    fun getDataById(id: String): Keranjang
}

interface DatabaseOutput{
    fun successGetData(list: List<Keranjang>)
    fun successUpdateData()
    fun successDeleteData()
    fun failedUpdateData(data: Keranjang)
}

interface DatabaseInterface{
    fun updateData(data: Keranjang)
    fun getData()
    fun deleteDataById(id: String)
    fun getDataById(id: String): Keranjang
}

interface DatabaseView{
    fun successGetData(list: List<Keranjang>)
    fun successUpdateData()
}