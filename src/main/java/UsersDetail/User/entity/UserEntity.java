package UsersDetail.User.entity;
import UsersDetail.User.model.Mobile;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;
@Table("userEntity")
public class UserEntity {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    @Column
    private String name;
    @Column
    @NotNull
    @Pattern(regexp="^[0-9]{10}$")
    @Size(max=10)
    private String number;
    @Column
    private String line1;
    @Column
    private String city;
    @Column
    private String pincode;

    @Column
    private Boolean isDeleted = false;

    public UserEntity() {

    }




    @Override
    public boolean equals(Object obj) {
        return true;
    }


    public UserEntity(String id, String name, String line1, String number, String city, String pincode) {
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
        this.number = mobile;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}



