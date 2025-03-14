package br.com.calorietracker.testflow

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext
import kotlin.random.Random

suspend fun main() {
    //firstFlow()
    //testCoroutines()
    //job()
    //dispatchers()
    //callAsync()
    //exceptionCourotines()
    //executePrimes()
    //executeSendNumbers()
//    convertListFlow().collect {
//        println("Received $it")
//
    //filterOperator
    //transformOperator()
    //takeOperator()
    // reduceOperator()
    //dispatchersOperator()
    //exampleCombine()
    runBlocking {
        exampleFlatMapLatest().collect {
            println(it)
        }
    }
}

suspend fun exampleCombine() {
    val numbers = (1..5).asFlow().onEach { delay(300) }
    val values = flowOf("One", "Two", "Three", "Four", "Five")
        .onEach { delay(400) }
    numbers.combine(values) { a, b ->
        "$a -> $b"
    }.collect{
        println(it)
    }
}

suspend fun exampleZip() {
    val english = flowOf("One", "Two", "Three")
    val french = flowOf("Un", "Deux", "Troix")
    english.zip(french) { a, b -> "'$a' in French is '$b'" }
        .collect {
            println(it)
        }
}

suspend fun dispatchersOperator() {
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect{
            println(it)
        }

}

suspend fun reduceOperator() {
    val size = 5
    val fatorial = (1..size).asFlow().reduce{ accumulator, value ->
        accumulator * value
    }

    println("Fatorial of $size is $fatorial")
}

suspend fun takeOperator(){
    (1..10).asFlow()
        .take(2)
        .collect{
            println(it)
        }
}

suspend fun transformOperator(){
    (1..10).asFlow()
        .transform {
            emit("Emitting value $it")
            emit(it)
        }.collect{
            println(it)
        }
}

suspend fun filterOperator(){
    (1..10).asFlow()
        .filter {
            it % 2 == 0
        }.map {
            "mapping $it"
        }.collect{
            println(it)
        }
}

suspend fun mapOperator(){
    (1..10).asFlow()
        .map {
            delay(500)
            "mapping $it"
        }.collect{
            println(it)
        }
}

fun executeSendNumbers() {
    runBlocking {
        sendNumbers().collect {
            println("Received $it")
        }
    }
}

fun sendNumbers(): Flow<Int> {
    return flow {
        for (i in 1..5) {
            emit(i)
        }
    }
}

fun convertListFlow(): Flow<Int> {
    return listOf(1, 2, 3, 4, 5, 6).asFlow()
}

fun executePrimes() {
    runBlocking {
        println("Receiving prime numbers")
        sendPrimes().collect {
            println("Received prime number $it")
        }
        println("Finished receiving numbers")
    }
}

fun sendPrimes() = flow {
    val primes = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    primes.forEach {
        delay(it * 100L)
        emit(it)
    }
}

fun exceptionCourotines() {
    runBlocking {
        val myHandleException = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception handled: ${throwable.localizedMessage}")
        }

        val job = GlobalScope.launch(Dispatchers.IO + myHandleException) {
            println("Throwing exception from job")
            throw IndexOutOfBoundsException("exception in coroutine")
        }
        job.join()
    }
}

fun callAsync() {
    runBlocking {
        val firstValue = async { getFirstValue() }
        val secondValue = async { getSecondValue() }
        println("Doing some processing here")
        delay(500)
        println("Waiting for values")

        val first = firstValue.await()
        val second = secondValue.await()
        println("The total is ${first + second}")
    }
}

suspend fun getFirstValue(): Int {
    delay(1000L)
    val value = Random.nextInt(100)
    println("Returning first value $value")
    return value
}

suspend fun getSecondValue(): Int {
    delay(2000L)
    val value = Random.nextInt(1000)
    println("Returning second value $value")
    return value
}

suspend fun dispatchers() {
    runBlocking {
//        launch(Dispatchers.Main) {
//            println("Main dispatcher. Thead: ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.IO) {
            println("IO dispatcher. Thead: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default dispatcher. Thead: ${Thread.currentThread().name}")
        }
    }
}

