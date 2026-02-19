public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();

        menu.tambahMenuMakanan("Pizza", 250000, 20);
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);

        System.out.println("=== MENU AWAL ===");
        menu.tampilMenuMakanan();
        System.out.println("\n=== ORDER ===");
        menu.pesanMenu("Pizza", 2);
        menu.pesanMenu("Pizza", 100);
        menu.pesanMenu("Burger", 1);

        System.out.println("\n=== MENU SETELAH ORDER ===");
        menu.tampilMenuMakanan();
    }
}
