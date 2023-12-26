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
            val text = _text.substring(start + 1, _position - 1)
            return SyntaxToken(TokenType.Text, text, null)
        }

        if (getCurrent().isLetter()) {
            val start = _position
            _position++

            while (!getCurrent().isWhitespace() && !isEndOfFile())
                _position++

            val text = _text.substring(start, _position)
            return SyntaxToken(TokenType.Text, text, null)
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

        when (getCurrent()) {
            '|' -> {
                _position++
                return SyntaxToken(TokenType.Pipe, "|", null)
            }
            '<' -> {
                _position++
                return SyntaxToken(TokenType.Input, "<", null)
            }
            '>' -> {
                _position++
                return SyntaxToken(TokenType.Output, ">", null)
            }
            '&' -> {
                _position++
                return SyntaxToken(TokenType.And, "&", null)
            }
            else -> {
                while (!getCurrent().isWhitespace() && !isEndOfFile())
                    _position++
            }
        }

        return SyntaxToken(TokenType.BadToken, "", null)
    }
}