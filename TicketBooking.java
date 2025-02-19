class TicketBookingSystem {
    private int availableSeats;

    public TicketBookingSystem(int seats) {
        this.availableSeats = seats;
    }

    public synchronized void bookSeat(String customerName) {
        if (availableSeats > 0) {
            System.out.println(customerName + " successfully booked a seat.");
            availableSeats--;
        } else {
            System.out.println(customerName + " tried to book but no seats are available.");
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem system;
    private String customerName;

    public BookingThread(TicketBookingSystem system, String customerName, int priority) {
        this.system = system;
        this.customerName = customerName;
        setPriority(priority);
    }

    @Override
    public void run() {
        system.bookSeat(customerName);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(5);

        Thread vip1 = new BookingThread(system, "VIP Customer 1", Thread.MAX_PRIORITY);
        Thread vip2 = new BookingThread(system, "VIP Customer 2", Thread.MAX_PRIORITY);
        Thread normal1 = new BookingThread(system, "Normal Customer 1", Thread.NORM_PRIORITY);
        Thread normal2 = new BookingThread(system, "Normal Customer 2", Thread.NORM_PRIORITY);
        Thread normal3 = new BookingThread(system, "Normal Customer 3", Thread.NORM_PRIORITY);
        Thread normal4 = new BookingThread(system, "Normal Customer 4", Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        normal1.start();
        normal2.start();
        normal3.start();
        normal4.start();
    }
}

//OUTPUT:
//VIP Customer 1 successfully booked a seat.
//Normal Customer 4 successfully booked a seat.
//Normal Customer 3 successfully booked a seat.
//Normal Customer 2 successfully booked a seat.
//Normal Customer 1 successfully booked a seat.
//VIP Customer 2 tried to book but no seats are available.
