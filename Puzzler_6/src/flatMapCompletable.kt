import io.reactivex.Completable
import io.reactivex.subjects.BehaviorSubject

fun main(args: Array<String>) {
    val completable: Completable = BehaviorSubject
        .createDefault(0)
        .doOnNext {
            println(it)
        }
        .flatMapCompletable {
            Completable.fromCallable {
                println("fromCallable")
            }
        }

    completable.subscribe {
        println("completed")
    }

    Thread.sleep(1000)
    System.out.flush()
}

/*
What we'll see on output?

A.
    0

B.
    0
    fromCallable

C.
    0
    fromCallable
    completed

D.
    nothing

 */