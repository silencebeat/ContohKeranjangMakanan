package keranjang.silencebeat.com.keranjangbelanja.Supports

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Candra Triyadi on 30/12/2017.
 */
class FragmentAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    val mFragments = ArrayList<Fragment>()
    val mTitle = ArrayList<String>()

    fun addFragment(fragment: Fragment, title: String){
        mFragments.add(fragment)
        mTitle.add(title)
    }

    override fun getItem(position: Int): Fragment {
        return mFragments.get(position)
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return  mTitle.get(position)
    }
}