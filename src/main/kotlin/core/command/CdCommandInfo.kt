package core.command

import cli.Path
import cli.Terminal

/**
 *
 */
class CdCommandInfo : CommandInfo("cd", arrayOf(), arrayOf()) {

    /**
     *
     */
    override fun onExecute(path: Path, terminal: Terminal, flags: ArrayList<Flag>, args: ArrayList<String>) {
        if (args.isEmpty()) {
            path.setValue("USER_HOME")
            return
        }

        path.setValue(args[0])
    }
}