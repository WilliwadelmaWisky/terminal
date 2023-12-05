package core.interpreter

/**
 *
 */
class Lexer(text: String) {

    private val _text = text
    private var _position = 0


    /**
     * @return
     */
    private fun isEndOfFile(): Boolean {
        return _position >= _text.length
    }

    /**
     * @return
     */
    private fun getCurrent(): Char {
        if (isEndOfFile())
            return Char.MIN_VALUE
        return _text[_position]
    }


    /**
     * @return
     */
    fun next(): SyntaxToken {

        if (isEndOfFile())
            return SyntaxToken(TokenType.EndOfFile, "", null)

        if (getCurrent() == '-') {
            val start = _position
            _position++

            while ((getCurrent().isLetterOrDigit() || getCurrent() == '-') && !isEndOfFile())
                _position++

            val text = _text.substring(start, _position)
            return SyntaxToken(TokenType.Flag, text, null)
        }

        if (getCurrent() == '\"') {
            val start = _position
            _position++

            while (getCurrent() != '\"') {
                _position++

                if (isEndOfFile())
                    return SyntaxToken(TokenType.BadToken, "", null)
            }

            _position++
            val text = _text.substring(start, _position)
            return SyntaxToken(TokenType.Text, text, null)
        }

        if (getCurrent().isLetter()) {
            val start = _position
            _position++

            while (!getCurrent().isWhitespace() && !isEndOfFile())
                _position++

            val text = _text.substring(start, _position)
            return SyntaxToken(TokenType.Command, text, null)
        }

        if (getCurrent().isDigit()) {
            val start = _position
            _position++

            while (getCurrent().isDigit() && !isEndOfFile())
                _position++

            val text = _text.substring(start, _position)
            return SyntaxToken(TokenType.Number, text, null)
        }

        if (getCurrent().isWhitespace()) {
            while (getCurrent().isWhitespace() && !isEndOfFile())
                _position++

            return SyntaxToken(TokenType.Whitespace, " ", null)
        }

        return SyntaxToken(TokenType.BadToken, "", null)
    }
}