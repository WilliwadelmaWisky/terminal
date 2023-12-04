package core.interpreter

/**
 *
 */
class DataBlockStack {

    private val _stack = ArrayDeque<DataBlock>()


    fun newBlock(block: DataBlock) {
        _stack.add(block)
    }
}