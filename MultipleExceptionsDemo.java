import java.util.Scanner;

public class MultipleExceptionsDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Uncomment the block below to test NullPointerException
            /*
            String str = null;
            System.out.println("Length of the string: " + str.length());  // This will throw NullPointerException
            */

            // Test ArrayIndexOutOfBoundsException
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing index 3: " + numbers[3]);  // This will throw ArrayIndexOutOfBoundsException

            // Test ArithmeticException
            System.out.print("Enter a number to divide 100 by: ");
            int divisor = scanner.nextInt();
            System.out.println("Result of division: " + (100 / divisor));  // This will throw ArithmeticException if divisor is 0

        } catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
        } catch (Exception e) {
            // General catch block to handle any other exceptions
            System.out.println("Caught an exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed, closing scanner.");
            scanner.close();  // Close the scanner to avoid resource leak
        }
    }
}

    
