package keranjang.silencebeat.com.keranjangbelanja.Modules

import keranjang.silencebeat.com.keranjangbelanja.Entities.Models.Keranjang

/**
 * Created by Candra Triyadi on 30/12/2017.
 */
class DatabaseInteractor (var db: DatabaseHelper): DatabaseInput {

    lateinit var output: DatabaseOutput

    override fun updateData(data: Keranjang) {
        var success = db.updateKeranjang(data)
        if (success)
            output.successUpdateData()
        else
            output.failedUpdateData(data)
    }

    override fun getData() {
        val list = db.getAllKeranjang()
        output.successGetData(list)
    }

    override fun deleteDataById(id: String) {
        db.deleteKeranjanById(id)
        output.successDeleteData()
    }

    override fun deleteAllData() {
        db.deleteKeranjang()
    }

    override fun getDataById(id: String): Keranjang {
        val data = db.getDataById(id)
        return data
    }
}