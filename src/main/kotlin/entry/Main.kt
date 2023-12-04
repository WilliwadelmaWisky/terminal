package entry

import cli.Terminal

/**
 *
 */
fun main(args: Array<String>) {
    println("Main")

    val terminal = Terminal("USER_HOME")
    terminal.run()
}