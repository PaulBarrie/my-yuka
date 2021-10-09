package com.barrie.androidtest

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.layout.*
import com.barrie.androidtest.model.Product

class MainActivity : AppCompatActivity() {
    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_constraint)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))

        val product = Product("Petits pois et carottes", "Cassegrain", "3083680085304",
            "E", "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            "400 g (280 g net égoutté)", listOf("France", "Japon", "Suisse"), listOf("Petits pois 66%",
            "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"))
        //Name
        val name = findViewById<TextView>(R.id.name)
        name.text = product.name
        //Brand
        val brand = findViewById<TextView>(R.id.brand)
        brand.text = product.brand
        //Barcode
        val barcode = findViewById<TextView>(R.id.barcode)
        barcode.setBoldText(getString(R.string.barcode, product.barcode))
        //Quantity
        val quantity = findViewById<TextView>(R.id.quantity)
        //barcode.setBoldText(getString(R.string.quantity, product.quantity))
        quantity.text = product.quantity
        //Sale country
        val sale_country = findViewById<TextView>(R.id.sale_country)
        //barcode.setBoldText(getString(R.string.sale_country, product.quantity))
        sale_country.text = product.getSaleCountriesContent()
        //Ingredients
        val ingredients = findViewById<TextView>(R.id.ingredients)
        ingredients.text = product.getIngredientsContent()
        //Allergenics
        val allergenics = findViewById<TextView>(R.id.allergenics)
        allergenics.text = product.getAllergenicsContent()
        //Additives
        val additives = findViewById<TextView>(R.id.additives)
        additives.text = product.getAdditivesContent()
        //barcode.setBoldText(getString(R.string.barcode, "Code barre: 123456"))
        // Interactive message
        /*
             Snackbar.make(
            this,
            findViewById(android.R.id.content),
            "Ceci est une version de dévelopement",
            Snackbar.LENGTH_INDEFINITE
        ).apply {
            setAction("Cliquez-moi", object: View.OnClickListener {
                override fun onClick(p0: View?) {
                    // TODO("Not yet implemented")
                }

            })
            show()
        }
         */

        Log.v("TEST", "Hello World")
        if(BuildConfig.DEBUG) {
            Log.v("PASSWORD", "Le log n'est pas visible en prod")

        }
    }

}

fun TextView.setBoldText(text: String, separator: String = ":") {
    val spannable = SpannableStringBuilder(text)
    spannable.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
    this.text = spannable
}