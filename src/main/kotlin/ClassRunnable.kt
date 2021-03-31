class ClassRunnable : Runnable {
    override fun run() {
        for (i in 0..10) {
            println("Runnable $i")
        }
        try {
            Thread.sleep(1000)
        } catch (e: Exception) {
            println(e.message)
        }
    }
}