package TaskManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataDiri {
    private String nama, npm, jurusan, fakultas;
    public Tugas tugas = null;
    public List<Tugas> tugasList = new ArrayList<Tugas>();
    Scanner Input = new Scanner(System.in);

    public DataDiri(String nama, String npm, String jurusan, String fakultas) {
        this.nama = nama;
        this.npm = npm;
        this.jurusan = jurusan;
        this.fakultas = fakultas;
    }

    public void addTugas(Tugas tugas) {
        tugasList.add(tugas);
        System.out.println("Tugas " + tugas.getJudul() + " berhasil ditambahkan");
    }

    public boolean removeTugas(String judul) {
        if (tugasList.isEmpty()) {
            return false;
        }

        for (Tugas tugas : tugasList) {
            if (tugas.getJudul().equals(judul)) {
                tugasList.remove(tugas);
                System.out.println("Tugas " + judul + " berhasil dihapus");
                return true;
            }
        }

        return false;
    }

    public String getTugasList() {
        if (tugasList.isEmpty()) {
            return "Tidak ada tugas";
        }

        StringBuilder tugasListStr = new StringBuilder("\n--- DAFTAR TUGAS ---\n\n");
        for (Tugas tugas : tugasList) {
            tugasListStr.append("Judul Tugas\t\t: " + tugas.getJudul()).append("\n");
            tugasListStr.append("Mata Kuliah\t\t: " + tugas.getMatkul()).append("\n");
            tugasListStr.append("Dosen\t\t: " + tugas.getDosen()).append("\n");
            tugasListStr.append("Deskripsi\t\t: " + tugas.getDeskripsi()).append("\n");
            tugasListStr.append("Deadline\t\t: " + tugas.getDeadline()).append("\n");
            tugasListStr.append("Status\t\t: " + tugas.getStatus()).append("\n\n");
        }

        return tugasListStr.toString();
    }

    public void editJudul(String judul) {
        if (tugasList.isEmpty()) {
            System.out.println("Tidak ada tugas");
            return;
        }

        for (Tugas tugas : tugasList) {
            if (tugas.getJudul().equals(judul)) {
                System.out.println("Judul Tugas\t\t: " + tugas.getJudul());
                System.out.println("Mata Kuliah\t\t: " + tugas.getMatkul());
                System.out.println("Dosen\t\t: " + tugas.getDosen());
                System.out.println("Deskripsi\t\t: " + tugas.getDeskripsi());
                System.out.println("Deadline\t: " + tugas.getDeadline());
                System.out.println("Status\t\t: " + tugas.getStatus());
                System.out.print("Masukkan judul baru\t: ");
                tugas.setJudul(Input.nextLine());
                System.out.println("Judul tugas berhasil diubah");
                return;
            }
        }

        System.out.println("\nTugas tidak ditemukan\n");
        return;
    }

    public void editMatkul(String judul) {
        if (tugasList.isEmpty()) {
            System.out.println("Tidak ada tugas");
            return;
        }

        for (Tugas tugas : tugasList) {
            if (tugas.getJudul().equals(judul)) {
                System.out.println("Judul Tugas\t\t: " + tugas.getJudul());
                System.out.println("Mata Kuliah\t\t: " + tugas.getMatkul());
                System.out.println("Dosen\t\t\t: " + tugas.getDosen());
                System.out.println("Deskripsi\t\t: " + tugas.getDeskripsi());
                System.out.println("Deadline\t: " + tugas.getDeadline());
                System.out.println("Status\t\t\t: " + tugas.getStatus());
                System.out.print("Masukkan mata kuliah baru\t: ");
                tugas.setMatkul(Input.nextLine());
                System.out.println("Mata kuliah berhasil diubah");
                return;
            }
        }
        System.out.println("\nTugas tidak ditemukan\n");
        return;
    }

    public void editDosen(String judul) {
        if (tugasList.isEmpty()) {
            System.out.println("Tidak ada tugas");
            return;
        }

        for (Tugas tugas : tugasList) {
            if (tugas.getJudul().equals(judul)) {
                System.out.println("Judul .Tugas\t\t: " + tugas.getJudul());
                System.out.println("Mata Kuliah\t\t: " + tugas.getMatkul());
                System.out.println("Dosen\t\t\t: " + tugas.getDosen());
                System.out.println("Deskripsi\t\t: " + tugas.getDeskripsi());
                System.out.println("Deadline\t: " + tugas.getDeadline());
                System.out.println("Status\t\t\t: " + tugas.getStatus());
                System.out.print("Masukkan dosen baru\t: ");
                tugas.setDosen(Input.nextLine());
                System.out.println("Dosen berhasil diubah");
                return;
            }
        }
        System.out.println("\nTugas tidak ditemukan\n");
        return;
    }

    public void editDeskripsi(String judul) {
        if (tugasList.isEmpty()) {
            System.out.println("Tidak ada tugas");
            return;
        }

        for (Tugas tugas : tugasList) {
            if (tugas.getJudul().equals(judul)) {
                System.out.println("Judul Tugas\t\t: " + tugas.getJudul());
                System.out.println("Mata Kuliah\t\t: " + tugas.getMatkul());
                System.out.println("Dosen\t\t\t: " + tugas.getDosen());
                System.out.println("Deskripsi\t\t: " + tugas.getDeskripsi());
                System.out.println("Deadline\t: " + tugas.getDeadline());
                System.out.println("Status\t\t\t: " + tugas.getStatus());
                System.out.print("Masukkan deskripsi baru\t: ");
                tugas.setDeskripsi(Input.nextLine());
                System.out.println("Deskripsi berhasil diubah");
                return;
            }
        }
        System.out.println("\nTugas tidak ditemukan\n");
        return;
    }

    public void editDeadline(String judul) {
        if (tugasList.isEmpty()) {
            System.out.println("Tidak ada tugas");
            return;
        }

        for (Tugas tugas : tugasList) {
            if (tugas.getJudul().equals(judul)) {
                System.out.println("Judul Tugas\t\t: " + tugas.getJudul());
                System.out.println("Mata Kuliah\t\t: " + tugas.getMatkul());
                System.out.println("Dosen\t\t\t: " + tugas.getDosen());
                System.out.println("Deskripsi\t\t: " + tugas.getDeskripsi());
                System.out.println("Deadline\t: " + tugas.getDeadline());
                System.out.println("Status\t\t\t: " + tugas.getStatus());
                System.out.print("Masukkan deadline baru\t: ");
                tugas.setDeadline(Input.nextLine());
                System.out.println("Deadline berhasil diubah");
                return;
            }
        }
        System.out.println("\nTugas tidak ditemukan\n");
        return;
    }

    public void editStatus(String judul) {
        if (tugasList.isEmpty()) {
            System.out.println("Tidak ada tugas");
            return;
        }

        for (Tugas tugas : tugasList) {
            if (tugas.getJudul().equals(judul)) {
                System.out.println("Judul Tugas\t\t: " + tugas.getJudul());
                System.out.println("Mata Kuliah\t\t: " + tugas.getMatkul());
                System.out.println("Dosen\t\t\t: " + tugas.getDosen());
                System.out.println("Deskripsi\t\t: " + tugas.getDeskripsi());
                System.out.println("Deadline\t: " + tugas.getDeadline());
                System.out.println("Status\t\t\t: " + tugas.getStatus());
                System.out.print("Masukkan status baru\t: \n1. Selesai\n2. Belum Selesai\n3. Tertunda\n ");
                int pilihan = Input.nextInt();

                if (pilihan == 1) {
                    tugas.setStatus(Status.SELESAI);
                } else if (pilihan == 2) {
                    tugas.setStatus(Status.BELUM_SELESAI);
                } else if (pilihan == 3) {
                    tugas.setStatus(Status.TERTUNDA);
                } else {
                    System.out.println("Pilihan tidak tersedia");
                    return;
                }

                System.out.println("Status berhasil diubah");
                return;
            }
        }
        System.out.println("\nTugas tidak ditemukan\n");
        return;
    }

    public String searchMatkul(String matkul) {
        StringBuilder output = new StringBuilder();

        if (tugasList.isEmpty()) {
            output.append("Tidak ada tugas");
            return output.toString();
        }

        output.append("\n--- DAFTAR TUGAS " + matkul + " ---\n");
        for (Tugas tugas : tugasList) {
            if (tugas.getMatkul().equals(matkul)) {
                output.append("Nama Tugas\t\t: " + tugas.getJudul() + "\n");
                output.append("Mata Kuliah\t\t: " + tugas.getMatkul() + "\n");
                output.append("Dosen\t\t: " + tugas.getDosen() + "\n");
                output.append("Deskripsi\t\t: " + tugas.getDeskripsi() + "\n");
                output.append("Deadline\t\t: " + tugas.getDeadline() + "\n");
                output.append("Status\t\t: " + tugas.getStatus() + "\n");
                output.append("\n");
            }
        }

        if (output.length() == 0) {
            output.append("\nTugas tidak ditemukan\n");
        }

        return output.toString();
    }

    public String toString() {
        return "Nama\t\t: " + this.nama + "\nNPM\t\t: " + this.npm + "\nJurusan\t\t: " + this.jurusan
                + "\nFakultas\t\t: " + this.fakultas;
    }

}
