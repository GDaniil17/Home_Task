fun main() {
    val seaAnimal = ObjectOfSeaAnimals()
    val found = seaAnimal.getCertainAnimal("Turtle")
    println(found)
    val unitedClass = ConnectionClass(listOf<ObjectOfSeaAndEarthAnimals>())
    println(unitedClass.connect())
    println(unitedClass.sort())
    println(unitedClass.groupThem())
    println(unitedClass.accord())
}