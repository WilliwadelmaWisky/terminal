package core.interpreter

/**
 *
 */
interface Interpreter {
    fun process(s: String): Result
}