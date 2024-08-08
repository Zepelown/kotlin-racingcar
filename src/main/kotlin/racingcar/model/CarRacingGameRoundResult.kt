package racingcar.model

import racingcar.util.RandomNumberGenerator

class CarRacingGameRoundResult(
    private val carNames : List<Car>
) {
    private val roundResult : HashMap<String, Int> = hashMapOf()

    init {
        carNames.forEach {
            val randomNumber = RandomNumberGenerator.generate()
            if (randomNumber >= 4){
                it.move()
            }
            roundResult[it.carName] = it.getLocation()
        }
    }

    fun getResult() = roundResult.toMap()
}