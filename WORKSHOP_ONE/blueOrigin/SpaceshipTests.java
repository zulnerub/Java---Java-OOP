package WORKSHOP_ONE.blueOrigin;


public class SpaceshipTests {
    private static final String INVALID_SPACESHIP_NAME = "Invalid spaceship name!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String SPACESHIP_FULL = "Spaceship is full!";
    private static final String ASTRONAUT_EXIST = "Astronaut %s is already in!";

    private static final String DEFAULT_ASTRONAUT_NAME = "Astro";
    private static final double DEFAULT_OXYGEN_PERCENTAGE = 1.1;
    private static final Astronaut DEFAULT_ASTRONAUT = new Astronaut(DEFAULT_ASTRONAUT_NAME, DEFAULT_OXYGEN_PERCENTAGE);

    private static final String TEST_NAME = "TestAstro";
    private static final double TEST_OXYGEN_PERCENTAGE = 2.2;
    private static final Astronaut TEST_ASTRONAUT = new Astronaut(TEST_NAME, TEST_OXYGEN_PERCENTAGE);

    private static final int NEGATIVE_CAPACITY = -1;
    private static final int DEFAULT_CAPACITY = 1;

    private static final String NULL_NAME = null;
    private static final String EMPTY_NAME = "";

    private static final String DEFAULT_SPACESHIP_NAME = "Spaceship";


    private Spaceship spaceship;

    @Before
    public void setUp(){
        this.spaceship = new Spaceship(DEFAULT_SPACESHIP_NAME, DEFAULT_CAPACITY);
    }

    @Test
    public void shouldReturnCorrectMessageWithInvalidCapacity(){
        String actual = "";
        try {
            this.spaceship = new Spaceship(DEFAULT_SPACESHIP_NAME, NEGATIVE_CAPACITY);
        }catch (IllegalArgumentException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals(INVALID_CAPACITY, actual);
    }

    @Test
    public void shouldReturnCorrectMessageWithExceedingCapacity(){
        String actual = "";
        this.spaceship = new Spaceship(DEFAULT_SPACESHIP_NAME, DEFAULT_CAPACITY);
        try {
            this.spaceship.add(DEFAULT_ASTRONAUT);
            this.spaceship.add(TEST_ASTRONAUT);
        }catch (IllegalArgumentException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals(SPACESHIP_FULL, actual);
    }

    @Test
    public void shouldReturnCorrectMessageAddingExistingAstronaut(){
        String actual = "";
        this.spaceship = new Spaceship(DEFAULT_SPACESHIP_NAME, 2);
        try {
            this.spaceship.add(TEST_ASTRONAUT);
            this.spaceship.add(TEST_ASTRONAUT);
        }catch (IllegalArgumentException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals(String.format(ASTRONAUT_EXIST, TEST_NAME), actual);
    }

    @Test
    public void shouldReturnCorrectMessageWithNullName(){
        String actual = "";
        try {
            this.spaceship = new Spaceship(NULL_NAME, DEFAULT_CAPACITY);
        }catch (NullPointerException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals(INVALID_SPACESHIP_NAME, actual);
    }

    @Test
    public void shouldReturnCorrectMessageWithEmptyName(){
        String actual = "";
        try {
            this.spaceship = new Spaceship(EMPTY_NAME, DEFAULT_CAPACITY);
        }catch (NullPointerException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals(INVALID_SPACESHIP_NAME, actual);
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullName() {
        this.spaceship = new Spaceship(NULL_NAME, DEFAULT_CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowEmptyName() {
        this.spaceship = new Spaceship(EMPTY_NAME, DEFAULT_CAPACITY);
    }

    @Test
    public void shouldReturnCorrectCount(){
        this.spaceship.add(DEFAULT_ASTRONAUT);
        int actualSize = this.spaceship.getCount();
        Assert.assertEquals(DEFAULT_CAPACITY, actualSize);
    }

    @Test
    public void shouldReturnCorrectName(){
        this.spaceship = new Spaceship(TEST_NAME, DEFAULT_CAPACITY);
        String actual = this.spaceship.getName();
        Assert.assertEquals(TEST_NAME, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenCapacityExceeded(){
        this.spaceship.add(DEFAULT_ASTRONAUT);
        this.spaceship.add(TEST_ASTRONAUT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenAddingExistingAstronaut(){
        this.spaceship.add(DEFAULT_ASTRONAUT);
        this.spaceship.add(DEFAULT_ASTRONAUT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenNegativeCapacity(){
        this.spaceship = new Spaceship(DEFAULT_SPACESHIP_NAME, NEGATIVE_CAPACITY);
    }

    @Test
    public void shouldReturnTrueIfRemoved(){
        this.spaceship.add(DEFAULT_ASTRONAUT);
        boolean actual = this.spaceship.remove(DEFAULT_ASTRONAUT_NAME);
        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseIfNotRemoved(){
        this.spaceship.add(DEFAULT_ASTRONAUT);
        boolean actual = this.spaceship.remove(TEST_NAME);
        Assert.assertFalse(actual);
    }




}
