package racingcar.model

class CarRacingGame(
    private val carNames : List<String>?
) {
    private val _cars : MutableList<Car> = mutableListOf()
    private val cars : List<Car> get() = cars


    init {
        initSetting()
    }

    private fun initSetting(){
        carNames?.forEach {
            val car = Car(it)
            _cars.add(car)
        }
    }
}