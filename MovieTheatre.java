public class MovieTheatre {

    static class TheatreSeats {
        private String[][] seatingArrangement;

        // Constructor initializes the seating arrangement
        public TheatreSeats(int rows, int cols) {
            seatingArrangement = new String[rows][cols];
            initializeSeats();
        }

        // Fill all seats as "Available"
        private void initializeSeats() {
            for (int i = 0; i < seatingArrangement.length; i++) {
                for (int j = 0; j < seatingArrangement[i].length; j++) {
                    seatingArrangement[i][j] = "Available";
                }
            }
        }

        // Reserve a seat
        public void reserveSeat(int row, int col) {
            if (isValidSeat(row, col)) {
                if ("Available".equals(seatingArrangement[row][col])) {
                    seatingArrangement[row][col] = "Reserved";
                    System.out.println("Seat at (" + row + ", " + col + ") reserved successfully.");
                } else {
                    System.out.println("Seat at (" + row + ", " + col + ") is already reserved.");
                    suggestAvailableSeats();
                }
            }
        }

        // Cancel a reserved seat
        public void cancelSeat(int row, int col) {
            if (isValidSeat(row, col)) {
                if ("Reserved".equals(seatingArrangement[row][col])) {
                    seatingArrangement[row][col] = "Available";
                    System.out.println("Seat at (" + row + ", " + col + ") cancelled successfully.");
                } else {
                    System.out.println("Seat at (" + row + ", " + col + ") is already available.");
                }
            }
        }

        // Check if the seat is valid
        private boolean isValidSeat(int row, int col) {
            if (row < 0 || col < 0 || row >= seatingArrangement.length || col >= seatingArrangement[0].length) {
                System.out.println("Invalid seat position: (" + row + ", " + col + ")");
                return false;
            }
            return true;
        }

        // Show available seats
        private void suggestAvailableSeats() {
            boolean found = false;
            for (int i = 0; i < seatingArrangement.length; i++) {
                for (int j = 0; j < seatingArrangement[i].length; j++) {
                    if ("Available".equals(seatingArrangement[i][j])) {
                        System.out.println("Available seat at (" + i + ", " + j + ")");
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("No available seats left.");
            }
        }

        // Display seating chart
        public void displaySeatingChart() {
            System.out.println("Current Seating Chart:");
            for (int i = 0; i < seatingArrangement.length; i++) {
                for (int j = 0; j < seatingArrangement[i].length; j++) {
                    System.out.printf("Seat (%d, %d): %s  ", i, j, seatingArrangement[i][j]);
                }
                System.out.println();
            }
        }

        // Main method to test
        public static void main(String[] args) {
            TheatreSeats theatreSeats = new TheatreSeats(5, 5);
            theatreSeats.reserveSeat(1, 1);
            theatreSeats.reserveSeat(2, 2);
            theatreSeats.reserveSeat(3, 3);
            theatreSeats.cancelSeat(1, 1);
            theatreSeats.displaySeatingChart();
        }
    }
}
