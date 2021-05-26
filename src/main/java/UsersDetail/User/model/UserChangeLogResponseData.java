package UsersDetail.User.model;

import java.util.Objects;
import UsersDetail.User.model.UserBaseChangeLogResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserChangeLogResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-25T14:44:11.109837519+05:30[Asia/Kolkata]")

public class UserChangeLogResponseData   {
  @JsonProperty("log")
  @Valid
  private List<UserBaseChangeLogResponse> log = null;

  @JsonProperty("totalItems")
  private Long totalItems;

  public UserChangeLogResponseData log(List<UserBaseChangeLogResponse> log) {
    this.log = log;
    return this;
  }

  public UserChangeLogResponseData addLogItem(UserBaseChangeLogResponse logItem) {
    if (this.log == null) {
      this.log = new ArrayList<>();
    }
    this.log.add(logItem);
    return this;
  }

  /**
   * Get log
   * @return log
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<UserBaseChangeLogResponse> getLog() {
    return log;
  }

  public void setLog(List<UserBaseChangeLogResponse> log) {
    this.log = log;
  }

  public UserChangeLogResponseData totalItems(Long totalItems) {
    this.totalItems = totalItems;
    return this;
  }

  /**
   * Get totalItems
   * @return totalItems
  */
  @ApiModelProperty(value = "")


  public Long getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(Long totalItems) {
    this.totalItems = totalItems;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserChangeLogResponseData userChangeLogResponseData = (UserChangeLogResponseData) o;
    return Objects.equals(this.log, userChangeLogResponseData.log) &&
        Objects.equals(this.totalItems, userChangeLogResponseData.totalItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(log, totalItems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserChangeLogResponseData {\n");
    
    sb.append("    log: ").append(toIndentedString(log)).append("\n");
    sb.append("    totalItems: ").append(toIndentedString(totalItems)).append("\n");
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

