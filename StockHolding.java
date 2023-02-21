/**
 * This class initializes StockHolding objects and contains methods used to buy
 * and sell shares of a stock.
 *
 * @author (Noah Demarco, Brendan Ortlieb)
 * @version (2/21/2023, Spring 2023)
 */
public class StockHolding
{
    private String name;
    private String symbol;
    private int numShares;
    private double price;
    
    public StockHolding(String symbol, String name, int numShares, double price) {
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getNumShares() {
        return numShares;
    }

    public double getPrice() {
        return price;
    }
    
    /**
     * Updates the number of shares the user has, based off if and how many
     * were purchased.
     * 
     * @param numShares
     * @param price
     */
    
    public void buyShares(int numShares, double price){
        this.numShares += numShares;
    }
    
    /**
     * returns the dollar amount resulting from the sale of shares.
     * 
     * @param numShares
     * @return returns the dollar amount resulting from the sale of shares.
     */
    public double sellShares(int numShares){
        if (this.numShares >= numShares){
            this.numShares -= numShares;
            return this.price * numShares;
        }
        return 0;
    }
    
    @Override
    public String toString()
     {
         //DO NOT EDIT THIS METHOD.
         return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
         symbol, name, numShares, price, numShares * price); 
     }
}
