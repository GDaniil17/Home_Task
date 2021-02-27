fun main() {
    val professionalOne = Programmer(2010, 2021, 100_000, "Pascal")
    val professionalTwo = Engineer(2000, 2021, 50_000, "ХимПром")
    val professionalThree = Doctor(2005, 2021, 100_000)
    professionalOne.wage()
    professionalTwo.wage()
    professionalThree.wage()
    println()
    professionalOne.workExperience()
    professionalTwo.workExperience()
    professionalThree.workExperience()
    println()
    val example: Jobs = Doctor(2005, 2021, 100_000)
    example.workExperience()
    // У professional_2 значение Name типа private, поэтому мы не можем его вызвать
    println(professionalTwo.salary)
    // У professional_2 значение salary не типа private, поэтому мы не можем его вызвать
    professionalOne.firstProgrammingLanguage()
    professionalTwo.industry()
    // перегруженный метод
    professionalThree.studyPeriod(6.5)
    professionalThree.studyPeriod(7)
}