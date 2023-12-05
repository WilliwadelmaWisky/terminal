package core.interpreter

/**
 *
 */
class Parser(text: String) {

    private val _list: ArrayList<SyntaxToken> = arrayListOf()


    /**
     *
     */
    init {
        val lexer = Lexer(text)
        while (true) {
            val token = lexer.next()
            if (token.getType() == TokenType.EndOfFile)
                break

            if (token.getType() == TokenType.BadToken || token.getType() == TokenType.Whitespace)
                continue

            println("[DEBUG] Found token (${token.getType()}): ${token.getText()}")
            _list.add(token)
        }

        println(_list.count())
    }


    fun parse() {

    }
}