class ListOfSeaAnimals{
    private val lis = listOf<Fish>(
        Fish("Salmon", "Black Sea", 2),
        Fish("Golden Fish", "Volga", 1),
        Fish("Turtle", "Sea / Shore", 100)
    )

    fun getCertainAnimal(name: String): String {
        var ans = ""
        for (i in lis) {
            if (i.name == name) {
                ans += "Name: ${i.name} \nAge: ${i.age} \nArea: ${i.area} \n"
            }
        }
        val res = ListOfAnimals().getCertainAnimal(name)

        return when {
            ans.isNullOrEmpty() -> {
                ""
            }
            res != null -> {
                ans + "Wild: ${res.wild} \nInfo: ${res.additionalInfoAbout}"
            }
            else -> {
                ans
            }
        }
    }

    fun getCertainAnimalEx(name: String): Fish? {
        for (i in lis) {
            if (i.name == name) {
                return i
            }
        }
        return null
    }
}