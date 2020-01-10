import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.lang.Thread.sleep

// PUZZLER 10
fun main(args: Array<String>) {
    Observable
        .merge(
            Observable.fromCallable {
                sleep(1000)
                0
            },
            Observable.fromCallable {
                sleep(1000)
                1
            }
        )
        .subscribeOn(Schedulers.io())
        .subscribe {
            println(it)
        }

    sleep(1500)
}