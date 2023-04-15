class Medico {
    var cpf: String? = null
    var nome: String? = null
    var idade: Int? = null
    var pacientesEnfermados = mutableListOf<Paciente>()
    fun adicionarPaciente(paciente: Paciente) {
        pacientesEnfermados.add(paciente)
    }
}