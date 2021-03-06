fun main() {
    val example = Queue<Int>()
    example.enqueue(1)
    example.enqueue(2)
    example.enqueue(3)
    example.enqueue(4)
    example.enqueue(5)
    println(example.dequeue())
    println(example.dequeue())
    example.enqueue(6)
    example.enqueue(7)
    println(example.lis)

    val exampleTwo = Stack<Int>()
    exampleTwo.push(1)
    exampleTwo.push(2)
    exampleTwo.push(3)
    exampleTwo.push(4)
    println(exampleTwo.pop())
    println(exampleTwo.pop())
    exampleTwo.push(5)
    println(exampleTwo.lis)


}