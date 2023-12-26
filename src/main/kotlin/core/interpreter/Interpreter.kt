package core.interpreter

import core.command.Command
import core.command.CommandInfo

/**
 *
 */
class Interpreter(commands: Array<CommandInfo>) {

    private val _commands = commands

    /**
     *
     */
    fun process(s: String): Command? {
        val parser = Parser(s, _commands)
        return parser.parse()
    }

}