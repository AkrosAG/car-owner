import {Component, OnDestroy, OnInit} from '@angular/core';
import {Owner} from '../../shared/entities/owner.type';
import {ActivatedRoute, Router} from '@angular/router';
import {OwnerService} from '../../shared/service/owner.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-owner-details',
  templateUrl: './owner-details.component.html',
  styleUrls: ['./owner-details.component.css']
})
export class OwnerDetailsComponent implements OnInit, OnDestroy {
  owner: Owner | null = null;
  private subs: Subscription[] = [];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private ownerService: OwnerService
  ) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.params['id'];
    this.subs.push(this.ownerService.getOwner(id).subscribe(owner => {
      this.owner = owner;
    }))
  }

  ngOnDestroy(): void {
    for (let sub of this.subs) {
      sub.unsubscribe();
    }
  }
}
