
public class UPS {
    
    public byte[] image;
    public int id;
    public String model;
    public double price;
    public double rating;

    public UPS(byte[] image, int id, String model, double price, double rating) {
        this.image = image;
        this.id = id;        
        this.model = model;       
        this.price = price;
        this.rating = rating;
    }

    public byte[] getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
    
    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }
    
}