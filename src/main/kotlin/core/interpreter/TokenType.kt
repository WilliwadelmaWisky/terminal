package core.interpreter

/**
 *
 */
enum class TokenType {
    Command,
    Flag,
    Text,
    Number,
    Split,
    Output,
    Whitespace,
    EndOfFile,
    BadToken
}