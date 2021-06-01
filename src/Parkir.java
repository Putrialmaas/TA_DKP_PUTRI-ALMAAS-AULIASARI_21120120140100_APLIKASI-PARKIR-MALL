import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Parkir {
    private JPanel ParkirPanel;
    private JRadioButton motorRadioButton, mobilRadioButton;
    private JButton prosesButton;
    private JButton keluarButton;
    private JTextField tfNo;
    private JTextField tfHargaParkir;
    private JTextField tfJamMasuk;
    private JTextField tfLamaParkir;
    private String tfTotalBayar;
    private JButton hapusButton;
    private JFrame f;
    private JTextField tfJamKeluar;
    private JTable tableParkir;
    private JTextField tfTaMasuk;
    private JTextField tfTaKeluar;
    private String JK;
    private ButtonGroup JenisKendaraan;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Parkir");
        frame.setContentPane(new Parkir().ParkirPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public Parkir() {
        prosesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetterGetter sg = new SetterGetter();
                PerhitunganTanggal pt = new PerhitunganTanggal();
                sg.setNomer(tfNo);
                sg.setHarga(tfHargaParkir);
                sg.setJamMasuk(tfJamMasuk);
                sg.setJamKeluar(tfJamKeluar);
                sg.setLamaParkir(tfLamaParkir);
                sg.setTfTaMasuk(tfTaMasuk);
                sg.setTfTaKeluar(tfTaKeluar);
                sg.setJK(JK);
                int c = Integer.parseInt(sg.getHargaParkir());
                double d = Double.parseDouble(sg.getLamaParkir());
                double hitung1 = d * Double.parseDouble(sg.getHargaParkir());
                pt.perhitunganTanggal (sg.getTanggalMasuk(), sg.getTanggalKeluar());
                pt.perhitunganJam(Double.parseDouble(sg.getJamMasuk()), Double.parseDouble(sg.getJamkeluar()), Integer.parseInt(sg.getHargaParkir()));
                tfTotalBayar = Double.toString(pt.ambilHasil());
                sg.setTfTotalBayar(tfTotalBayar);

                DefaultTableModel model = (DefaultTableModel) tableParkir.getModel();
                model.addRow(new Object[]{
                        sg.getNoKendaraan(),
                        sg.getJenisKendaraan(),
                        sg.getHargaParkir(),
                        sg.getJamMasuk(),
                        sg.getJamkeluar(),
                        sg.getTanggalMasuk(),
                        sg.getTanggalKeluar(),
                        sg.getLamaParkir(),
                        sg.getTotalBayar()
                });
                kosongkanField();
            }
        });
        motorRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfHargaParkir.setText("2000");
                JK = "Motor";
                if (motorRadioButton.isSelected()){
                    mobilRadioButton.setSelected(false);
                }
            }
        });
        mobilRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfHargaParkir.setText("4000");
                JK = "Mobil";
                if (mobilRadioButton.isSelected()){
                    motorRadioButton.setSelected(false);
                }
            }
        });
        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNo.setText("");
                tfJamMasuk.setText("");
                tfLamaParkir.setText("");
                tfHargaParkir.setText("");
                tfJamKeluar.setText("");
                tfTaMasuk.setText("");
                tfTaKeluar.setText("");
                mobilRadioButton.setSelected(false);
                motorRadioButton.setSelected(false);
                DefaultTableModel model = (DefaultTableModel) tableParkir.getModel();
                model.setRowCount(0);
            }
        });
        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int konfirmasi = JOptionPane.showConfirmDialog(f, "Apakah anda yakin ingin keluar?","Pilih", JOptionPane.YES_NO_OPTION);
                if (konfirmasi ==JOptionPane.YES_OPTION) {
                   JOptionPane.showMessageDialog(f, "Program akan keluar");
                   System.exit(0);
                }
            }
        });
        tfLamaParkir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                double a = Double.parseDouble(tfJamMasuk.getText());
                double b = Double.parseDouble(tfJamKeluar.getText());
                int c = Integer.parseInt(tfHargaParkir.getText());
                PerhitunganTanggal pt = new PerhitunganTanggal();
                pt.perhitunganJam(a, b, c);
                tfLamaParkir.setText(String.valueOf(pt.ambiljam()));
            }
        });
    }
    public void kosongkanField(){
        tfNo.setText("");
        tfJamMasuk.setText("");
        tfLamaParkir.setText("");
        tfHargaParkir.setText("");
        tfJamKeluar.setText("");
        tfTaMasuk.setText("");
        tfTaKeluar.setText("");
        motorRadioButton.setSelected(false);
        mobilRadioButton.setSelected(false);
    }
    String kolom [] = {"No. Kendaraan", "Jenis Kendaraan", "Harga Parkir", "Jam Masuk", "Jam Keluar", "Tanggal Masuk", "Tanggal Keluar","Lama Parkir", "Total Bayar"};
    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model = new DefaultTableModel(0,9);
        model.setColumnIdentifiers(kolom);
        tableParkir = new JTable(model);
    }

}