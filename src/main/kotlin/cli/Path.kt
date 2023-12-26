package cli

/**
 *
 */
class Path(defaultValue: String) {
    private var _value = defaultValue


    fun getValue(): String { return _value }
    fun setValue(value: String) { _value = value }
}