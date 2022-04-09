import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.berezin_y_a.Logic;

class SortArrayTest {

    TestArrays testArrays = new TestArrays();
    Logic logic = new Logic();
    int[] actualResult;

    @Test
    public void test1() {
        int[] correctResult = {1, 2, 5};
        logic.sortArray(testArrays.testArray1);
        actualResult = testArrays.testArray1;
        Assertions.assertArrayEquals(correctResult, actualResult);
    }

    @Test
    public void test2() {
        int[] correctResult = {1, 2, 2, 4, 6, 44, 234, 334};
        logic.sortArray(testArrays.testArray2);
        actualResult = testArrays.testArray2;
        Assertions.assertArrayEquals(correctResult, actualResult);
    }

    @Test
    public void test3() {
        int[] correctResult = {1, 1, 1, 2, 2, 11, 12, 222, 1111111};
        logic.sortArray(testArrays.testArray3);
        actualResult = testArrays.testArray3;
        Assertions.assertArrayEquals(correctResult, actualResult);
    }

}