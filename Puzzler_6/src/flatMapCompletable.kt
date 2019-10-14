import io.reactivex.Completable
import io.reactivex.subjects.BehaviorSubject

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

    Thread.sleep(1000)
    System.out.flush()
}