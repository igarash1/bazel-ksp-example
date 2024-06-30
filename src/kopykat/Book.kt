package src.kopykat

data class Book(
    val title: String,
    val author: String,
    val id: String,
    val priceJpy: Int,
)

fun example() {
    val book1 = Book(
        title = "How to get rich",
        author = "Rich man",
        id = "ID_123456789",
        priceJpy = 1000000,
    )
    // kopykat
    val book2 = book1.copy {
        priceJpy++
    }
    println("book1 = $book1")
    println("book2 = $book2")
}

class Main {
    companion object {
        @JvmStatic
        fun main(args : Array<String>) {
            example()
        }
    }
}
