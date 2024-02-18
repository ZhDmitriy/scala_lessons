import scala.collection.mutable.ArrayBuffer

var capital = Map("US" -> "Washngton", "France" -> "Paris")
capital += ("Japan" -> "Tokyo")
println(capital("France"))

def factorial(x: BigInt): BigInt =
  if (x == 0) 1 else x * factorial(x - 1)

println(factorial(30))

// Переменные
var str = "Hello, " // переменная
val add = "world!" // константа
str += add
print(str)

// Объявление функций
def square(x: Int) = x * x
square(10)

// if
def abs(x: Int) = {
  if (x >= 0){
    x
  } else {
    -x // здесь нет слова return
  }
}
abs(10)

// while
var a: Int = 0
while (a < 10){
  a += 1
  println(a)
} // бывает еще do { ... } while

// for
for (i <- 0 to 10){
  println(i)
}

// явное указание коллекции через Vector
for (i <- Vector(1, 2, 3)){
  println(i)
}

// Цикл for с условием
for {
  v <- 1 until 10 if v%2 == 0
} yield {
  v * v
}

// Пара (Tuple)
val pair: (Int, Int) = (1, 2)
val pair2 = "key" -> "value"

val (fisrt, second) = pair // деконструкция

// объект Scala
object HelloWorld extends App { // тк работает поверх JVM, то должны создать объект HelloWorld
  println("Hello, world!")
}

// Создание собственных типов данных. Case-классы
case class Address(`type`: String, value: String){
  def toStringAddress = s"${`type`}:$value"
}

// собственный тип лучше, чем просто значения
case class Address(`type`: String, value: String) // type - ключевое слово, поэтому в апострофах
val address = Address("email", "someone@gmail.com")

// пара, а не собственный тип значения
val address: (String, String) = ("email", "someone@gmail.com")

// Case-классы можно определить в иерархию
sealed trait Expr // sealed означает, что все прямые потомки Expr находятся в исходном файле

case class Number(value: Int) extends Expr // тип число с типом Int
case class Plus(ihs: Expr, rhs: Expr) extends Expr // операция "плюс"
case class Minus(ihs: Expr, rhs: Expr) extends Expr // операция "минус"

// PATTERN MATCHING
def value(expression: Expr): Int = expression match { // match перебирает экстракторы (экстратор может не подойти)
  // аналог switch case
  case Number(value) => value
  case Plus(ihs, rhs) => value(ihs)+ value(rhs)
  case Minus(ihs, rhs) => value(ihs) - value(rhs)
}

val result = value(Plus(Number(2), Number(2)))

// Списки (буферы)
val buffer = ArrayBuffer[Int](1, 2, 3)
buffer += 4 // добавление элемента
buffer(1) // получение элемента

val f: (Int => Int) = buffer

// Экстрактор - позволяет вытащить содержимое пары обратно
val address = Address("email", "abuse@sportloto.ru")
val Address(_, email) = address // вытаскивает значение из содержимого пары

// Обработка исключений
try{
  1/0
} catch {
  case ex: ArithmeticException =>
    println(ex.getMessage)
    1
}

// ИММУТАБЕЛЬНОСТЬ И БАЗОВЫЕ СТРУКТУРЫ ДАННЫХ. РАБОТА СО СПИСКАМИ.
