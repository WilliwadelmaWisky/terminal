package cli

import core.command.*
import core.interpreter.Interpreter
import core.output.Output
import core.process.Process
import core.util.getInput

/**
 *
 */
class Terminal(location: String) : Process, Output {

    private val _interpreter = Interpreter(arrayOf(Clear(), Exit(), Man(), Cd(), Ls()))
    private var _isRunning: Boolean = true
    private var _location: String = location


    /**
     *
     */
    fun run() {
        while (_isRunning) {
            val input = getInput("$_location > ") ?: continue
            val executable = _interpreter.process(input)
            executable?.execute(this)
        }
    }


    /**
     *
     */
    override fun terminate() {
        _isRunning = false
        println("Goodbye")
    }


    fun getLocation(): String { return _location }
    fun setLocation(loc: String) { _location = loc }


    override fun println(message: String) {
        kotlin.io.println(message)
    }
}