package keranjang.silencebeat.com.keranjangbelanja.Views.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import keranjang.silencebeat.com.keranjangbelanja.Entities.Lists.ListMenu
import keranjang.silencebeat.com.keranjangbelanja.Entities.Models.MenuModel
import keranjang.silencebeat.com.keranjangbelanja.Modules.DatabasePresenter
import keranjang.silencebeat.com.keranjangbelanja.R
import keranjang.silencebeat.com.keranjangbelanja.Supports.Adapter
import keranjang.silencebeat.com.keranjangbelanja.Views.Activities.ListMenuRestoranActivity
import keranjang.silencebeat.com.keranjangbelanja.Views.ViewHolders.ListMenuViewHolder
import kotlinx.android.synthetic.main.fragment_list_menu.*

/**
 * Created by Candra Triyadi on 30/12/2017.
 */
class FragmentMenu: Fragment() {

    var type = ""
    var idRestoran = ""
    var adapter: Adapter<MenuModel, ListMenuViewHolder>? = null
    var presenter: DatabasePresenter? = null

    companion object {
        val TYPE = "TYPE"
        val ID_RESTORAN = "ID_RESTORAN"

        fun newInstance(idRestoran: String, type: String): FragmentMenu {
            val fragment = FragmentMenu()
            val bundle = Bundle()
            bundle.putString(TYPE, type)
            bundle.putString(ID_RESTORAN, idRestoran)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val bundle = arguments
        type = bundle.getString(TYPE)
        idRestoran = bundle.getString(ID_RESTORAN)
        presenter = (activity as ListMenuRestoranActivity).presenter
        return inflater.inflate(R.layout.fragment_list_menu, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setList(type, idRestoran)
    }

    fun setList(type: String, idRestoran: String){
        val listMenu = ListMenu()
        var arraylist = ArrayList<MenuModel>()
        if (type.equals("makanan")){
            if (idRestoran.equals("1"))
                arraylist = listMenu.arraylistMakanan
            else
                arraylist = listMenu.arraylistMakanan2
        }else{
            if (idRestoran.equals("1"))
                arraylist = listMenu.arrayListMinuman
            else
                arraylist = listMenu.arrayListMinuman2
        }

        val manager = LinearLayoutManager(activity)
        adapter = object : Adapter<MenuModel, ListMenuViewHolder>(R.layout.item_menu, ListMenuViewHolder::class.java, MenuModel::class.java, arraylist){
            override fun bindView(holder: ListMenuViewHolder, tipeData: MenuModel, position: Int) {
                holder.onBind(context, tipeData, idRestoran, presenter!!)
            }
        }

        list_menu.layoutManager = manager
        list_menu.adapter = adapter

    }
}