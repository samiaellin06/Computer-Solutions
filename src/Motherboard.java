
public class Motherboard {
    public int Id;
    public String model;
    public String CPU_Sockets;
    public String chipset;
    public String supported_CPU;
    public String generation;
    public String RAM_type;	
    public String RAM_bus;	
    public int RAM_max;		
    public String PCI_Express;
    public double price;
    public double rating;

    
    public Motherboard (int id, String model, String socket, String chipset, String CPU, String generation, String ram_type, String ram_bus, int ram_max, String pci, double price, double rating)
    {
        this.Id = id;
        this.model = model;
        this.CPU_Sockets = socket;
        this.chipset = chipset;
        this.supported_CPU = CPU;
        this.generation = generation;
        this.RAM_type = ram_type;
        this.RAM_bus = ram_bus;
        this.RAM_max = ram_max;
        this.PCI_Express = pci;
        this.price = price;
        this.rating = rating;
    }
    
    public int getId()
    {
        return Id;
    }
    
    public String getModel()
    {
        return model;
    }
    
    public String getCPUSocket()
    {
        return CPU_Sockets;
    }
    
    public String getChipset()
    {
        return chipset;
    }
    
    public String getSupportedCPU()
    {
        return supported_CPU;
    }
    
    public String getGeneration()
    {
        return generation;
    }
    
    public String getRAMType()
    {
        return RAM_type;
    }
    
    public String getRAMBus()
    {
        return RAM_bus;
    }
    
    public int getRAMMax()
    {
        return RAM_max;
    }
    
    public String getPCIExpress()
    {
        return PCI_Express;
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
