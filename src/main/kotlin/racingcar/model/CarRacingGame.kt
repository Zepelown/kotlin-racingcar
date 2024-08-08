package racingcar.model

class CarRacingGame(
    private val carNames : List<String>?,
    private val gameRound : String?
) {
    private val cars : MutableList<Car> = mutableListOf()

    private val maxGameRound : CarRacingGameMaxRound = CarRacingGameMaxRound(gameRound)
    private val carRacingGameResults : MutableList<CarRacingGameRoundResult> = mutableListOf()

    init {
        initSetting()
    }

    fun calculateRoundResult() : List<CarRacingGameRoundResult>{
        for (i in 1 .. maxGameRound.carGameMaxRound){
            val roundResult = CarRacingGameRoundResult(i, cars)
            carRacingGameResults.add(roundResult)
        }
        return carRacingGameResults
    }

    fun getWinners() : List<String>?{
        carRacingGameResults.forEach {
            if (it.round == maxGameRound.carGameMaxRound){
                return it.getWinners()
            }
        }
        return null
    }

    private fun initSetting(){
        carNames?.forEach {
            val car = Car(it)
            cars.add(car)
        }
    }
}