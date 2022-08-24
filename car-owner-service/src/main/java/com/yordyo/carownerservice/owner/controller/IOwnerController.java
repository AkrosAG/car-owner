package com.yordyo.carownerservice.owner.controller;

import java.util.List;

import com.yordyo.carownerservice.owner.dto.OwnerDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("owner")
public interface IOwnerController {
  @GetMapping("all")
  List<OwnerDTO> getAllOwners();
}
