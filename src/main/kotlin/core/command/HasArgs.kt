package core.command

/**
 *
 */
interface HasArgs {
    fun getName(): String
    fun append(arg: String)
}