import java.util.Locale;

public class Deposito extends Rekening implements BerBunga {

    private double sukuBunga;

    public Deposito(int nomor, String pemilik, long saldo, double sukuBunga) {
        super(nomor, pemilik, saldo);
        this.sukuBunga = sukuBunga;
    }

    @Override
    public boolean tarik(long jumlah) {
        throw new UnsupportedOperationException("Deposito tidak bisa ditarik");
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