package keranjang.silencebeat.com.keranjangbelanja.Views.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import keranjang.silencebeat.com.keranjangbelanja.Entities.Models.Keranjang
import keranjang.silencebeat.com.keranjangbelanja.Modules.DatabaseHelper
import keranjang.silencebeat.com.keranjangbelanja.Modules.DatabaseInteractor
import keranjang.silencebeat.com.keranjangbelanja.Modules.DatabasePresenter
import keranjang.silencebeat.com.keranjangbelanja.Modules.DatabaseView
import keranjang.silencebeat.com.keranjangbelanja.R
import keranjang.silencebeat.com.keranjangbelanja.Supports.FragmentAdapter
import keranjang.silencebeat.com.keranjangbelanja.Views.Fragments.FragmentMenu
import kotlinx.android.synthetic.main.activity_list_menu_restoran.*

/**
 * Created by Candra Triyadi on 30/12/2017.
 */
class ListMenuRestoranActivity : AppCompatActivity(), DatabaseView {

    var presenter = DatabasePresenter(DatabaseInteractor(DatabaseHelper(this)), this, this)
    var idRestoran = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_menu_restoran)
        setSupportActionBar(toolbar)

        val bundle = intent.extras
        idRestoran = bundle.getString("ID_RESTORAN")

        presenter.getData()

        setViewPager()

    }

    fun setViewPager(){
        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(FragmentMenu.newInstance(idRestoran, "makanan"), "MAKANAN")
        fragmentAdapter.addFragment(FragmentMenu.newInstance(idRestoran, "minuman"), "MINUMAN")
        pager.adapter = fragmentAdapter
        tabs.setupWithViewPager(pager)
    }

    override fun successGetData(list: List<Keranjang>) {

        if (list.isEmpty()){
            layout_peek.visibility = View.GONE
            return
        }else{
            layout_peek.visibility = View.VISIBLE
        }

        var totalUang = 0
        var jumlahPesanan = 0

        for (keranjang in list){
            totalUang = totalUang + keranjang.totalPrice
            jumlahPesanan = jumlahPesanan + keranjang.quantity
        }

        txt_item.text = "$jumlahPesanan items:"
        txt_total_harga.text = "Rp. $totalUang"

    }

    override fun successUpdateData() {
    }
}