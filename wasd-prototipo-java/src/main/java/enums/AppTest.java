package enums;

public class AppTest {

    public static void main(String[] args) {

        MaquinaTest m1 = new MaquinaTest("Dell01", 55.1);
        MaquinaTest m2 = new MaquinaTest("Fritadeira", 99.0);
        MaquinaTest m3 = new MaquinaTest("Alienware", 22.0);

        TemperaturaAlerta maquinaStatus1 = TemperaturaAlerta.fromTemperatura(m1.getTemperatura());
        TemperaturaAlerta maquinaStatus2 = TemperaturaAlerta.fromTemperatura(m2.getTemperatura());
        TemperaturaAlerta maquinaStatus3 = TemperaturaAlerta.fromTemperatura(m3.getTemperatura());

        
        System.out.println("STATUS DISPONIVEIS:");
        for (TemperaturaAlerta statusType : TemperaturaAlerta.values()) {
            System.out.println(statusType);
        }

        System.out.println("Maquina:" + m1.getMaquina() + ", Status Temperatura: " + maquinaStatus1);
        System.out.println("Maquina:" + m2.getMaquina() + ", Status Temperatura: " + maquinaStatus2);
        System.out.println("Maquina:" + m3.getMaquina() + ", Status Temperatura: " + maquinaStatus3);
    }
}
