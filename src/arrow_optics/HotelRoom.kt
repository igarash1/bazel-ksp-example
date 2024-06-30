package src.arrow_optics

import arrow.optics.copy
import arrow.optics.optics

enum class Equipment {
    BATHTUB,
    WASHROOM,
    TV,
    REFRIGERATOR,
    WINDOW,
}

@optics
data class HotelRoom (
    val roomNumber: Int,
    val numberOfBed: Int,
    val equipments: List<Equipment>,
    val occupied: Boolean,
) {
    companion object
}

fun example() {
    val room1 = HotelRoom(
        roomNumber = 1,
        numberOfBed = 2,
        equipments = listOf(Equipment.WASHROOM, Equipment.TV, Equipment.REFRIGERATOR, Equipment.WINDOW),
        occupied = true,
    )
    // Arrow lenses
    val room2 = room1.copy {
        HotelRoom.roomNumber set 2
        HotelRoom.occupied set false
    }
    println("room1 = $room1")
    println("room2 = $room2")
}

class Main {
    companion object {
        @JvmStatic
        fun main(args : Array<String>) {
            example()
        }
    }
}