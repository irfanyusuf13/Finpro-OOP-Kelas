package TaskManagement;

public class Tugas {
    private String judul;
    private String matkul;
    private String dosen;
    private String deskripsi;
    private String deadline;
    private Status status;

    public Tugas() {
    }

    public Tugas(String judul, String matkul, String deadline, String dosen, String deskripsi, String status) {
        this.judul = judul;
        this.matkul = matkul;
        this.dosen = dosen;
        this.deskripsi = deskripsi;
        this.deadline = deadline;

        if (status.equals("Belum Selesai")) {
            this.status = Status.BELUM_SELESAI;
        } else if (status.equals("Selesai")) {
            this.status = Status.SELESAI;
        } else if (status.equals("Tertunda")) {
            this.status = Status.TERTUNDA;
        } else
            this.status = Status.BELUM_SELESAI;
    }

    public String getJudul() {
        return judul;
    }

    public String getMatkul() {
        return matkul;
    }

    public String getDosen() {
        return dosen;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getDeadline() {
        return deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
