package com.yordyo.carownerservice.owner.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.yordyo.carownerservice.car.dto.CarDTO;
import com.yordyo.carownerservice.car.entity.Car;
import com.yordyo.carownerservice.cardata.dto.CarDataDTO;
import com.yordyo.carownerservice.cardata.entity.CarData;
import com.yordyo.carownerservice.owner.dto.OwnerDTO;
import com.yordyo.carownerservice.owner.entity.Owner;
import com.yordyo.carownerservice.owner.repository.OwnerRepository;
import com.yordyo.carownerservice.owner.service.IOwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerService implements IOwnerService {
  private final OwnerRepository ownerRepository;

  public OwnerService(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  @Override
  public List<OwnerDTO> getAllOwners() {
    List<Owner> owners = new ArrayList<>();

    ownerRepository.findAll().forEach(owners::add);
    if (!owners.isEmpty()) {
      return owners.stream()
          .map(this::mapToDto)
          .collect(Collectors.toList());
    }

    return Collections.emptyList();
  }

  private OwnerDTO mapToDto(Owner owner) {
    OwnerDTO result = new OwnerDTO();

    result.setId(owner.getId());
    result.setFirstName(owner.getFirstName());
    result.setLastName(owner.getLastName());
    result.setCreated(owner.getCreated());
    result.setCars(owner.getCars() != null ?
        owner.getCars().stream().map(this::mapToDto).collect(Collectors.toList()) : null);

    return result;
  }

  private CarDTO mapToDto(Car car) {
    CarDTO result = new CarDTO();

    result.setId(car.getId());
    result.setManufacturer(car.getManufacturer());
    result.setModel(car.getModel());
    result.setRegistrationYear(car.getRegistrationYear());
    result.setData(car.getData() != null ? mapToDto(car.getData()) : null);

    return result;
  }

  private CarDataDTO mapToDto(CarData carData) {
    CarDataDTO result = new CarDataDTO();

    result.setId(carData.getId());
    result.setHp(carData.getHp());
    result.setEngineSize(carData.getEngineSize());
    result.setType(carData.getType());
    result.setSeats(carData.getSeats());
    result.setManufacturedYear(carData.getManufacturedYear());

    return result;
  }
}
