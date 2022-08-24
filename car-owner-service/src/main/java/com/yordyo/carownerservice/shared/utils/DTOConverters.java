package com.yordyo.carownerservice.shared.utils;

import java.util.stream.Collectors;

import com.yordyo.carownerservice.car.dto.CarDTO;
import com.yordyo.carownerservice.car.entity.Car;
import com.yordyo.carownerservice.cardata.dto.CarDataDTO;
import com.yordyo.carownerservice.cardata.entity.CarData;
import com.yordyo.carownerservice.owner.dto.OwnerDTO;
import com.yordyo.carownerservice.owner.entity.Owner;

public class DTOConverters {
  private DTOConverters() {
    // no-op
  }

  public static OwnerDTO mapToDto(Owner owner, boolean deep) {
    OwnerDTO result = new OwnerDTO();

    result.setId(owner.getId());
    result.setFirstName(owner.getFirstName());
    result.setLastName(owner.getLastName());
    result.setCreated(owner.getCreated());
    result.setCars(owner.getCars() != null && deep ?
        owner.getCars().stream().map(car -> DTOConverters.mapToDto(car, true)).collect(Collectors.toList()) : null);

    return result;
  }

  public static CarDTO mapToDto(Car car, boolean deep) {
    CarDTO result = new CarDTO();

    result.setId(car.getId());
    result.setManufacturer(car.getManufacturer());
    result.setModel(car.getModel());
    result.setRegistrationYear(car.getRegistrationYear());
    result.setData(car.getData() != null && deep ? mapToDto(car.getData()) : null);

    return result;
  }

  public static CarDataDTO mapToDto(CarData carData) {
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
