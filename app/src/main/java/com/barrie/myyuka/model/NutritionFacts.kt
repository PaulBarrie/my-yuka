package com.barrie.myyuka.model

import com.barrie.myyuka.R

data class NutritionFacts(
    val energy: NutritionFactsItem, val butterfat: NutritionFactsItem, val saturatedFattyAcid : NutritionFactsItem,
    val carbohydrate: NutritionFactsItem, val sugar: NutritionFactsItem, val alimentaryFiber : NutritionFactsItem,
    val protein: NutritionFactsItem, val salt: NutritionFactsItem, val sodium: NutritionFactsItem){

    fun getButterFatLevel() : Pair<Int, String> {
        if(this.butterfat.quantityPer100g < 3) {
            return Pair(R.color.nutrient_level_low, "faible quantité")
        }
        else if(this.butterfat.quantityPer100g < 20) {
            return Pair(R.color.nutrient_level_moderate, "quantité modérée")
        } else {
            return Pair( R.color.nutrient_level_high, "quantité élevée")
        }
    }

    fun getSaturatedFattyAcidLevel() : Pair<Int, String> {
        if(this.saturatedFattyAcid.quantityPer100g < 1.5) {
            return Pair(R.color.nutrient_level_low, "faible quantité")
        }
        else if(this.saturatedFattyAcid.quantityPer100g < 5) {
            return Pair(R.color.nutrient_level_moderate, "quantité modérée")
        } else {
            return Pair( R.color.nutrient_level_high, "quantité élevée")
        }
    }

    fun getSugarLevel() : Pair<Int, String>  {
        if(this.butterfat.quantityPer100g < 5) {
            return Pair(R.color.nutrient_level_low, "faible quantité")
        }
        else if(this.butterfat.quantityPer100g < 12.5) {
            return Pair(R.color.nutrient_level_moderate, "quantité modérée")
        } else {
            return Pair( R.color.nutrient_level_high, "quantité élevée")
        }
    }

    fun getSaltLevel() : Pair<Int, String>  {
        if(this.salt.quantityPer100g < 0.3) {
            return Pair(R.color.nutrient_level_low, "faible quantité")
        }
        else if(this.salt.quantityPer100g < 1.5) {
            return Pair(R.color.nutrient_level_moderate, "quantité modérée")
        } else {
            return Pair( R.color.nutrient_level_high, "quantité élevée")
        }
    }


}