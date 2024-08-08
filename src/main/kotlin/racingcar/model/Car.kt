package racingcar.model

data class Car(
    val carName : String?
) {
    init {
        require(validateCarName())
    }

    private fun validateCarName(): Boolean {
        if (carName.isNullOrBlank()) {
            return false
        }
        return isAllAlphabetic() && carName.length <= 5
    }

    private fun isAllAlphabetic(): Boolean {
        return carName?.all { it.isLetter() } ?: false
    }
}