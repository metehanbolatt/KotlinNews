public inline fun <T> retry(
    n: Int,
    condition: (T) -> Boolean,
    generate: () -> T
): T {
    check(n > 0) { "Hey! We have to try at least once." }
    repeat(n - 1) {
        generate().takeIf(condition)?.let { return it }
    }
    return generate()
}