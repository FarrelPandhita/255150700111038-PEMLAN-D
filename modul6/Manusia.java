public class Manusia {
    private String nama;
    private boolean jenisKelamin; // true = laki-laki, false = perempuan
    private String nik;
    private boolean menikah;

    public Manusia(String nama, String nik, boolean jenisKelamin, boolean menikah) {
        this.nama = nama;
        this.nik = nik;
        this.jenisKelamin = jenisKelamin;
        this.menikah = menikah;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public boolean getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(boolean jenisKelamin) { this.jenisKelamin = jenisKelamin; }
    public String getNik() { return nik; }
    public void setNik(String nik) { this.nik = nik; }
    public boolean getMenikah() { return menikah; }
    public void setMenikah(boolean menikah) { this.menikah = menikah; }

    public double getTunjangan() {
        if (menikah) return jenisKelamin ? 25 : 20;
        return 15;
    }

    public double getPendapatan() {
        return getTunjangan();
    }

    @Override
    public String toString() {
        return "nama : " + nama +
               "\nnik : " + nik +
               "\njenisKelamin : " + (jenisKelamin ? "Laki-laki" : "Perempuan") +
               "\npendapatan : " + getPendapatan();
    }
}