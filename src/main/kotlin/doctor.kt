class doctor(override val start: Int, override val last: Int, override val salary: Int, private var Studied: Int) : jobs{
    fun studyPeriod(Studied: Int){
        println("The doctor studied $Studied years") // текст на английском из-за правил русского языка
    }
    fun studyPeriod(Studied: Double){
        println("The doctor studied $Studied years") // текст на английском из-за правил русского языка
    }
}