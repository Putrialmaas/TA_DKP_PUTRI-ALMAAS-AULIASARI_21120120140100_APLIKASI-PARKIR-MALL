import javax.swing.*;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PerhitunganTanggal {
    private SimpleDateFormat tanggal = new SimpleDateFormat("dd-MM-yyyy");
    private long hasilPerhitunganTanggal;
    private double hasilAkhir, hasilPerhitunganJam;


    public void  perhitunganTanggal (String tm, String tk) {
        long hasil = 0;
        try {
            Date d1 = tanggal.parse(tm);
            Date d2 = tanggal.parse(tk);

            if (d1.getTime() == d2.getTime()) {

                long perbedaanWaktu = d2.getTime() - d1.getTime();

                TimeUnit time = TimeUnit.DAYS;
                hasil = time.convert(perbedaanWaktu, TimeUnit.MILLISECONDS);

                this.hasilPerhitunganTanggal = hasil;

            } else if (d1.getTime() != d2.getTime()){

                long perbedaanWaktu = d2.getTime() - d1.getTime();

                TimeUnit time = TimeUnit.DAYS;
                hasil = time.convert(perbedaanWaktu, TimeUnit.MILLISECONDS);

                this.hasilPerhitunganTanggal = hasil;


            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public long ambilSelisihTgl(){

        return hasilPerhitunganTanggal;
    }

    public void perhitunganJam(double jamMasuk, double jamKeluar, int hargaParkir){

        double hitung1, hitung2 = 0, hitung3 = 0;

        if (jamKeluar > jamMasuk ) {

            hitung2 = jamKeluar - jamMasuk;
            this.hasilPerhitunganJam = hitung2;

        } else if (jamKeluar < jamMasuk) {

            hitung1 = 24.00 - jamMasuk;
            hitung2 = hitung1 + jamKeluar;
            this.hasilPerhitunganJam = hitung2;
        }

        if(hargaParkir == 2000){

            hitung3 = hitung2 * 2000;


        }else if(hargaParkir == 4000){

            hitung3 = hitung2 * 4000;

        }

        if(ambilSelisihTgl() == 0){

            this.hasilAkhir = hitung3;

        }else if(ambilSelisihTgl() > 0){

            this.hasilAkhir = (hitung3 + (ambilSelisihTgl() - 1) * 5000);
        }


    }

    public double ambilHasil(){

        return hasilAkhir;
    }
    public double ambiljam(){
        return hasilPerhitunganJam;
    }
}
