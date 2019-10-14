import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val subject = BehaviorSubject.create<Long>()

    Observable
        .interval(100, TimeUnit.MILLISECONDS)
        .take(3)
        .subscribe(subject)

    Thread.sleep(1000)

    subject
            .subscribe {
                println(it)
            }

    Thread.sleep(1000)
    System.out.flush()
}

/*
What we'll see on output?

A.
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