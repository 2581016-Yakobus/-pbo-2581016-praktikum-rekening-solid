import java.util.Locale;

public abstract class Rekening {

    protected int nomor;
    protected String pemilik;
    protected long saldo;

    public Rekening(int nomor, String pemilik, long saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public int getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setor(long jumlah) {
        saldo += jumlah;
    }

    // Kontrak tarik: true kalau berhasil, false kalau gagal, tidak pernah melempar exception.
    public abstract boolean tarik(long jumlah);

    // Potong biaya admin (bukan penarikan, jadi tidak lewat tarik)
    public void kurangiSaldo(long jumlah) {
        saldo -= jumlah;
    }

    public abstract long biayaAdmin();

    // Baris kedua laporan, misalnya "Tabungan, bunga 2.5% per bulan"
    public abstract String keterangan();

    // Format angka menjadi rupiah, misalnya 1000000 -> Rp1.000.000
    public static String rupiah(long jumlah) {
        return "Rp" + String.format(Locale.GERMANY, "%,d", jumlah);
    }
}