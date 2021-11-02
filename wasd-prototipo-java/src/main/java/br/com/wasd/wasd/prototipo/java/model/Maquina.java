
package br.com.wasd.wasd.prototipo.java.model;


public class Maquina {
    
    private Integer maquina_id;
    private String nome;
    private String so;
    private Double cpu;
    private Double ram;
    private Double gpu;
    private String status;
    
    public Integer getMaquina_id() {
        return maquina_id;
    }

    public void setMaquina_id(Integer maquina_id) {
        this.maquina_id = maquina_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public Double getCpu() {
        return cpu;
    }

    public void setCpu(Double cpu) {
        this.cpu = cpu;
    }

    public Double getRam() {
        return ram;
    }

    public void setRam(Double ram) {
        this.ram = ram;
    }

    public Double getGpu() {
        return gpu;
    }

    public void setGpu(Double gpu) {
        this.gpu = gpu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}



