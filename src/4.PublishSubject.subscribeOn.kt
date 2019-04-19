import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

fun main(args: Array<String>) {
    val subject = PublishSubject.create<Int>()

    println(Thread.currentThread().name)

    subject
        .subscribeOn(Schedulers.computation())
        .subscribe {
            println("onNext: ${Thread.currentThread().name}")
        }

    subject.onNext(0)
    subject.onNext(1)
    subject.onComplete()

    Thread.sleep(1000)
    System.out.flush()
}

/*
What we'll see on output?

A.
    main
    onNext: RxComputationThreadPool-1
    onNext: RxComputationThreadPool-1

B.
    main
    onNext: RxComputationThreadPool-1
    onNext: RxComputationThreadPool-2

C.
    main
    onNext: main
    onNext: main

D.
    main

 */