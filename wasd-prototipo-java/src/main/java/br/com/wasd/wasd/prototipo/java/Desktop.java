/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java;

import br.com.wasd.wasd.prototipo.java.enums.TemperaturaAlerta;
import br.com.wasd.wasd.prototipo.java.model.dao.LogDao;
import br.com.wasd.wasd.prototipo.java.model.DiscoMaquina;
import br.com.wasd.wasd.prototipo.java.model.Log;
import br.com.wasd.wasd.prototipo.java.model.LogDisco;
import br.com.wasd.wasd.prototipo.java.model.Maquina;
import br.com.wasd.wasd.prototipo.java.model.dao.DiscoDao;
import br.com.wasd.wasd.prototipo.java.model.dao.LogDiscoDAO;
import br.com.wasd.wasd.prototipo.java.model.dao.MaquinaDao;
import br.com.wasd.wasd.prototipo.java.model.dao.ProcessosDao;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bianc
 */
public class Desktop extends javax.swing.JFrame {

    private Looca looca;
    private Sistema sistema;
    private Memoria memoria;
    private Processador processador;
    private DiscosGroup grupoDeDiscos;
    private Components componentes;
    private Maquina maquina;
    private ProcessosGroup grupoDeProcessos;
    private String hostname;
    private Integer idUser;
    MaquinaDao maquinaDao;

    /**
     * Creates new form Dash
     *
     * @throws java.net.UnknownHostException
     */
    public Desktop() throws UnknownHostException, InterruptedException {
        initComponents();

    }

