package racingcar.controller

import racingcar.model.CarRacingGame
import racingcar.view.ConsoleOutputView

class CarRacingGameController {
    private val consoleOutputView : ConsoleOutputView = ConsoleOutputView()
    private var carRacingGame : CarRacingGame? = null

    fun startGame(){
        consoleOutputView.printCarNameInputMessage()
        carRacingGame = CarRacingGame()
    }
}