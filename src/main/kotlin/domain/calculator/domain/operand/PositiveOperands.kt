package domain.calculator.domain.operand

@JvmInline
value class PositiveOperands private constructor(private val operands: List<PositiveOperand>) {
    init {
        if (operands.isEmpty()) throw RuntimeException(EMPTY_EXCEPTION_MESSAGE)
    }

    fun sum(): Int = operands.sumOf { positiveOperand: PositiveOperand -> positiveOperand.operand }

    companion object {
        private const val EMPTY_EXCEPTION_MESSAGE = "PositiveOperands, 비어있는 컬렉션은 입력될 수 없습니다."

        fun of(operands: List<PositiveOperand>): PositiveOperands = PositiveOperands(operands.toList())
    }
}
