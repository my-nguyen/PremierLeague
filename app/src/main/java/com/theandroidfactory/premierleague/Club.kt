package com.theandroidfactory.premierleague

data class Club(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val descriptionLong: String = "",
    val buttonText: String = "",
    val imageResId: Int = 0,
    val imageUrl: String? = null,
    val officialUrl: String = "",
    var isFavorite: Boolean = false
): java.io.Serializable
