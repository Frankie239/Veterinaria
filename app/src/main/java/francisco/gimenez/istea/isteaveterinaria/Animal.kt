package francisco.gimenez.istea.isteaveterinaria
import java.io.Serializable

public data class Animal(
    val nombre: String,
    val tipo:String,
    val raza:String,
    val edad:Int,
    val causa:String,
    val vete:String
):Serializable
