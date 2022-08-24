import {CarData} from './car-data.type';

export type Car = {
  id: number,
  manufacturer: string,
  model: string,
  registrationYear:number,
  data: CarData
}
