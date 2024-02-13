package core.command

import cli.Path
import cli.Terminal

/**
 *
 */
class Command(commandInfo: CommandInfo) : HasArgs {

    private val _name = commandInfo.getName()
    private val _onExecute = commandInfo::onExecute
    private var _subcommand: Command? = null
    private val _flagList = arrayListOf<Flag>()
    private val _argList = arrayListOf<String>()



    /**
     *
     */
    override fun getName(): String { return _name }


    override fun append(arg: String) {
        _argList.add(arg)
    }

    fun setSubcommand(command: Command) {
        _subcommand = command
    }

    fun addFlag(flag: Flag) {
        _flagList.add(flag)
    }


    private fun getMessage(): String {
        var flagString = ""
        for (flag in _flagList) {
            flagString += "${flag.getName()} "
        }

        return if (_subcommand == null)
            "$_name $flagString"
        else
            "$_name $flagString ${_subcommand!!.getMessage()}"
    }


    /**
     *
     */
    fun execute(path: Path, terminal: Terminal) {
        _onExecute(path, terminal, _flagList, _argList)
    }
}