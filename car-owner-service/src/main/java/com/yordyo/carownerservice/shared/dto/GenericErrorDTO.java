package com.yordyo.carownerservice.shared.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericErrorDTO {
  String errorCode;
  String errorMessage;
  List<String> errorMessages;
}
