package UsersDetail.User.model;

import java.util.Objects;
import UsersDetail.User.model.Error;
import UsersDetail.User.model.Request;
import UsersDetail.User.model.UserChangeLogResponseData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserChangeLogResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-26T18:56:14.559989353+05:30[Asia/Kolkata]")

public class UserChangeLogResponse   {
  @JsonProperty("error")
  private Error error;

  @JsonProperty("data")
  private UserChangeLogResponseData data;

  @JsonProperty("request")
  private Request request;

  public UserChangeLogResponse error(Error error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
  */
  @ApiModelProperty(value = "")

  @Valid

  public Error getError() {
    return error;
  }

  public void setError(Error error) {
    this.error = error;
  }

  public UserChangeLogResponse data(UserChangeLogResponseData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @ApiModelProperty(value = "")

  @Valid

  public UserChangeLogResponseData getData() {
    return data;
  }

  public void setData(UserChangeLogResponseData data) {
    this.data = data;
  }

  public UserChangeLogResponse request(Request request) {
    this.request = request;
    return this;
  }

  /**
   * Get request
   * @return request
  */
  @ApiModelProperty(value = "")

  @Valid

  public Request getRequest() {
    return request;
  }

  public void setRequest(Request request) {
    this.request = request;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserChangeLogResponse userChangeLogResponse = (UserChangeLogResponse) o;
    return Objects.equals(this.error, userChangeLogResponse.error) &&
        Objects.equals(this.data, userChangeLogResponse.data) &&
        Objects.equals(this.request, userChangeLogResponse.request);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, data, request);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserChangeLogResponse {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    request: ").append(toIndentedString(request)).append("\n");
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

