import kotlin.random.Random

fun generarCampo(fil: Int, col:Int): MutableList<MutableList<Char>> {
    var campo=MutableList(fil){MutableList(col) {'X'} }
    return campo
}

fun ponerMinas(campo: MutableList<MutableList<Char>>, fil:Int, col: Int, min: Int):MutableList<MutableList<Char>> {
    var columna = col-1
    for (i in 0 until min) {
        var f = Random.nextInt(0, fil)
        var c = Random.nextInt(0, columna)
        campo[f][c] = 'M'
    }
    return campo
}

fun recorrerCampo(campo: MutableList<MutableList<Char>>, f:Int, c:Int):String {
    var s= ""
    for (i in 0 until f) {
        for (j in 0 until c) {
            print(campo[i][j])
            print(" ")
        }
        println()
    }
    return s
}

class Campo(f:Int, c: Int, m:Int) {
    var falso = generarCampo(f,c)
    var real =  ponerMinas(falso, f, c, m)

    var fil = f
    var col = c

    fun coordenadas(fF:Int, cC:Int): Char { return real[fF][cC] }
    fun remplazar(fR:Int,cR:Int,chR:Char) {
        falso[fR][cR] = chR
        real[fR][cR] = chR
    }
    fun mostrar():String { return recorrerCampo(falso, fil, col)}
    fun revelar():String { return recorrerCampo(real, fil, col)}
}