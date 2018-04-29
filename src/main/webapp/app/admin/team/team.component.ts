import { Component, OnInit, Input } from '@angular/core';
import { log } from 'util';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'jhi-teimportam',
  templateUrl: './team.component.html',
})



export class TeamComponent implements OnInit {
  team : String;
  code : String;
  rang : String;
  answer : String;
  constructor() { }

  ngOnInit() {
  }

  add(){

  
  
  }
}
