import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import java.lang.Thread.sleep

// PUZZLER 3
fun main(args: Array<String>) {
    val subject = BehaviorSubject.create<String>()

    println("Main: $threadName")

    subject
        .subscribeOn(Schedulers.computation())
        .subscribe { value ->
            println("$value: $threadName")
        }

    subject.onNext("First")
    subject.onComplete()

    sleep(1000)
}