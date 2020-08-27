
public class PowerSupply {
    public int id;
    public String model;
    public int max_power;
    public double price;
    public double rating;
    
    public PowerSupply (int id, String model, int power, double price, double rating)
    {
        this.id = id;
        this.model = model;
        this.max_power = power;
        this.price = price;
        this.rating = rating;      
    }
    
     public int getId()
    {
            return id;
    }
     
    public String getModel()
    {
            return model;
    }
    
    public int getMaxPower()
    {
            return max_power;
    }
    
    public double getPrice()
    {
            return price;
    }
     
    public double getRating()
    {
            return rating;
    }
}
