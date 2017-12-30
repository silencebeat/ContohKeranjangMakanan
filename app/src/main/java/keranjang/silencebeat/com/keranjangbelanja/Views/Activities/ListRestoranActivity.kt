package keranjang.silencebeat.com.keranjangbelanja.Views.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import keranjang.silencebeat.com.keranjangbelanja.Entities.Lists.ListRestoran
import keranjang.silencebeat.com.keranjangbelanja.Entities.Models.RestoranModel
import keranjang.silencebeat.com.keranjangbelanja.R
import keranjang.silencebeat.com.keranjangbelanja.Supports.Adapter
import keranjang.silencebeat.com.keranjangbelanja.Views.ViewHolders.ListRestoranViewHolder
import kotlinx.android.synthetic.main.activity_list_restoran.*

/**
 * Created by Candra Triyadi on 30/12/2017.
 */
class ListRestoranActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_restoran)
        setSupportActionBar(toolbar)
        setList()
    }

    fun setList(){
        val listRestoran = ListRestoran()
        val manager = LinearLayoutManager(this)
        val adapter = object : Adapter<RestoranModel, ListRestoranViewHolder>(R.layout.item_restoran, ListRestoranViewHolder::class.java, RestoranModel::class.java, listRestoran.arraylist){
            override fun bindView(holder: ListRestoranViewHolder, tipeData: RestoranModel, position: Int) {
                holder.onBind(applicationContext, tipeData)
            }
        }

        list_restoran.layoutManager = manager
        list_restoran.adapter = adapter
    }
}