
public class GraphicsCard {
    int id;
    String chipset;  
    String engine_model; 
    double interface_bus; 
    int memory;
    int psu;
    double price; 
    double rating;
    
    public GraphicsCard (int Id, String Chipset, String Engine_Model, double Interface_bus, int Memory, int PSU, double Price, double Rating)
    {
        this.id = Id;
        this.chipset = Chipset;  
        this.engine_model = Engine_Model; 
        this.interface_bus = Interface_bus; 
        this.memory = Memory;
        this.psu = PSU;
        this.price = Price; 
        this.rating = Rating;   
    }
    
    public int getId()
    {
            return id;
    }
    
    public String getChipset()
    {
            return chipset;
    }
    
    public String getEngineModel()
    {
            return engine_model;
    }
    
    public double getInterfaceBus()
    {
            return interface_bus;
    }
    
    public int getMemory()
    {
            return memory;
    }
    
    public int getPSU()
    {
            return psu;
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
