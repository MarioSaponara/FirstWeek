package main.model;

public class Gomma {

    private Integer id_gomme;
    private String model;
    private String manufacturer;
    private double price;
    private double width;
    private double height;
    private double diameter;
    private double weight;
    private String speed;
    private String season;
    private String typevehicle;
    private Integer quantity;

    public Gomma(Integer id_gomme, String model, String manufacturer, double price, double width, double height, double diameter, double weight, String speed, String season, String typevehicle, Integer quantity) {
        this.id_gomme = id_gomme;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.width = width;
        this.height = height;
        this.diameter = diameter;
        this.weight = weight;
        this.speed = speed;
        this.season = season;
        this.typevehicle = typevehicle;
        this.quantity = quantity;
    }

    public Integer getId_gomme() {
        return id_gomme;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTypevehicle() {
        return typevehicle;
    }

    public void setTypevehicle(String typevehicle) {
        this.typevehicle = typevehicle;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gomma gomma = (Gomma) o;

        if (Double.compare(gomma.price, price) != 0) return false;
        if (Double.compare(gomma.width, width) != 0) return false;
        if (Double.compare(gomma.height, height) != 0) return false;
        if (Double.compare(gomma.diameter, diameter) != 0) return false;
        if (Double.compare(gomma.weight, weight) != 0) return false;
        if (model != null ? !model.equals(gomma.model) : gomma.model != null) return false;
        if (manufacturer != null ? !manufacturer.equals(gomma.manufacturer) : gomma.manufacturer != null) return false;
        if (speed != null ? !speed.equals(gomma.speed) : gomma.speed != null) return false;
        if (season != null ? !season.equals(gomma.season) : gomma.season != null) return false;
        return typevehicle != null ? typevehicle.equals(gomma.typevehicle) : gomma.typevehicle == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = model != null ? model.hashCode() : 0;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(diameter);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        result = 31 * result + (season != null ? season.hashCode() : 0);
        result = 31 * result + (typevehicle != null ? typevehicle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GOMMA:" +
                "\nCodice gomma = " + id_gomme +
                "\nModello = " + model +
                "\nProduttore = " + manufacturer +
                "\nPrezzo = " + price +
                "\nLarghezza = " + width +
                "\nAltezza = " + height +
                "\nDiametro = " + diameter +
                "\nCarico = " + weight +
                "\nVelocità = " + speed +
                "\nStagione = " + season +
                "\nTipo veicolo = " + typevehicle +
                "\nQuantità = " + quantity;
    }
}
