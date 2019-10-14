import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

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

    Thread.sleep(1000)
    System.out.flush()
}