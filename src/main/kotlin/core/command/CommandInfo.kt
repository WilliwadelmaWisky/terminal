package core.command

import cli.Path
import cli.Terminal

/**
 *
 */
open class CommandInfo(name: String, subcommands: Array<CommandInfo>, flags: Array<FlagInfo>) {
    private val _name = name
    private val _subcommands = subcommands
    private val _flags = flags


    fun getName(): String { return _name }
    fun findSubcommand(name: String): CommandInfo? {
        return _subcommands.find { subcommand -> subcommand.getName() == name }
    }
    fun isValidFlag(flag: Flag): Boolean {
        return _flags.find { flagInfo -> flagInfo.getName() == flag.getName() } != null
    }


    /**
     *
     */
    open fun onExecute(path: Path, terminal: Terminal, flags: ArrayList<Flag>, args: ArrayList<String>) {
        terminal.println("Default command execution")
    }
}