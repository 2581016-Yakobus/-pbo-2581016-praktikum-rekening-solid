import java.util.Locale;

public class Tabungan extends Rekening implements BerBunga {

    private double sukuBunga;

    public Tabungan(int nomor, String pemilik, long saldo, double sukuBunga) {
        super(nomor, pemilik, saldo);
        this.sukuBunga = sukuBunga;
    }

    @Override
    public boolean tarik(long jumlah) {
        if (jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    @Override
    public long biayaAdmin() {
        if (saldo >= 1000000) {
            return 0;
        }
        return 5000;
    }

    @Override
    public long tambahBunga() {
        long bunga = Math.round(saldo * sukuBunga / 100);
        saldo += bunga;
        return bunga;
    }

    @Override
    public String keterangan() {
        return String.format(Locale.US, "Tabungan, bunga %.1f%% per bulan", sukuBunga);
    }
}