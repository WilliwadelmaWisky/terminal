package core.interpreter

/**
 *
 */
enum class TokenType {
    Text,
    Number,
    Flag,
    Pipe,
    And,
    Input,
    Output,
    Whitespace,
    EndOfFile,
    BadToken
}