package org.sample.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
public class MetaInfo implements Serializable{

  private String status;
  private boolean error;
  private Integer errorCode;

  @Getter
  @Setter
  @JsonInclude(Include.NON_EMPTY)
  public static class Warning {
    private Integer code;
    private String text;
  }
  public MetaInfo(){
    this.status = String.valueOf("SUCCESS");
    this.error = false;
  }
  public MetaInfo(String status, boolean error){
    this.status = status;
    this.error = true;
  }
  public MetaInfo(String status, Integer errorCode){
    this.status = status;
    this.error = true;
    this.errorCode = errorCode;
  }
}
