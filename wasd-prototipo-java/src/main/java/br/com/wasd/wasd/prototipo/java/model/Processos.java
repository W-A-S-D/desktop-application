package br.com.wasd.wasd.prototipo.java.model;

public class Processos {

    private Integer processos_id;
    private Integer fk_maquina;
    private String nome;
    private String status;
    private String iniciado;
    private String encerrado;

    public Integer getProcessos_id() {
        return processos_id;
    }

    public void setProcessos_id(Integer processos_id) {
        this.processos_id = processos_id;
    }

    public Integer getFk_maquina() {
        return fk_maquina;
    }

    public void setFk_maquina(Integer fk_maquina) {
        this.fk_maquina = fk_maquina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIniciado() {
        return iniciado;
    }

    public void setIniciado(String iniciado) {
        this.iniciado = iniciado;
    }

    public String getEncerrado() {
        return encerrado;
    }

    public void setEncerrado(String encerrado) {
        this.encerrado = encerrado;
    }

}
