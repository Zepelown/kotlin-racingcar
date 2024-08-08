package racingcar.model

import racingcar.util.RandomNumberGenerator

class CarRacingGameRoundResult(
    private val carNames : List<Car>
) {
    private val roundResult : HashMap<String, Int> = hashMapOf()

    init {
        carNames.forEach {
            roundResult.set(it.carName,RandomNumberGenerator.generate())
        }
    }
}