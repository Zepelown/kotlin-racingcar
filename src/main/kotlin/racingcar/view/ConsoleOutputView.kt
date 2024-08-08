package racingcar.view

import racingcar.model.CarRacingGameResult


class ConsoleOutputView {
    fun printCarNameInputMessage(){
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printCarRacingRoundCountMessage(){
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printCarRacingGameResult(gameResults : List<CarRacingGameResult>){
        println("실행 결과")
        gameResults.forEach {
            it.carRacingGameRoundResult.getResult().forEach { carName, location ->
                print("$carName : ")
                for (i in 1 .. location){
                    print("-")
                }
                println()
            }
            println()
        }
    }
}