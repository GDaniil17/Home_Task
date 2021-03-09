class Stack<T> {
    private var lis = mutableListOf<T>()
    fun push(element: T){
        lis.add(element)
    }
    fun pop(): T {
        return lis.removeLast()
    }
    fun lis(){
        println(lis)
    }
}