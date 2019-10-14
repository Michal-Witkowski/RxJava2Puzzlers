val threadName: String
get() {
    val name = Thread.currentThread().name
    return when {
        name.contains("RxCachedThreadScheduler") -> name.replace("RxCachedThreadScheduler", "IO")
        name.contains("RxComputationThreadPool") -> name.replace("RxComputationThreadPool", "Computation")
        else -> name
    }
}