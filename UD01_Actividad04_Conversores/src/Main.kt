fun main() {
    var seleccion: Int?
    do {
        println("~~ CONVERSOR DE UNIDADES ~~")
        println("1. Conversor de divisas")
        println("2. Conversor de distancias")
        println("3. Conversor de temperaturas")
        println("4. Salir")
        println("Seleccione una opción: ")
        seleccion = readLine()?.toIntOrNull()

        // Uso de when para llamar a las diferentes opciones del menú
        when (seleccion) {
            1 -> menuDivisas()
            2 -> menuDistancias()
            3 -> menuTemperaturas()
            4 -> println("Saliendo de la aplicación. ¡Hasta pronto!")
            else -> println("Error: opción no válida.")
        }
        println()
    } while (seleccion != 4)
}

//1. Conversión de divisas
fun menuDivisas() {
    println("\n--- CONVERSOR DE DIVISAS ---")
    println("1. Euros a Dólares")
    println("2. Euros a Libras esterlinas")
    println("3. Euros a Yenes")
    println("4. Euros a Francos suizos")
    println("Seleccione una opción de divisas")

    val subOpcion = readLine()?.toIntOrNull()
    print("Introduzca la cantidad en euros: ")

    val cantidad = readLine()?.toDoubleOrNull()//Lee depurando la entrada

    // Comprueba si la cantidad es nula o es un número negativo
    if (cantidad == null || cantidad < 0) {
        println("Error: la cantidad no puede ser negativa.")
        return
    }

    // Variables inmutables
    val dolar = 1.08
    val libra = 0.86
    val yen = 163.0
    val francoSuizo = 0.95

    // Evalúa la opción elegida y calcula el resultado
    when (subOpcion) {
        1 -> println("$cantidad € equivalen a ${cantidad * dolar} dólares.")
        2 -> println("$cantidad € equivalen a ${cantidad * libra} libras esterlinas.")
        3 -> println("$cantidad € equivalen a ${cantidad * yen} yenes.")
        4 -> println("$cantidad € equivalen a ${cantidad * francoSuizo} francos suizos.")
        else -> println("Error: opción no válida.")
    }
}
//2.Conversor de distancias
fun menuDistancias() {
    println("\n--- CONVERSOR DE DISTANCIAS ---")
    println("1. Kilómetros a metros")
    println("2. Metros a kilómetros")
    println("3. Kilómetros a millas")
    println("4. Millas a kilómetros")
    println("5. Centímetros a metros")

    val opcion = readLine()?.toIntOrNull()

    print("Introduzca la distancia: ")
    val distancia = readLine()?.toDoubleOrNull()

    // Depura la entrada de la distancia
    if (distancia == null || distancia < 0) {
        println("Error: la cantidad no puede ser negativa.")
        return
    }
    val millasFactor = 0.621371
    when (opcion) {
        1 -> println("$distancia kilómetros equivalen a ${distancia * 1000} metros.")
        2 -> println("$distancia metros equivalen a ${distancia / 1000} kilómetros.")
        3 -> println("$distancia kilómetros equivalen a ${distancia * millasFactor} millas.")
        4 -> println("$distancia millas equivalen a ${distancia / millasFactor} kilómetros.")
        5 -> println("$distancia centímetros equivalen a ${distancia / 100} metros.")
        else -> println("Error: opción no válida.")
    }
}

//3.Conversor de temperaturas
fun menuTemperaturas() {
    println("--- CONVERSOR DE TEMPERATURAS ---")
    println("Celsius a Fahrenheit")
    println("Fahrenheit a Celsius")
    println("Celsius a Kelvin")
    println("Kelvin a Celsius")
    println("Seleccione una opción de temperaturas: ")

    val opcion = readLine()?.toIntOrNull()
    print("Introduzca la temperatura: ")
    val temperatura = readLine()?.toDoubleOrNull()

    if (temperatura == null) {
        println("Error: entrada de datos incorrecta.")
        return
    }

    // Evalúa la conversión y aplica las fórmulas correspondientes
    when (opcion) {
        1 -> {
            val resultado = temperatura * 9.0 / 5.0 + 32
            println("$temperatura °C equivalen a $resultado °F.")
        }
        2 -> {
            val resultado = (temperatura - 32) * 5.0 / 9.0
            println("$temperatura °F equivalen a $resultado °C.")
        }
        3 -> {
            //En Celsius no se puede bajar del cero absoluto (-273.15 °C) para calcular Kelvin
            if (temperatura < -273.15) {
                println("Error: la temperatura en Celsius no puede ser inferior a -273.15 para calcular Kelvin.")
            } else {
                val resultado = temperatura + 273.15
                println("$temperatura °C equivalen a $resultado K.")
            }
        }
        4 -> {
            //La escala Kelvin no admite valores menores a 0
            if (temperatura < 0) {
                println("Error: la temperatura en Kelvin no puede ser inferior a 0.")
            } else {
                val resultado = temperatura - 273.15
                println("$temperatura K equivalen a $resultado °C.")
            }
        }

        else -> println("Error: opción no válida.")
    }

}