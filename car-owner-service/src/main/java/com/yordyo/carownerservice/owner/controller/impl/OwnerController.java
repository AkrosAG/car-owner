package com.yordyo.carownerservice.owner.controller.impl;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.yordyo.carownerservice.owner.controller.IOwnerController;
import com.yordyo.carownerservice.owner.dto.CreateOwnerDTO;
import com.yordyo.carownerservice.owner.dto.OwnerDTO;
import com.yordyo.carownerservice.owner.service.IOwnerService;
import com.yordyo.carownerservice.shared.dto.GenericErrorDTO;
import com.yordyo.carownerservice.shared.dto.GenericSuccessDTO;
import com.yordyo.carownerservice.shared.utils.PropertiesAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import static com.yordyo.carownerservice.owner.misc.MessageConstants.ERROR_WRONG_ARGUMENTS;
import static com.yordyo.carownerservice.owner.misc.MessageConstants.SUCCESS_DELETE;
import static com.yordyo.carownerservice.shared.utils.PropertiesAccessor.getSuccessProperties;

@RestController
public class OwnerController implements IOwnerController {
  private final IOwnerService ownerService;

  public OwnerController(IOwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @Override
  public List<OwnerDTO> getAllOwners() {
    return ownerService.getAllOwnersData();
  }

  @Override
  public List<OwnerDTO> getOwnerList() {
    return ownerService.getOwnerList();
  }

  @Override
  public OwnerDTO getOwner(Long id) {
    return ownerService.getOwner(id);
  }

  @Override
  public GenericSuccessDTO deleteOwner(Long id) throws IOException {
    ownerService.deleteOwner(id);
    return new GenericSuccessDTO(
        SUCCESS_DELETE,
        getSuccessProperties("owner-success.properties").getProperty(SUCCESS_DELETE)
    );
  }

  @Override
  public OwnerDTO createOwner(CreateOwnerDTO owner) {
    return ownerService.createOwner(owner);
  }



  @ExceptionHandler({ ConstraintViolationException.class })
  public ResponseEntity<Object> handleConstraintViolation(
      ConstraintViolationException ex, WebRequest request) throws IOException {
    List<String> errors = new ArrayList<>();
    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
      errors.add(violation.getRootBeanClass().getName() + " " +
          violation.getPropertyPath() + ": " + violation.getMessage());
    }

    GenericErrorDTO errorDTO = new GenericErrorDTO();
    errorDTO.setErrorCode(ERROR_WRONG_ARGUMENTS);
    errorDTO.setErrorMessage(PropertiesAccessor.getErrorProperties("owner-errors.properties").get(ERROR_WRONG_ARGUMENTS).toString());
    return ResponseEntity.badRequest().body(errorDTO);
  }
}
