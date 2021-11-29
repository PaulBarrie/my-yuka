package com.barrie.myyuka

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.barrie.myyuka.model.Product
import com.squareup.picasso.Picasso

class ProductDetailsSummaryFragment(val product: Product) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_product_details,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setProductContent(this.product, view)
    }


    fun setProductContent(product: Product, view: View)  {
        //Image
        val productImageView = view.findViewById<ImageView>(R.id.product_image)
        Picasso.get().load(product.url_image).into(productImageView)
        //Name
        val name = view.findViewById<TextView>(R.id.name)
        name.text = product.name
        //Brand
        val brand = view.findViewById<TextView>(R.id.brand)
        brand.text = product.brand
        //Nutriscore
        val nutriscoreView = view.findViewById<ImageView>(R.id.nutri_score)
        val context: Context = nutriscoreView.context
        nutriscoreView.setImageResource(product.getNutriscoreImage())
        //Barcode
        val barcode = view.findViewById<TextView>(R.id.barcode)
        barcode.setBoldText(product.getBarcodeContent())
        //Quantity
        val quantity = view.findViewById<TextView>(R.id.quantity)
        quantity.setBoldText(product.getQuantityContent())
        //Sale country
        val sale_country = view.findViewById<TextView>(R.id.sale_country)
        sale_country.setBoldText(product.getSaleCountriesContent())
        //Ingredients
        val ingredients = view.findViewById<TextView>(R.id.ingredients)
        ingredients.setBoldText(product.getIngredientsContent())
        //Allergenics
        val allergenics = view.findViewById<TextView>(R.id.allergenics)
        allergenics.setBoldText(product.getAllergenicsContent())
        //Additives
        val additives = view.findViewById<TextView>(R.id.additives)
        additives.setBoldText(product.getAdditivesContent())
    }
    fun TextView.setBoldText(text: String, separator: String = ":") {
        val spannable = SpannableStringBuilder(text)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        this.text = spannable
    }
}