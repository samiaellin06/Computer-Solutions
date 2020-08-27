
public class Mouse {
    
    public byte[] image;
    public int id;
    public String model;
    public String type;
    public String connectivity;
    public double price;
    public double rating;

    public Mouse(byte[] image, int id, String model, String type, String connectivity, double price, double rating) {
        this.image = image;
        this.id = id;
        this.model = model;
        this.type = type;
        this.connectivity = connectivity;
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
    
    public String getType() {
        return type;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }
    
}
