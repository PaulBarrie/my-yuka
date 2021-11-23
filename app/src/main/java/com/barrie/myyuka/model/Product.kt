package com.barrie.myyuka.model

import java.security.InvalidKeyException
import java.security.InvalidParameterException


data class Product(val name : String, val brand : String, val barcode: String, val nutriscore : String,
                   val url_image : String, val quantity : String, val sale_country : List<String>,
                   val ingredients : List<String>, val allergenics : List<String> = emptyList(),
                   val additives : List<String> = emptyList(), val kCalPerPart : Int) {


    fun getBarcodeContent() : String {
        return "Code barres: ${this.barcode}"
    }

    fun getQuantityContent() : String {
        return "Quantité: ${this.barcode}"
    }

    fun getSaleCountriesContent() : String {
        return "Vendu en: ${this.sale_country.joinToString(", ")}"
    }

    fun getIngredientsContent() : String {
        return "Ingrédients: ${this.ingredients.joinToString(", ")}"
    }

    fun getAllergenicsContent() : String {
        if(this.allergenics.isEmpty()) {
            return "Substances allergènes: Aucune"
        }
        return "Substances allergènes: ${this.allergenics.joinToString(", ")}"
    }

    fun getAdditivesContent() : String {
        if(this.allergenics.isEmpty()) {
            return "Additifs: Aucun"
        }
        return "Additifs: ${this.additives.joinToString(", ")}"
    }

    fun getKCalPerPart() : String {
        return "${this.kCalPerPart} kCal/part"
    }

    fun getNutriscoreOnList() : String {
        return "Nutriscore: ${this.nutriscore}"
    }
    @Throws(InvalidParameterException::class)
    fun getNutriscoreImage() : String  {
        return when (this.nutriscore) {
            "A" -> "@drawable/nutriscore_a.png"
            "B" -> "@drawable/nutriscore_b.png"
            "C" -> "@drawable/nutriscore_c.png"
            "D" -> "@drawable/nutriscore_d.png"
            "E" -> "@drawable/nutriscore_e.png"
            else -> throw InvalidParameterException()
        }
    }

}

