package TaskManagement.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import TaskManagement.DataDiri;
import TaskManagement.Status;
import TaskManagement.Tugas;

import java.util.List;
import java.util.ArrayList;

public class TaskGUI {
    private JFrame frame;
    private TaskManagement.DataDiri dataDiri;
    public List<Tugas> tugasList = new ArrayList<Tugas>();

    public TaskGUI() {

        frame = new JFrame("Task Management Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dataDiri = initializeDataDiri();

        createMenuPanel();
        createTaskListPanel();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        frame.getContentPane().setBackground(Color.black);
    }

    private TaskManagement.DataDiri initializeDataDiri() {
        String nama = JOptionPane.showInputDialog(frame, "Masukkan nama:");
        String npm = JOptionPane.showInputDialog(frame, "Masukkan NPM:");
        String jurusan = JOptionPane.showInputDialog(frame, "Masukkan jurusan:");
        String fakultas = JOptionPane.showInputDialog(frame, "Masukkan fakultas:");

        return new TaskManagement.DataDiri(nama, npm, jurusan, fakultas);
    }

    private void createMenuPanel() {
        JPanel menuPanel = new JPanel();

        // menampilkan data diri
        JButton dataDiriButton = new JButton("Data Diri");
        dataDiriButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDataDiriDialog();
            }
        });

        JButton tambahButton = new JButton("Tambah Tugas");
        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTambahTugasDialog();
            }
        });

        JButton lihatButton = new JButton("Lihat Tugas");
        lihatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLihatTugasDialog();
            }
        });

        JButton hapusButton = new JButton("Hapus Tugas");
        hapusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showHapusTugasDialog();
            }
        });

        JButton searchMatkulButton = new JButton("Cari Tugas by Matkul");
        searchMatkulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSearchMatkulDialog();
            }
        });

        JButton editButton = new JButton("Edit Tugas");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showEditTugasDialog(dataDiri);
            }
        });

        JButton keluarButton = new JButton("Keluar");
        keluarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        dataDiriButton.setBackground(Color.white);
        tambahButton.setBackground(Color.white);
        lihatButton.setBackground(Color.white);
        hapusButton.setBackground(Color.white);
        searchMatkulButton.setBackground(Color.white);
        editButton.setBackground(Color.white);
        keluarButton.setBackground(Color.white);

        menuPanel.add(dataDiriButton);
        menuPanel.add(tambahButton);
        menuPanel.add(lihatButton);
        menuPanel.add(hapusButton);
        menuPanel.add(searchMatkulButton);
        menuPanel.add(editButton);
        menuPanel.add(keluarButton);

        frame.getContentPane().add(menuPanel, "North");
    }

    private void createTaskListPanel() {
        JPanel taskListPanel = new JPanel();

        JTextArea taskTextArea = new JTextArea();
        taskTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(taskTextArea);

        taskListPanel.setLayout(new BorderLayout());
        taskListPanel.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(taskListPanel, BorderLayout.CENTER);
    }

    private void showDataDiriDialog() {
          String dataDiri = TaskGUI.this.dataDiri.toString();
                JTextArea textArea = new JTextArea(dataDiri);
                JScrollPane scrollPane = new JScrollPane(textArea);

                JDialog dialog = new JDialog(frame, "Data Diri", Dialog.ModalityType.APPLICATION_MODAL);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                // Set the size of the dialog to full-screen
                dialog.setSize(Toolkit.getDefaultToolkit().getScreenSize());

                // Set the content of the dialog
                dialog.add(scrollPane);

                dialog.setVisible(true);
    }

    private void showTambahTugasDialog() {
        String judul = JOptionPane.showInputDialog(frame, "Masukkan Judul Tugas:");
        String matkul = JOptionPane.showInputDialog(frame, "Masukkan Matkul:");
        String deadline = JOptionPane.showInputDialog(frame, "Masukkan Deadline:");
        String dosen = JOptionPane.showInputDialog(frame, "Masukkan Dosen:");
        String deskripsi = JOptionPane.showInputDialog(frame, "Masukkan Deskripsi:");
        String status = JOptionPane.showInputDialog(frame, "Apakah informasi tugas sudah lengkap? (y/n):");

        Tugas tugas = new Tugas(judul, matkul, deadline, dosen, deskripsi, status);
        dataDiri.addTugas(tugas);
    }

    private void showLihatTugasDialog() {
        String tugasList = dataDiri.getTugasList();
        JTextArea textArea = new JTextArea(tugasList);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JDialog dialog = new JDialog(frame, "Daftar Tugas", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Set the size of the dialog to full-screen
        dialog.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        // Set the content of the dialog
        dialog.add(scrollPane);

        dialog.setVisible(true);
    }

    private void showHapusTugasDialog() {
        String judul = JOptionPane.showInputDialog(frame, "Masukkan Judul Tugas yang ingin dihapus:");
        boolean isRemoved = dataDiri.removeTugas(judul);

        if (isRemoved) {
            JOptionPane.showMessageDialog(null, "Tugas berhasil dihapuskan.", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Tugas tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showSearchMatkulDialog() {
        String matkul = JOptionPane.showInputDialog(frame, "Masukkan Matkul yang ingin dicari:");
        String tugasList = dataDiri.searchMatkul(matkul);
        JTextArea textArea = new JTextArea(tugasList);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JDialog dialog = new JDialog(frame, "Daftar Tugas", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Set the size of the dialog to full-screen
        dialog.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        // Set the content of the dialog
        dialog.add(scrollPane);

        dialog.setVisible(true);
    }

    public DataDiri getDataDiri() {
        return dataDiri;
    }

    private void showEditTugasDialog(DataDiri data) {
        String judul = JOptionPane.showInputDialog("Masukkan judul tugas yang ingin diubah:");

        if (judul == null || judul.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid input. Task title cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Tugas tugas : data.tugasList) {
            if (tugas.getJudul().equals(judul)) {
                // Task found, now display an edit dialog
                String[] options = { "Judul", "Matkul", "Deadline", "Dosen", "Deskripsi", "Status" };
                int choice = JOptionPane.showOptionDialog(null, "Pilih bagian yang ingin diubah:", "Edit Task",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (choice == -1) {
                    // DataDiri clicked cancel or closed the dialog
                    return;
                }

                switch (choice) {
                    case 0:
                        String newJudul = JOptionPane.showInputDialog("Masukkan judul yang baru:", tugas.getJudul());
                        if (newJudul != null && !newJudul.isEmpty()) {
                            tugas.setJudul(newJudul);
                            JOptionPane.showMessageDialog(null, "Judul berhasil diubah.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input. Task title cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 1:
                        String newMatkul = JOptionPane.showInputDialog("Masukkan matkul yang baru:", tugas.getMatkul());
                        if (newMatkul != null) {
                            tugas.setMatkul(newMatkul);
                            JOptionPane.showMessageDialog(null, "Matkul berhasil diubah.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 2:
                        String newDeadline = JOptionPane.showInputDialog("Masukkan deadline yang baru:", tugas.getDeadline());
                        if (newDeadline != null) {
                            tugas.setDeadline(newDeadline);
                            JOptionPane.showMessageDialog(null, "Deadline berhasil diubah.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 3:
                        String newDosen = JOptionPane.showInputDialog("Masukkan nama dosen yang baru:", tugas.getDosen());
                        if (newDosen != null) {
                            tugas.setDosen(newDosen);
                            JOptionPane.showMessageDialog(null, "Dosen berhasil diubah.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 4:
                        String newDeskripsi = JOptionPane.showInputDialog("Masukkan deskripsi tugas yang baru:", tugas.getDeskripsi());
                        if (newDeskripsi != null) {
                            tugas.setDeskripsi(newDeskripsi);
                            JOptionPane.showMessageDialog(null, "Deskripsi tugas berhasil diubah.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 5:
                        String[] statusOptions = { "Selesai", "Belum Selesai", "Tertunda" };
                        int statusChoice = JOptionPane.showOptionDialog(null, "Pilih status yang baru:", "Edit Task Status", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, statusOptions,statusOptions[0]);

                        if (statusChoice != -1) {
                            switch (statusChoice) {
                                case 0:
                                    tugas.setStatus(Status.SELESAI);
                                    break;
                                case 1:
                                    tugas.setStatus(Status.BELUM_SELESAI);
                                    break;
                                case 2:
                                    tugas.setStatus(Status.TERTUNDA);
                                    break;
                            }
                            JOptionPane.showMessageDialog(null, "Status berhasil diubah.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    default:
                        // Unexpected choice
                        break;
                }
                return;
            }
        }

        // Task not found
        JOptionPane.showMessageDialog(null, "Tugas dengan judul '" + judul + "' tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
    }

}
