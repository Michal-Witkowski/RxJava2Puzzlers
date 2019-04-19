import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {
    val observables = (0..3).map {
        Observable
            .just(1)
            .subscribeOn(Schedulers.io())
    }

    println(Thread.currentThread().name)

    Observable
        .merge(observables)
        .observeOn(Schedulers.computation())
        .subscribe {
            println(Thread.currentThread().name)
        }

    Thread.sleep(1000)
    System.out.flush()
}

/*
What we'll see on output?

A.
    main
    RxComputationThreadPool-1
    RxComputationThreadPool-2
    RxComputationThreadPool-3
    RxComputationThreadPool-4

B.
    main
    RxComputationThreadPool-1
    RxComputationThreadPool-1
    RxComputationThreadPool-1
    RxComputationThreadPool-1

C.
    main
    RxCachedThreadScheduler-1
    RxCachedThreadScheduler-2
    RxCachedThreadScheduler-3
    RxCachedThreadScheduler-4

D.
    main

 */