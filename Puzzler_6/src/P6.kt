import io.reactivex.Maybe
import java.lang.Thread.sleep

// PUZZLER 6
fun main() {
    val name: String? = null

    Maybe
        .just(name)
        .subscribe {
            println(it)
        }

    sleep(1000)
}