package racingcar.controller

import racingcar.model.CarRacingGameFactory
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView

class CarRacingGameController {
    private val consoleInputView : ConsoleInputView = ConsoleInputView()
    private val consoleOutputView : ConsoleOutputView = ConsoleOutputView()
    private val carRacingGameFactory : CarRacingGameFactory = CarRacingGameFactory()

    fun startGame(){
        consoleOutputView.printCarNameInputMessage()
        val carNames = consoleInputView.getCarNames()
        val cars = carRacingGameFactory.createCars(carNames)

        consoleOutputView.printCarRacingRoundCountMessage()
        val gameMaxRound = carRacingGameFactory.createGameMaxRound(consoleInputView.getCarRacingRoundCount())
        val carRacingGame = carRacingGameFactory.createCarRacingGame(cars, gameMaxRound)

        val gameResults = carRacingGame.calculateRoundResult()
        consoleOutputView.printCarRacingGameResult(gameResults)
        consoleOutputView.printCarRacingGameWinners(carRacingGame.getWinners() ?: emptyList())
    }

}