public class Cart
{
    String item;
    int id;
    int quantity;
    double price;
    
    public Cart (String item, int quantity, double price)
    {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Cart (int id, String item, int quantity, double price)
    {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }
    
    public int getId()
    {
            return id;
    }
    
    
    public String getItem()
    {
            return item;
    }
    
    public int getQuantity()
    {
            return quantity;
    }
    
    public double getPrice()
    {
            return price;
    }
}
     
     