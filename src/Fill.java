import java.util.Scanner;

public class Fill {
    Scanner get = new Scanner(System.in);


    /**
     * simply get the information and save it in array
     */
    public Flight fill() {
        get.nextLine();
        System.out.println("please fill the information you want");
        System.out.print("flightID :");
        String id = get.nextLine();
        System.out.println();
        System.out.print("origin :");
        String origin = get.nextLine();
        System.out.println();
        System.out.print("destination :");
        String destination = get.nextLine();
        System.out.println();
        System.out.print("time :");
        String time = get.nextLine();
        System.out.println();
        System.out.print("date :");
        String date = get.nextLine();
        System.out.println();
        System.out.print("price :");
        long price = get.nextLong();
        System.out.println();
        System.out.print("seats :");
        int seats = get.nextInt();
        return new Flight(id,origin,destination,time,date,price,seats);
    }
}
