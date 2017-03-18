describe("Consulta", function() {

    var paciente;

    beforeEach(function() {
        paciente = new PacienteBuilder().constroi();
    });

    describe("Consulta tipo retorno", function () {
      it("Deve retornar o preço de um retorno", function() {
          var consulta = new Consulta(paciente, ["consulta"], true, true);
          expect(consulta.preco()).toEqual(0);
      });
    });

    describe("Consulta com procedimentos padrões", function () {
      it("Deve retornar o preço de uma consulta con 2 procedimentos", function() {
          var consulta = new Consulta(paciente, ["consulta", "receita"], false, false);
          expect(consulta.preco()).toEqual(50);
      });

      it("Deve retornar o preço de uma consulta con 2 procedimentos particular", function() {
          var consulta = new Consulta(paciente, ["consulta", "receita"], true, false);
          expect(consulta.preco()).toEqual(100);
      });
    });

    describe("Consulta com procedimentos especificos", function () {
      it("Deve retornar o preço de uma consulta com procedimentos especiais", function() {
          var consulta = new Consulta(paciente, ["gesso", "receita"], false, false);
          expect(consulta.preco()).toEqual(57);
      });

      it("Deve retornar o preço de uma consulta com particular", function() {
          var consulta = new Consulta(paciente, ["raio-x", "receita"], true, false);
          expect(consulta.preco()).toEqual(160);
      });
    })
});
