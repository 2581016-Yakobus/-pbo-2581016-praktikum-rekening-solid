import java.util.Locale;

public class Deposito extends Rekening implements BerBunga {

    private double sukuBunga;

    public Deposito(int nomor, String pemilik, long saldo, double sukuBunga) {
        super(nomor, pemilik, saldo);
        this.sukuBunga = sukuBunga;
    }

    // Hasil menjalankan versi awal (melempar exception):
    // Exception in thread "main" java.lang.UnsupportedOperationException: Deposito tidak bisa ditarik
    // Diperbaiki: sesuai kontrak Rekening.tarik, kembalikan false (tidak melempar exception)
    @Override
    public boolean tarik(long jumlah) {
        return false;
    }

    @Override
    public long biayaAdmin() {
        return 0;
    }

    @Override
    public long tambahBunga() {
        long bunga = Math.round(saldo * sukuBunga / 100);
        saldo += bunga;
        return bunga;
    }

    @Override
    public String keterangan() {
        return String.format(Locale.US, "Deposito, bunga %.1f%% per bulan", sukuBunga);
    }
}