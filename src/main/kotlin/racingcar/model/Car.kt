package racingcar.model

class Car(
    private val _carName : String?
) {
    val carName : String get() = _carName!!
    init {
        require(validateCarName())
    }

    private fun validateCarName(): Boolean {
        if (_carName.isNullOrBlank()) {
            return false
        }
        return isAllAlphabetic() && _carName.length <= 5
    }

    private fun isAllAlphabetic(): Boolean {
        return _carName?.all { it in 'a'..'z' || it in 'A'..'Z'} ?: false
    }
}