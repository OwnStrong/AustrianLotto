/*
Author: Own Daghagheleh
Problem statement: Solving Austrian Lotto "6 aus 45" problem, gathered from https://community.topcoder.com/stat?c=problem_statement&pm=1934 on 18/07/2017
Class Description: Test method for AustrianLotto class
*/
import com.distributed.austrianlotto.AustrianLotto;
import static com.distributed.austrianlotto.AustrianLotto.evaluate;
import org.junit.Test;
import static org.junit.Assert.*;


public class AustrianLottoTest {

    @Test
    public void testAustrianLottoBasicExecution(){
        String drawing = "3 11 18 23 37 45";
        String[] picks = {"4 7 14 30 33 35", "1 11 12 25 37 38", "11 18 19 20 21 22"};
        int[] expectedResult = { 1,  0,  2,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test
    public void testAustrianLotto_AllElementsCorrect(){
        String drawing = "3 18 23 11 37 45";
        String[] picks = {"3 11 18 23 37 45"};
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  1 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test
    public void testAustrianLotto_ThreeCorrects(){
        String drawing = "42 26 33 2 13 14";
        String[] picks = {"13 4 36 42 26 12"};
        int[] expectedResult = { 0,  0,  0,  1,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test
    public void testAustrianLotto_NoCorrect(){
        String drawing = "3 18 23 11 37 45";
        String[] picks = {"4 4 4 4 4 4", "5 5 5 5 5 5", "6 6 6 6 6 6"};
        int[] expectedResult = { 3,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAustrianLotto_DrawNonInteger(){
        String drawing = "3 18 23 11 37 l";
        String[] picks = {"4 4 4 4 4 4", "5 5 5 5 5 5", "6 6 6 6 6 6"};
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAustrianLotto_PickNonNumber(){
        String drawing = "3 18 23 11 37 45";
        String[] picks = {"4 4 4 4 4 4", "5 k 5 5 5 5", "6 6 6 6 6 6"};
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAustrianLotto_DrawShortElemnt(){
        String drawing = "3 18 23 11 45";
        String[] picks = {"4 4 4 4 4 4", "5 5 5 5 5 5", "6 6 6 6 6 6"};
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAustrianLotto_PickShortElemnt(){
        String drawing = "3 18 23 11 37 45";
        String[] picks = {"4 4 4 4 4 4", "5 5 5 5 5", "6 6 6 6 6 6"};
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAustrianLotto_DrawExtraNumber(){
        String drawing = "3 18 23 11 37 45 33";
        String[] picks = {"4 4 4 4 4 4", "5 5 5 5 5 5", "6 6 6 6 6 6"};
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAustrianLotto_PickExtraNumber(){
        String drawing = "3 18 23 11 37 45";
        String[] picks = {"4 4 4 4 4 4", "5 5 5 5 5 5", "6 6 6 6 6 6 6"};
        int[] expectedResult = { 3,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAustrianLotto_DrawIllegalNumber(){
        String drawing = "3 18 23 11 37 77";
        String[] picks = {"4 4 4 4 4 4", "5 5 5 5 5 5", "6 6 6 6 6 6"};
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAustrianLotto_PickIllegalNumber(){
        String drawing = "3 18 23 11 37 45";
        String[] picks = {"4 4 4 4 4 4", "5 5 5 5 5 5", "6 6 6 6 6 0"};
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAustrianLotto_MoreThanFiftyPicks(){
        String drawing = "3 18 23 11 37 45";
        String[] picks = new String[51];
        for (int i =0; i<51;i++ ){
            picks[i] = "10 10 10 10 10 10";
        }
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAustrianLotto_ZeroPicks(){
        String drawing = "3 18 23 11 37 45";
        String[] picks = {};
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAustrianLotto_EmptyDraw(){
        String drawing = "";
        String[] picks = {"4 4 4 4 4 4", "5 5 5 5 5 5", "6 6 6 6 6 6"};
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAustrianLotto_OneEmptyPick(){
        String drawing = "3 18 23 11 37 45";
        String[] picks = {"", "5 5 5 5 5 5", "6 6 6 6 6 6"};
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  0 };
        int[] result = evaluate(drawing ,picks);
        assertArrayEquals(result,expectedResult);
    }
}
