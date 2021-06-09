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
 * Mobile
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-26T18:56:14.559989353+05:30[Asia/Kolkata]")

public class Mobile   {
  @JsonProperty("number")
  private String number;

  public Mobile number(String number) {
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
    Mobile mobile = (Mobile) o;
    return Objects.equals(this.number, mobile.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mobile {\n");
    
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

