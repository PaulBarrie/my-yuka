package com.barrie.myyuka

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.barrie.myyuka.model.NutritionFacts
import com.barrie.myyuka.model.NutritionFactsItem
import com.barrie.myyuka.model.Product

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val nutritionFacts = NutritionFacts(
            NutritionFactsItem("kj", 546f, 293f),
            NutritionFactsItem("g", 6f, 0.8f),
            NutritionFactsItem("g", 3f, 0.1f),
            NutritionFactsItem("g", 24.7f, 8.4f),
            NutritionFactsItem("g", 18.3f, 5.2f),
            NutritionFactsItem("g", 18.3f, 5.2f),
            NutritionFactsItem("g", 15.7f, 4.8f),
            NutritionFactsItem("g", 2.8f, 0.75f),
            NutritionFactsItem("g", 1.23f, 0.295f)
        )
        val product = Product(
            "Petits pois et carottes",
            "Cassegrain",
            "3083680085304",
            "B",
            "https://cdn.mcommerce.franprix.fr/product-images/3083680481991_H1C1_s01",
            "400 g (280 g net égoutté)",
            listOf("France", "Japon", "Suisse"),
            listOf(
                "Petits pois 66%",
                "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"
            ),
            listOf(),
            listOf(),
            35,
            nutritionFacts
        )
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_view, DetailsFragment(product))
            .commitAllowingStateLoss()
        /*
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.product_fragment, ProductDetailsSummaryFragment())

                if (nutri_fragment != null) {
                    replace(R.id.nutri_fragment, ProductDetailsNutritionalValuesFragment())
                }

                commitAllowingStateLoss()
            } */
        /*

        //setProductContent(product)
        val products = listOf(product, product, product, product, product, product, product)
        recyclerview.layoutManager = GridLayoutManager(this, 1)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = ListAdapter(products)


        Log.v("TEST", "Hello World")
        if(BuildConfig.DEBUG) {
            Log.v("PASSWORD", "Le log n'est pas visible en prod")

        }

         */

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
    val image = v.findViewById<ImageView>(R.id.product_image)
    val name = v.findViewById<TextView>(R.id.name)
    val brand = v.findViewById<TextView>(R.id.brand)
    val nutri_score = v.findViewById<TextView>(R.id.nutri_score)
    val calorie = v.findViewById<TextView>(R.id.calorie)
    fun bindProduct(product: Product) {
        name.text = product.name
        brand.text = product.brand
        nutri_score.text = product.getNutriscoreOnList()
        calorie.text = product.getKCalPerPart()
        //Picasso.get().load(product.url_image).into(image)
    }

}



