package racingcar.domain

class Judge (private val cars: List<Car>){
    fun setWinner(): List<Car>{
        val farthest = cars.maxOfOrNull { it.distance }
        return cars.filter { car-> car.distance == farthest }
    }
}