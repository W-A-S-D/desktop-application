/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.util.List;

/**
 *
 * @author bianc
 */
public class Teste {

    public static void main(String[] args) {
        getGpu();
//        Looca looca = new Looca();
//    
//        Memoria memoria = looca.getMemoria();
//    
//        System.out.println(memoria);
//        System.out.println(Conversor.formatarBytes(memoria.getEmUso())); // pra pegar o uso da memória
//        
//        System.out.println("-------------------------------------------------------------");
//        
//        Processador processador = looca.getProcessador();
//        
//        System.out.println(processador);
//        System.out.println(processador.getUso()); //uso da CPU, mas n entendi mt bem
//        
//        System.out.println("Info Hardware");
//        
//        Sistema sistema = looca.getSistema();
//        
//        System.out.println("Sistema operacional: " + sistema.getSistemaOperacional() + "\nProcessador: " + processador.getNome() + "\nMemória: " + Conversor.formatarBytes(memoria.getTotal()));
//        
//        System.out.println("-------------------------------------------------------------");
//        
//        ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();
//        
//        List<Processo> processos = grupoDeProcessos.getProcessos();
//       
//        processos.forEach(processo -> {
//            System.out.println(processo);
//        });
//        
//        System.out.println("-------------------------------------------------------------");
//        
//        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
//        
//        List<Disco> discos = grupoDeDiscos.getDiscos();
//        
//        discos.forEach(disco -> {
//            System.out.println(disco);
//        });
    }

    public static void getGpu() {
        Components componentes = JSensors.get.components();

        List<Gpu> gpus = componentes.gpus;
        
        List<Cpu> cpus = componentes.cpus;
        
        if (cpus != null) {
            for (final Cpu cpu : cpus) {
                System.out.println("Found CPU component: " + cpu.name);
                if (cpu.sensors != null) {
                    System.out.println("Sensors: ");

                    List<Temperature> temps = cpu.sensors.temperatures;
                    for (final Temperature temp : temps) {
                        System.out.println(temp.name + ": " + temp.value + " C");
                    }

                    //Print fan speed
//                    List<Fan> fans = gpu.sensors.fans;;
//                    fans.forEach(fan -> {
//                        System.out.println(fan.name + ": " + fan.value + " RPM");
//                    });
                }
            }
        }

        if (gpus != null) {
            for (final Gpu gpu : gpus) {
                System.out.println("Found GPU component: " + gpu.name);
                
                if (gpu.sensors != null) {
                    System.out.println("Sensors: ");

                    List<Temperature> temps = gpu.sensors.temperatures;
                    for (final Temperature temp : temps) {
                        System.out.println(temp.name + ": " + temp.value + " C");
                    }
                    
                    //Print fan speed
//                    List<Fan> fans = gpu.sensors.fans;;
//                    fans.forEach(fan -> {
//                        System.out.println(fan.name + ": " + fan.value + " RPM");
//                    });
                }
            }
        }
    }
}
