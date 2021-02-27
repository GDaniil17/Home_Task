class stack {
    var lis = mutableListOf<Any>()
    fun push(element: Any){
        lis.add(element)
    }
    fun pop(){
        println(lis[lis.size-1])
        lis = lis.subList(0, lis.size-1)
    }
}