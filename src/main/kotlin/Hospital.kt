class Hospital (val nome: String? = null) {
    var totalMedicos = mutableListOf<Medico>()
    var totalPacientes = mutableListOf<Paciente>()
}