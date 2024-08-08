package study

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car

class CarNameValidateTest {

    @ParameterizedTest()
    @ValueSource(strings = ["0","`","@","한글"," "])
    fun `자동차 이름을 영어 알파벳을 사용하지 않은 경우`(input : String){
        assertThrows<IllegalArgumentException> {
            val car = Car(input)
        }
    }

    @ParameterizedTest()
    @ValueSource(strings = ["abc","aba","test"])
    fun `자동차 이름을 길이가 5이하인 영어 알파벳으로만 지은 경우`(input: String){
        assertDoesNotThrow {
            val car = Car(input)
        }
    }

    @ParameterizedTest()
    @ValueSource(strings = ["abcaaaa","abaaaa","testqweasdf"])
    fun `자동차 이름을 길이가 5보다 긴 영어 알파벳으로만 지은 경우`(input: String){
        assertThrows<IllegalArgumentException> {
            val car = Car(input)
        }
    }
}