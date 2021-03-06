class Stack<T>() {
    var lis = mutableListOf<T>()
    fun push(element: T){
        lis.add(element)
    }
    fun pop(): T {
        val tmp = lis[lis.size-1]
        lis.removeLast()
        return tmp
    }
}