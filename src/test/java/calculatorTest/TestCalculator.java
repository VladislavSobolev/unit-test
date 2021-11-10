package calculatorTest;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculator {
   @BeforeClass
    public void beforeClass(){
        System.out.println("Запуск тестов");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Тесты завершены");
    }

    @DataProvider
    public Object[][] sumEquals(){
        return new Object[][]{
                {10, 8, 2},
                {-10, 10, -20},
                {0, 10, -10},
                {-20, -10, -10}
        };
    }
    @DataProvider
    public Object[][] sumEqualsNegative(){
        return new Object[][]{
                {20, 5, 12},
                {-20, -10, 10},
                {99, 9, 9}
        };
    }

    @DataProvider
    public Object[][] differenceEquals(){
        return  new Object[][]{
                {100, 300, 200},
                {0, -10, -10},
                {-20, -50, -30},
                {-5, 0, 5},
                {5, 5, 0},
                {0, 0, 0}
        };
    }

    @DataProvider
    public Object[][] differenceEqualsNegative(){
        return new Object[][]{
                {50, 20, 30},
                {25, 40, 82},
                {66, 14, 88},
                {0 , 12, 13}

        };
    }

    @DataProvider
    public Object[][] divisionEquals(){
        return new Object[][]{
                {0, 100, 0},
                {3, 9, 3},
                {-4, -16, 4},
                {0, 0, 100},
                {-4, 16, -4}
        };
    }

    @DataProvider
    public Object[][] divisionEqualsNegative(){
        return new Object[][]{
                {5, 100, 0},
                {4, 9, 3},
                {-7, -16, 4},
                {20, 0, 100},
                {-16, 16, -4}
        };
    }

    @DataProvider
    public Object[][] multiplicationEquals(){
        return new Object[][]{
                {-10, -10, 1},
                {100, -10, -10},
                {0, -16, 0},
                {0, 0, 100},
                {0, 16, 0},
                {100, 10, 10}
        };
    }

    @DataProvider
    public Object[][] multiplicationEqualsNegative(){
        return new Object[][]{
                {-100, -10, 1},
                {100, -100, -10},
                {0, 12, 10}
        };
    }

    @Test(dataProvider = "sumEquals")
    public void sumTest(int one, int two, int tree){
        Assert.assertEquals(one,new Calculator().sum(two, tree),"Значения не равны");
    }

    @Test(dataProvider = "sumEqualsNegative")
    public void sumTestNegative(int one, int two, int tree){
        Assert.assertNotEquals(one,new Calculator().sum(two, tree),"Значения  равны");
    }

    @Test(dataProvider = "differenceEquals")
    public void differenceTest(int one, int two, int tree){
       Assert.assertEquals(one, new Calculator().difference(two, tree), "Значения не равны");
    }

    @Test(dataProvider = "differenceEqualsNegative")
    public void differenceTestNegative(int one, int two, int tree){
       Assert.assertNotEquals(one, new Calculator().difference(two, tree), "Значения равны");
    }

    @Test(dataProvider = "divisionEquals")
    public void divisionTest(int one, int two, int tree){
       Assert.assertEquals(one, new Calculator().division(two, tree), "Значения не равны");
    }

    @Test(dataProvider = "divisionEqualsNegative")
    public void divisionTestNegative(int one, int two, int tree){
       Assert.assertNotEquals(one, new Calculator().division(two, tree), "Значения равны");
    }

    @Test(dataProvider = "multiplicationEquals")
    public void multiplicationTest(int one, int two, int tree){
       Assert.assertEquals(one, new Calculator().multiplication(two, tree),"Значения не равны");
    }

    @Test(dataProvider = "multiplicationEqualsNegative")
    public void multiplicationTestNegative(int one, int two, int tree){
       Assert.assertNotEquals(one, new Calculator().multiplication(two, tree), "Значения равны");
    }
}
