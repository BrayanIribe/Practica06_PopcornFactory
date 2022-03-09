package com.example.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)
        val bundle = intent.extras ?: return

        iv_imagen_pelicula.setImageResource(bundle.getInt("header"))
        tv_TituloPelicula.setText(bundle.getString("nombre"))
        tv_DescPelicula.setText(bundle.getString("sinopsis"))

        var id = bundle.getInt("pos")
        var titulo = bundle.getString("titulo")!!

        buyTickets.setOnClickListener {
            val intent: Intent = Intent(this, SeatSelection::class.java)
            intent.putExtra("id", id)
            intent.putExtra("title", titulo)
            startActivity(intent)
        }
    }
}