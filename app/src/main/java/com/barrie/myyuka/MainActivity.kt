package com.barrie.myyuka

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.barrie.myyuka.model.Product

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
        setProductContent(product)

        Log.v("TEST", "Hello World")
        if(BuildConfig.DEBUG) {
            Log.v("PASSWORD", "Le log n'est pas visible en prod")

        }
    }
    fun setProductContent(product: Product) : Unit {
        //Name
        val name = findViewById<TextView>(R.id.name)
        name.text = product.name
        //Brand
        val brand = findViewById<TextView>(R.id.brand)
        brand.text = product.brand
        //Barcode
        val barcode = findViewById<TextView>(R.id.barcode)
        barcode.setBoldText(product.getBarcodeContent())
        //Quantity
        val quantity = findViewById<TextView>(R.id.quantity)
        quantity.setBoldText(product.getQuantityContent())
        //Sale country
        val sale_country = findViewById<TextView>(R.id.sale_country)
        sale_country.setBoldText(product.getSaleCountriesContent())
        //Ingredients
        val ingredients = findViewById<TextView>(R.id.ingredients)
        ingredients.setBoldText(product.getIngredientsContent())
        //Allergenics
        val allergenics = findViewById<TextView>(R.id.allergenics)
        allergenics.setBoldText(product.getAllergenicsContent())
        //Additives
        val additives = findViewById<TextView>(R.id.additives)
        additives.setBoldText(product.getAdditivesContent())
    }

}

fun TextView.setBoldText(text: String, separator: String = ":") {
    val spannable = SpannableStringBuilder(text)
    spannable.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
    this.text = spannable
}