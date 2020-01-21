import io.reactivex.Completable
import io.reactivex.Maybe
import java.lang.Thread.sleep

// PUZZLER 9
fun main() {
    var processed = false

    Completable
            .fromCallable {
                processed = true
            }
            .subscribe {
                println("completed")
            }

    sleep(1000)
}