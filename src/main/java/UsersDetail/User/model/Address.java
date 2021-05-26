package UsersDetail.User.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Address
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-26T18:56:14.559989353+05:30[Asia/Kolkata]")

public class Address   {
  @JsonProperty("line1")
  private String line1;

  @JsonProperty("city")
  private String city;

  @JsonProperty("pincode")
  private Integer pincode;

  public Address line1(String line1) {
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

  public Address city(String city) {
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

  public Address pincode(Integer pincode) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.line1, address.line1) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.pincode, address.pincode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(line1, city, pincode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    line1: ").append(toIndentedString(line1)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    pincode: ").append(toIndentedString(pincode)).append("\n");
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

