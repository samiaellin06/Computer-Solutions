
public class Monitor {

    public byte[] image;
    public int id;
    public String model;
    public double display_size;
    public String display_resolution;
    public double price;
    public double rating;

    public Monitor(byte[] image, int id, String model, double ds, String dr, double price, double rating) {
        this.image = image;
        this.id = id;
        this.model = model;
        this.display_size = ds;
        this.display_resolution = dr;
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
    
    public double getDisplaySize() {
        return display_size;
    }

    public String getDisplayResolution() {
        return display_resolution;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

}
