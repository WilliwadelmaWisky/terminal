package core.command

import core.process.Process

/**
 *
 */
class Exit : Command {

    override fun getName(): String {
        return "exit"
    }

    override fun getDoc(): String {
        return "Exit"
    }

    override fun execute(caller: Any, args: Array<Any?>, flags: Array<String?>) {
        println("Exit command")

        if (args.isEmpty()) {
            if (caller !is Process)
                return
            caller.terminate()
        } else {
            println("Terminate external process")
        }
    }

}