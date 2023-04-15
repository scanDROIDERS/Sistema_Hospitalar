class Paciente {
    var cpf: String? = null
    var nome: String? = null
    var idade: Int? = null
    var problema: String? = null
    var medicosResposaveis = mutableListOf<Medico>()

    fun adicionarMedicoResponsavel(medico: Medico) {
        medicosResposaveis.add(medico)
        println("DEBUG\n ${medico.nome}")
    }
}