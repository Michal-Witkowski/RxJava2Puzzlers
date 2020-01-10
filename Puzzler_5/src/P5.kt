import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

// PUZZLER 5
fun main(args: Array<String>) {
    val subject = BehaviorSubject.create<Long>()

    Observable
        .interval(100, TimeUnit.MILLISECONDS)  // Emits 0, 1, 2, 3, etc... each after given delay
        .take(3)
        .subscribe(subject)

    sleep(1000)

    subject
            .subscribe {
                println(it)
            }

    sleep(1000)
}