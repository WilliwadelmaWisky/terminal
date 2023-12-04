package core.command.flag

/**
 *
 */
class HelpFlag(help: String) : Flag {

    private val _help = help


    override fun getName(): String {
        return "-h"
    }


    override fun modify() {
        println(_help)
    }
}