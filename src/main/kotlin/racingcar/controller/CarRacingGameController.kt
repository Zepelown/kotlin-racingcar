package racingcar.controller

import racingcar.model.CarRacingGame
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView

class CarRacingGameController {
    private val consoleInputView : ConsoleInputView = ConsoleInputView()
    private val consoleOutputView : ConsoleOutputView = ConsoleOutputView()
    private var carRacingGame : CarRacingGame? = null

    fun startGame(){
        consoleOutputView.printCarNameInputMessage()
        val carNames = consoleInputView.getCarNames()
        consoleOutputView.printCarRacingRoundCountMessage()

        val gameRoundCount = consoleInputView.getCarRacingRoundCount()
        carRacingGame = CarRacingGame(carNames, gameRoundCount)

        val gameResults = carRacingGame!!.calculateRoundResult()
        consoleOutputView.printCarRacingGameResult(gameResults)
        consoleOutputView.printCarRacingGameWinners(carRacingGame!!.getWinners()!!)
    }
}