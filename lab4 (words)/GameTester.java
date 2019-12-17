import org.junit.Assert;
import org.junit.Test;

public class GameTester{
    @Test
    public void emptyWordInputTest()
    {
        Game.startGame("");
        Assert.assertEquals("Error!", Game.getFullLine());
    }
    @Test
    public void symbolVisualReplaceTest()
    {
        Game.startGame("Hello");
        Game.trySymbol('l');
        Assert.assertEquals(5 + " | " + "H*llo", Game.getFullLine());
    }

    @Test
    public void winTest()
    {
        Game.startGame("Hello");
        Game.trySymbol('l');
        Assert.assertEquals(5 + " | " + "H*llo", Game.getFullLine());
        Game.trySymbol('e');
        Assert.assertEquals("You win!", Game.getFullLine());
    }
    @Test
    public void looseTest()
    {
        Game.startGame("Hello");
        Game.trySymbol('1');
        Assert.assertEquals(4 + " | " + "H***o", Game.getFullLine());
        Game.trySymbol('2');
        Assert.assertEquals(3 + " | " + "H***o", Game.getFullLine());
        Game.trySymbol('3');
        Assert.assertEquals(2 + " | " + "H***o", Game.getFullLine());
        Game.trySymbol('4');
        Assert.assertEquals(1 + " | " + "H***o", Game.getFullLine());
        Game.trySymbol('5');
        Assert.assertEquals("Game over!", Game.getFullLine());
    }
    @Test
    public void letterRepeatTest()
    {
        Game.startGame("Hello");
        Game.trySymbol('o');
        Assert.assertEquals(5 + " | " + "H***o", Game.getFullLine());
    }
}