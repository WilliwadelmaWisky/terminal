package cli

import core.command.CommandInfo
import core.interpreter.Interpreter
import core.output.Output
import core.process.Process
import core.util.getInput

/**
 *
 */
class Terminal(location: String, commands: Array<CommandInfo>) : Process, Output {

    private val _interpreter = Interpreter(commands)
    private var _isRunning: Boolean = true
    private var _path = Path(location)


    /**
     *
     */
    fun run() {
        while (_isRunning) {
            val input = getInput("${_path.getValue()} > ") ?: continue
            val command = _interpreter.process(input)
            command?.execute(_path, this)
        }
    }


    /**
     *
     */
    override fun terminate() {
        _isRunning = false
        println("Goodbye")
    }


    override fun println(message: String) {
        kotlin.io.println(message)
    }
}