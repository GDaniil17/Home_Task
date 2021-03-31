import java.util.concurrent.Callable
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.concurrent.thread

fun main() {

    // Задание #1

    val t1 = ClassThread("#1 ")
    t1.start()
    val t2 = ClassThread("#2 ")
    t2.start()
    val t3 = ClassThread("#3 ")
    t3.start()

    val tRunnable = Thread(ClassRunnable())
    tRunnable.start()


    for (j in 0..10) {
        Thread(Runnable {
            for (i in 0..10) {
                println(i)
            }
        }).start()
    }
    val tDSL1 = thread(priority = 10) {
        for (i in 11..20) {
            println(Thread.currentThread().name + " $i with priority 1")
        }
    }
    val tDSL2 = thread(priority = 10) {
        for (i in 11..20) {
            println(Thread.currentThread().name + " $i with priority 10")
        }
    }

    val tDSL3 = thread(isDaemon = true) {
        for (i in 11..20) {
            println(Thread.currentThread().name + " $i Demon")
        }
    }

    // Задание #2

    val obj = CommonVariable()

    val variable = Thread {
        repeat(10) {
            println("Incremented i ${++obj.i}")
            Thread.sleep(100)
        }
    }.apply { start() }

    val checkVariable1 = Thread {
        var j1 = obj.i
        while (obj.i < 10) {
            if (obj.i != j1) {
                println("checkVariable1: New value in i ${obj.i}")
                j1 = obj.i
            }
        }
    }.apply { start() }
    val checkVariable2 = Thread {
        var j2 = obj.i
        while (obj.i < 10) {
            if (obj.i != j2) {
                println("checkVariable2: New value in i ${obj.i}")
                j2 = obj.i
            }
        }
    }.apply { start() }
    val checkVariable3 = Thread {
        var j3 = obj.i
        while (obj.i < 10) {
            if (obj.i != j3) {
                println("checkVariable3: New value in i ${obj.i}")
                j3 = obj.i
            }
        }
    }.apply { start() }



    // Задание #3

    val executor1 = Executors.newFixedThreadPool(10)
    val res1 = mutableListOf<Future<Long>>()
    val executor2 = Executors.newFixedThreadPool(20)
    val res2 = mutableListOf<Future<Long>>()
    val executor3 = Executors.newFixedThreadPool(30)
    val res3 = mutableListOf<Future<Long>>()
    var i = 0

    repeat(10) {
        executor1.submit(Callable {
            val start = System.nanoTime()
            while(i < 1_000_000) {
                i++
                if (i == 1_000_000) {
                    println(Thread.currentThread().name + " i = 1_000_000")
                }
            }
            System.nanoTime() - start
        }).also { res1.add(it) }
    }
    executor1.shutdown()
    Thread.sleep(100)
    var i2 = 0
    repeat(20) {
        executor2.submit(Callable {
            val start = System.nanoTime()
            while (i2 < 1_000_000){
                i2++
                if (i2 == 1_000_000) {
                    println(Thread.currentThread().name + " i2 = 1_000_000")
                }
            }
            System.nanoTime() - start
        }).also { res2.add(it) }
    }
    executor2.shutdown()
    Thread.sleep(100)
    var i3 = 0
    repeat(30) {
        executor3.submit(Callable {
            val start = System.nanoTime()
            while(i3 < 1_000_000) {
                i3++
                if (i3 == 1_000_000) {
                    println(Thread.currentThread().name + " i3 = 1_000_000")
                }
            }
            System.nanoTime() - start
        }).also { res3.add(it) }
    }
    executor3.shutdown()
    Thread.sleep(100)

    var ans: Long = 0
    res1.forEach{
        println("res1 "+it.get())
        ans += it.get()
    }
    println("ans1 = $ans")
    ans = 0
    println()
    res2.forEach{
        println("res2 "+it.get())
        ans += it.get()
    }
    println("ans2 = $ans")
    ans = 0
    println()
    res3.forEach{
        println("res3 "+it.get())
        ans += it.get()
    }
    println("ans3 = $ans")


}

class CommonVariable {
    @Volatile
    var i = 0
}


