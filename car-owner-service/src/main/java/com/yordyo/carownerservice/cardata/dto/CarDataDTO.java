package com.yordyo.carownerservice.cardata.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDataDTO {
  private long id;
  private Integer engineSize;
  private String type;
  private Integer hp;
  private Integer seats;
  private Integer manufacturedYear;
}

