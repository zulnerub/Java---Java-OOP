package WORKSHOP_THREE.heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    private static final Item DEFAULT_ITEM = new Item(10,10,10);
    private static final Item TEST_ITEM = new Item(1,1,1);
    private static final Item ITEM_NEG_STR = new Item(-1,1,1);
    private static final Item ITEM_NEG_INT = new Item(1,1,-1);
    private static final Item ITEM_NEG_AGY = new Item(1,-1,1);
    private static final Hero DEFAULT_HERO = new Hero("DefaultHero", 10, DEFAULT_ITEM);
    private static final Hero TEST_HERO = new Hero("TestHero",1, TEST_ITEM);
    private static final Hero HERO_NEG_STR = new Hero("TestHeroNegStr",1, ITEM_NEG_STR);
    private static final Hero HERO_NEG_INT = new Hero("TestHeroNegInt",1, ITEM_NEG_INT);
    private static final Hero HERO_NEG_AGY = new Hero("TestHeroNegAgy",1, ITEM_NEG_AGY);





    private HeroRepository heroRepository;

    public HeroRepositoryTest( ) {
        this.heroRepository = new HeroRepository();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenNoHeroWithHieghestStrength(){
        this.heroRepository = new HeroRepository();
        this.heroRepository.add(HERO_NEG_STR);
        this.heroRepository.getHeroWithHighestStrength();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenNoHeroWithHighestAgility(){
        this.heroRepository = new HeroRepository();
        this.heroRepository.add(HERO_NEG_AGY);
        this.heroRepository.getHeroWithHighestAgility();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenNoHeroWithHighestIntelligence(){
        this.heroRepository = new HeroRepository();
        this.heroRepository.add(HERO_NEG_INT);
        this.heroRepository.getHeroWithHighestIntelligence();
    }

    @Test
    public void returnCorrectSize(){
        this.heroRepository.add(TEST_HERO);
        int actual = this.heroRepository.getCount();
        Assert.assertEquals(2,actual);
    }

    @Before
    public void setUp(){
        this.heroRepository.add(DEFAULT_HERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenAddingExistingHero(){
        this.heroRepository.add(DEFAULT_HERO);
    }
    @Test
    public void returnCorrectMessageDuplicateHero(){
        String actual = "";
        try {
            this.heroRepository.add(DEFAULT_HERO);
        }catch (IllegalArgumentException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals("Duplicate heroes!", actual);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowHeroNull(){
        this.heroRepository.remove(TEST_HERO.getName());
    }
    @Test
    public void returnCorrectMessageHeroNotInDatabase(){
        String actual = "";
        try {
            this.heroRepository.remove(TEST_HERO.getName());
        }catch (NullPointerException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals("Hero doesn't exist", actual);
    }
    @Test
    public void checkIfHeroIsRemoved(){
        this.heroRepository.remove(DEFAULT_HERO.getName());
        int actual = this.heroRepository.getCount();
        Assert.assertEquals(0, actual);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenAskedForHighestStrength(){
        this.heroRepository = new HeroRepository();
        this.heroRepository.getHeroWithHighestStrength();
    }
    @Test
    public void returnCorrectMessageHeroBestStrength(){
        String actual = "";
        try {
            this.heroRepository = new HeroRepository();
            this.heroRepository.getHeroWithHighestStrength();
        }catch (NullPointerException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals("Hero with highest strength not found", actual);
    }
    @Test
    public void shouldReturnHeroStrength(){
        this.heroRepository.add(TEST_HERO);
        Hero actualHero = this.heroRepository.getHeroWithHighestStrength();
        Assert.assertEquals(DEFAULT_HERO, actualHero);
    }

    //

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenAskedForHighestAgility(){
        this.heroRepository = new HeroRepository();
        this.heroRepository.getHeroWithHighestAgility();
    }
    @Test
    public void returnCorrectMessageHeroBestAgility(){
        String actual = "";
        try {
            this.heroRepository = new HeroRepository();
            this.heroRepository.getHeroWithHighestAgility();
        }catch (NullPointerException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals("Hero with highest agility not found", actual);
    }
    @Test
    public void shouldReturnHeroAgility(){
        this.heroRepository.add(TEST_HERO);
        Hero actualHero = this.heroRepository.getHeroWithHighestAgility();
        Assert.assertEquals(DEFAULT_HERO, actualHero);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenAskedForHighestIntelligence(){
        this.heroRepository = new HeroRepository();
        this.heroRepository.getHeroWithHighestIntelligence();
    }
    @Test
    public void returnCorrectMessageHeroBestIntelligence(){
        String actual = "";
        try {
            this.heroRepository = new HeroRepository();
            this.heroRepository.getHeroWithHighestIntelligence();
        }catch (NullPointerException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals("Hero with highest intelligence not found", actual);
    }
    @Test
    public void shouldReturnHeroIntelligence(){
        this.heroRepository.add(TEST_HERO);
        Hero actualHero = this.heroRepository.getHeroWithHighestIntelligence();
        Assert.assertEquals(DEFAULT_HERO, actualHero);
    }

    @Test
    public void returnCorrectCount(){
        int actual = this.heroRepository.getCount();
        Assert.assertEquals(1, actual);
    }

    @Test
    public void returnCorrectToString(){
        this.heroRepository = new HeroRepository();
        this.heroRepository.add(DEFAULT_HERO);
        String actual = this.heroRepository.toString();

        Assert.assertEquals(String.format("Hero: %s – %d%n" +
                        "  *  Strength: %d%n" +
                        "  *  Agility: %d%n" +
                        "  *  Intelligence: %d%n", DEFAULT_HERO.getName(), DEFAULT_HERO.getLevel(),
                DEFAULT_ITEM.getStrength(), DEFAULT_ITEM.getAgility(), DEFAULT_ITEM.getIntelligence()), actual);
    }


}