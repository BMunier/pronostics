import { Component, OnInit } from '@angular/core';

import { Team } from './team.model';
import { TeamsService } from './teams.service';

@Component({
  selector: 'jhi-team',
  templateUrl: './team.component.html',
  styles: []
})
export class TeamComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
