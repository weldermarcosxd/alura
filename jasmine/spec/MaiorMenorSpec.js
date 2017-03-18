describe("Maior e menor", function() {

  it("Deve retornar o maior e o menor numero de uma lista crescente", function() {
    var algoritimo = new MaiorEMenor();
    algoritimo.encontra([5,10,17,29]);
    expect(algoritimo.pegaMaior()).toEqual(29);
    expect(algoritimo.pegaMenor()).toEqual(5);
  });

  it("Deve retornar o maior e o menor numero de uma lista decrescente", function() {
    var algoritimo = new MaiorEMenor();
    algoritimo.encontra([30,20,10,5]);
    expect(algoritimo.pegaMaior()).toEqual(30);
    expect(algoritimo.pegaMenor()).toEqual(5);
  });

  it("Deve retornar o maior e o menor numero de uma lista desordenada", function() {
    var algoritimo = new MaiorEMenor();
    algoritimo.encontra([20,30,10,5]);
    expect(algoritimo.pegaMaior()).toEqual(30);
    expect(algoritimo.pegaMenor()).toEqual(5);
  });

  it("Deve retornar o maior e o menor numero de uma lista de um elemento", function() {
    var algoritimo = new MaiorEMenor();
    algoritimo.encontra([25]);
    expect(algoritimo.pegaMaior()).toEqual(25);
    expect(algoritimo.pegaMenor()).toEqual(25);
  });
});
