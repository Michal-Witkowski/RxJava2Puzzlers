import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.lang.Thread.sleep

// PUZZLER 1
fun main(args: Array<String>) {
    val observables = (0..3).map {
        Observable
            .just(1)
            .subscribeOn(Schedulers.io())
    }

    println(Thread.currentThread().name)

    Observable
        .merge(observables)
        .subscribeOn(Schedulers.computation())
        .subscribe {
            println(Thread.currentThread().name)
        }

    sleep(1000)
}