describe("Paciente", function(){

  it("Deve retornar a média de batimentos", function() {
    var paciente = new Paciente("Alfa", 20, 100, 2);
    expect(paciente.batimentos()).toEqual(20 * 365 * 24 * 60 * 80);
  });

  it("Deve retornar o imc do paciente",function() {
    var paciente = new Paciente("Alfa", 20, 100, 2);
    expect(paciente.imc()).toEqual(100 / (2 * 2));
  });

  it("Deve retornar o paciente mais idade", function() {
    var paciente = new Paciente("Alfa", 20, 100, 2);
    expect(paciente.imprime()).toEqual(console.log("Alfa tem 20"));
  });

});
