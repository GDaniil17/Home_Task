fun main() {
    val foundSeaAnimal = ObjectOfSeaAnimals().getCertainAnimal("Turtle")
    val foundAnimal = ListOfAnimals().getCertainAnimal("Snake")
    println(foundSeaAnimal)
    println(foundAnimal)
    val unitedClass = ConnectionClass()
    println(unitedClass.sort())
    println(unitedClass.groupThem())
    println(unitedClass.accord())
}