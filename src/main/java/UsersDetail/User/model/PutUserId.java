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
 * PutUserId
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-26T18:56:14.559989353+05:30[Asia/Kolkata]")

public class PutUserId   {
  @JsonProperty("line1")
  private String line1;

  @JsonProperty("city")
  private String city;

  @JsonProperty("pincode")
  private Integer pincode;

  @JsonProperty("number")
  private String number;

  public PutUserId line1(String line1) {
    this.line1 = line1;
    return this;
  }

  /**
   *  user's  house number
   * @return line1
  */
  @ApiModelProperty(value = " user's  house number")


  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public PutUserId city(String city) {
    this.city = city;
    return this;
  }

  /**
   * user's city
   * @return city
  */
  @ApiModelProperty(value = "user's city")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public PutUserId pincode(Integer pincode) {
    this.pincode = pincode;
    return this;
  }

  /**
   *  pincode 
   * @return pincode
  */
  @ApiModelProperty(value = " pincode ")

@Size(max=6) 
  public Integer getPincode() {
    return pincode;
  }

  public void setPincode(Integer pincode) {
    this.pincode = pincode;
  }

  public PutUserId number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Mobile no. of the user.
   * @return number
  */
  @ApiModelProperty(required = true, value = "Mobile no. of the user.")
  @NotNull

@Pattern(regexp="^[0-9]{10}$") @Size(max=10) 
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PutUserId putUserId = (PutUserId) o;
    return Objects.equals(this.line1, putUserId.line1) &&
        Objects.equals(this.city, putUserId.city) &&
        Objects.equals(this.pincode, putUserId.pincode) &&
        Objects.equals(this.number, putUserId.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(line1, city, pincode, number);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PutUserId {\n");
    
    sb.append("    line1: ").append(toIndentedString(line1)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    pincode: ").append(toIndentedString(pincode)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
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