suspend fun job() {
    runBlocking {
        val job1 = launch {
            //delay(3000L)
            println("Job1 launched")
            val job2 = launch {
                println("Job2 launched")
                delay(3000L)
                println("Job2 is finishing")
            }
            job2.invokeOnCompletion { println("Job2 completed") }
            val job3 = launch {
                println("Job3 launched")
                delay(3000L)
                println("Job3 is finishing")
            }
            job3.invokeOnCompletion { println("Job3 completed") }
        }

        job1.invokeOnCompletion { println("Job1 completed") }
        delay(500)
        println("Job1 will be cancelled")
        job1.cancel()
    }
}

suspend fun testCoroutines() {
    GlobalScope.launch {
        delay(1000)
        println("World!")
    }

    print("Hello, ")
    Thread.sleep(2000)
}

suspend fun firstFlow() = runBlocking {
    val firstFlow = flowOf<Int>(1).collect { emmited ->
        println("fitstflow : $emmited")
    }

    val secondFlow = flowOf(1, 2, 3)

    secondFlow.collect { emmited ->
        println("secondFlow : $emmited")
    }

    listOf("A", "B", "C").asFlow().collect { emmited ->
        println("thirdFlow : $emmited")
    }

    flow {
        delay(2000)
        emit("item emitted after 2000ms")

        secondFlow.collect { emmitedValue ->
            emit(emmitedValue)
        }
    }.collect { emmited ->
        println("fourthFlow : $emmited")

    }
}

fun exampleFlatMapLatest() = flow {
        emit("a")
        delay(100)
        emit("b")
    }.flatMapLatest { value ->
        flow {
            emit(value)
            delay(200)
            emit(value + "_last")
        }

}

@OptIn(ExperimentalCoroutinesApi::class)
fun login(username: String, password: String) {


    val _loginResult = MutableStateFlow<LoginState>(LoginState.Initial)
    val loginResult: StateFlow<LoginState> = _loginResult

//     val repository = AuthRepository()
//        GlobalScope.launch(Dispatchers.IO) {
//            flow {
//                emit(repository.getToken())
//            }
//                .flatMapConcat { tokenResponse ->
//                    flow {
//                        emit(repository.login(tokenResponse.token, username, password))
//                    }
//                }
//                .flatMapConcat { loginResponse ->
//                    if (loginResponse.success) ({
//                        flow {
//                            emit(repository.getHomeData(loginResponse.message))
//                        }
//                    }) as Nothing else {
//                        throw Exception(loginResponse.message)
//                    }
//                }
//                .onStart { _loginResult.value = LoginState.Loading }
//                .catch { exception -> _loginResult.value = LoginState.Error(exception.message ?: "Erro desconhecido") }
//                .onCompletion { _loginResult.value = LoginState.Finished }
//                .collect { homeData ->
//                    _loginResult.value = LoginState.Success(homeData)
//                }
//
//    }
}

sealed class LoginState {
    object Initial : LoginState()
    object Loading : LoginState()
    data class Success(val homeData: HomeData) : LoginState()
    data class Error(val message: String) : LoginState()
    object Finished : LoginState()
}

class AuthRepository {
    suspend fun getToken(): TokenResponse {
        delay(1000) // Simula atraso de 1 segundo
        return TokenResponse("token123")
    }

    suspend fun login(token: String, username: String, password: String): LoginResponse {
        delay(1500) // Simula atraso de 1.5 segundos
        return if (username == "usuario" && password == "senha") {
            LoginResponse(true, "Login bem-sucedido")
        } else {
            LoginResponse(false, "Credenciais inválidas")
        }
    }

    suspend fun getHomeData(token: String): HomeData {
        delay(2000) // Simula atraso de 2 segundos
        return HomeData("Usuário Exemplo", "usuario@exemplo.com")
    }
}

data class TokenResponse(val token: String)
data class LoginResponse(val success: Boolean, val message: String)
data class HomeData(val userName: String, val userEmail: String)