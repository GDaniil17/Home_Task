class ClassThread() : Thread() {
    var ThreadName: String = ""

    constructor(ThreadName: String) : this() {
        this.ThreadName = ThreadName
        println(this.ThreadName + " is started")
    }

    override fun run() {
        for (i in 0..10) {
            println(this.ThreadName + " $i")
        }
        try {
            Thread.sleep(1000)
        } catch (e: Exception) {
            println(e.message)
        }
    }
}