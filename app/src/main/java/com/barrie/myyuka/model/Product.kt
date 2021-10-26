package com.barrie.myyuka.model


data class Product(val name : String, val brand : String, val barcode: String, val nutriscore : String,
                   val url_image : String, val quantity : String, val sale_country : List<String>,
                   val ingredients : List<String>, val allergenics : List<String> = emptyList(),
                   val additives : List<String> = emptyList()) {


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



}

