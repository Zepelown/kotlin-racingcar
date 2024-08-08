package study

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.CarRacingGameMaxRound

class CarRacingGameMaxRoundValidateTest {
    @ParameterizedTest
    @ValueSource(strings = ["`","@","-","a","한"])
    fun `숫자가 아닌 값을 입력한 경우`(input: String){
        assertThrows<IllegalArgumentException> {
            CarRacingGameMaxRound(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0","1.1","-1"])
    fun `자연수를 입력하지 않은 경우`(input: String){
        assertThrows<IllegalArgumentException> {
            CarRacingGameMaxRound(input)
        }
    }
}