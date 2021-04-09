class ConnectionClass(private var lis: List<ObjectOfSeaAndEarthAnimals>) {
    fun connect(): List<ObjectOfSeaAndEarthAnimals> {
        ListOfAnimals().getAllSpecies().map{
            if (ObjectOfSeaAnimals().getCertainAnimal(it.name) != null) {
                lis += ObjectOfSeaAndEarthAnimals(it.name, null, null, it.wild, it.additionalInfoAbout)
            } else {
                val data: Fish? = ObjectOfSeaAnimals().getCertainAnimalEx(it.name)
                if (data != null) {
                    lis += ObjectOfSeaAndEarthAnimals(it.name, data.area, data.age, it.wild, it.additionalInfoAbout)
                }
            }
        }
        return lis
    }

    fun sort(): List<ObjectOfSeaAndEarthAnimals> {
        return lis.sortedBy { it.name }
    }

    fun groupThem(): Map<Boolean?, List<ObjectOfSeaAndEarthAnimals>> {
        return lis.groupBy { it.wild }
    }

    fun accord(): List<ObjectOfSeaAndEarthAnimals> {
        return lis.filter { it.additionalInfoAbout.isNotEmpty() }
    }
}