package core.command

/**
 *
 */
class Flag(name: String) : HasArgs {

    private val _name = name

    override fun getName(): String { return _name }


    override fun append(arg: String) {

    }

}