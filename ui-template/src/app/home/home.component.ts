import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {Demodata} from '../api/entities/demodata';
import {DemodataService} from '../api/services/demodata.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  demoData: Demodata[] = [];
  dataSource: MatTableDataSource<Demodata> = new MatTableDataSource();
  displayedColumns: string[] = ['id', 'description', 'date'];
  isLoaded = false;
  isClicked = false;

  constructor(private demoDataService: DemodataService) {
  }

  ngOnInit(): void {
    // This is intentional
  }

  importData(): void {
    console.log('Data import clicked...');
    this.isClicked = true;
    this.demoDataService.getDemodata().subscribe((data) => {
      console.log('Data... ' + data);
      this.demoData = data;
      this.dataSource = new MatTableDataSource(data);
      this.isLoaded = true;
      this.isClicked = false;
    });
  }

}
