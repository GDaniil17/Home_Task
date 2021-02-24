class Engineer(override val start:Int, override val last:Int, override val salary:Int, private var Name:String):Jobs{
    override fun wage(){
        println("Его/Её зарплата после всех надбавок за текущий стаж: ${salary+(last-start)*5000} рублей")
    }
    fun industry(){
        println("Этот инженер работает в $Name области")
    }
}