package core.interpreter

/**
 *
 */
class SyntaxToken(type: TokenType, text: String, value: Any?) {

    private val _type = type
    private val _text = text
    private val _value = value


    fun getType(): TokenType { return _type }
    fun getText(): String { return _text }
}