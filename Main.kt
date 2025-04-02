fun main() {
    println("Bienvenido a Buscaminas.")
    println("Por favor, escribe las dimensiones de tu buscaminas")
    println()
    var jugar=1
    while (jugar == 1) {
        print("Escribe un numero de filas: ")
        var filas = readln().toInt()
        print("Escribe un numero de columnas: ")
        var columnas = readln().toInt()
        print("Escribe el numero de minas que quieres: ")
        var minas = readln().toInt()
        println()
        Buscaminas(filas, columnas, minas)
        println()
        println("Quieres volver a jugar? (S/N)")
        var volver= readln()
        if (volver == "S" || volver == "s") { jugar == 1 }
        else if (volver == "N" || volver == "n") { break }
    }
}