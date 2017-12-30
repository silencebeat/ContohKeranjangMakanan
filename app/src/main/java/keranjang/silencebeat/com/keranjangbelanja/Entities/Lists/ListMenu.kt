package keranjang.silencebeat.com.keranjangbelanja.Entities.Lists

import keranjang.silencebeat.com.keranjangbelanja.Entities.Models.MenuModel

/**
 * Created by Candra Triyadi on 30/12/2017.
 */
class ListMenu {

    var arraylistMakanan = ArrayList<MenuModel>()
    var arrayListMinuman = ArrayList<MenuModel>()

    var arraylistMakanan2 = ArrayList<MenuModel>()
    var arrayListMinuman2 = ArrayList<MenuModel>()

    init {

        arraylistMakanan.add(MenuModel("1", "Rujak", 10000, "https://img-global.cpcdn.com/003_recipes/567e60eebab844b3/400x400cq70/photo.jpg"))
        arraylistMakanan.add(MenuModel("2", "Pecel", 8000, "https://b.zmtcdn.com/data/pictures/3/7400293/f6e546b185f2ec2593f4b910e5ccff37_featured_v2.jpg"))

        arrayListMinuman.add(MenuModel("3", "Es Teh", 5000, "https://img-global.cpcdn.com/003_recipes/567e60eebab844b3/400x400cq70/photo.jpg"))
        arrayListMinuman.add(MenuModel("4", "Es jeruk", 4000, "https://b.zmtcdn.com/data/pictures/3/7400293/f6e546b185f2ec2593f4b910e5ccff37_featured_v2.jpg"))

        arraylistMakanan2.add(MenuModel("5", "Rujak", 10000, "https://img-global.cpcdn.com/003_recipes/567e60eebab844b3/400x400cq70/photo.jpg"))
        arraylistMakanan2.add(MenuModel("6", "Pecel", 8000, "https://b.zmtcdn.com/data/pictures/3/7400293/f6e546b185f2ec2593f4b910e5ccff37_featured_v2.jpg"))

        arrayListMinuman2.add(MenuModel("7", "Es Teh", 5000, "https://img-global.cpcdn.com/003_recipes/567e60eebab844b3/400x400cq70/photo.jpg"))
        arrayListMinuman2.add(MenuModel("8", "Es jeruk", 4000, "https://b.zmtcdn.com/data/pictures/3/7400293/f6e546b185f2ec2593f4b910e5ccff37_featured_v2.jpg"))

    }
}