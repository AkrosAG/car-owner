import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map, Observable} from 'rxjs';
import {Owner} from '../entities/owner.type';
import {environment} from "../../../environments/environment.prod";

@Injectable({
  providedIn: 'root'
})
export class OwnerService {


  constructor(private http: HttpClient) {
  }

  getOwnerList(): Observable<any> {
    // return this.http.get('http://127.0.0.1:64891/owner/list').pipe(map(response => {
    return this.http.get(`http://${environment.backend_address}:8080/owner/list`).pipe(map(response => {
      return response as Owner[];
    }));
  }

  getOwner(id: number): Observable<any> {
    return this.http.get('http://127.0.0.1:64891/owner/' + id).pipe(map(response => {
      return response as Owner;
    }));
  }
}
