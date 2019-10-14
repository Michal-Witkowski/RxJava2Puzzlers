import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.lang.Thread.sleep

// PUZZLER 2
fun main(args: Array<String>) {
    val observables = (0..3).map {
        Observable
            .just(1)
            .subscribeOn(Schedulers.io())
    }

    println(threadName)

    Observable
        .merge(observables)
        .observeOn(Schedulers.computation())
        .subscribe {
            println(threadName)
        }

    sleep(1000)
}