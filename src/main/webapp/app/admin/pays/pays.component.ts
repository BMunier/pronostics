import { Component, OnInit } from '@angular/core';

import { Pays, PaysService } from '../../shared/';

@Component({
  selector: 'pays',
  templateUrl: './pays.component.html',
  styles: []
})
export class PaysComponent implements OnInit {

  payss : Pays[];

  constructor(private paysService: PaysService) { }

  ngOnInit() {
    this.getPays();
  }

  getPays(): void{
    this.paysService.getPays().subscribe(pays => this.payss = pays);
  }

}
