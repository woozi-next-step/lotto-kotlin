package domain.lotto.domain

import domain.lotto.error.InvalidMoneyRangeException

@JvmInline
value class Money(private val money: Int = DEFAULT_MONEY) {
    init {
        if (money < DEFAULT_MONEY) {
            throw InvalidMoneyRangeException(money)
        }
    }

    fun numberOfPurchases(productPrice: Int): Int = Math.floorDiv(money, productPrice)

    fun yield(other: Money): Double {
        val otherMoney = other.money
        val otherMoneyDouble = otherMoney.toDouble()
        return otherMoneyDouble.div(money.toDouble())
    }

    companion object {
        private const val DEFAULT_MONEY = 0
    }
}
