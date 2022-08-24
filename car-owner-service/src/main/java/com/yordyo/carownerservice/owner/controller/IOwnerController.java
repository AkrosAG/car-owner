package com.yordyo.carownerservice.owner.controller;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import com.yordyo.carownerservice.owner.dto.CreateOwnerDTO;
import com.yordyo.carownerservice.owner.dto.OwnerDTO;
import com.yordyo.carownerservice.shared.dto.GenericSuccessDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("owner")
public interface IOwnerController {
  @GetMapping("all")
  List<OwnerDTO> getAllOwners();

  @GetMapping("list")
  List<OwnerDTO> getOwnerList();

  @GetMapping("{id}")
  OwnerDTO getOwner(@PathVariable("id") Long id);

  @DeleteMapping("{id}")
  GenericSuccessDTO deleteOwner(@PathVariable("id") Long id) throws IOException;

  @PostMapping("")
  OwnerDTO createOwner(@RequestBody @Valid CreateOwnerDTO owner);
}
