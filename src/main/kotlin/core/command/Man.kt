package core.command

import cli.Terminal
import core.command.flag.Flag
import core.command.flag.HelpFlag

class Man : Command {

    private val _flags: Array<Flag> = arrayOf(HelpFlag("Insert command name after man to see instructions"))


    override fun getName(): String {
        return "man"
    }

    override fun getDoc(): String {
        return "Manual command"
    }


    override fun execute(caller: Any, args: Array<Any?>, flags: Array<String?>) {
        println("Man command")
        if (caller !is Terminal)
            return

        for (flagName in flags) {
            val flag = _flags.find { f -> f.getName() == flagName }
            flag?.modify()
        }
    }
}