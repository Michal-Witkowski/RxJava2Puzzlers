import io.reactivex.Maybe

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

/*
What we'll see on output?

A.
    nothing

B.
    kotlin.Nothing

C.
    io.reactivex.exceptions.OnErrorNotImplementedException

D.
    null

 */