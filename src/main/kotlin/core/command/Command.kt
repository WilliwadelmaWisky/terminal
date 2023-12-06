package core.command

/**
 *
 */
interface Command {
    fun getName(): String
    fun getDoc(): String
    fun execute(caller: Any, args: Array<Any?>, flags: Array<String?>)
}