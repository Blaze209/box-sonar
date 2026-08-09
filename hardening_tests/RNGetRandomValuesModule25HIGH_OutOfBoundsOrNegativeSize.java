package hardening_tests;

import org.linusu.RNGetRandomValuesModule;

/**
 * Test to demonstrate vulnerable vs fixed behavior for RNGetRandomValuesModule.
 *
 * Expected behavior (fixed):
 * The getRandomBase64 method must validate its input size bounds, throwing a standard managed
 * IllegalArgumentException if the size is negative or excessively large (to prevent NegativeArraySizeException or OutOfMemoryError).
 *
 * Actual behavior (vulnerable):
 * A negative value causes a NegativeArraySizeException, and an extremely large value causes OutOfMemoryError, crashing the process.
 */
public class RNGetRandomValuesModule25HIGH_OutOfBoundsOrNegativeSize {
    public static void main(String[] args) throws Exception {
        RNGetRandomValuesModule module = new RNGetRandomValuesModule(null);

        // 1. Test negative size
        try {
            module.getRandomBase64(-5);
            throw new RuntimeException("Assertion failed: Expected IllegalArgumentException for negative size but none was thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("Negative input handled correctly with IllegalArgumentException.");
        } catch (Exception e) {
            if (e.getClass().getSimpleName().equals("NegativeArraySizeException")) {
                System.err.println("VULNERABLE CODE DETECTED: NegativeArraySizeException thrown!");
                throw e;
            }
            throw e;
        }

        // 2. Test extremely large size
        try {
            module.getRandomBase64(2_000_000_000);
            throw new RuntimeException("Assertion failed: Expected IllegalArgumentException for extremely large size but none was thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("Extremely large input handled correctly with IllegalArgumentException.");
        } catch (OutOfMemoryError oom) {
            System.err.println("VULNERABLE CODE DETECTED: OutOfMemoryError thrown!");
            throw oom;
        }

        System.out.println("Test passed successfully on fixed code!");
    }
}
