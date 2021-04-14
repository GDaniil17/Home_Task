class ConnectionClass {
    private val lis: List<ObjectOfSeaAndEarthAnimals> = ListOfAnimals().getAllSpecies().map{
        if (ObjectOfSeaAnimals().getCertainAnimal(it.name) != null) {
            ObjectOfSeaAndEarthAnimals(it.name, null, null, it.wild, it.additionalInfoAbout)
        } else {
            val data: Fish? = ObjectOfSeaAnimals().getCertainAnimal(it.name)
            ObjectOfSeaAndEarthAnimals(it.name, data?.area, data?.age, it.wild, it.additionalInfoAbout)
        }
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