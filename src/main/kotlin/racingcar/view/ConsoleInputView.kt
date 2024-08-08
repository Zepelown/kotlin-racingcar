package racingcar.view

class ConsoleInputView {
    fun getCarNames() : List<String>? = readLine()?.split(",")
}