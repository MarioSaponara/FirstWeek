package main.model;

public class Compatibility {

    private Integer id_vehicle;
    private Integer id_gomme;

    public Compatibility(Integer id_vehicle, Integer id_gomme) {
        this.id_vehicle = id_vehicle;
        this.id_gomme = id_gomme;
    }

    public Integer getId_vehicle() {
        return id_vehicle;
    }

    public void setId_vehicle(Integer id_vehicle) {
        this.id_vehicle = id_vehicle;
    }

    public Integer getId_gomme() {
        return id_gomme;
    }

    public void setId_gomme(Integer id_gomme) {
        this.id_gomme = id_gomme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Compatibility that = (Compatibility) o;

        if (id_vehicle != null ? !id_vehicle.equals(that.id_vehicle) : that.id_vehicle != null) return false;
        return id_gomme != null ? id_gomme.equals(that.id_gomme) : that.id_gomme == null;
    }

    @Override
    public int hashCode() {
        int result = id_vehicle != null ? id_vehicle.hashCode() : 0;
        result = 31 * result + (id_gomme != null ? id_gomme.hashCode() : 0);
        return result;
    }
}

