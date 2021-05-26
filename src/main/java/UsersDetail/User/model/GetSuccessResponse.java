package UsersDetail.User.model;

import java.util.Objects;
import UsersDetail.User.model.Error;
import UsersDetail.User.model.ErrorResponse;
import UsersDetail.User.model.GetSuccessResponseAllOf;
import UsersDetail.User.model.Request;
import UsersDetail.User.model.UserResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetSuccessResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-26T18:56:14.559989353+05:30[Asia/Kolkata]")

public class GetSuccessResponse   {
  @JsonProperty("error")
  private Error error;

  @JsonProperty("request")
  private Request request;

  @JsonProperty("data")
  private UserResponse data;

  public GetSuccessResponse error(Error error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Error getError() {
    return error;
  }

  public void setError(Error error) {
    this.error = error;
  }

  public GetSuccessResponse request(Request request) {
    this.request = request;
    return this;
  }

  /**
   * Get request
   * @return request
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Request getRequest() {
    return request;
  }

  public void setRequest(Request request) {
    this.request = request;
  }

  public GetSuccessResponse data(UserResponse data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @ApiModelProperty(value = "")

  @Valid

  public UserResponse getData() {
    return data;
  }

  public void setData(UserResponse data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetSuccessResponse getSuccessResponse = (GetSuccessResponse) o;
    return Objects.equals(this.error, getSuccessResponse.error) &&
        Objects.equals(this.request, getSuccessResponse.request) &&
        Objects.equals(this.data, getSuccessResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, request, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetSuccessResponse {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    request: ").append(toIndentedString(request)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

