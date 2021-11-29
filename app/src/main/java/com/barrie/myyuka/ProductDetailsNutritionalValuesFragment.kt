package com.barrie.myyuka

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.barrie.myyuka.model.NutritionFacts

class ProductDetailsNutritionalValuesFragment(val nutritionFacts: NutritionFacts) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_details_nutritional_values,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContent(view)

    }

    fun setContent(view: View) {
        //Energy
        view.findViewById<TextView>(R.id.energy100g).text = "${this.nutritionFacts.energy.quantityPer100g} ${this.nutritionFacts.energy.unit}"
        view.findViewById<TextView>(R.id.energyPP).text = "${this.nutritionFacts.energy.quantityPerPortion} ${this.nutritionFacts.energy.unit}"

        //Butterfat
        view.findViewById<TextView>(R.id.butterfat100g).text = "${this.nutritionFacts.butterfat.quantityPer100g} ${this.nutritionFacts.butterfat.unit}"
        view.findViewById<TextView>(R.id.butterfatPP).text = "${this.nutritionFacts.butterfat.quantityPerPortion} ${this.nutritionFacts.butterfat.unit}"

        //Fatty acid
        view.findViewById<TextView>(R.id.fattyacid100g).text = "${this.nutritionFacts.saturatedFattyAcid.quantityPer100g} ${this.nutritionFacts.saturatedFattyAcid.unit}"
        view.findViewById<TextView>(R.id.fattyacidPP).text = "${this.nutritionFacts.saturatedFattyAcid.quantityPerPortion} ${this.nutritionFacts.saturatedFattyAcid.unit}"

        //Carbohydrates
        view.findViewById<TextView>(R.id.carbohydrates100g).text = "${this.nutritionFacts.carbohydrate.quantityPer100g} ${this.nutritionFacts.carbohydrate.unit}"
        view.findViewById<TextView>(R.id.carbohydratesPP).text = "${this.nutritionFacts.carbohydrate.quantityPerPortion} ${this.nutritionFacts.carbohydrate.unit}"

        //Sugar
        view.findViewById<TextView>(R.id.sugar100g).text = "${this.nutritionFacts.sugar.quantityPer100g} ${this.nutritionFacts.sugar.unit}"
        view.findViewById<TextView>(R.id.sugarPP).text = "${this.nutritionFacts.sugar.quantityPerPortion} ${this.nutritionFacts.sugar.unit}"

        //Fibres
        view.findViewById<TextView>(R.id.fibres100g).text = "${this.nutritionFacts.alimentaryFiber.quantityPer100g} ${this.nutritionFacts.alimentaryFiber.unit}"
        view.findViewById<TextView>(R.id.fibresPP).text = "${this.nutritionFacts.alimentaryFiber.quantityPerPortion} ${this.nutritionFacts.alimentaryFiber.unit}"

        //Proteins
        view.findViewById<TextView>(R.id.proteins100g).text = "${this.nutritionFacts.protein.quantityPer100g} ${this.nutritionFacts.protein.unit}"
        view.findViewById<TextView>(R.id.proteinsPP).text = "${this.nutritionFacts.protein.quantityPerPortion} ${this.nutritionFacts.protein.unit}"

        //Salt
        view.findViewById<TextView>(R.id.salt100g).text = "${this.nutritionFacts.salt.quantityPer100g} ${this.nutritionFacts.salt.unit}"
        view.findViewById<TextView>(R.id.saltPP).text = "${this.nutritionFacts.salt.quantityPerPortion} ${this.nutritionFacts.salt.unit}"

        //Sodium
        view.findViewById<TextView>(R.id.sodium100g).text = "${this.nutritionFacts.sodium.quantityPer100g} ${this.nutritionFacts.sodium.unit}"
        view.findViewById<TextView>(R.id.sodiumPP).text = "${this.nutritionFacts.sodium.quantityPerPortion} ${this.nutritionFacts.sodium.unit}"




    }

}