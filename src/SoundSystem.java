
public class SoundSystem {
   
    public byte[] image;
    public int id;
    public String brand;
    public String model;
    public double channel;
    public double price;
    public double rating;

    public SoundSystem(byte[] image, int id, String brand, String model, double channel, double price, double rating) {
        this.image = image;
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.channel = channel;
        this.price = price;
        this.rating = rating;
    }

    public byte[] getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }

    public double getChannel() {
        return channel;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }
    
}
