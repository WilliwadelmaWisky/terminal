package core.interpreter

/**
 *
 */
class DataBlock(startChar: Char, escapeChar: Char) {

    val _startChar = startChar
    val _escapeChar = escapeChar

    var _index = 0
    var isActive = false
}