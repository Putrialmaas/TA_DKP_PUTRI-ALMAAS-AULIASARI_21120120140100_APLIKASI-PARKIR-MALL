import javax.swing.*;

public class SetterGetter {
    private JTextField tfNo;
    private JTextField tfHargaParkir;
    private JTextField tfJamMasuk;
    private JTextField tfLamaParkir;
    private JTextField tfJamKeluar;
    private JTextField tfTaMasuk;
    private JTextField tfTaKeluar;
    private String JK;
    private String tfTotalBayar;

    public void setNomer (JTextField nomer) {
        this.tfNo = nomer;
    }
    public void setHarga (JTextField harga) {
        this.tfHargaParkir = harga;
    }
    public void setJamMasuk (JTextField jamMasuk) {
        this.tfJamMasuk = jamMasuk;
    }
    public void setJamKeluar (JTextField jamKeluar) {
        this.tfJamKeluar = jamKeluar;
    }
    public void setLamaParkir (JTextField lamaParkir) {
        this.tfLamaParkir = lamaParkir;
    }
    public void setTfTaMasuk (JTextField tanggalMasuk) {
        this.tfTaMasuk = tanggalMasuk;
    }
    public void setTfTaKeluar (JTextField tanggalKeluar) {
        this.tfTaKeluar = tanggalKeluar;
    }
    public void setJK (String jenisKendaraan) {
        this.JK = jenisKendaraan;
    }
    public void setTfTotalBayar (String totalBayar) {
        this.tfTotalBayar = totalBayar;
    }

    public String getNoKendaraan() {
        return tfNo.getText();
    }
    public String getHargaParkir() {
        return tfHargaParkir.getText();
    }
    public String getJamMasuk() {
        return tfJamMasuk.getText();
    }
    public String getJamkeluar() {
        return tfJamKeluar.getText();
    }
    public String getLamaParkir() {
        return tfLamaParkir.getText();
    }
    public String getTanggalMasuk() {
        return tfTaMasuk.getText();
    }
    public String getTanggalKeluar() {
        return tfTaKeluar.getText();
    }
    public String getJenisKendaraan() {
        return JK;
    }
    public String getTotalBayar() {
        return tfTotalBayar;
    }
}
