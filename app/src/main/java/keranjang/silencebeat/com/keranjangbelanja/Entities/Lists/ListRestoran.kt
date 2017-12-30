package keranjang.silencebeat.com.keranjangbelanja.Entities.Lists

import keranjang.silencebeat.com.keranjangbelanja.Entities.Models.RestoranModel

/**
 * Created by Candra Triyadi on 30/12/2017.
 */
class ListRestoran {

    var arraylist = ArrayList<RestoranModel>()
    init {
        arraylist.add(RestoranModel("1", "McD Cabang Malang", "Jalan Pelan2 banyak anak kecil"
                , "https://img-global.cpcdn.com/003_recipes/567e60eebab844b3/400x400cq70/photo.jpg"))
        arraylist.add(RestoranModel("2", "KFC Cabang Malang belok dikit", "Jalan Pelan2 banyak anak kecil"
                , "https://b.zmtcdn.com/data/pictures/3/7400293/f6e546b185f2ec2593f4b910e5ccff37_featured_v2.jpg"))
    }
}