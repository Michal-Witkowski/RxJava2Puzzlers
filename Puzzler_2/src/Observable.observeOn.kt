import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

// PUZZLER 2
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