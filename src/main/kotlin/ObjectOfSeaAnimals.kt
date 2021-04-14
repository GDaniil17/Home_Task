class ObjectOfSeaAnimals {
    private val lis = listOf<Fish>(
        Fish("Salmon", "Black Sea", 2),
        Fish("Golden Fish", "Volga", 1),
        Fish("Turtle", "Sea / Shore", 100)
    )

    fun getAllSpecies(): List<Fish> = lis

    fun getCertainAnimal(name: String): Fish? {
        return lis.firstOrNull {
            it.name == name
        }
    }
}