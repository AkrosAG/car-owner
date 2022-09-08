import {Component, OnDestroy, OnInit} from '@angular/core';
import {OwnerService} from '../shared/service/owner.service';
import {Owner} from '../shared/entities/owner.type';
import {Subscription} from 'rxjs';
import {Router} from '@angular/router';

@Component({
  selector: 'app-owners',
  templateUrl: './owners.component.html',
  styleUrls: ['./owners.component.css']
})
export class OwnersComponent implements OnInit, OnDestroy {
  owners: Owner[] = [];
  subs: Subscription[] = [];
  columnsToDisplay = ['id', 'firstName', 'lastName'];
  constructor(
    private ownerService: OwnerService,
    private router: Router) { }

  ngOnInit(): void {
    this.subs.push(this.ownerService.getOwnerList().subscribe((ownersResponse: any[]) => {
      this.owners = ownersResponse;
    }));
  }

  showDetails(id: number) {
    this.router.navigate(['/owner', id]);
  }

  ngOnDestroy(): void {
    for (let sub of this.subs) {
      sub.unsubscribe();
    }
  }
}
