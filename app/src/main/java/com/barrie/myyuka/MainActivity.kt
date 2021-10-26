package com.barrie.myyuka

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barrie.myyuka.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))
        val product = Product("Petits pois et carottes", "Cassegrain", "3083680085304",
            "E", "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            "400 g (280 g net égoutté)", listOf("France", "Japon", "Suisse"), listOf("Petits pois 66%",
                "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"))
        //setProductContent(product)
        val products = listOf(product, product, product, product, product, product, product)
        recyclerview.layoutManager = GridLayoutManager(this, 1)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = ListAdapter(products)


        Log.v("TEST", "Hello World")
        if(BuildConfig.DEBUG) {
            Log.v("PASSWORD", "Le log n'est pas visible en prod")

        }

    }
    fun setProductContent(product: Product) : Unit {
        //Image
        val productImageView = findViewById<ImageView>(R.id.product_image)
        Picasso.get().load("url").into(productImageView)
        //Name
        val name = findViewById<TextView>(R.id.name)
        name.text = product.name
        //Brand
        val brand = findViewById<TextView>(R.id.brand)
        brand.text = product.brand
        //Nutriscore
        //nutriscore.
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

class ListAdapter(val product: List<Product>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_cell, parent, false)
        )
    }
    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val item = holder as ListItemViewHolder
        item.bindProduct(product[position])
    }

    override fun getItemCount(): Int {
        return 7
    }

}

class ListItemViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val name = v.findViewById<TextView>(R.id.name)
    val brand = v.findViewById<TextView>(R.id.brand)
    val nutri_score = v.findViewById<TextView>(R.id.nutri_score)
    val calorie = v.findViewById<TextView>(R.id.calorie)

    fun bindProduct(product: Product) {
        name.text = product.name
        brand.text = product.brand
    }

}

fun TextView.setBoldText(text: String, separator: String = ":") {
    val spannable = SpannableStringBuilder(text)
    spannable.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
    this.text = spannable
}

