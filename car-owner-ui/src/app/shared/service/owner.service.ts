import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map, Observable} from 'rxjs';
import {Owner} from '../entities/owner.type';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {
  constructor(private http: HttpClient) {}

  getOwnerList(): Observable<any> {
    return this.http.get('http://localhost:8080/owner/list').pipe(map(response => {
      return response as Owner[];
    }));
  }

  getOwner(id: number): Observable<any> {
    return this.http.get('http://localhost:8080/owner/' + id).pipe(map(response => {
      return response as Owner;
    }));
  }
}
