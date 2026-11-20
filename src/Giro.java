public class Giro extends Rekening {

    private long batasOverdraft;

    public Giro(int nomor, String pemilik, long saldo, long batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    @Override
    public boolean tarik(long jumlah) {
        if (saldo - jumlah < -batasOverdraft) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    @Override
    public long biayaAdmin() {
        return 15000;
    }

    @Override
    public String keterangan() {
        return "Giro, batas overdraft " + rupiah(batasOverdraft);
    }
}