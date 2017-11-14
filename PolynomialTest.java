import org.junit.Test;
import static org.junit.Assert.*;

public class PolynomialTest {
    // Constructor Tests

    /**
     * Tests if default constructor sets order to 0
     */
    @Test
    public void doesDConSetPolyOrderZero() {
        Polynomial poly = new Polynomial();
        int actual = poly.order();
        int expected = 0;
        assertEquals("The order set by the default constructor is not zero",
                expected, actual);
    }

    /**
     * Tests if default constructor sets coefficient to 1
     */
    @Test
    public void doesDConSetPolyCoeffOne() {
        Polynomial poly = new Polynomial();
        int actual = poly.get(0);
        int expected = 1;
        assertEquals(
                "The coefficient set by the default constructor is not one",
                expected, actual);

    }

    /**
     * Tests if nondefault constructor creates a polynomial with the given order
     */
    @Test
    public void doesNdConMakePolyWithGivenOrder() {
        Polynomial poly = new Polynomial(2);
        int actual = poly.order();
        int expected = 2;
        assertEquals(
                "The order of the polynomial does not match the given order",
                expected, actual);

    }

    /**
     * Tests if nondefault constructor defers to Polynomial() if order is
     * invalid
     */
    @Test
    public void doesNdConDeferToDConifInvalidOrder() {
        Polynomial poly = new Polynomial(-1);
        int actual = poly.order();
        int expected = 0;
        assertEquals("The order of the polynomial is not zero", expected,
                actual);
    }

    /**
     * Tests to see if nondefault constructor sets all coefficients to 1
     */
    @Test
    public void doesNdConSetAllCoefficientsToOne() {
        Polynomial poly = new Polynomial(2);
        int actualOne = poly.get(0);
        int actualTwo = poly.get(1);
        int actualThree = poly.get(2);

        int expectedOne = 1;
        int expectedTwo = 1;
        int expectedThree = 1;

        assertEquals("The coefficient at order zero does not equal one",
                expectedOne, actualOne);
        assertEquals("The coefficient at order one does not equal one",
                expectedTwo, actualTwo);
        assertEquals("The coefficient at order two does not equal one",
                expectedThree, actualThree);
    }

    // Set Tests

    /**
     * Tests to see if set() sets the coefficient to the given value for one
     * value
     */

    @Test
    public void doesSetSetCoefficientToGivenValueOne() {
        Polynomial poly = new Polynomial();
        poly.set(0, 30);
        int actual = poly.get(0);
        int expected = 30;
        assertEquals("The coefficient is not equal to the given coefficient",
                expected, actual);

    }

    /**
     * Tests to see if set() sets the coefficient to the given value for
     * multiple values
     */

    @Test
    public void doesSetSetCoefficientToGivenValueMultiple() {
        Polynomial poly = new Polynomial(1);
        poly.set(0, 30);
        poly.set(1, 50);
        int actualZero = poly.get(0);
        int actualOne = poly.get(1);

        int expectedZero = 30;
        int expectedOne = 50;
        assertEquals("The coefficient is not equal to the given coefficient",
                expectedZero, actualZero);
        assertEquals("The coefficient is not equal to the given coefficient",
                expectedOne, actualOne);

    }

    /**
     * Tests to see if set() ignores an illegal coefficient
     */
    @Test
    public void doesSetIgnoreIllegalValueCoefficient() {
        Polynomial poly = new Polynomial();
        poly.set(0, -3);
        int actual = poly.get(0);
        int expected = 1;

        assertEquals("set() did not ignore the illegal command", expected,
                actual);

    }

    /**
     * Tests to see if set() ignores an illegal order command
     */
    @Test
    public void doesSetIgnoreIllegalValueOrder() {
        Polynomial poly = new Polynomial();
        poly.set(2, 5);
        int actual = poly.get(2);
        int expected = 0;

        assertEquals("set() did not ignore the illegal command", expected,
                actual);
    }

    // Get Tests

    /**
     * Tests to see if get returns the coefficient of the given term
     */
    @Test
    public void doesGetReturnProperCoefficient() {
        Polynomial poly = new Polynomial();
        poly.set(0, 22);
        int actual = poly.get(0);
        int expected = 22;

        assertEquals("get() did not return the proper value", expected, actual);
    }

