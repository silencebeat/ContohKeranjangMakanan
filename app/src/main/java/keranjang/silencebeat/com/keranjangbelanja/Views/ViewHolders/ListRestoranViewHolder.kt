package keranjang.silencebeat.com.keranjangbelanja.Views.ViewHolders

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import keranjang.silencebeat.com.keranjangbelanja.Entities.Models.RestoranModel
import keranjang.silencebeat.com.keranjangbelanja.Views.Activities.ListMenuRestoranActivity
import kotlinx.android.synthetic.main.item_restoran.view.*

/**
 * Created by Candra Triyadi on 30/12/2017.
 */
class ListRestoranViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(context: Context, model: RestoranModel) = with(itemView){

        txt_nama_resto.text = model.name
        txt_alamat_resto.text = model.address
        Glide.with(context)
                .load(model.imgUrl).asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .dontAnimate()
                .into(img_resto)

        rootView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, ListMenuRestoranActivity::class.java)
            intent.putExtra("ID_RESTORAN", model.id)
            context.startActivity(intent)
        })
    }
}