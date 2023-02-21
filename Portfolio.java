import java.util.ArrayList;
/**
 * This class initializes a Portfolio containing StockHolding objects and
 * contains method used to buy, sell, add, and remove stocks from the Portfolio.
 *
 * @author (Brendan Ortlieb, Noah Demarco)
 * @version (2/21/23, Spring 2023)
 */
public class Portfolio
{
    private ArrayList<StockHolding> stocks;
    private double investment;
    private double payout;
    
    public Portfolio(){
        stocks = new ArrayList<StockHolding>();
        investment = 0;
        payout = 0;
    }
    
    public double getInvestment(){
        return investment;
    }
    
    public double getPayout(){
        return payout;
    }
    
    /**
     * Returns the index of the stock in the stocks portfolio with the same
     * stock symbol, otherwise it returns -1.
     * 
     * @param symbol
     * @return returns the index of the stock in the stocks portfolio with the same
     * stock symbol, otherwise it returns -1.
     */
    private int getIndex(String symbol){
        for(int i = 0; i < stocks.size(); i++){
            if(stocks.get(i).getSymbol().equals(symbol)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Checks to sees if a stock can be found in the portfolio based on the
     * stock symbol, otherwise adds the input stock into the portfolio, and 
     * returns the cost of buying the input stock, or the matching stock.
     * 
     * @param symbol, name, numShares, price
     * @return returns the cost of buying the input stock, or the matching stock.
     */
    public double buyStock(String symbol, String name, int numShares, double price){
        for(int i = 0; i < stocks.size(); i++){
            if(stocks.get(i).getSymbol().equals(symbol)){
                stocks.get(i).buyShares(numShares, price);
                investment += numShares * price;
                return numShares * price;
            }
        }
        stocks.add(new StockHolding(symbol, name, numShares, price));
        investment += numShares * price;
        return numShares * price;
    }
    
    /**
     * Checks to sees if a stock can be found in the portfolio based on the
     * stock symbol, and sells the stock based off of the numShares number of 
     * stocks, and removes it from the portfolio if the portfolio holds 0 shares
     * of that stock. Returns the payout from selling the matching stock, 
     * otherwise it returns 0.
     * 
     * @param symbol, numShares
     * @return returns the payout from selling the matching stock, 
     * otherwise it returns 0.
     */
    public double sellStock(String symbol, int numShares){
        for(int i = 0; i < stocks.size(); i++){
            if(stocks.get(i).getSymbol().equals(symbol)){
                double cost = stocks.get(i).sellShares(numShares);
                payout += cost;
                if(stocks.get(i).getNumShares() == 0){
                    stocks.remove(stocks.get(i));
                }
                return cost;
            }
        }
        return 0;
    }
    
    /**
     * Returns the current value of the sum of all stocks in the portfolio.
     * 
     * @return returns the current value of the sum of all stocks in the portfolio.
     */
    public double getCurrentValue(){
        double value = 0.0;
        for(StockHolding stock: stocks){
            value += stock.getNumShares() * stock.getPrice();
        }
        return value;
    }
    
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%6s%25s%10s%15s%15s%n", 
            "Symbol", "Name", "Shares", "@Price", "Total"));
        sb.append("-----------------------------------------------------------------------\n");

        for(StockHolding s : stocks){
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
