class queue(){
    var lis = mutableListOf<Any>()
    fun enqueue(element: Any){
        lis.add(element)
        //println(lis)
    }
    fun dequeue(){
        println(lis[0])
        lis = lis.subList(1, lis.size)
    }
}