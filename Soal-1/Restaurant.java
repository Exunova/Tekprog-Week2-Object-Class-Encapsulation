public class Restaurant {

    private String[] namaMakanan;
    private double[] hargaMakanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        namaMakanan = new String[10];
        hargaMakanan = new double[10];
        stok = new int[10];
    }

    //Getter dan Setter
    public String getNamaMakanan(int index) {
        return namaMakanan[index];
    }
    public void setNamaMakanan(int index, String nama) {
        namaMakanan[index] = nama;
    }

    public double getHargaMakanan(int index) {
        return hargaMakanan[index];
    }

    public void setHargaMakanan(int index, double harga) {
        if (harga < 0) {
            harga = 0;
        }
        hargaMakanan[index] = harga;
    }

    public int getStok(int index) {
        return stok[index];
    }

    public void setStok(int index, int stokBaru) {
        if (stokBaru < 0) {
            System.out.println("Stok tidak boleh negatif");
            return;
        }
        stok[index] = stokBaru;
    }

    public int getJumlahMenu() {
        return id;
    }

    // ===== Fitur tambah menu =====
    public void tambahMenuMakanan(String nama, double harga, int stokAwal) {
        if (id >= namaMakanan.length) {
            System.out.println("Menu sudah penuh (maks 10 item).");
            return;
        }

        setNamaMakanan(id, nama);
        setHargaMakanan(id, harga);
        setStok(id, stokAwal);
        nextId();
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i < id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(
                    getNamaMakanan(i) + " [" + getStok(i) + "]\tRp. " + getHargaMakanan(i)
                );
            }
        }
    }

    private boolean isOutOfStock(int index) {
        return getStok(index) == 0;
    }

    private static void nextId() {
        id++;
    }

    //Pemesanan
    public void pesanMenu(String nama, int jumlah) {
        int idx = cariIndexMenu(nama);
        if (idx == -1) {
            System.out.println("Pesan ditolak: menu " + nama + " tidak ditemukan.");
            return;
        }
        if (jumlah <= 0) {
            System.out.println("Pesanan ditolak : Jumlah tidak boleh nol atau negatif.");
            return;
        }

        int stokSekarang = getStok(idx);

        if (stokSekarang < jumlah) {
            System.out.println("Pesanan ditolak : Stok tidak mencukupi, Stok yang tersedia = " + stokSekarang);
            return;
        }

        setStok(idx, stokSekarang - jumlah);
        System.out.println("Pesanan diterima: " + nama + " x" + jumlah);
    }

    private int cariIndexMenu(String nama) {
        for (int i = 0; i < id; i++) {
            String item = getNamaMakanan(i);
            if (item != null && item.equalsIgnoreCase(nama)) {
                return i;
            }
        }
        return -1;
    }
}
