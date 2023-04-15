
fun criarHospital(): Hospital {
    println("Digite o nome do hospital: ")
    val hospitalNome = readln()

    return Hospital(hospitalNome)
}
fun criarMedico(): Medico {
    val medico = Medico()

    println("Digite o nome do medico: ")
    medico.nome = readln()
    println("Digite a idade de ${medico.nome}: ")
    medico.idade = readln().toInt()
    println("Digite o CPF de ${medico.nome}: ")
    medico.cpf = readln()

    return medico
}
fun listarMedicos(listaMedicos: List<Medico>) {
    println("Total: ${listaMedicos.size}")
    for (medico in listaMedicos) {
        println("--------------")
        println("Nome: ${medico.nome}")
        println("Idade: ${medico.idade}")
        println("CPF: ${medico.cpf}")
        println("Total de pacientes: ${medico.pacientesEnfermados.size}")
    }
}
fun criarPaciente(hospital: Hospital): Paciente {
    val paciente = Paciente()

    println("Digite o nome do paciente: ")
    paciente.nome = readln()
    println("Digite a idade de ${paciente.nome}: ")
    paciente.idade = readln().toInt()
    println("Digite o CPF de ${paciente.nome}: ")
    paciente.cpf = readln()
    println("Digite o problema de ${paciente.nome}: ")
    paciente.problema = readln()
    println("--------\nMedicos disponiveis\n--------")
    for (medico in hospital.totalMedicos) {
        println("|${hospital.totalMedicos.indexOf(medico)}| ${medico.nome}")
        println("----------------")
    }
    println("Digite o numero ou nome do medico: ")
    val opcaoMedico = readln()
    for (medico in hospital.totalMedicos) {
        if (medico.nome?.lowercase() == opcaoMedico.toString().lowercase() || hospital.totalMedicos.indexOf(medico) == opcaoMedico.toInt()) {
            medico.adicionarPaciente(paciente)
            paciente.adicionarMedicoResponsavel(medico)
        }
    }

    return paciente
}

fun listarPaciente(listaPacientes: List<Paciente>) {
    println("Total: ${listaPacientes.size}")
    for (paciente in listaPacientes) {
        println("--------------")
        println("Nome: ${paciente.nome}")
        println("Idade: ${paciente.idade}")
        println("CPF: ${paciente.cpf}")
        println("Problema: ${paciente.problema}")
        print("Medicos responsaveis: ")
        for (medico in paciente.medicosResposaveis) {
            print("${medico.nome}")
        }
    }
}
fun main() {
    val hospitaisCadastradosLista = mutableListOf<Hospital>()
    val totalMedicosListaGlobal = mutableListOf<Medico>()
    val totalPacientesListaGlobal = mutableListOf<Paciente>()

    //Criar a opcao de login no hospital

    do {
        println("1.Criar hospital\n2.Listar hospitais\n3.Remover hospital\n4.Editar hospital\n5.Sair")
        val hospitalOpcao = readln().toInt()

        when(hospitalOpcao) {
            1 -> {
                val hospital = criarHospital()
                hospitaisCadastradosLista.add(hospital)
                println("Hospital adicionado!")

                do {
                    println("------------\n${hospital.nome}\n------------\n1.Criar Medico\n2.Listar Medicos\n3.Criar Paciente\n4.Listar Pacientes\n5.Sair")
                    val opcaoSecundaria = readln().toInt()

                    when(opcaoSecundaria) {
                        1 -> {
                            val medico = criarMedico()
                            totalMedicosListaGlobal.add(medico)
                            hospital.totalMedicos.add(medico)
                            println("Medico adicionado!")
                        }
                        2 -> {
                            listarMedicos(hospital.totalMedicos)
                        }
                        3 -> {
                            val paciente = criarPaciente(hospital)
                            totalPacientesListaGlobal.add(paciente)
                            hospital.totalPacientes.add(paciente)
                            println("Paciente adicionado!")
                        }
                        4 -> {
                            listarPaciente(hospital.totalPacientes)
                        }
                        5 -> break
                        else -> {
                            println("Opcao Invalida")
                            continue
                        }
                    }
                }while(opcaoSecundaria != 5)
            }
            2 -> {
                for (hospital in hospitaisCadastradosLista) {
                    println("Nome: ${hospital.nome}")
                    println("Total de Medicos: ${hospital.totalMedicos.size}")
                    println("Total de Pacientes: ${hospital.totalPacientes.size}")
                }
            }
            3 -> {}
            4 -> {}
            5 -> break
            else -> {
                println("Opcao Invalida")
                continue
            }
        }
    }while(hospitalOpcao != 5)



}