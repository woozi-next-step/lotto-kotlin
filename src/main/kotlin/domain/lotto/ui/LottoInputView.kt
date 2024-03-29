package domain.lotto.ui

import domain.lotto.error.InputDataNullPointerException
import global.strategy.ui.ConsoleInputStrategy
import global.strategy.ui.ConsoleOutputStrategy

class LottoInputView(
    private val consoleInputStrategy: ConsoleInputStrategy,
    private val consoleOutputStrategy: ConsoleOutputStrategy
) {

    fun purchaseLotto(): Int {
        consoleOutputStrategy.output(PURCHASE_MESSAGE)
        val money = consoleInputStrategy.input() ?: throw InputDataNullPointerException
        return money.toInt()
    }

    fun manuallyPurchaseLotto(): Int {
        consoleOutputStrategy.output(MANUALLY_PURCHASE_LOTTO_MESSAGE)
        val money = consoleInputStrategy.input() ?: throw InputDataNullPointerException
        return money.toInt()
    }

    fun manuallyLottos(ticketCount: Int): List<String> {
        consoleOutputStrategy.output(MANUALLY_INPUT_LOTTOS_MESSAGE)
        return (TICKET_COUNT_START..ticketCount).map {
            consoleInputStrategy.input() ?: throw InputDataNullPointerException
        }.toList()
    }

    fun winningLotto(): String {
        consoleOutputStrategy.output(WINNING_LOTTO_MESSAGE)
        return consoleInputStrategy.input() ?: throw InputDataNullPointerException
    }

    fun bonusBall(): Int {
        consoleOutputStrategy.output(BONUS_BALL_MESSAGE)
        val bonusBall = consoleInputStrategy.input() ?: throw InputDataNullPointerException
        return bonusBall.toInt()
    }

    companion object {
        private const val PURCHASE_MESSAGE = "구입금액을 입력해 주세요."
        private const val MANUALLY_PURCHASE_LOTTO_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
        private const val MANUALLY_INPUT_LOTTOS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요."
        private const val WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
        private const val BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요."

        private const val TICKET_COUNT_START = 1
    }
}
