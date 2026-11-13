public class Tabungan extends Rekening implements BerBunga {
    private double bungaPersen;

    public Tabungan(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) Math.round(saldo * bungaPersen / 100);
        saldo += bunga;
        return bunga;
    }

    @Override
    public int biayaAdminBulanan() {
        return saldo >= 1_000_000 ? 0 : 5_000;
    }

    @Override
    public String info() {
        return "Tabungan, bunga " + bungaPersen + "% per bulan";
    }
}