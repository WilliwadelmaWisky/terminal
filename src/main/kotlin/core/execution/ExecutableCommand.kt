package core.execution

import core.command.Command

/**
 *
 */
class ExecutableCommand(command: Command, flags: Array<String?>, args: Array<Any?>) : Executable {

    private val _command = command
    private val _flags: Array<String?> = flags
    private val _args: Array<Any?> = args


    /**
     *
     */
    override fun execute(caller: Any) {
        _command.execute(caller, _args, _flags)
    }

}