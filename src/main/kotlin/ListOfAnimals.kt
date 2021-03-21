class ListOfAnimals {

    private val lis: List<Animal> = listOf(
        Animal("Monkey", true, "Funny"),
        Animal("Dog", false, ""),
        Animal("Turtle", true, "Really old")
    )

    fun getAllSpecies(): List<Animal> = lis

    fun getCertainAnimal(name: String): Animal? {
        var ans: Animal? = null
        lis.map{
            if (it.name == name) {
                ans = it
            }
        }.firstOrNull()
        return ans
    }
}