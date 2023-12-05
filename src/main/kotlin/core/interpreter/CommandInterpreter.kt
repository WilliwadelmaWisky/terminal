package core.interpreter

import core.command.ExitCommand
import core.execution.ExecutableCommand

/**
 *
 */
class CommandInterpreter : Interpreter {



    /**
     *
     */
    override fun process(s: String): Result {

        val parser = Parser(s)
        parser.parse()


        val executable = ExecutableCommand(ExitCommand(), arrayOf(), arrayOf())
        return Result(executable)
    }

}