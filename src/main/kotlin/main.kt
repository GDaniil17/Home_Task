import java.util.concurrent.Callable
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
        Thread {
            for (i in 0..10) {
                println(i)
            }
        }.start()
    }
    thread {
        for (i in 11..20) {
            println(Thread.currentThread().name + " $i with priority 1")
        }
    }
    thread(priority = 10) {
        for (i in 11..20) {
            println(Thread.currentThread().name + " $i with priority 10")
        }
    }

    thread(isDaemon = true) {
        for (i in 11..20) {
            println(Thread.currentThread().name + " $i Demon")
        }
    }

    // Задание #2

    val obj = CommonVariable()

    Thread {
        repeat(10) {
            println("${Thread.currentThread().name}: common value is i ${obj.i}")
            Thread.sleep(100)
        }
    }.apply { start() }

    Thread {
        var j1 = obj.i
        while (obj.i < 10) {
            if (obj.i != j1) {
                println("${Thread.currentThread().name}: common value is i ${obj.i}")
                j1 = obj.i
            }
        }
    }.apply { start() }
    Thread {
        var j2 = obj.i
        while (obj.i < 10) {
            if (obj.i != j2) {
                println("${Thread.currentThread().name}: common value is i ${obj.i}")
                j2 = obj.i
            }
        }
    }.apply { start() }
    Thread {
        var j3 = obj.i
        while (obj.i < 10) {
            if (obj.i != j3) {
                println("${Thread.currentThread().name}: common value is i ${obj.i}")
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
            repeat(1_000_000) {
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
            repeat(1_000_000) {
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
            repeat(1_000_000) {
                if (i3 == 1_000_000) {
                    println(Thread.currentThread().name + " i3 = 1_000_000")
                }
            }
            System.nanoTime() - start
        }).also { res3.add(it) }
    }
    executor3.shutdown()
    Thread.sleep(100)

    for (i in mapOf(
        "res1" to
                res1.sumBy { it.get().toInt() },
        "res2" to
                res2.sumBy { it.get().toInt() },
        "res3" to
                res3.sumBy { it.get().toInt() })){
        println("${i.key} ${i.value}")
    }

}

class CommonVariable {
    @Volatile
    var i = 0
}


