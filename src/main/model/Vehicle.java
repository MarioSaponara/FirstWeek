package main.model;

public class Vehicle {

    private Integer id_vehicle;
    private String brand;
    private String model;
    private String fuel;
    private String version;
    private String capacity;

    public Vehicle(Integer id_vehicle, String brand, String model, String fuel, String version, String capacity) {
        this.id_vehicle = id_vehicle;
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
        this.version = version;
        this.capacity = capacity;
    }

    public Integer getId_vehicle() {
        return id_vehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (brand != null ? !brand.equals(vehicle.brand) : vehicle.brand != null) return false;
        if (model != null ? !model.equals(vehicle.model) : vehicle.model != null) return false;
        if (fuel != null ? !fuel.equals(vehicle.fuel) : vehicle.fuel != null) return false;
        if (version != null ? !version.equals(vehicle.version) : vehicle.version != null) return false;
        return capacity != null ? capacity.equals(vehicle.capacity) : vehicle.capacity == null;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (fuel != null ? fuel.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Veicolo:" +
                "\n Codice Veicolo = " + id_vehicle +
                "\n Marca = " + brand +
                "\n Modello = " + model +
                "\n Alimentazione = " + fuel +
                "\n Versione = " + version +
                "\n Cilindrata = " + capacity;
    }
}
