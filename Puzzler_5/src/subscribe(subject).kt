import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit

// PUZZLER 5
fun main(args: Array<String>) {
    val subject = BehaviorSubject.create<Long>()

    Observable
        .interval(100, TimeUnit.MILLISECONDS)
        .take(3)
        .subscribe(subject)

    Thread.sleep(1000)

    subject
            .subscribe {
                println(it)
            }

    Thread.sleep(1000)
    System.out.flush()
}