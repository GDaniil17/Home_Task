class Doctor(override val start: Int, override val last: Int, override val salary: Int, private var Studied: Int) : Jobs{
    fun studyPeriod(){
        println("The doctor studied $Studied years") // текст на английском из-за правил русского языка
    }
}