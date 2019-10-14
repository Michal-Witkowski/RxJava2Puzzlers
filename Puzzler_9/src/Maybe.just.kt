import io.reactivex.Maybe

// PUZZLER 9
fun main(args: Array<String>) {
    val name: String? = null

    Maybe
        .just(name)
        .subscribe {
            println(it)
        }

    Thread.sleep(1000)
    System.out.flush()
}