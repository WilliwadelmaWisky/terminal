package core.interpreter

import core.command.Command
import core.command.MasterCommand
import core.execution.Executable
import core.execution.ExecutableCommand
import core.execution.Error

/**
 *
 */
class Parser(text: String) {

    private val _list: ArrayList<SyntaxToken> = arrayListOf()


    /**
     *
     */
    init {
        val lexer = Lexer(text)
        while (true) {
            val token = lexer.next()
            if (token.getType() == TokenType.EndOfFile)
                break

            if (token.getType() == TokenType.BadToken || token.getType() == TokenType.Whitespace)
                continue

            println("[DEBUG] Found token (${token.getType()}): ${token.getText()}")
            _list.add(token)
        }
    }


    fun parse(commands: Array<Command>): Executable? {

        println("---- PARSE ----")
        val commandStack = ArrayDeque<Command>()
        val flagList: ArrayList<String> = arrayListOf()
        val argList: ArrayList<Any> = arrayListOf()
        var position = 0

        var currentCommand: Command = findCommand(get(position).getText(), commands) ?: return null
        position++

        while (true) {
            if (position >= _list.count())
                break;

            when (get(position).getType()) {
                TokenType.Text -> {
                    if (currentCommand is MasterCommand) {
                        if (flagList.isNotEmpty() || argList.isNotEmpty()) {
                            return Error("Syntax error")
                        }

                        currentCommand = findCommand(get(position).getText(), currentCommand.getCommands()) ?: break
                    } else {
                        argList.add(get(position).getText())
                    }
                }

                TokenType.Flag -> {
                    flagList.add(get(position).getText())
                }

                TokenType.Number -> {
                    argList.add(get(position).getText())
                }

                TokenType.Pipe -> {
                    println("Pipe character encountered")
                }

                else -> break
            }

            position++
        }

        val flags = arrayOfNulls<String>(flagList.size)
        flagList.toArray(flags)
        val args = arrayOfNulls<Any>(argList.size)
        argList.toArray(args)

        return ExecutableCommand(currentCommand, flags, args)
    }


    private fun findCommand(name: String, commands: Array<Command>): Command? {
        return commands.find { c -> c.getName() == name }
    }

    private fun get(index: Int): SyntaxToken {
        return _list[index]
    }
}