package src.moshi

import com.squareup.moshi.adapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi

enum class ProductCategory {
    FOOD_AND_BEVERAGES,
    COMPUTERS,
    VIDEO_GAMES,
    ELECTRONICS,
    BOOKS,
    ACCESSORIES,
    KITCHEN_HOUSEWARES,
    OTHERS,
}

@JsonClass(generateAdapter = true)
data class Product(
    val name: String,
    val imageUrl: String,
    val priceJpy: Int,
    val category: ProductCategory,
)

@OptIn(ExperimentalStdlibApi::class)
fun encodeAndDecode() {
    val product = Product(
        name = "Bubble Tea",
        imageUrl = "https://bubbletea.com",
        priceJpy = 800,
        category = ProductCategory.FOOD_AND_BEVERAGES,
    )
    val moshi = Moshi.Builder().build()
    val jsonAdapter: JsonAdapter<Product> = moshi.adapter<Product>()

    val encodedJson = jsonAdapter.toJson(product)
    println("Encoded Json: $encodedJson")
    val decodedObject = jsonAdapter.fromJson(encodedJson)
    println("Decoded object: $decodedObject")
}


class Main {
    companion object {
        @JvmStatic
        fun main(args : Array<String>) {
            encodeAndDecode()
        }
    }
}
