
public class Casing {

    public byte[] image;
    public int id;
    public String model;
    public String supported_motherboard;
    public int psu;
    public double price;
    public double rating;

    public Casing(byte[] image, int id, String model, String sm, int psu, double price, double rating) {
        this.image = image;
        this.id = id;
        this.model = model;
        this.supported_motherboard = sm;
        this.psu = psu;
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

    public String getSupportedMotherboard() {
        return supported_motherboard;
    }

    public int getPSU() {
        return psu;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

}