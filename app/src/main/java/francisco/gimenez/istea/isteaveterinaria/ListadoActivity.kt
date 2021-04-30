package francisco.gimenez.istea.isteaveterinaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class ListadoActivity : AppCompatActivity() {
    lateinit var diagnostico:EditText
    lateinit var causa:EditText
    lateinit var medicamentos:EditText
    lateinit var tratamiento:EditText
    lateinit var reposo:EditText
    lateinit var animalitos:Spinner
    lateinit var descartar:Button
    lateinit var listAnimalitos:ArrayList<Animal>
    var listNombres:ArrayList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        Init()
        descartar.setOnClickListener(View.OnClickListener {
            var animal: Animal? = listAnimalitos.find { animal: Animal -> animal.nombre == animalitos.selectedItem.toString() }
            val texto:String? = animal?.nombre.toString() + " Estaba atendido por:"+ animal?.vete.toString()

            Toast.makeText(this, texto,Toast.LENGTH_LONG).show()

            InicializarSkinneeeeeer(animal?.nombre.toString())

        })

    }

    private fun Init(){
        diagnostico=findViewById(R.id.e_diagnostico)
        causa=findViewById(R.id.e_causaD)
        medicamentos=findViewById(R.id.e_meds)
        tratamiento=findViewById(R.id.e_tratamiento)
        reposo=findViewById(R.id.e_reposo)
        animalitos=findViewById(R.id.s_animalitos)
        descartar=findViewById(R.id.b_descartar)
        InicializarSkinneeeeeer()
    }

    //Overload that is used only when the view is first created.
    private fun InicializarSkinneeeeeer(){
        //Define los datos de mi combo

        listAnimalitos = intent.getSerializableExtra("ListaAnimales") as ArrayList<Animal>

        for ( animal:Animal in listAnimalitos){
            listNombres.add(animal.nombre.toString())
        }

        AgregarAlSpinner(listNombres)


    }

    //Overload that is used on any refresh of the list to remove one of the names.
    private fun InicializarSkinneeeeeer(nombre:String){
        listNombres.remove(nombre)
        AgregarAlSpinner(listNombres)
    }

    private fun AgregarAlSpinner(nombres:ArrayList<String>){

        var adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,nombres)

        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        animalitos.adapter = adaptador
    }
}