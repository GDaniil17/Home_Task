class ConnectionClass(private var lis: List<ListOfSeaAndEarthAnimals>) {
    fun connect(): List<ListOfSeaAndEarthAnimals> {
        ListOfAnimals().getAllSpecies().map{
            if (ObjectOfSeaAnimals().getCertainAnimal(it.name) != null) {
                lis += ListOfSeaAndEarthAnimals(it.name, null, null, it.wild, it.additionalInfoAbout)
            } else {
                val data: Fish? = ObjectOfSeaAnimals().getCertainAnimalEx(it.name)
                if (data != null) {
                    lis += ListOfSeaAndEarthAnimals(it.name, data.area, data.age, it.wild, it.additionalInfoAbout)
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
        return lis.filter { it.additionalInfoAbout.isNotEmpty() }
    }
}