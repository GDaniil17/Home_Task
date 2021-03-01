fun main() {
    var example = queue()
    example.enqueue(1)
    example.enqueue(2)
    example.enqueue(3)
    example.enqueue(4)
    example.enqueue(5)
    example.dequeue()
    example.dequeue()
    example.enqueue(6)
    example.enqueue(7)
    println(example.lis)

    
    var exampleTwo = stack()
    exampleTwo.push(1)
    exampleTwo.push(2)
    exampleTwo.push(3)
    exampleTwo.push(4)
    exampleTwo.pop()
    exampleTwo.pop()
    exampleTwo.push(5)
    println(exampleTwo.lis)

}