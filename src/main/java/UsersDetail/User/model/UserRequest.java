package UsersDetail.User.model;

import java.util.Objects;
import UsersDetail.User.model.Address;
import UsersDetail.User.model.Mobile;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-25T14:44:11.109837519+05:30[Asia/Kolkata]")

public class UserRequest   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("address")
  private Address address;

  @JsonProperty("mobile")
  private Mobile mobile;

  public UserRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of the user
   * @return name
  */
  @ApiModelProperty(required = true, value = "name of the user")
  @NotNull

@Pattern(regexp="^[a-zA-Z]$") 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserRequest address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public UserRequest mobile(Mobile mobile) {
    this.mobile = mobile;
    return this;
  }

  /**
   * Get mobile
   * @return mobile
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Mobile getMobile() {
    return mobile;
  }

  public void setMobile(Mobile mobile) {
    this.mobile = mobile;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRequest userRequest = (UserRequest) o;
    return Objects.equals(this.name, userRequest.name) &&
        Objects.equals(this.address, userRequest.address) &&
        Objects.equals(this.mobile, userRequest.mobile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, mobile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

