package Module_4.BowlingShopApp;

/*
 * Author: [Your Last Name], [Your First Name]
 * Course: [Course Name]
 * Date: 2026
 * Assignment: Assignment 4.2 - Bowling Shop Application
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

/**
 * Purpose: This class represents the bowling shop's product database.
 *          It provides a static method to retrieve products by category code.
 */
public class ProductDB {

    /**
     * Purpose: Retrieves a queue of products based on the provided category code.
     *          Supports "b" for bowling balls, "s" for bowling shoes,
     *          "a" for bowling bags, and any other input returns an empty queue.
     * Input:   lCode - a String representing the product category ("b", "s", or "a").
     * Output:  A GenericQueue of Product objects matching the requested category.
     */
    public static GenericQueue<Product> getProducts(String lCode) {

        // Check if the user's selection is "b" for bowling balls.
        if (lCode.equalsIgnoreCase("b")) {

            // Create a generic queue to hold ball product objects.
            GenericQueue<Product> balls = new GenericQueue<>();

            // Create and configure the first ball instance with all required data fields.
            Ball lBall1 = new Ball();
            lBall1.setCode("B100");
            lBall1.setDescription("Black Widow 2.0");
            lBall1.setPrice(144.95);
            lBall1.setColor("Black and Red");

            // Create and configure the second ball instance with all required data fields.
            Ball lBall2 = new Ball();
            lBall2.setCode("B200");
            lBall2.setDescription("Axiom Pearl");
            lBall2.setPrice(154.95);
            lBall2.setColor("Blue and Red");

            // Create and configure the third ball instance with all required data fields.
            Ball lBall3 = new Ball();
            lBall3.setCode("B300");
            lBall3.setDescription("Proton Physix");
            lBall3.setPrice(174.95);
            lBall3.setColor("Pink and Purple");

            // Create and configure the fourth ball instance with all required data fields.
            Ball lBall4 = new Ball();
            lBall4.setCode("B400");
            lBall4.setDescription("Force Unleashed");
            lBall4.setPrice(139.99);
            lBall4.setColor("Red and White");

            // Create and configure the fifth ball instance with all required data fields.
            Ball lBall5 = new Ball();
            lBall5.setCode("B500");
            lBall5.setDescription("Phaze III");
            lBall5.setPrice(154.99);
            lBall5.setColor("Purple and Green");

            // Add all five ball objects to the queue.
            balls.enqueue(lBall1);
            balls.enqueue(lBall2);
            balls.enqueue(lBall3);
            balls.enqueue(lBall4);
            balls.enqueue(lBall5);

            return balls;

        // Check if the user's selection is "s" for bowling shoes.
        } else if (lCode.equalsIgnoreCase("s")) {

            // Create a generic queue to hold shoe product objects.
            GenericQueue<Product> shoes = new GenericQueue<>();

            // Create and configure the first shoe instance with all required data fields.
            Shoe lShoe1 = new Shoe();
            lShoe1.setCode("S100");
            lShoe1.setDescription("Men's Ram Black");
            lShoe1.setPrice(39.99);
            lShoe1.setSize(10.5);

            // Create and configure the second shoe instance with all required data fields.
            Shoe lShoe2 = new Shoe();
            lShoe2.setCode("S200");
            lShoe2.setDescription("Women's Rise Black/Hot Pink");
            lShoe2.setPrice(39.99);
            lShoe2.setSize(7.0);

            // Create and configure the third shoe instance with all required data fields.
            Shoe lShoe3 = new Shoe();
            lShoe3.setCode("S300");
            lShoe3.setDescription("Women's Path Lite Seamless Mesh");
            lShoe3.setPrice(54.99);
            lShoe3.setSize(6.0);

            // Create and configure the fourth shoe instance with all required data fields.
            Shoe lShoe4 = new Shoe();
            lShoe4.setCode("S400");
            lShoe4.setDescription("Men's Tribal White");
            lShoe4.setPrice(26.99);
            lShoe4.setSize(8.5);

            // Create and configure the fifth shoe instance with all required data fields.
            Shoe lShoe5 = new Shoe();
            lShoe5.setCode("S500");
            lShoe5.setDescription("Youth Skull Green/Black");
            lShoe5.setPrice(39.99);
            lShoe5.setSize(3.0);

            // Add all five shoe objects to the queue.
            shoes.enqueue(lShoe1);
            shoes.enqueue(lShoe2);
            shoes.enqueue(lShoe3);
            shoes.enqueue(lShoe4);
            shoes.enqueue(lShoe5);

            return shoes;

        // Check if the user's selection is "a" for bowling bags.
        } else if (lCode.equalsIgnoreCase("a")) {

            // Create a generic queue to hold bag product objects.
            GenericQueue<Product> bags = new GenericQueue<>();

            // Create and configure the first bag instance with all required data fields.
            Bag lBag1 = new Bag();
            lBag1.setCode("A100");
            lBag1.setDescription("Path Pro Deluxe");
            lBag1.setPrice(34.99);
            lBag1.setType("Single");

            // Create and configure the second bag instance with all required data fields.
            Bag lBag2 = new Bag();
            lBag2.setCode("A200");
            lBag2.setDescription("Prime Roller Black/Royal Blue");
            lBag2.setPrice(54.99);
            lBag2.setType("Double");

            // Create and configure the third bag instance with all required data fields.
            Bag lBag3 = new Bag();
            lBag3.setCode("A300");
            lBag3.setDescription("Silver/Royal Blue");
            lBag3.setPrice(74.99);
            lBag3.setType("Triple");

            // Add all three bag objects to the queue.
            bags.enqueue(lBag1);
            bags.enqueue(lBag2);
            bags.enqueue(lBag3);

            return bags;

        // Return an empty product queue for any unrecognized input.
        } else {
            return new GenericQueue<>();
        }
    }
}