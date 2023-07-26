

data class PerfilUsuario(var id:Int,var names: String = "",var lastnames: String ="",var urlPhoto: String?=null,
                         var age: Int = 0,var email: String = "",var biography: String?=null, var status:Status = Status.Activo,var hobbies: MutableList<Hobby> = mutableListOf()){

    fun AgregarHobby(hobby:Hobby):Unit {
        hobbies.add(hobby);
    }
}

enum class Status{
    Activo,
    Pendiente,
    Inactivo
}
