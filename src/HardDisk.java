
public class HardDisk {
    public int id;
    public String model;
    public double storage;
    public double rpm;
    public double price;
    public double rating;
    
    public HardDisk (int id, String model, double storage, double rpm, double price, double rating)
    {
        this.id = id;
        this.model = model;
        this.storage = storage;
        this.rpm = rpm;
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
    
    public double getStorage()
    {
            return storage;
    }
    
    public double getRPM()
    {
            return rpm;
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
