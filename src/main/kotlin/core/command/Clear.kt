package core.command

/**
 *
 */
class Clear : Command {

    /**
     *
     */
    override fun getName(): String {
        return "clear"
    }

    override fun getDoc(): String {
        return "Clear"
    }


    /**
     *
     */
    override fun execute(caller: Any, args: Array<Any?>, flags: Array<String?>) {
        println("Clear command")
    }
}