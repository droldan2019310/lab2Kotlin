import java.io.*

var profiles: MutableList<PerfilUsuario> = mutableListOf()
var resp: Int = -1


fun main(args: Array<String>) {

    createProfiles()
    while(resp!= 5){
        println("Bienvenido a la creación de perfiles")
        println("1. Crear Perfil")
        println("2. Buscar Perfil")
        println("3. Eliminar Perfil")
        println("4. Agregar Hobby")
        println("5. Salir")
        resp =  readln().toInt()
        menu()
    }


}


fun menu(){

    if(resp==1){
        saveProfile()
    }else if(resp ==2){
        searchProfile()
    }else if(resp==3){
        removeProfile()
    }else if(resp==4){
        addHobby()
    }
}

fun saveProfile(){
    println("Ingresa tu ID: ")
    var id: Int = readln().toInt()

    println("Ingresa tu nombre: ")
    var names: String = readln()

    println("Ingresa tus apellidos: ")
    var lastnames: String = readln()

    println("Ingresa url de foto si tiene: ")
    var urlPhoto:String? = readln()

    println("Ingresa tu edad: ")
    var age: Int = readln().toInt()

    println("Ingresa tu email: ")
    var email:String = readln()

    println("Ingresa tu biografía si tiene: ")
    var biography:String? = readln()
    var respStatus: Int = -1
    while(respStatus==1 || respStatus ==2 || respStatus==3 ){
        println("elige una opción de estado: ")
        println("1. Activo")
        println("2. Pendiente")
        println("3. Inactivo")
        respStatus = readln().toInt()
    }
    var status:Status = Status.Inactivo
    if(respStatus==1){
        status = Status.Activo
    }else if(respStatus==2){
        status = Status.Pendiente
    }

    var newProfile = PerfilUsuario(id, names,lastnames, urlPhoto, age,email, biography, status)

    profiles.add(newProfile)
}

fun searchProfile(){
    println("Ingresa ID a buscar: ")
    val id: Int = readln().toInt()

    val profileFind = profiles.find {it.id == id}

    if(profileFind!=null){
        println("Perfil encontrado: $profileFind")
    }else{
        println("no hemos encontrado el perfil con el ID: $id")
    }
}

fun removeProfile(){
    println("Ingresa ID a eliminar: ")
    val id: Int = readln().toInt()

    val profileFind = profiles.find {it.id == id}

    if(profileFind!=null){
        profiles.remove(profileFind)
        println("Perfil eliminado: $profileFind")
    }else{
        println("no hemos encontrado el perfil con el ID: $id")
    }
}

fun addHobby(){

    println("Ingresa el titulo del hobby: ")
    var title:String = readln()

    println("Ingresa la descripción del hobby: ")
    var description:String = readln()

    println("Ingresa la url de la foto si tiene: ")
    var UrlPhoto:String? = readln()

    var newHobby = Hobby(title, description, UrlPhoto)

    println("Ingresa ID para agregar el hobby: ")
    val id: Int = readln().toInt()

    val profileFind = profiles.find {it.id == id}

    if(profileFind!=null){
        profileFind.AgregarHobby(newHobby)
        println("Perfil actualizado: $profileFind")
    }else{
        println("no hemos encontrado el perfil con el ID: $id")
    }

}


fun createProfiles(){

    profiles = mutableListOf(
        PerfilUsuario(1, "Davis Alejandro", "Roldan Ordoñez", null, 20,"davisrdln@gmail.com", null,Status.Activo,
            mutableListOf()),
                PerfilUsuario(2, "Jorge Fabian", "Lopez", null, 20,"jorge@gmail.com", null,Status.Activo,
        mutableListOf()),
        PerfilUsuario(3, "Diederich", "Solis", null, 20,"diederich@gmail.com", null,Status.Activo,
            mutableListOf())
    )
}