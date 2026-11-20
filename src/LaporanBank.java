public class LaporanBank {

    private boolean sudahCetak = false;

    public void cetakJudul(String judul) {
        if (sudahCetak) {
            System.out.println();
        }
        System.out.println("========== " + judul + " ==========");
        sudahCetak = true;
    }

    public void cetakDaftar(String judul, Rekening[] semua) {
        cetakJudul(judul);
        for (Rekening r : semua) {
            System.out.printf("%d | %-6s | %11s%n", r.getNomor(), r.getPemilik(), Rekening.rupiah(r.getSaldo()));
            System.out.println("      " + r.keterangan());
        }
    }

    public void cetakTotal(Rekening[] semua) {
        long total = 0;
        for (Rekening r : semua) {
            total += r.getSaldo();
        }
        System.out.println("-----------------------------------");
        System.out.println("Total dana bank : " + Rekening.rupiah(total));
    }
}