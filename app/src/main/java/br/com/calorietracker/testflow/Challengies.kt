package br.com.calorietracker.testflow

fun main() {

}

//Fatorial
fun fatorial(n: Int) {
    val fatorial = (1..n).toList().reduce{acc, value -> acc * value}
    println("Fatorial of $n is $fatorial")

    val fatorial2 = (0..5).toList().reduce{acc , value -> acc * value}
    println("Fatorial of $n is $fatorial2")
}

fun reverseString(text: String) {
    var reversedString = StringBuilder()
    for(i in text.length - 1 downTo 0) {
        reversedString.append(text[i])
    }

    val stringReverse2 = StringBuilder()
    for(i in text.length - 1 downTo 0){
        stringReverse2.append(text[i])
    }


    println(reversedString)
}

fun areAnagrams(str1: String, str2: String): Boolean {
    return str1.toCharArray().sorted() == str2.toCharArray().sorted()
}


fun fatorial2(n: Int) {
    val fatorial = (1..n).toList().reduce{acc, value -> acc * value}
    println("Fatorial of $n is $fatorial")
}

fun reverse2(text: String) {
    val reversed = StringBuilder()
    for(i in text.length - 1 downTo 0) {
        reversed.append(text[i])
    }
}




