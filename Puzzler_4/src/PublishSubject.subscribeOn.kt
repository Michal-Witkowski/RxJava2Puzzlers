import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

// PUZZLER 4
fun main(args: Array<String>) {
    val subject = PublishSubject.create<Int>()

    println(Thread.currentThread().name)

    subject
        .subscribeOn(Schedulers.computation())
        .subscribe {
            println("onNext: ${Thread.currentThread().name}")
        }

    subject.onNext(0)
    subject.onNext(1)
    subject.onComplete()

    Thread.sleep(1000)
    System.out.flush()
}