package core.interpreter

import core.execution.Executable

class Result(executable: Executable) {

    private val _executable: Executable = executable


    fun execute() {
        _executable.execute()
    }
}