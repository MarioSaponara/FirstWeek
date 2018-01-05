package main.model;

import java.util.Objects;

public class User {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String dateofbirth;
    private String fiscalcode;
    private String businessname;
    private String vat;
    private String municipality;
    private String post;
    private String city;
    private String address;
    private String telephone;
    private String fax;
    private String role;

    public User(String username, String password, String firstname, String lastname, String dateofbirth, String fiscalcode, String businessname, String vat, String municipality, String post, String city, String address, String telephone, String fax, String role) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.fiscalcode = fiscalcode;
        this.businessname = businessname;
        this.vat = vat;
        this.municipality = municipality;
        this.post = post;
        this.city = city;
        this.address = address;
        this.telephone = telephone;
        this.fax = fax;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getFiscalcode() {
        return fiscalcode;
    }

    public void setFiscalcode(String fiscalcode) {
        this.fiscalcode = fiscalcode;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        if (!firstname.equals(user.firstname)) return false;
        if (!lastname.equals(user.lastname)) return false;
        if (!dateofbirth.equals(user.dateofbirth)) return false;
        if (!fiscalcode.equals(user.fiscalcode)) return false;
        if (!businessname.equals(user.businessname)) return false;
        if (!vat.equals(user.vat)) return false;
        if (!municipality.equals(user.municipality)) return false;
        if (!post.equals(user.post)) return false;
        if (!city.equals(user.city)) return false;
        if (!address.equals(user.address)) return false;
        if (!telephone.equals(user.telephone)) return false;
        if (!fax.equals(user.fax)) return false;
        return role.equals(user.role);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + dateofbirth.hashCode();
        result = 31 * result + fiscalcode.hashCode();
        result = 31 * result + businessname.hashCode();
        result = 31 * result + vat.hashCode();
        result = 31 * result + municipality.hashCode();
        result = 31 * result + post.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + telephone.hashCode();
        result = 31 * result + fax.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UTENTE:" +
                "\nUsername = " + username +
                "\nPassword = " + password +
                "\nNome = " + firstname +
                "\nCognome = " + lastname +
                "\nData di nascita = " + dateofbirth +
                "\nCF = " + fiscalcode +
                "\nRegione Sociale = " + businessname +
                "\nP.IVA = " + vat +
                "\nComune = " + municipality +
                "\nCAP = " + post +
                "\nProvincia = " + city +
                "\nIndirizzo = " + address +
                "\nTelefono = " + telephone +
                "\nFax = " + fax +
                "\nRuolo = " + role;
    }
}