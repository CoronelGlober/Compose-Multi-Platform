import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

expect fun httpClient(config: HttpClientConfig<*>.() -> Unit = {}): HttpClient


fun main() {
    println("Hello, Kotlin/Native!")
    runBlocking {
        val client = httpClient()
        println("Hello, Kotlin/Native!")
        val response = withContext(Dispatchers.Default){ client.get("https://my-json-server.typicode.com/typicode/demo/posts") }
        println("Hello, Kotlin/Native!")
        println(response.bodyAsText())
    }
}