package TaskManagement;
// Source code is decompiled from a .class file using FernFlower decompiler.


import java.util.Scanner;
import javax.swing.*;

import TaskManagement.GUI.TaskGUI;
import java.io.FileWriter;
import java.io.IOException;

public class Application {
    public static String nama;
    public static String npm;
    public static String jurusan;
    public static String fakultas;
    public static Scanner input;

    public Application() {
    }

    public static void main(String[] args) {
        input = new Scanner(System.in);

        SwingUtilities.invokeLater(() -> {
            TaskGUI app = new TaskGUI();
            DataDiri dataDiri = app.getDataDiri();
        });


        System.out.println("Selamat Datang di Aplikasi Manajemen Tugas");
        System.out.print("\nMasukkan nama\t\t: ");
        nama = input.nextLine();
        System.out.print("Masukkan NPM\t\t: ");
        npm = input.nextLine();
        System.out.print("Masukkan jurusan anda\t: ");
        jurusan = input.nextLine();
        System.out.print("Masukkan fakultas anda\t: ");
        fakultas = input.nextLine();

        DataDiri data = new DataDiri(nama, npm, jurusan, fakultas);
        
        Application Pilihan = new Application();
        Pilihan.menu(data);
    }

    public void menu(DataDiri data) {
        System.out.println("\n--- MENU APLIKASI ---");
        System.out.println("1. Tambah Tugas");
        System.out.println("2. Lihat Tugas");
        System.out.println("3. Hapus Tugas");
        System.out.println("4. Edit");
        System.out.println("5. Keluar");
        System.out.print("Masukkan pilihan\t: ");
        int Pilihan = input.nextInt();
        String judul;
        switch (Pilihan) {
            case 1:
                System.out.println("\n--- TAMBAH TUGAS ---");
                System.out.print("\nJudul\t\t: ");
                input.nextLine();
                judul = input.nextLine();
                System.out.print("Matkul\t\t: ");
                String matkul = input.nextLine();
                System.out.print("Deadline\t: ");
                String deadline = input.nextLine();
                System.out.print("Dosen\t\t: ");
                String dosen = input.nextLine();
                System.out.print("Deskripsi\t: ");
                String deskripsi = input.nextLine();
                System.out.println("Apakah informasi tugas sudah lengkap? (y/n)");
                String status = input.nextLine();
                String s;
                if (status.equals("n")) {
                    s = "Tertunda";
                } else {
                    s = "Belum Selesai";
                }

                data.tugas = new Tugas(judul, matkul, deadline, dosen, deskripsi, s);
                data.addTugas(data.tugas);
                this.menu(data);
                break;
            case 2:
                data.getTugasList();
                this.menu(data);
                break;
            case 3:
                System.out.println("\n--- HAPUS TUGAS ---");
                input.nextLine();
                System.out.print("\nJudul\t\t: ");
                judul = input.nextLine();
                data.removeTugas(judul);
                this.menu(data);
                break;
            case 4:
                this.menuEdit(data);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                this.menu(data);
        }

    }

    public void menuEdit(DataDiri data) {
        System.out.println("\n--- EDIT TUGAS ---");
        System.out.println("\nMenu Edit : ");
        System.out.println("1. Judul");
        System.out.println("2. Matkul");
        System.out.println("3. Deadline");
        System.out.println("4. Dosen");
        System.out.println("5. Deskripsi");
        System.out.println("6. Status");
        System.out.println("7. Kembali");
        System.out.print("Masukkan pilihan\t: ");
        int Pilihan = input.nextInt();
        String judul;
        switch (Pilihan) {
            case 1:
                input.nextLine();
                System.out.print("\nJudul tugas\t\t: ");
                judul = input.nextLine();
                data.editJudul(judul);
                this.menu(data);
                break;
            case 2:
                input.nextLine();
                System.out.print("\nJudul tugas\t\t: ");
                judul = input.nextLine();
                data.editMatkul(judul);
                this.menu(data);
                break;
            case 3:
                input.nextLine();
                System.out.print("\nJudul tugas\t\t: ");
                judul = input.nextLine();
                data.editDeadline(judul);
                this.menu(data);
                break;
            case 4:
                input.nextLine();
                System.out.print("\nJudul tugas\t\t: ");
                judul = input.nextLine();
                data.editDosen(judul);
                this.menu(data);
                break;
            case 5:
                input.nextLine();
                System.out.print("\nJudul tugas\t\t: ");
                judul = input.nextLine();
                data.editDeskripsi(judul);
                this.menu(data);
                break;
            case 6:
                input.nextLine();
                System.out.print("\nJudul tugas\t\t: ");
                judul = input.nextLine();
                data.editStatus(judul);
                this.menu(data);
                break;
            case 7:
                this.menu(data);
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                this.menuEdit(data);
        }

    }

    static {
        input = new Scanner(System.in);
    }
}
