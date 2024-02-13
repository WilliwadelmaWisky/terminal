package core.interpreter

import core.command.Command
import core.command.CommandInfo
import core.command.Flag
import core.command.HasArgs

/**
 *
 */
class Parser(text: String, commands: Array<CommandInfo>) {

    private val _tokenList = arrayListOf<SyntaxToken>()
    private val _commands = commands


    /**
     *
     */
    init {
        println("---- LEX ----")
        val lexer = Lexer(text)
        while (true) {
            val token = lexer.next()
            if (token.getType() == TokenType.EndOfFile)
                break

            if (token.getType() == TokenType.BadToken || token.getType() == TokenType.Whitespace)
                continue

            println("[DEBUG] Found token (${token.getType()}): ${token.getText()}")
            _tokenList.add(token)
        }
    }


    /**
     *
     */
    fun parse(): Command? {

        var position = 0
        val token = get(position)
        if (token.getType() != TokenType.Text)
            return null

        println("---- PARSE ----")
        var currentCommandInfo = _commands.find { c -> c.getName() == token.getText() } ?: return null
        val command = Command(currentCommandInfo)
        var currentCommand = command
        var current: HasArgs = command
        position++

        while (true) {
            if (position >= _tokenList.count())
                break;

            when (get(position).getType()) {
                TokenType.Text -> {
                    val subcommandInfo = currentCommandInfo.findSubcommand(get(position).getText())
                    if (subcommandInfo != null) {
                        val subcommand = Command(subcommandInfo)
                        currentCommand.setSubcommand(subcommand)
                        currentCommandInfo = subcommandInfo
                        currentCommand = subcommand
                        current = subcommand
                    } else {
                        current.append(get(position).getText())
                    }
                }

                TokenType.Flag -> {
                    val flag = Flag(get(position).getText())
                    if (currentCommandInfo.isValidFlag(flag)) {
                        currentCommand.addFlag(flag)
                        current = flag
                    }
                }

                TokenType.Number -> {
                    current.append(get(position).getText())
                }

                TokenType.And -> {
                    println("And character encountered")
                }

                TokenType.Pipe -> {
                    println("Pipe character encountered")
                }

                else -> {
                    println("Ignored token!")
                }
            }

            position++
        }

        return command
    }


    private fun get(index: Int): SyntaxToken {
        return _tokenList[index]
    }
}