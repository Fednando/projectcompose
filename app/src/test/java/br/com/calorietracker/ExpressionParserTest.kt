package br.com.calorietracker

import br.com.calorietracker.calculator.domain.ExpressionParser
import br.com.calorietracker.calculator.domain.ExpressionPart
import br.com.calorietracker.calculator.domain.Operation
import br.com.calorietracker.calculator.domain.ParenthesesType
import com.google.common.truth.ExpectFailure
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class ExpressionParserTest {

    private lateinit var parser: ExpressionParser

    @Test
    fun `Simple expression is properly parsed`() {
        // Given
        parser = ExpressionParser("3+5-3*4/3")

        // Do something with what´s given
        val actual = parser.parse()

        // Then
        val expected = listOf(
            ExpressionPart.Number(3.0),
            ExpressionPart.Operation(Operation.ADD),
            ExpressionPart.Number(5.0),
            ExpressionPart.Operation(Operation.SUBTRACT),
            ExpressionPart.Number(3.0),
            ExpressionPart.Operation(Operation.MULTIPLY),
            ExpressionPart.Number(4.0),
            ExpressionPart.Operation(Operation.DIVIDE),
            ExpressionPart.Number(3.0),
        )

        // Then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `Expression with parenthesis is properly parsed`(){
        // Given
        parser = ExpressionParser("4-(4*5)")

        val actual = parser.parse()

        val expected = listOf(
            ExpressionPart.Number(4.0),
            ExpressionPart.Operation(Operation.SUBTRACT),
            ExpressionPart.Parentheses(ParenthesesType.Opening),
            ExpressionPart.Number(4.0),
            ExpressionPart.Operation(Operation.MULTIPLY),
            ExpressionPart.Number(5.0),
            ExpressionPart.Parentheses(ParenthesesType.Closing),
        )

        assertThat(actual).isEqualTo(expected)
    }
}