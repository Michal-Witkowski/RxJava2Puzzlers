import io.reactivex.Completable
import io.reactivex.Maybe

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

    Thread.sleep(1000)
    System.out.flush()
}