    public Desktop(Integer idUser) throws UnknownHostException, InterruptedException {
        initComponents();
        looca = new Looca();
        grupoDeProcessos = looca.getGrupoDeProcessos();
        sistema = looca.getSistema();
        memoria = looca.getMemoria();
        processador = looca.getProcessador();
        grupoDeDiscos = looca.getGrupoDeDiscos();
        componentes = JSensors.get.components();
        idUser = this.idUser;
        hostname = InetAddress.getLocalHost().getHostName();
        maquinaDao = new MaquinaDao();
        maquina = (Maquina) maquinaDao.findOne(hostname);

        this.setLocationRelativeTo(null);
        getHardware();
        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    getHardwareUse();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Desktop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 0, 30000);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() {
                getProccess();
            }
        }, 0, 120000);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDisco = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProcessos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCpu = new javax.swing.JLabel();
        lblUsoMemoria = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSO = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCPU = new javax.swing.JLabel();
        lblMemoria = new javax.swing.JLabel();
        lblMemoriaDisponivel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        lblGpu = new javax.swing.JLabel();
        lblTempGpu = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(45, 52, 54));
        jPanel2.setPreferredSize(new java.awt.Dimension(620, 643));

        lblDisco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDisco.setForeground(new java.awt.Color(255, 255, 255));
        lblDisco.setText("0.0");

        tbProcessos.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

        }, new String[] { "Processo", "Uso CPU", "Uso Memória" }));
        jScrollPane1.setViewportView(tbProcessos);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Memória Usada:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Uso CPU:");

        lblCpu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCpu.setForeground(new java.awt.Color(255, 255, 255));
        lblCpu.setText("0.0");

        lblUsoMemoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsoMemoria.setForeground(new java.awt.Color(255, 255, 255));
        lblUsoMemoria.setText("0.0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Disco:");

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("nome");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CPU:");

        lblSO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSO.setForeground(new java.awt.Color(255, 255, 255));
        lblSO.setText("Sistema Operacional");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Memória:");

        lblCPU.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCPU.setForeground(new java.awt.Color(255, 255, 255));
        lblCPU.setText("0.0");

        lblMemoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMemoria.setForeground(new java.awt.Color(255, 255, 255));
        lblMemoria.setText("0.0");

        lblMemoriaDisponivel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMemoriaDisponivel.setForeground(new java.awt.Color(255, 255, 255));
        lblMemoriaDisponivel.setText("0.0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Memória Disponível:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("GPU:");

        lblGpu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGpu.setForeground(new java.awt.Color(255, 255, 255));
        lblGpu.setText("0.0");

        lblTempGpu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTempGpu.setForeground(new java.awt.Color(255, 255, 255));
        lblTempGpu.setText("0 °C");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Temperatura GPU:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Máquina");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2)
                .addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup().addGap(23, 23, 23).addComponent(jScrollPane1,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup().addGap(89, 89, 89)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblDisco))
                                        .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblCpu))
                                        .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblMemoriaDisponivel))
                                        .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblUsoMemoria))
                                        .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblTempGpu))))
                        .addGroup(jPanel2Layout.createSequentialGroup().addGap(91, 91, 91)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblCPU))
                                        .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblGpu))))
                        .addGroup(jPanel2Layout.createSequentialGroup().addGap(91, 91, 91).addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMemoria))
                        .addGroup(jPanel2Layout.createSequentialGroup().addGap(30, 30, 30).addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNome).addGap(18, 18, 18).addComponent(lblSO)))
                        .addContainerGap(23, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 702, Short.MAX_VALUE))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNome).addComponent(lblSO).addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2).addComponent(lblCPU))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4).addComponent(lblMemoria))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8).addComponent(lblGpu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9).addComponent(lblTempGpu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7).addComponent(lblMemoriaDisponivel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3).addComponent(lblUsoMemoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5).addComponent(lblCpu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6).addComponent(lblDisco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 517, Short.MAX_VALUE))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Desktop().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Desktop.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Desktop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void getHardware() throws UnknownHostException {

        DiscoDao discoDao = new DiscoDao();
        List<Disco> disco = grupoDeDiscos.getDiscos();
        List<Gpu> gpus = componentes.gpus;
        String so, cpu, gpuNome = "Sem GPU no sistema";
        Long ram = 0L;

        so = sistema.getSistemaOperacional();
        cpu = processador.getNome();
        ram = memoria.getTotal();

        if (gpus != null) {
            for (final Gpu gpu : gpus) {
                gpuNome = gpu.name;
            }
        }

        lblGpu.setText(gpuNome);
        lblCPU.setText(cpu);
        lblMemoria.setText(Conversor.formatarBytes(ram));
        lblSO.setText(so);
        lblNome.setText(hostname);

        if (maquina == null) {
            for (Disco d : disco) {
                DiscoMaquina discoMaquina = new DiscoMaquina(1, d.getNome(),
                        ConversorDouble.formatarBytes(d.getTamanho()));
                discoDao.insert(discoMaquina);
            }

            maquina = new Maquina(2, hostname, so, cpu, ConversorDouble.formatarBytes(ram), gpuNome, "pendente");

            maquinaDao.insert(maquina);
        }
    }

    public void getHardwareUse() throws InterruptedException {
        Long usoRam, usoDisco = 0L;
        Double usoCpu, temperaturaGpu = 0.0;

        List<Volume> discoVolume = grupoDeDiscos.getVolumes();
        List<Gpu> gpus = componentes.gpus;

        // Classe para inserção de dados
        LogDao logDao = new LogDao();
        LogDiscoDAO logDiscoDao = new LogDiscoDAO();

        usoCpu = processador.getUso();
        usoRam = memoria.getEmUso();

        if (gpus != null) {
            for (final Gpu gpu : gpus) {
                if (gpu.sensors != null) {
                    System.out.println("Sensors: ");
                    // Print temperatures
                    List<Temperature> temps = gpu.sensors.temperatures;
                    for (final Temperature temp : temps) {
                        System.out.println(temp.name + ": " + temp.value + " C");
                        temperaturaGpu = temp.value;
                        lblTempGpu.setText(temp.value + " C");
                    }
                }
            }
        }

        for (Volume volume : discoVolume) {
            usoDisco = volume.getDisponivel();
            lblDisco.setText(Conversor.formatarBytes(volume.getDisponivel()));
            
            LogDisco logDisco;
            logDisco = new LogDisco(1, 1, ConversorDouble.formatarBytes(volume.getDisponivel()));
            logDiscoDao.insert(logDisco);
        }

        // UPDATE DO STATUS
        String status;
        status = TemperaturaAlerta.fromTemperatura(temperaturaGpu);

        lblUsoMemoria.setText(Conversor.formatarBytes(usoRam));
        lblMemoriaDisponivel.setText(Conversor.formatarBytes(memoria.getDisponivel()));
        lblCpu.setText(usoCpu.toString());

        if (maquina != null) {
            Log log = new Log(maquina.getMaquina_id(), usoCpu, ConversorDouble.formatarBytes(usoRam),
                    ConversorDouble.formatarBytes(usoDisco), temperaturaGpu);
            logDao.insert(log);
        } else {
            //log 
        }
    }

    public void getProccess() {
        List<Processo> processos = grupoDeProcessos.getProcessos();
        DecimalFormat saida = new DecimalFormat("0.00");
        ProcessosDao processosDao = new ProcessosDao();

        DefaultTableModel model = (DefaultTableModel) tbProcessos.getModel();

        processos.forEach(processo -> {

            if (processosDao.findOne(processo.getNome()) != null) {
                ;
                ;
                processosDao.update(processo);
            } else {
                processosDao.insert(processo);
            }

            Object[] processosAtuais = { processo.getNome(), saida.format(processo.getUsoCpu()),
                    saida.format(processo.getUsoMemoria()) };
            model.addRow(processosAtuais);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCPU;
    private javax.swing.JLabel lblCpu;
    private javax.swing.JLabel lblDisco;
    private javax.swing.JLabel lblGpu;
    private javax.swing.JLabel lblMemoria;
    private javax.swing.JLabel lblMemoriaDisponivel;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSO;
    private javax.swing.JLabel lblTempGpu;
    private javax.swing.JLabel lblUsoMemoria;
    private javax.swing.JTable tbProcessos;
    // End of variables declaration//GEN-END:variables
}
