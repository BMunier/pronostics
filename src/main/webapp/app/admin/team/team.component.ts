import { Component, OnInit } from '@angular/core';

import { Team } from './team.model';
import { TeamsService } from './teams.service';
import { HttpResponse } from '@angular/common/http';
import { JhiAlertService, JhiParseLinks, JhiEventManager } from 'ng-jhipster';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ITEMS_PER_PAGE } from '../../shared';

@Component({
  selector: 'jhi-team',
  templateUrl: './team.component.html',
  styles: []
})
export class TeamComponent implements OnInit {

  predicate: any;
  reverse: any;
  previousPage: any;
  routeData: Subscription;
  queryCount: number;
  itemsPerPage: any;
  teams: Team[];
  page: any;
  links: any;
  totalItems: number;

  constructor(private teamsService: TeamsService,
    private alertService: JhiAlertService,
    private parseLinks: JhiParseLinks,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private eventManager: JhiEventManager ) {
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.routeData = this.activatedRoute.data.subscribe((data) => {
        this.page = data['pagingParams'].page;
        this.previousPage = data['pagingParams'].page;
        this.reverse = data['pagingParams'].ascending;
        this.predicate = data['pagingParams'].predicate;
    });
  }

  ngOnInit() {
    this.loadAll();
  }

  loadAll() {
    this.teamsService.query({
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort()}).subscribe(
    (res: HttpResponse<Team[]>) => this.onSuccess(res.body, res.headers),
    (res: HttpResponse<any>) => this.onError(res.body)
    );
  }

  private onSuccess(data, headers) {
      this.links = this.parseLinks.parse(headers.get('link'));
      this.totalItems = headers.get('X-Total-Count');
      this.queryCount = this.totalItems;
      this.teams = data;
    }

    private onError(error) {
      this.alertService.error(error.error, error.message, null);
    }

    loadPage(page: number) {
      if (page !== this.previousPage) {
          this.previousPage = page;
          this.transition();
      }
  }

  transition() {
      this.router.navigate(['/team'], {
          queryParams: {
              page: this.page,
              sort: this.predicate + ',' + (this.reverse ? 'asc' : 'desc')
          }
      });
      this.loadAll();
  }

  sort() {
    const result = [this.predicate + ',' + (this.reverse ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
        result.push('id');
    }
    return result;
}
}
