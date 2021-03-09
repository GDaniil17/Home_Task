data class ConnectionClass(val tr: Boolean = true) {
    private var lis = listOf<ListOfSeaAndEarthAnimals>()
    fun connect(): List<ListOfSeaAndEarthAnimals> {
        for (i in ListOfAnimals().getAllSpecies()) {
            if (ListOfSeaAnimals().getCertainAnimal(i.name) == "") {
                lis += ListOfSeaAndEarthAnimals(i.name, null, null, i.wild, i.additionalInfoAbout)
            } else {
                val data: Fish? = ListOfSeaAnimals().getCertainAnimalEx(i.name)
                if (data != null) {
                    lis += ListOfSeaAndEarthAnimals(i.name, data.area, data.age, i.wild, i.additionalInfoAbout)
                }
            }
        }
        return lis
    }

    fun sort(): List<ListOfSeaAndEarthAnimals> {
        return lis.sortedBy { it.name }
    }

    fun groupThem(): Map<Boolean?, List<ListOfSeaAndEarthAnimals>> {
        return lis.groupBy { it.wild }
    }

    fun accord(): List<ListOfSeaAndEarthAnimals> {
        return lis.filter { it.additionalInfoAbout != "" }
    }
}