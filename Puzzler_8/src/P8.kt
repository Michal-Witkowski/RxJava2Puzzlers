import io.reactivex.Maybe
import java.lang.Thread.sleep

// PUZZLER 8
fun main(args: Array<String>) {
    val name: String? = null

    Maybe
        .just(name)
        .subscribe {
            println(it)
        }

    sleep(1000)
}