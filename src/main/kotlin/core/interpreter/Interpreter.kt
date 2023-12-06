package core.interpreter

import core.command.Command
import core.execution.Executable

/**
 *
 */
class Interpreter(commands: Array<Command>) {

    private val _commands = commands

    /**
     *
     */
    fun process(s: String): Executable? {
        val parser = Parser(s)
        return parser.parse(_commands)
    }

}