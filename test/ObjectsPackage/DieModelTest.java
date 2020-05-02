package ObjectsPackage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DieModelTest {

    /** The DieModel */
    private DieModel dieModel;

    @BeforeAll
    void beforeAll() {
       dieModel = new DieModel();
    }

    @Test
    void roll1To6() {
        for (int i = 0; i < 20; i++) {
            dieModel.roll();
            assertTrue(dieModel.getDiceRollNum() < 7 && dieModel.getDiceRollNum() > 0);
        }
    }

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

    @Test
    void rollTwo1To6() {
        for (int i = 0; i < 20; i++) {
            dieModel.rollTwo();
            assertTrue(dieModel.getDiceRollNumTwo() < 7 && dieModel.getDiceRollNumTwo() > 0);
        }
    }

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