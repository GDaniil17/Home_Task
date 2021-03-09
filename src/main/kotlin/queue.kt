class Queue<T>{
    private var lis = mutableListOf<T>()
    fun enqueue(element: T){
        lis.add(element)
    }
    fun dequeue(): T {
        return lis.removeFirst()
    }
    fun lis(){
        println(lis)
    }
}