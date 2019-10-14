import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

fun main(args: Array<String>) {
    Observable
        .just(1, 2)
        .startWith { 0 }
        .subscribe {
            println(it)
        }

    Thread.sleep(1000)
    System.out.flush()
}

/*
What we'll see on output?

A.
    1
    2

B.
    0
    1
    2

C.
    io.reactivex.exceptions.OnErrorNotImplementedException

D.
    nothing

 */