package keranjang.silencebeat.com.keranjangbelanja.Views.ViewHolders

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import keranjang.silencebeat.com.keranjangbelanja.Entities.Models.Keranjang
import keranjang.silencebeat.com.keranjangbelanja.Entities.Models.MenuModel
import keranjang.silencebeat.com.keranjangbelanja.Modules.DatabasePresenter
import kotlinx.android.synthetic.main.item_menu.view.*

/**
 * Created by Candra Triyadi on 30/12/2017.
 */
class ListMenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun onBind(context: Context, model: MenuModel, idRestoran: String, presenter: DatabasePresenter) = with(itemView){

        txt_nama_menu.text = model.name
        txt_harga_menu.text = "Rp. ${model.price}"
        Glide.with(context)
                .load(model.imgUrl).asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .dontAnimate()
                .into(img_menu)

        if (presenter.getDataById(model.id).quantity > 0){
            container_jumlah.visibility = View.VISIBLE
            btn_add.visibility = View.GONE
            edit_jumlah.text = "${presenter.getDataById(model.id).quantity}"
        }else{
            container_jumlah.visibility = View.GONE
            btn_add.visibility = View.VISIBLE
            edit_jumlah.text = "0"
        }

        btn_add.setOnClickListener(View.OnClickListener {
            container_jumlah.visibility = View.VISIBLE
            btn_add.visibility = View.GONE
            edit_jumlah.text = "1"
            val keranjang = Keranjang(model.id, idRestoran, model.name, model.price, model.imgUrl, 1, model.price)
            updateKeranjang(presenter,keranjang)
        })

        btn_kurang.setOnClickListener(View.OnClickListener {
            val valString = edit_jumlah.text.toString().trim()
            var value = 0
            if (!valString.isEmpty()){
                value = valString.toInt()
            }

            val temp = value - 1

            if (temp < 0){
                return@OnClickListener
            }

            if (temp == 0){
                container_jumlah.visibility = View.GONE
                btn_add.visibility = View.VISIBLE
                presenter.deleteDataById(model.id)
            }else{
                container_jumlah.visibility = View.VISIBLE
                btn_add.visibility = View.GONE
                val harga = temp * model.price
                val keranjang = Keranjang(model.id, idRestoran, model.name, model.price, model.imgUrl, temp, harga)
                updateKeranjang(presenter,keranjang)
            }
            edit_jumlah.text = "$temp"
        })

        btn_tambah.setOnClickListener(View.OnClickListener {
            val valString = edit_jumlah.text.toString().trim()
            var value = 0
            if (!valString.isEmpty()){
                value = valString.toInt()
            }

            val temp = value + 1
            val harga = temp * model.price
            val keranjang = Keranjang(model.id, idRestoran, model.name, model.price, model.imgUrl, temp, harga)
            updateKeranjang(presenter,keranjang)
            edit_jumlah.text = "$temp"
        })

    }

    fun updateKeranjang(presenter: DatabasePresenter, keranjang: Keranjang){
        presenter.updateData(keranjang)
    }
}