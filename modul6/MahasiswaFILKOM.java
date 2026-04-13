public class MahasiswaFILKOM extends Manusia {
    private String nim;
    private double ipk;

    public MahasiswaFILKOM(String nim, double ipk, String nama, String nik, boolean jenisKelamin, boolean menikah) {
        super(nama, nik, jenisKelamin, menikah);
        this.nim = nim;
        this.ipk = ipk;
    }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    public double getIpk() { return ipk; }
    public void setIpk(double ipk) { this.ipk = ipk; }

    // digit 1-2 = angkatan, digit 7 = kode prodi
    public String getStatus() {
        String angkatan = "20" + nim.substring(0, 2);
        String prodi = "";
        switch (nim.charAt(6)) {
            case '2': prodi = "Teknik Informatika"; break;
            case '3': prodi = "Teknik Komputer"; break;
            case '4': prodi = "Sistem Informasi"; break;
            case '6': prodi = "Pendidikan Teknologi Informasi"; break;
            case '7': prodi = "Teknologi Informasi"; break;
        }
        return prodi + ", " + angkatan;
    }

    // ipk 3.0-3.5 = $50, ipk 3.5-4.0 = $75
    public double getBeasiswa() {
        if (ipk >= 3.5) return 75;
        if (ipk >= 3.0) return 50;
        return 0;
    }

    @Override
    public double getPendapatan() {
        return getBeasiswa();
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nnim : " + nim +
               "\nipk : " + ipk +
               "\nstatus : " + getStatus();
    }
}
