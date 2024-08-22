package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarRacingGameFactory
import racingcar.view.ConsoleErrorView
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView

class CarRacingGameController {
    private val consoleInputView : ConsoleInputView = ConsoleInputView()
    private val consoleOutputView : ConsoleOutputView = ConsoleOutputView()
    private val consoleErrorView : ConsoleErrorView = ConsoleErrorView()
    private val carRacingGameFactory: CarRacingGameFactory = CarRacingGameFactory()

    fun startGame(){
        val cars = createCarsFromInput()

        consoleOutputView.printCarRacingRoundCountMessage()
        val gameMaxRound = carRacingGameFactory.createGameMaxRound(consoleInputView.getCarRacingRoundCount())
        val carRacingGame = carRacingGameFactory.createCarRacingGame(cars, gameMaxRound)

        val gameResults = carRacingGame.calculateRoundResult()
        consoleOutputView.printCarRacingGameResult(gameResults)
        consoleOutputView.printCarRacingGameWinners(carRacingGame.getWinners() ?: emptyList())
    }

    private fun createCarsFromInput() : List<Car>{
        var cars : List<Car> = mutableListOf()
        try {
            consoleOutputView.printCarNameInputMessage()
            val carNames = consoleInputView.getCarNames()
            cars = carRacingGameFactory.createCars(carNames)

        } catch (e : IllegalArgumentException){
            consoleErrorView.printCarNamesInputErrorMsg()
            createCarsFromInput()
        }
        return cars
    }

}