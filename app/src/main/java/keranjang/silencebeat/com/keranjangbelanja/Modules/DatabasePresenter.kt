package keranjang.silencebeat.com.keranjangbelanja.Modules

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import keranjang.silencebeat.com.keranjangbelanja.Entities.Models.Keranjang

/**
 * Created by Candra Triyadi on 30/12/2017.
 */
class DatabasePresenter (var interactor: DatabaseInteractor,
                         var view: DatabaseView,
                         var context: Context) : DatabaseInterface, DatabaseOutput {

    init {
        interactor.output = this
    }

    override fun successGetData(list: List<Keranjang>) {
        view.successGetData(list)
    }

    override fun successUpdateData() {
        view.successUpdateData()
        interactor.getData()
    }

    override fun successDeleteData() {
        interactor.getData()
    }

    override fun failedUpdateData(data: Keranjang) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage("Anda memiliki pesanan dengan restoran yang berbeda. Sistem akan menghapus keranjang pesanan sebelumnya jika Anda setuju.")
        builder.setCancelable(true)
        builder.setPositiveButton("Setuju", DialogInterface.OnClickListener {
            _, _ ->
            interactor.deleteAllData()
            interactor.updateData(data)
        })
        builder.setNegativeButton("Batal", DialogInterface.OnClickListener {
            dialog, _ ->
            dialog.cancel()
        })

        val alert = builder.create()
        alert.show()
    }

    override fun updateData(data: Keranjang) {
        interactor.updateData(data)
    }

    override fun getData() {
        interactor.getData()
    }

    override fun deleteDataById(id: String) {
        interactor.deleteDataById(id)
    }

    override fun getDataById(id: String): Keranjang {
        return interactor.getDataById(id)
    }
}