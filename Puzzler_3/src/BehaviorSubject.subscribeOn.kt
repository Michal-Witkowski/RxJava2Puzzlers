import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

fun main(args: Array<String>) {
    val subject = BehaviorSubject.create<Int>()

    println(Thread.currentThread().name)

    subject
        .subscribeOn(Schedulers.computation())
        .subscribe {
            println("onNext: ${Thread.currentThread().name}")
        }

    subject.onNext(0)
    subject.onComplete()

    Thread.sleep(1000)
    System.out.flush()
}

/*
What we'll see on output?

A.
    main
    onNext: RxComputationThreadPool-1

B.
    main
    onNext: main

C.
    main

D.
    nothing

 */