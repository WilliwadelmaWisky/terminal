package core.interpreter

import core.command.ExitCommand
import core.execution.ExecutableCommand

/**
 *
 */
class CommandInterpreter : Interpreter {

    private val flagBlock = DataBlock('-', ' ')


    /**
     *
     */
    override fun process(s: String): Result {

        var prevChar = Char.MIN_VALUE

        val input = s.trim()
        var index = 0
        var startIndex = 0

        for (char in input) {

            if (!flagBlock.isActive && char == flagBlock._startChar && prevChar == ' ') {
                flagBlock.isActive = true
                flagBlock._index = index
            }

            if (prevChar == ' ' && char != ' ' && !flagBlock.isActive) {
                startIndex = index
            } else if (!flagBlock.isActive && (char == ' ' || index >= input.length - 1)) {
                val name = input.substring(startIndex, index + 1)
                println("Command/Arg: $name")
            }

            if (flagBlock.isActive && (char == flagBlock._escapeChar || index >= input.length - 1)) {
                flagBlock.isActive = false
                var endIndex = index
                if (index >= input.length - 1)
                    endIndex++

                val flagName = input.substring(flagBlock._index, endIndex)
                println("Flag: $flagName")
            }

            prevChar = char
            index++
        }

        val executable = ExecutableCommand(ExitCommand(), arrayOf(), arrayOf())
        return Result(executable)
    }

}