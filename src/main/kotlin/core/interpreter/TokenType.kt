package core.interpreter

/**
 *
 */
enum class TokenType {
    Text,
    Number,
    Flag,
    Pipe,
    Input,
    Output,
    Whitespace,
    EndOfFile,
    BadToken
}