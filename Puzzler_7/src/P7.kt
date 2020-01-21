import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.lang.Thread.sleep

// PUZZLER 7
fun main() {
    Observable
        .just(1, 2)
        .startWith { 0 }
        .subscribe {
            println(it)
        }

    sleep(1000)
}