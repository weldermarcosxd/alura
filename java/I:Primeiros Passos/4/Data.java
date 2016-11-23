public class Data {

private int dia;
private int mes;
private int ano;

public String getFormatada(){
        return this.getDia() + "/" + this.getMes() + "/" + this.getAno();
}

public int getDia() {
        return this.dia;
}

public void setDia(int dia) {
        this.dia = dia;
}

public int getMes() {
        return this.mes;
}

public void setMes(int mes) {
        this.mes = mes;
}

public int getAno() {
        return this.ano;
}

public void setAno(int ano) {
        this.ano = ano;
}

public Data() {
}

public Data(int dia, int mes, int ano) {
        if(mes == 2) {
                if(dia < 30) {
                        this.setDia(dia);
                        this.setMes(mes);
                        this.setAno(ano);
                }
        }
}
}
