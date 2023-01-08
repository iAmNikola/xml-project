import { Component, OnInit } from '@angular/core';
import { ZahtevZaPriznanjePatenta } from 'src/app/classes/ZahtevZaPriznanjePatenta';
import { PatentService } from 'src/app/services/PatentService';

@Component({
  selector: 'app-p-search',
  templateUrl: './p-search.component.html',
  styleUrls: ['./p-search.component.css']
})
export class PSearchComponent implements OnInit {

  constructor(
    private patentService: PatentService
  ) {}
  ngOnInit(): void {
    
    this.zahteviZaPriznanjePatenta = this.patentService.getAllZahtev();
  }

  zahteviZaPriznanjePatenta: ZahtevZaPriznanjePatenta[] = [];

}
