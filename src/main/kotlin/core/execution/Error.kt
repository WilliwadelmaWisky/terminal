package core.execution

import core.output.Output

/**
 *
 */
class Error(message: String) : Executable {

    private val _message = message


    override fun execute(caller: Any) {
        if (caller !is Output)
            return

        caller.println(_message)
    }
}