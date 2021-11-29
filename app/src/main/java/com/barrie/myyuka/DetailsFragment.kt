package com.barrie.myyuka

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.barrie.myyuka.model.Product
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment(val product : Product) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_details,
            container,
            false
        )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        product_details_bottom_nav.setOnNavigationItemSelectedListener { menu ->
            childFragmentManager.beginTransaction()
                .replace(
                    R.id.product_details_nav_host,
                    when (menu.itemId) {
                        R.id.tab_fiche -> ProductDetailsSummaryFragment(this.product)
                        R.id.tab_nutrition -> ProductDetailsNutritionFragment(this.product.nutritionFacts)
                        R.id.tab_tableau -> ProductDetailsNutritionalValuesFragment(this.product.nutritionFacts)
                        else -> throw Exception()
                    }

                )
                .commitAllowingStateLoss()

            true
        }
//        val navHost = childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
//        NavigationUI.setupWithNavController(product_details_bottom_nav, navHost.navController)
    }

}