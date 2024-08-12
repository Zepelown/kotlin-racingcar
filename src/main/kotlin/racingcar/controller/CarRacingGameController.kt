package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarRacingGame
import racingcar.service.CarRacingGameManager
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView

class CarRacingGameController {
    private val consoleInputView : ConsoleInputView = ConsoleInputView()
    private val consoleOutputView : ConsoleOutputView = ConsoleOutputView()
    private val carRacingGameManager : CarRacingGameManager = CarRacingGameManager()

    fun startGame(){
        consoleOutputView.printCarNameInputMessage()
        val carNames = consoleInputView.getCarNames()
        val cars = carRacingGameManager.createCars(carNames)

        consoleOutputView.printCarRacingRoundCountMessage()
        val gameRoundCount = consoleInputView.getCarRacingRoundCount()
        val carRacingGame = CarRacingGame(cars, gameRoundCount)

        val gameResults = carRacingGame.calculateRoundResult()
        consoleOutputView.printCarRacingGameResult(gameResults)
        consoleOutputView.printCarRacingGameWinners(carRacingGame.getWinners() ?: emptyList())
    }

}