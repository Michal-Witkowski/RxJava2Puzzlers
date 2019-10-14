import io.reactivex.Maybe

// PUZZLER 8
fun main(args: Array<String>) {
    val name: String? = null

    Maybe
        .fromCallable { name }
        .subscribe {
            println(it)
        }

    Thread.sleep(1000)
    System.out.flush()
}