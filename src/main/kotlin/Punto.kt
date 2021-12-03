import Punto.Companion.componenteDeVector
import java.lang.Math.sqrt
import kotlin.math.pow

class Punto(id: String) {

    val idPunto: String = id
    var xPos: Int = 0
    var yPos: Int = 0

    constructor(id: String, x: Int, y: Int) : this(id) {
        this.xPos = x
        this.yPos = y
    }

    fun getCoordenadas() = Pair(this.xPos, this.yPos)
    override fun toString() = "punto <$idPunto> -> [<$xPos>,<$yPos>]"


    companion object {
        fun componenteDeVector(punto1: Punto, punto2: Punto): Punto {
            return Punto(punto1.idPunto + punto2.idPunto, punto2.xPos - punto1.xPos, punto2.yPos - punto1.yPos)
        }

        fun localizacionGeograficaNS(lista: List<Punto>): String {
            val ite = lista.listIterator()
            var mapCaridnalidad = ""
            var puntosNorte = "Norte= "
            var puntosSur = "Sur= "
            var norte: MutableList<Punto> = mutableListOf()
            var sur: MutableList<Punto> = mutableListOf()
            for (i in ite) {
                if (i.yPos >= 0) {
                    puntosNorte += " " + i.toString()
                } else {
                    puntosSur += " " + i.toString()
                }
            }
            return lista.toString() + " Localización Geográfica " + puntosNorte + puntosSur
        }
    }

    fun distancia(punto1: Punto, punto2: Punto): Double {
        var value =
            kotlin.math.sqrt(Math.pow((punto2.xPos - punto1.xPos).toDouble()) + Math.pow(((punto2.yPos - punto1.yPos).toDouble())))
        return value
    }

    fun localizacionGeograficaNS(lista: List<Punto>): Map<String, List<Punto>> {
        val ite = lista.listIterator()
        var loc: MutableMap<String, List<Punto>> = mutableMapOf()
        var norte: MutableList<Punto> = mutableListOf()
        var sur: MutableList<Punto> = mutableListOf()
        for (i in ite) {
            if (i.yPos >= 0) {
                norte.add(i)
            } else {
                sur.add(i)
            }
        }
        loc.put("Norte", norte)
        loc.put("Sur", sur)
        return loc
    }

}

fun main() {
    val p1 = Punto("id1", 3, 2)
    val p2 = Punto("id2", 1, 3)
    val resultadoResta = componenteDeVector(p1, p2)
}