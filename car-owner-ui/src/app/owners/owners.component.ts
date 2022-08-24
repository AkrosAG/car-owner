import { Component, OnInit } from '@angular/core';
import {OwnerService} from '../shared/service/owner.service';
import {Owner} from '../shared/entities/owner.type';

@Component({
  selector: 'app-owners',
  templateUrl: './owners.component.html',
  styleUrls: ['./owners.component.css']
})
export class OwnersComponent implements OnInit {
  owners: Owner[] = [];

  constructor(private ownerService: OwnerService) { }

  ngOnInit(): void {
    this.ownerService.getOwnerList().subscribe((ownersResponse: any[]) => {
      this.owners = ownersResponse;
    })
  }

  showDetails(id: number) {
    console.log(id);
  }
}
