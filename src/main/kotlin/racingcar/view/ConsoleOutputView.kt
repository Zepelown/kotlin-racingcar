package racingcar.view

import racingcar.model.CarRacingGameResult
import racingcar.model.CarRacingGameRoundResult


class ConsoleOutputView {
    fun printCarNameInputMessage(){
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printCarRacingRoundCountMessage(){
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printCarRacingGameResult(gameResults : List<CarRacingGameResult>){
        println("실행 결과")
        gameResults.forEach { result ->
            printGameRoundResult(result.carRacingGameRoundResult)
            println()
        }
    }

    fun printCarRacingGameWinners(winners: List<String>){
        print("최종 우승자 : ")
        print(winners.joinToString(separator = ","))
    }

    private fun printGameRoundResult(roundResult: CarRacingGameRoundResult) {
        roundResult.getResult().forEach { (carName, location) ->
            println("${carName} : ${"-".repeat(location)}")
        }
    }
}