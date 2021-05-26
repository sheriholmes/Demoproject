package UsersDetail.User.model;

import java.util.Objects;
import UsersDetail.User.model.ActionBy;
import UsersDetail.User.model.ChangeAction;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BaseChange
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-26T18:56:14.559989353+05:30[Asia/Kolkata]")

public class BaseChange   {
  @JsonProperty("action")
  private ChangeAction action;

  @JsonProperty("actionTime")
  private Long actionTime;

  @JsonProperty("actionBy")
  private ActionBy actionBy;

  public BaseChange action(ChangeAction action) {
    this.action = action;
    return this;
  }

  /**
   * Get action
   * @return action
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ChangeAction getAction() {
    return action;
  }

  public void setAction(ChangeAction action) {
    this.action = action;
  }

  public BaseChange actionTime(Long actionTime) {
    this.actionTime = actionTime;
    return this;
  }

  /**
   * Get actionTime
   * @return actionTime
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getActionTime() {
    return actionTime;
  }

  public void setActionTime(Long actionTime) {
    this.actionTime = actionTime;
  }

  public BaseChange actionBy(ActionBy actionBy) {
    this.actionBy = actionBy;
    return this;
  }

  /**
   * Get actionBy
   * @return actionBy
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ActionBy getActionBy() {
    return actionBy;
  }

  public void setActionBy(ActionBy actionBy) {
    this.actionBy = actionBy;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseChange baseChange = (BaseChange) o;
    return Objects.equals(this.action, baseChange.action) &&
        Objects.equals(this.actionTime, baseChange.actionTime) &&
        Objects.equals(this.actionBy, baseChange.actionBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, actionTime, actionBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseChange {\n");
    
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    actionTime: ").append(toIndentedString(actionTime)).append("\n");
    sb.append("    actionBy: ").append(toIndentedString(actionBy)).append("\n");
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

