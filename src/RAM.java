
public class RAM {
 private int id;
    private String model;
    private String memory_type;
    private int memory_bus;
    private int capacity;
    private double price;
    private double rating;
    
    
    public RAM (int id, String model, String memory_type, int memory_bus, int capacity, double price, double rating)
    {
        this.id = id;
        this.model = model;
        this.memory_type = memory_type;
        this.memory_bus = memory_bus;
        this.capacity = capacity;
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
    
    public String getMemoryType()
    {
            return memory_type;
    }
    
    public int getMemoryBus()
    {
            return memory_bus;
    }
    
     public int getCapacity()
    {
            return capacity;
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
