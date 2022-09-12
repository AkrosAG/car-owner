import {Injectable} from '@angular/core';
import {delay, Observable, of} from 'rxjs';
import {Demodata} from '../entities/demodata';

@Injectable({
  providedIn: 'root'
})
export class DemodataService {

  constructor() {
    // This is intentional
  }

  getDemodata(): Observable<Demodata[]> {
    return of(DEMO_DATA).pipe(delay(5000));
  }
}

const DEMO_DATA: Demodata[] = [
  {id: 1, description: 'Description 1', date: Date.now()},
  {id: 2, description: 'Description 2', date: Date.now()}
];
