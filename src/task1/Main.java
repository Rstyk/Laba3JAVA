package task1;

import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CottageManager myCottageManager = new CottageManager();

        Amenity wifi = new Amenity("WiFi", 10, 0, 10);
        Amenity kitchen = new Amenity("Kitchen", 20, 0, 100);
        Amenity sofa = new Amenity("Sofa", 30, 1, 20);
        Amenity crib = new Amenity("Crib", 15, 1, 50);

        Cottage cottage1 = new Cottage("Big one", "Luxury", 200, 4, 4, 1000);
        cottage1.addAmenity(wifi);
        cottage1.addAmenity(sofa);

        Cottage cottage2 = new Cottage("Not big", "Standard", 100, 3, 3, 100);
        cottage2.addAmenity(crib);
        cottage2.addAmenity(kitchen);

        myCottageManager.addCottage(cottage1);
        myCottageManager.addCottage(cottage2);

        System.out.println("All amenities for Cottage 1:");
        List<Amenity> allAmenitiesCottage1 = cottage1.getAmenities();
        for (Amenity amenity : allAmenitiesCottage1) {
            System.out.println(amenity.getName());
        }

        try {
            Calendar startDate = Calendar.getInstance();
            Calendar endDate = Calendar.getInstance();
            startDate.set(2024, Calendar.NOVEMBER, 1);
            endDate.set(2024, Calendar.NOVEMBER, 5);
            cottage1.bookCottage("John Doe", startDate, endDate);
            myCottageManager.updateTotalIncome(cottage1.getIncome());
        } catch (BookingException e) {
            System.out.println(e.getMessage());
        }

        try {
            Calendar startDate = Calendar.getInstance();
            Calendar endDate = Calendar.getInstance();
            startDate.set(2024, Calendar.NOVEMBER, 1);
            endDate.set(2024, Calendar.NOVEMBER, 5);
            cottage2.bookCottage("Jane Smith", startDate, endDate);
            myCottageManager.updateTotalIncome(cottage2.getIncome());
        } catch (BookingException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Cottages with WiFi:");
        List<Cottage> cottagesWithWifi = myCottageManager.filterCottagesByAmenity("WiFi");
        for (Cottage cottage : cottagesWithWifi) {
            System.out.println(cottage.getName());
        }

        System.out.println("Luxury cottages:");
        List<Cottage> luxuryCottages = myCottageManager.filterCottagesByCategory("Luxury");
        for (Cottage cottage : luxuryCottages) {
            System.out.println(cottage.getName());
        }

        System.out.println("\nFinancial Report:");
        System.out.println(myCottageManager.generateFinancialReport());

        try {
            Calendar startDate = Calendar.getInstance();
            Calendar endDate = Calendar.getInstance();
            startDate.set(2024, Calendar.NOVEMBER, 5);
            endDate.set(2024, Calendar.NOVEMBER, 1);
            cottage2.bookCottage("John Bender", startDate, endDate);
            myCottageManager.updateTotalIncome(cottage2.getPricePerNight());
        } catch (BookingException e) {
            System.out.println(e.getMessage());
        }
    }
}
