class Doctor(override val start: Int, override val last: Int, override val salary: Int) :
    Jobs {
    fun studyPeriod(studied: Int) {

        println("The Doctor studied $studied years") // текст на английском из-за правил русского языка
    }

    fun studyPeriod(studied: Double) {
        println("The Doctor studied $studied years") // текст на английском из-за правил русского языка
    }
}