    /**
     * Tests to see if get returns the coeffient of the given values with order
     * greater than one
     */
    @Test
    public void doesGetReturnProperCoefficientMultiple() {
        Polynomial poly = new Polynomial(2);
        poly.set(0, 22);
        poly.set(1, 5);
        poly.set(2, 4);

        int actualZero = poly.get(0);
        int actualOne = poly.get(1);
        int actualTwo = poly.get(2);

        int expectedZero = 22;
        int expectedOne = 5;
        int expectedTwo = 4;

        assertEquals("get() did not return the proper value", expectedZero,
                actualZero);
        assertEquals("get() did not return the proper value", expectedOne,
                actualOne);
        assertEquals("get() did not return the proper value", expectedTwo,
                actualTwo);
    }

    /**
     * Tests to see if get() throws IllegalArgumentException if invalid order is
     * given
     */

    @Test(expected = IllegalArgumentException.class)
    public void doesGetThrowIAEIfInvalidOrder() {
        Polynomial poly = new Polynomial();
        poly.get(1);
    }

    // Tests to see if get() throws IllegalArgumentException if given order is
    // neative
    @Test(expected = IllegalArgumentException.class)
    public void doesGetThrowIAEIfInvalidOrderNegative() {
        Polynomial poly = new Polynomial();
        poly.get(-1);
    }

    // Order Tests

    /**
     * Tests to see if order() outputs the order of the polynomial
     */
    @Test
    public void doesOrderOutputOrderofPoly() {
        Polynomial poly = new Polynomial();
        int actual = poly.order();
        int expected = 0;
        assertEquals(
                "order() did not output the correct order of the polynomial",
                expected, actual);
    }

    /**
     * Tests to see if order() outputs the order of a polynomial with multiple
     * terms
     */

    @Test
    public void doesOrderOutputOrderOfPolyMultiple() {
        Polynomial poly = new Polynomial(5);
        int actual = poly.order();
        int expected = 5;
        assertEquals(
                "order() did not output the correct order of the polynomial",
                expected, actual);

    }

    // Add Tests

    /**
     * Tests to see if add creates the sum of the corresponding coefficients
     */
    @Test
    public void doesAddReturnSumOfCoefficients() {
        Polynomial poly = new Polynomial();
        Polynomial thePoly = new Polynomial();
        Polynomial polySum = poly.add(thePoly);
        int actual = polySum.get(0);
        int expected = 2;
        assertEquals("add did not add the two coefficients", expected, actual);

    }

    /**
     * Tests to see if add creates the sum of corresponding coefficients with
     * order greater than 0
     */

    @Test
    public void doesAddReturnSumMultiple() {
        Polynomial poly = new Polynomial(3);
        Polynomial thePoly = new Polynomial();
        poly.set(0, 3);
        poly.set(2, 20);
        thePoly.set(0, 2);
        thePoly.set(2, 4);
        Polynomial polySum = poly.add(thePoly);
        int actualZero = polySum.get(0);
        int actualOne = polySum.get(1);
        int actualTwo = polySum.get(2);

        int expectedZero = 5;
        int expectedOne = 2;
        int expectedTwo = 24;

        assertEquals("add did not add the two coefficients", expectedZero,
                actualZero);
        assertEquals("add did not add the two coefficients", expectedOne,
                actualOne);
        assertEquals("add did not add the two coefficients", expectedTwo,
                actualTwo);
    }

    /**
     * Tests to see if add can add polynomials of different orders
     */
    @Test
    public void doesAddAddPolyDiffCoeff() {
        Polynomial poly = new Polynomial(1);
        Polynomial thePoly = new Polynomial(2);
        poly.set(0, 3);
        poly.set(1, 2);
        thePoly.set(0, 2);
        thePoly.set(1, 3);
        thePoly.set(2, 4);
        Polynomial polySum = new Polynomial();

        int actualZero = polySum.get(0);
        int actualOne = polySum.get(1);
        int actualTwo = polySum.get(2);

        int expectedZero = 5;
        int expectedOne = 5;
        int expectedTwo = 4;

        assertEquals("add did not add the two coefficients", expectedZero,
                actualZero);
        assertEquals("add did not add the two coefficients", expectedOne,
                actualOne);
        assertEquals("add did not add the two coefficients", expectedTwo,
                actualTwo);

    }

    //

}
