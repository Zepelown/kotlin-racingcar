package racingcar.model

class CarRacingGameMaxRound(
    private val carGameRoundCountInput: String?
) {
    val carGameMaxRound: Int

    init {
        require(validateMaxRound())
        carGameMaxRound = carGameRoundCountInput?.toIntOrNull() ?: 0
    }

    private fun validateMaxRound(): Boolean {
        val roundCount = carGameRoundCountInput?.toIntOrNull()
        return roundCount != null && roundCount > 0
    }
}