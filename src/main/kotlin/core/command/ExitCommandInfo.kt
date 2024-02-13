package core.command

import cli.Path
import cli.Terminal

/**
 *
 */
class ExitCommandInfo : CommandInfo("exit", arrayOf(), arrayOf()) {

    /**
     *
     */
    override fun onExecute(path: Path, terminal: Terminal, flags: ArrayList<Flag>, args: ArrayList<String>) {
        terminal.terminate()
    }
}