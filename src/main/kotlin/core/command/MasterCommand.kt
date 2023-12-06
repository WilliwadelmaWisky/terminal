package core.command

/**
 *
 */
interface MasterCommand : Command {
    fun getCommands(): Array<Command>
}