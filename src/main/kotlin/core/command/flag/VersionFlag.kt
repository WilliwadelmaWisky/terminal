package core.command.flag

/**
 *
 */
class VersionFlag : Flag {

    override fun getName(): String {
        return "-v"
    }


    override fun modify() {
        println("version flag found")
    }
}