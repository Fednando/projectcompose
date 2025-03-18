package br.com.calorietracker.calculator.domain

sealed interface ExpressionPart {
    data class Operation(val operation: br.com.calorietracker.calculator.domain.Operation) : ExpressionPart
    data class Number(val number: Double) : ExpressionPart
    data class Parentheses(val type: ParenthesesType) : ExpressionPart
}

sealed interface ParenthesesType {
    object Opening : ParenthesesType
    object Closing : ParenthesesType
}