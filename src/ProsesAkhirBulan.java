public class ProsesAkhirBulan {

    public void potongBiayaAdmin(Rekening[] semua) {
        for (Rekening r : semua) {
            long biaya = r.biayaAdmin();
            r.kurangiSaldo(biaya);
            System.out.printf("%d %-13s: %s%n", r.getNomor(), "biaya admin", Rekening.rupiah(biaya));
        }
    }

    public void tambahBunga(BerBunga[] berbunga) {
        for (BerBunga b : berbunga) {
            long bunga = b.tambahBunga();
            System.out.printf("%d %-13s: %s%n", b.getNomor(), "bunga", Rekening.rupiah(bunga));
        }
    }

    public void autodebet(Rekening[] semua, int jumlah) {
        for (Rekening r : semua) {
            boolean berhasil = r.tarik(jumlah);
            String hasil;
            if (berhasil) {
                hasil = Rekening.rupiah(jumlah);
            } else {
                hasil = "gagal";
            }
            System.out.printf("%d %-13s: %s%n", r.getNomor(), "autodebet", hasil);
        }
    }
}