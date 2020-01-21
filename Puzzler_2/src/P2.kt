import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.lang.Thread.sleep

// PUZZLER 2
fun main() {
    val subject = PublishSubject.create<String>()

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