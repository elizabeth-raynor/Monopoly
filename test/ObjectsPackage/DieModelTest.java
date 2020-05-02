/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Elizabeth Raynor
 * Section: 11 am
 * Date: 4/29/2020
 * Time: 9:38 AM
 *
 * Project: csci205finalprojectsp2020
 * Package: ObjectsPackage
 * Class: DieModelTest
 *
 * Description: tests the DieModel that represents a die roll
 *
 * ****************************************
 */

package ObjectsPackage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the DieModel class
 *
 * @author Elizabeth Raynor
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DieModelTest {

    /** The DieModel */
    private DieModel dieModel;

    /**
     * Intialize the DieModel before each test
     */
    @BeforeAll
    void beforeAll() {
       dieModel = new DieModel();
    }

    /**
     * Test that the random numbers are only 1 to 6 for the first die
     */
    @Test
    void roll1To6() {
        for (int i = 0; i < 20; i++) {
            dieModel.roll();
            assertTrue(dieModel.getDiceRollNum() < 7 && dieModel.getDiceRollNum() > 0);
        }
    }

    /**
     * Test that the dice roll actually changes for the first die
     */
    @Test
    void rollChange() {
        dieModel.roll();
        int roll1 =  dieModel.getDiceRollNum();
        dieModel.roll();
        int roll2 = dieModel.getDiceRollNum();
        dieModel.roll();
        int roll3 = dieModel.getDiceRollNum();
        assertTrue(roll1 != roll2 || roll2 != roll3);
    }

    /**
     * Test that the random numbers are only 1 to 6 for the second die
     */
    @Test
    void rollTwo1To6() {
        for (int i = 0; i < 20; i++) {
            dieModel.rollTwo();
            assertTrue(dieModel.getDiceRollNumTwo() < 7 && dieModel.getDiceRollNumTwo() > 0);
        }
    }

    /**
     * Test that the dice roll actually changes for the second die
     */
    @Test
    void rollTwoChange() {
        dieModel.rollTwo();
        int roll1 =  dieModel.getDiceRollNumTwo();
        dieModel.rollTwo();
        int roll2 = dieModel.getDiceRollNumTwo();
        dieModel.rollTwo();
        int roll3 = dieModel.getDiceRollNumTwo();
        assertTrue(roll1 != roll2 || roll2 != roll3);
    }
}