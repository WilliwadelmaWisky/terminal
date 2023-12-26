package entry

import cli.Terminal
import core.command.CdCommandInfo
import core.command.CommandInfo
import core.command.ExitCommandInfo

/**
 *
 */
fun main(args: Array<String>) {
    println("Main")

    val cdCommand = CdCommandInfo()
    val exitCommand = ExitCommandInfo()

    val gitCommand = CommandInfo("git", arrayOf(
        CommandInfo("add", arrayOf(), arrayOf()),
        CommandInfo("commit", arrayOf(), arrayOf()),
        CommandInfo("push", arrayOf(
            CommandInfo("origin", arrayOf(), arrayOf())
        ), arrayOf())
    ), arrayOf())

    val commands = arrayOf(cdCommand, gitCommand, exitCommand)

    val terminal = Terminal("USER_HOME", commands)
    terminal.run()
}