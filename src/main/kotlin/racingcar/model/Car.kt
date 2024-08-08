package racingcar.model

class Car(
    private val _carName : String?
) {
    private var carLocation : Int = 0
    val carName : String get() = _carName!!

    init {
        require(validateCarName())
    }

    fun move(){
        carLocation++
    }

    fun getLocation() = carLocation

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