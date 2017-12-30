package keranjang.silencebeat.com.keranjangbelanja

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import keranjang.silencebeat.com.keranjangbelanja.Views.Activities.ListRestoranActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, ListRestoranActivity::class.java)
        startActivity(intent)
        finish()
    }
}
