import io.reactivex.Completable
import io.reactivex.Maybe

fun main(args: Array<String>) {
    var first = 1
    var second = 2

    Completable
            .fromCallable {
                first = second
            }
            .subscribe {
                println("completed")
            }

    Thread.sleep(1000)
    System.out.flush()
}

/*
What we'll see on output?

A.
    nothing

B.
    completed

C.
    io.reactivex.exceptions.OnErrorNotImplementedException

D.
    Compilation error

 */