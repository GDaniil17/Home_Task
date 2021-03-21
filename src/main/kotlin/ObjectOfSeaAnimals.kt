class ObjectOfSeaAnimals {
    private val lis = listOf<Fish>(
        Fish("Salmon", "Black Sea", 2),
        Fish("Golden Fish", "Volga", 1),
        Fish("Turtle", "Sea / Shore", 100)
    )

    fun getAllSpecies(): List<Fish> = lis

    fun getCertainAnimal(name: String): Fish? {
        return lis.mapNotNull {
            it.name == name
            it
        }.firstOrNull()
    }

    fun getCertainAnimalEx(name: String): Fish? {
        var ans: Fish? = null
        lis.map{
            if (it.name == name) {
                ans = it
            }
        }.firstOrNull()
        return ans
    }
}