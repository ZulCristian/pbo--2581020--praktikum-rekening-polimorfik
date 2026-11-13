public class BankPolimorfik {
    public static void main(String[] args) {
        Tabungan ani   = new Tabungan("101", "Ani", 1_000_000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300_000, 2.0);
        Giro budi      = new Giro("201", "Budi", 200_000, 500_000);

        Rekening[] semua    = { ani, citra, budi };
        BerBunga[] berbunga = { ani, citra };

        System.out.println("========== REKENING AWAL ==========");
        for (Rekening r : semua) r.tampilkan();

        System.out.println();
        System.out.println("========== AKHIR BULAN ============");
        for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();
            System.out.println(r.getNomor() + " biaya admin  : " + Rekening.rupiah(biaya));
        }
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();
            System.out.println(b.getNomor() + " bunga        : " + Rekening.rupiah(bunga));
        }

        System.out.println();
        System.out.println("========== REKENING AKHIR =========");
        int total = 0;
        for (Rekening r : semua) {
            r.tampilkan();
            total += r.getSaldo();
        }
        System.out.println("-----------------------------------");
        System.out.println("Total dana bank : " + Rekening.rupiah(total));

        // Rekening r = new Rekening("999", "Eko", 0);
        // Pesan errornya: Rekening is abstract; cannot be instantiated
    }
}