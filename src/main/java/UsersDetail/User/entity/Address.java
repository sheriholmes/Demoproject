package UsersDetail.User.entity;

public class Address {
    String line1;
    Integer pincode;
    String city;

    public Address(String line1, Integer pincode, String city) {
        this.line1 = line1;
        this.pincode = pincode;
        this.city= city;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city= city;
    }
}

