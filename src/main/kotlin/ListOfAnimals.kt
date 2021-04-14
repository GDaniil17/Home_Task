class ListOfAnimals {

    private val lis: List<Animal> = listOf(
        Animal("Monkey", true, "Funny"),
        Animal("Dog", false, ""),
        Animal("Turtle", true, "Really old")
    )

    fun getAllSpecies(): List<Animal> = lis

    fun getCertainAnimal(name: String): Animal? {
        return lis.firstOrNull {
            it.name == name
        }
    }

}