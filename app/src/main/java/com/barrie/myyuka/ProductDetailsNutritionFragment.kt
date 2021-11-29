package com.barrie.myyuka

import android.annotation.SuppressLint
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.barrie.myyuka.model.NutritionFacts

class ProductDetailsNutritionFragment(val nutritionFacts: NutritionFacts) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_details_nutrition,
            container,
            false
        )
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewContent(this.nutritionFacts, view)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("SetTextI18n")
    fun setViewContent(nutritionFacts: NutritionFacts, view: View) {
        // Butterfat
        val (butterColor, butterLevel) = nutritionFacts.getButterFatLevel()
        view.findViewById<TextView>(R.id.butterfat_quantity).text = "${nutritionFacts.butterfat.quantityPer100g} de Matières grasses / Lipides"
        view.findViewById<TextView>(R.id.butterfat_level).text = "en $butterLevel"
        view.findViewById<ImageView>(R.id.butterfat_circle).background.colorFilter = BlendModeColorFilter(
            resources.getColor(butterColor), BlendMode.SRC_ATOP)

        // Fatty acid
        val fattyAcidItem = nutritionFacts.getSaturatedFattyAcidLevel()
        val (fattyColor, fattyLevel) = nutritionFacts.getButterFatLevel()
        view.findViewById<TextView>(R.id.fatty_acid_quantity).text = "${nutritionFacts.saturatedFattyAcid.quantityPer100g} de Matières grasses / Lipides"
        view.findViewById<TextView>(R.id.fatty_acid_level).text = "en $fattyLevel"
        view.findViewById<ImageView>(R.id.fatty_acid_circle).background.colorFilter = BlendModeColorFilter(
            resources.getColor(fattyColor), BlendMode.SRC_ATOP)

        //Sugar
        val (sugarColor, sugarLevel) = nutritionFacts.getSugarLevel()
        view.findViewById<TextView>(R.id.sugar_quantity).text = "${nutritionFacts.sugar.quantityPer100g} de Matières grasses / Lipides"
        view.findViewById<TextView>(R.id.sugar_level).text = "en $sugarLevel"
        view.findViewById<ImageView>(R.id.sugar_circle).background.colorFilter = BlendModeColorFilter(
            resources.getColor(sugarColor), BlendMode.SRC_ATOP)

        val (saltColor, saltLevel) = nutritionFacts.getSaltLevel()
        view.findViewById<TextView>(R.id.salt_quantity).text = "${nutritionFacts.salt.quantityPer100g} de Matières grasses / Lipides"
        view.findViewById<TextView>(R.id.salt_level).text = "en $saltLevel"
        view.findViewById<ImageView>(R.id.salt_circle).background.colorFilter = BlendModeColorFilter(
            resources.getColor(saltColor), BlendMode.SRC_ATOP)

    }

}