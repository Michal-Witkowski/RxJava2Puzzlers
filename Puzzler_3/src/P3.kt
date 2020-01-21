import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.lang.Thread.sleep

// PUZZLER 3
fun main() {
    val observables = (0..3).map {
        Observable
            .just(1)
            .subscribeOn(Schedulers.io())
    }

    println("Main: $threadName")

    Observable
        .merge(observables)
        .subscribeOn(Schedulers.computation())
        .subscribe {
            println("Item: $threadName")
        }

    sleep(1000)
}