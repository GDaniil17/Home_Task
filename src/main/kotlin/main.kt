// Профессии

interface Jobs{
    val start: Int
    val last: Int
    val salary: Int
    fun wage(){
        println("Зарплата: $salary рублей")
    }

    fun  workExperience(){
        println("Его/Её стаж: ${last - start} лет")
    }
}

class Programmer (override val start: Int, override val last: Int, override val salary: Int, private var Language: String): Jobs{
    override fun wage(){
        println("Зарплата: $salary долларов")
    }

    fun firstProgrammingLanguage(){
        println("Первый ЯП этого программиста: $Language")
    }
}

class Engineer (override val start: Int, override val last: Int, override val salary: Int, private var Name: String): Jobs{
    override fun wage(){
        println("Его/Её зарплата после всех надбавок за текущий стаж: ${salary+(last-start)*5000} рублей")
    }
    fun Industry(){
        println("Этот инженер работает в $Name области")
    }

}

class Doctor(override val start: Int, override val last: Int, override val salary: Int, private var Studied: Int) : Jobs{
    fun studyPeriod(){
        println("The doctor studied $Studied years") // текст на английском из-за правил русского языка
    }
}

fun main(args: Array<String>) {
    val professional_1 = Programmer(2010, 2021, 100_000, "Pascal")
    val professional_2 = Engineer(2000, 2021, 50_000, "ХимПром")
    val professional_3 = Doctor(2005, 2021, 100_000, 7)
    professional_1.wage()
    professional_2.wage()
    professional_3.wage()
    println()
    professional_1.workExperience()
    professional_2.workExperience()
    professional_3.workExperience()
    println()
    // У professional_2 значение Name типа private, поэтому мы не можем его вызвать
    println(professional_2.salary)
    // У professional_2 значение salary не типа private, поэтому мы не можем его вызвать
    professional_1.firstProgrammingLanguage()
    professional_2.Industry()
    professional_3.studyPeriod()
}