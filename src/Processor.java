public class Processor 
{
    private int id;
    private String model;
    private String code_name;
    private double base_frequency;
    private int cache_memory;
    private int generation;
    private double price;
    private double rating;
    
    
    public Processor (int id, String model, String code_name, double base_frequency, int cache_memory, int generation, double price, double rating)
    {
        this.id = id;
        this.model = model;
        this.code_name = code_name;
        this.base_frequency = base_frequency;
        this.cache_memory = cache_memory;
        this.generation = generation;
        this.price = price;
        this.rating = rating;
    }

    Processor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId()
    {
            return id;
    }
    
    public String getModel()
    {
            return model;
    }
    
    public String getCodeName()
    {
            return code_name;
    }
    
    public double getBaseFrequency()
    {
            return base_frequency;
    }
    
     public int getCacheMemory()
    {
            return cache_memory;
    }
     
    public int getGeneration()
    {
            return generation;
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
     
     
