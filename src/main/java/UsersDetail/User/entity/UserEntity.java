package UsersDetail.User.entity;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;
@Table
public class UserEntity {
    @PrimaryKey
    private String id  = UUID.randomUUID().toString();
    @Column
    private String name;
    @Column
    private String number;
    @Column
    private String line1;
    @Column
    private String city;
    @Column
    private Integer pincode;
    @Column
    private String address;
    @Column
    private  String mobile;

    @Column
    private Boolean isDeleted = false;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



    public UserEntity() {

    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }


    public UserEntity(String id, String name, String line1, String number, String city, Integer pincode) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.line1 = line1;
        this.city = city;
        this.pincode = pincode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String mobile) {
        this.number = number;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}

