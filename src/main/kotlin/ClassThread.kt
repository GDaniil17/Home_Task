class ClassThread() : Thread() {
    var threadName: String = ""

    constructor(ThreadName: String) : this() {
        this.threadName = ThreadName
        println(this.threadName + " is started")
    }

    override fun run() {
        for (i in 0..10) {
            println(this.threadName + " $i")
        }
        try {
            Thread.sleep(1000)
        } catch (e: Exception) {
            println(e.message)
        }
    }
}