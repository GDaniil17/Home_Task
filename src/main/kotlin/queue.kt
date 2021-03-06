class Queue<T>(){
    var lis = mutableListOf<T>()
    fun enqueue(element: T){
        lis.add(element)
    }
    fun dequeue(): T {
        val tmp = lis[0]
        lis.removeFirst()
        return tmp
    }
}