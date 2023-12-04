package core.command

/**
 *
 */
interface Command {
    fun getName(): String
    fun execute()
}