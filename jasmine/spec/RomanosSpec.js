describe("Romanos", function () {
  it("Retorna longos numeros romanos em decimais", function () {
    var romano = new Romano("MMDCCXCVII");
    expect(romano.toDecimal()).toEqual(2797);
  });

  it("Retorna numeros complexo em decimais", function () {
    var romano = new Romano("IX");
    expect(romano.toDecimal()).toEqual(9);
  });
});
