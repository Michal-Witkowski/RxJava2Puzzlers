import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

// PUZZLER 7
fun main(args: Array<String>) {
    Observable
        .just(1, 2)
        .startWith { 0 }
        .subscribe {
            println(it)
        }

    Thread.sleep(1000)
    System.out.flush()
}