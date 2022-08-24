package com.yordyo.carownerservice.car.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yordyo.carownerservice.cardata.dto.CarDataDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {
  private Long id;
  private String manufacturer;
  private String model;
  private Integer registrationYear;
  private CarDataDTO data;
}

