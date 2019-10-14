import io.reactivex.Completable
import io.reactivex.Maybe
import java.lang.Thread.sleep

// PUZZLER 10
fun main(args: Array<String>) {
    var first = 1
    var second = 2

    Completable
            .fromCallable {
                first = second
            }
            .subscribe {
                println("completed")
            }

    sleep(1000)
}