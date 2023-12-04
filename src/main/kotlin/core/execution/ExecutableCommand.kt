package core.execution

import core.command.Command
import core.command.arg.Arg
import core.command.flag.Flag

/**
 *
 */
class ExecutableCommand(command: Command, flags: Array<Flag>, args: Array<Arg>) : Executable {

    private val _command = command
    private val _flags = flags
    private val _args = args


    /**
     *
     */
    override fun execute() {
        _command.execute()
    }

}