import {Car} from './car.type';

export type Owner = {
  id: number,
  firstName: string,
  lastName: string,
  created: string,
  cars: Car[]
}
