function PacienteBuilder() {

    var atributos = {
        nome: "Gama",
        idade: 30,
        peso: 80,
        altura: 1.70
    };

    var clazz = {
        comNome : function(val) {
            nome = val;
            return this;
        },
        comIdade : function(val) {
            idade = val;
            return this;
        },
        comPeso : function(val) {
            peso = val;
            return this;
        },
        constroi : function() {
            return new Paciente(atributos)
        }
    };

    return clazz;
}
