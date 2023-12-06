package core.command

import core.command.flag.Flag
import core.command.flag.HelpFlag
import core.output.Output

/**
 *
 */
class Ls : Command {

    private val helpFlag = HelpFlag(getDoc())
    private val aFlag = AFlag()


    override fun getName(): String {
        return "ls"
    }

    override fun getDoc(): String {
        return "LS"
    }

    override fun execute(caller: Any, args: Array<Any?>, flags: Array<String?>) {
        if (caller !is Output)
            return

        if (flags.isNotEmpty() && flags.contains(helpFlag.getName())) {
            helpFlag.modify()
            return
        }

        caller.println("Display contents")
    }


    class AFlag : Flag {
        override fun getName(): String {
            return "-a"
        }

        override fun modify() {

        }

    }
}