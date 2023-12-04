package cli

import core.interpreter.CommandInterpreter
import core.interpreter.Interpreter
import core.util.getInput

class Terminal(location: String) {

    private val _interpreter: Interpreter = CommandInterpreter()
    private var _isRunning: Boolean = true
    private var _location: String = location


    /**
     *
     */
    fun run() {
        while (_isRunning) {
            val input = getInput("$_location ") ?: continue
            val result = _interpreter.process(input)
            result.execute()


            if (input == "exit")
                exit()
        }
    }


    /**
     *
     */
    fun exit() {
        _isRunning = false
        println("Goodbye")
    }
}