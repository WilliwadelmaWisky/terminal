package core.command

import cli.Terminal
import core.command.flag.HelpFlag

/**
 *
 */
class Cd : Command {

    private val helpFlag = HelpFlag(getDoc())


    override fun getName(): String {
        return "cd"
    }

    override fun getDoc(): String {
        return "Change directory:\nDescription\nExamples:\ncd c:/users -> changes the current directory to c:/users"
    }

    override fun execute(caller: Any, args: Array<Any?>, flags: Array<String?>) {
        if (caller !is Terminal)
            return

        if (flags.isNotEmpty() && flags.contains(helpFlag.getName())) {
            helpFlag.modify()
            return
        }

        if (args.isNotEmpty() && args[0] != null) {
            val loc = args[0] as String
            if (loc.isNotEmpty()) {
                caller.setLocation(loc)
                println("Cd: location changed to -> $loc")
            }
        } else {
            println("Cd: print location -> ${caller.getLocation()}")
        }
    }
}