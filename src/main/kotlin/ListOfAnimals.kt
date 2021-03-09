class ListOfAnimals {

    private val lis: List<Animal> = listOf(
        Animal("Monkey", true, "Funny"),
        Animal("Dog", false, ""),
        Animal("Turtle", true, "Really old")
    )

    fun getAllSpecies(): List<Animal> = lis

    fun getCertainAnimal(name: String): Animal? {
        var ans: Animal? = null
        for (i in lis) {
            if (i.name == name) {
                ans = i
                break
            }
        }
        return ans
    }
}