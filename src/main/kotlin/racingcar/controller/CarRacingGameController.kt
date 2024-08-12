package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarRacingGame
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView

class CarRacingGameController {
    private val consoleInputView : ConsoleInputView = ConsoleInputView()
    private val consoleOutputView : ConsoleOutputView = ConsoleOutputView()

    fun startGame(){
        consoleOutputView.printCarNameInputMessage()
        val carNames = consoleInputView.getCarNames()
        val cars = createCars(carNames)

        consoleOutputView.printCarRacingRoundCountMessage()
        val gameRoundCount = consoleInputView.getCarRacingRoundCount()
        val carRacingGame = CarRacingGame(cars, gameRoundCount)

        val gameResults = carRacingGame.calculateRoundResult()
        consoleOutputView.printCarRacingGameResult(gameResults)
        consoleOutputView.printCarRacingGameWinners(carRacingGame.getWinners() ?: emptyList())
    }

    private fun createCars(carNames : List<String>) : List<Car>{
        val cars : MutableList<Car> = mutableListOf()
        carNames.forEach {carName ->
            val car = Car(carName)
            cars.add(car)
        }
        return cars
    }
}