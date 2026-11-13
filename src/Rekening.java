public abstract class Rekening {
    protected String nomor;
    protected String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor()   { return nomor; }
    public String getPemilik() { return pemilik; }
    public int getSaldo()      { return saldo; }

    public boolean tarik(int jumlah) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    public abstract int biayaAdminBulanan();

    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public abstract String info();

    public static String rupiah(int angka) {
        return "Rp" + String.format("%,d", angka).replace(',', '.');
    }

    public void tampilkan() {
        System.out.println(String.format("%s | %-6s | %11s", nomor, pemilik, rupiah(saldo)));
        System.out.println("      " + info());
    }
}