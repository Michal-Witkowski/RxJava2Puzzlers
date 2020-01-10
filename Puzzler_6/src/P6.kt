import io.reactivex.Completable
import io.reactivex.subjects.BehaviorSubject
import java.lang.Thread.sleep

// PUZZLER 6
fun main(args: Array<String>) {
    val completable: Completable = BehaviorSubject
        .createDefault(0)
        .doOnNext {
            println(it)
        }
        .flatMapCompletable {
            Completable.fromCallable {
                println("fromCallable")
            }
        }

    completable.subscribe {
        println("completed")
    }

    sleep(1000)
}