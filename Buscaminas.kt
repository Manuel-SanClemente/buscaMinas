fun check(f:Int, c:Int, m: Int) {
    if (f<=1 && c<=1) { throw Exception("La longitud del campo es invalido") }
    if (m >= (f * c)) { throw Exception("El numero de minas es demasiado grande") }
}

fun jugar(campo:Campo, f: Int, c:Int, m:Int) {
    var minas = m
    while (minas != 0) {
        println("Comienza el juego")
        println("1-. Destapar casilla")
        println("2-. Poner bandera")
        println("3-. Rendirse")
        println("$minas minas restantes")
        campo.mostrar()
        print("Escribe ahora tu entrada: ")
        var entrada = readln().toInt()
        if (entrada == 1) {
            if (destapar(campo) == true) {
                println("¡Te ha explotado la mina!")
                println(campo)
                break
            }
        } else if (entrada == 2) {
            if (bandera(campo) == true) {
                minas=minas-1
            }
        } else if (entrada == 3) {
            campo.revelar()
            break
        }
    }
}

fun destapar(campo: Campo):Boolean {
    println("Introduce las coordenadas donde crees que esta la bomba")
    print("Introduce la fila: ")
    var fD = readln().toInt() -1
    print("Introduce la columna: ")
    var cD = readln().toInt() -1
    if (campo.coordenadas(fD,cD) == 'M') {
        return true
    } else if (campo.coordenadas(fD,cD) == 'B') {
        return false
    } else {
        campo.remplazar(fD, cD, '_')
    }
    return false
}

fun bandera(campo: Campo):Boolean {
    println("Introduce las coordenadas donde crees que esta la bomba")
    print("Introduce la fila: ")
    var fB = readln().toInt() -1
    print("Introduce la columna: ")
    var cB = readln().toInt() -1
    if (campo.coordenadas(fB,cB) == 'M') {
        campo.remplazar(fB, cB, 'B')
        return true
    } else {
        campo.remplazar(fB, cB, 'B')
    }
    return false
}

class Buscaminas (f: Int, c:Int, m:Int) {
    var C=check(f,c,m)
    var Campo= Campo(f,c,m)
    var juego= jugar(Campo,f,c,m)
}