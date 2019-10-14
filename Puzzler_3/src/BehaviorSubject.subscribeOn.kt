import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import java.lang.Thread.sleep

// PUZZLER 3
fun main(args: Array<String>) {
    val subject = BehaviorSubject.create<Int>()

    println(Thread.currentThread().name)

    subject
        .subscribeOn(Schedulers.computation())
        .subscribe {
            println("onNext: ${Thread.currentThread().name}")
        }

    subject.onNext(0)
    subject.onComplete()

    sleep(1000)
}