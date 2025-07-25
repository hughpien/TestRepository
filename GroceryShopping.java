import java.util.Scanner;

class ItemNotFoundException extends Exception
{
    public ItemNotFoundException(String message)
    {
        super(message);
    }
}

public class GroceryShopping
{

    public static void main(String[] args)
    {
        String[] storeProducts = {
            "Book",
            "Lamp",
            "Mug",
            "Socks",
            "Charger",
            "Cable",
            "Mouse",
            "Keyboard",
            "Headphones",
            "T-shirt",
            "Jeans",
            "Shoes",
            "Watch",
            "Wallet",
            "Candle",
            "Soap",
            "Shampoo",
            "Brush",
            "Perfume",
            "Coffee",
            "Tea",
            "Snacks",
            "Vitamins",
            "Toy",
            "Game"
        };

        double[] productUnitPrices = new double[]
        {
            12.99,  // Book
            25.50,  // Lamp
            8.00,   // Mug
            6.50,   // Socks
            15.99,  // Charger
            7.25,   // Cable
            29.99,  // Mouse
            45.00,  // Keyboard
            75.00,  // Headphones
            18.75,  // T-shirt
            49.99,  // Jeans
            65.00,  // Shoes
            89.99,  // Watch
            22.00,  // Wallet
            10.50,  // Candle
            4.00,   // Soap
            9.75,   // Shampoo
            5.50,   // Brush
            55.00,  // Perfume
            12.00,  // Coffee
            7.00,   // Tea
            3.50,   // Snacks
            19.99,  // Vitamins
            14.50,  // Toy
            39.99   // Game
        };

        Scanner scanner = new Scanner(System.in);
        double totalAmount = 0;
        int itemIndex = -1;

        // System.out.println("Welcom to the online shopping. Please input the number from following menu.");
        // System.out.println("Welcom to the online shopping. Please input the number from following menu.");
        while (true)
        {
            try
            {
                System.out.println("Enter the name of product to add it into shopping cart " + 
                    "or Enter \"Finish\" to checkout or Enter \"Exit\" to end the shopping.");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("Exit"))
                {
                    System.out.println("Thank you for shopping. Good bye.");
                    break;
                }
                
                if (input.equalsIgnoreCase("Finish"))
                {
                    System.out.println("Your total amount is: " + totalAmount);
                    System.out.println("Thank you for shopping with us. Good bye.");
                    break;
                }
                
                for (int index = 0;index < storeProducts.length;index++)
                {
                    if (storeProducts[index].equalsIgnoreCase(input))
                    {                    
                        itemIndex = index;
                        System.out.println("The item \"" + storeProducts[index] + "\" is found in the store." + 
                        " Please enter the quantity: ");
                        int qty = scanner.nextInt();
                        double itemCost = productUnitPrices[index] * qty;
                        totalAmount += itemCost;
                        System.out.println("Added product " + storeProducts[index] + " into shopping cart.");
                        System.out.println("The unit price is: " + productUnitPrices[index] + "\nQty: " + qty);
                        System.out.println("Item cost " + productUnitPrices[index] + " x " + qty + " = $" + itemCost);
                        System.out.println("Current total: $" + totalAmount);
                        break;
                    }                
                }
                
                if (itemIndex == -1)
                {
                    throw new ItemNotFoundException("Item \"" + input + "\" is not found. Please enter another name.");
                }
            }
            catch (ItemNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
            catch (Exception e)
            {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }

            
        }

        scanner.close();
    }
}
