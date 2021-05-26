package UsersDetail.User.model;

import java.util.Objects;
import UsersDetail.User.model.ActionBy;
import UsersDetail.User.model.BaseChange;
import UsersDetail.User.model.ChangeAction;
import UsersDetail.User.model.UserResponseData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserBaseChangeLogResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-26T18:56:14.559989353+05:30[Asia/Kolkata]")

public class UserBaseChangeLogResponse extends BaseChange  {
  @JsonProperty("cdc")
  private UserResponseData cdc = null;

  public UserBaseChangeLogResponse cdc(UserResponseData cdc) {
    this.cdc = cdc;
    return this;
  }

  /**
   * Get cdc
   * @return cdc
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public UserResponseData getCdc() {
    return cdc;
  }

  public void setCdc(UserResponseData cdc) {
    this.cdc = cdc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserBaseChangeLogResponse userBaseChangeLogResponse = (UserBaseChangeLogResponse) o;
    return Objects.equals(this.cdc, userBaseChangeLogResponse.cdc) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cdc, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserBaseChangeLogResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    cdc: ").append(toIndentedString(cdc)).append("\n");
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

