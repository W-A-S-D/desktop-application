package enums;

public class MaquinaTest {
    private String maquina;
    private Double temperatura;

    public MaquinaTest(String maquina, Double temperatura) {
        this.maquina = maquina;
        this.temperatura = temperatura;
    }

    public MaquinaTest() {
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }
}
