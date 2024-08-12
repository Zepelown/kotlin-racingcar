package racingcar.service

import racingcar.model.Car

class CarRacingGameManager {
    fun createCars(carNames : List<String>) : List<Car>{
        val cars : MutableList<Car> = mutableListOf()
        carNames.forEach {carName ->
            val car = Car(carName)
            cars.add(car)
        }
        return cars
    }

}