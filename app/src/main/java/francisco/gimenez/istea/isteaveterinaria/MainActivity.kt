package francisco.gimenez.istea.isteaveterinaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var e_name:EditText
    lateinit var e_tipo:EditText
    lateinit var e_raza:EditText
    lateinit var e_edad:EditText
    lateinit var e_causa:EditText
    lateinit var b_aceptar:Button
    lateinit var b_agregar:Button
    lateinit var vetes: Spinner
    private var animalitos:ArrayList<Animal> =ArrayList<Animal>()
    private var countJuan:Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Init()

        b_agregar.setOnClickListener(View.OnClickListener {
            
            if(animalitos.count() < 5){

                if(vetes.selectedItem.toString() == "Juan" && countJuan ==3 || e_tipo.text.toString().toLowerCase() != "perro" ){

                    Toast.makeText(this, "Che!, Juan solo puede atender pichichos y menos de 3, mescuchas?", Toast.LENGTH_LONG).show()
                }

                else{

                    if (vetes.selectedItem.toString() == "Juan")
                        countJuan++

                    val animal:Animal = GuardarDatos()
                    animalitos.add(animal)
                    Cls()
                    Toast.makeText(this, "Ya van: "+animalitos.count().toString(), Toast.LENGTH_LONG).show()
                }

            }
            else
                Toast.makeText(this, "Para pibe, hasta 5 aguantamos, mas no", Toast.LENGTH_LONG).show()



        })

        b_aceptar.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, ListadoActivity::class.java)
            intent.putExtra("ListaAnimales",animalitos)
            startActivity(intent)
        })
    }

    private fun InicializarSpinner(){
        //Define los datos de mi combo
        var listaVets = arrayOf("Juan","Pedro")
        var adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,listaVets)
        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        vetes.adapter = adaptador


    }

    private fun GuardarDatos(): Animal {

        return Animal(
            e_name.text.toString(),
            e_tipo.text.toString(),
            e_raza.text.toString(),
            e_edad.text.toString().toInt(),
            e_causa.text.toString(),
            vetes.selectedItem.toString()
        )

    }

    fun Init(){

        e_name=findViewById(R.id.e_name)
        e_tipo=findViewById(R.id.e_tipo)
        e_raza=findViewById(R.id.e_raza)
        e_edad=findViewById(R.id.e_edad)
        e_causa=findViewById(R.id.e_causa)
        b_aceptar=findViewById(R.id.b_aceptar)
        b_agregar=findViewById(R.id.b_agregar)
        vetes=findViewById(R.id.s_vete)
        InicializarSpinner()
    }

    fun Cls(){
        e_name.setText("")
        e_tipo.setText("")
        e_raza.setText("")
        e_edad.setText("")
        e_causa.setText("")
    }
}