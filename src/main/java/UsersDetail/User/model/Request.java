package UsersDetail.User.model;

import java.util.Objects;
import UsersDetail.User.model.Method;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Request
 */
@ApiModel(description = "Request")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-25T14:44:11.109837519+05:30[Asia/Kolkata]")

public class Request   {
  @JsonProperty("uri")
  private String uri;

  @JsonProperty("method")
  private Method method;

  @JsonProperty("queryString")
  private String queryString;

  @JsonProperty("body")
  private Object body;

  public Request uri(String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * end point where the request will be received
   * @return uri
  */
  @ApiModelProperty(required = true, value = "end point where the request will be received")
  @NotNull


  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public Request method(Method method) {
    this.method = method;
    return this;
  }

  /**
   * Get method
   * @return method
  */
  @ApiModelProperty(value = "")

  @Valid

  public Method getMethod() {
    return method;
  }

  public void setMethod(Method method) {
    this.method = method;
  }

  public Request queryString(String queryString) {
    this.queryString = queryString;
    return this;
  }

  /**
   * query string received by the server
   * @return queryString
  */
  @ApiModelProperty(value = "query string received by the server")


  public String getQueryString() {
    return queryString;
  }

  public void setQueryString(String queryString) {
    this.queryString = queryString;
  }

  public Request body(Object body) {
    this.body = body;
    return this;
  }

  /**
   * Get body
   * @return body
  */
  @ApiModelProperty(value = "")

  @Valid

  public Object getBody() {
    return body;
  }

  public void setBody(Object body) {
    this.body = body;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Request request = (Request) o;
    return Objects.equals(this.uri, request.uri) &&
        Objects.equals(this.method, request.method) &&
        Objects.equals(this.queryString, request.queryString) &&
        Objects.equals(this.body, request.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uri, method, queryString, body);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");
    
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    queryString: ").append(toIndentedString(queryString)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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

