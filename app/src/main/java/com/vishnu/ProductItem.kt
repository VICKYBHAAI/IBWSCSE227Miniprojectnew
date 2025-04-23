package com.vishnu

import java.io.Serializable

data class ProductItem(
    val id: String = "",
    val name: String = "",
    val imageUrl: String = "",
    val price: Double = 0.0,
    var quantity: Int = 1,
    var imageRes: Int? = null
) : Serializable {

    // Add this function to convert ProductItem to a Map for Firebase
    fun toFirebaseMap(): Map<String, Any> {
        return hashMapOf(
            "id" to id,
            "name" to name,
            "imageUrl" to imageUrl,
            "price" to price,
            "quantity" to quantity,
            "imageRes" to (imageRes ?: 0) // Handle null with default value
        )
    }

    // Secondary constructor for compatibility
    constructor(id: Int, name: String, imageRes: Int, price: Int) : this(
        id = id.toString(),
        name = name,
        imageUrl = "",
        price = price.toDouble(),
        quantity = 1,
        imageRes = imageRes
    )
}