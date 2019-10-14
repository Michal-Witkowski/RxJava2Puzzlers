import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.lang.Thread.sleep

// PUZZLER 4
fun main(args: Array<String>) {
    val subject = PublishSubject.create<String>()

    println(threadName)

    subject
        .subscribeOn(Schedulers.computation())
        .subscribe { value ->
            println("$value: $threadName")
        }

    subject.onNext("First")
    subject.onNext("Second")
    subject.onComplete()

    sleep(1000)
}