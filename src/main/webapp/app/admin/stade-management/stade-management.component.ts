import { Component, OnInit } from '@angular/core';
import { Stade} from './stade.model';
import { HttpResponse } from '@angular/common/http';
import {HttpClientModule, HttpClient} from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { JhiEventManager, JhiParseLinks, JhiAlertService } from 'ng-jhipster';
import { ITEMS_PER_PAGE} from '../../shared';
import { StadeMgmntService } from './stade-management.service';

@Component({
  selector: 'jhi-stade-management',
  templateUrl: './stade-management.component.html',
  styles: []
})

export class StadeManagementComponent implements OnInit {
  currentAccount: any;
  stades: Stade[];
  error: any;
  success: any;
  routeData: any;
  links: any;
  totalItems: any;
  queryCount: any;
  itemsPerPage: any;
  page: any;
  predicate: any;
  previousPage: any;
  reverse: any;
  constructor(
    private stadeService: StadeMgmntService,
    private alertService: JhiAlertService,
    private parseLinks: JhiParseLinks,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private eventManager: JhiEventManager
) {
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
    this.stadeService.query({
        page: this.page - 1,
        size: this.itemsPerPage,
        sort: this.sort()}).subscribe(
            (res: HttpResponse<Stade[]>) => this.onSuccess(res.body, res.headers),
            (res: HttpResponse<any>) => this.onError(res.body)
    );
}
private onSuccess(data, headers) {
  this.links = this.parseLinks.parse(headers.get('link'));
  this.totalItems = headers.get('X-Total-Count');
  this.queryCount = this.totalItems;
  this.stades = data;
}

private onError(error) {
  this.alertService.error(error.error, error.message, null);
}

sort() {
  const result = [this.predicate + ',' + (this.reverse ? 'asc' : 'desc')];
  if (this.predicate !== 'id') {
      result.push('id');
  }
  return result;
}

loadPage(page: number) {
  if (page !== this.previousPage) {
      this.previousPage = page;
      this.transition();
  }
}
ngOnDestroy() {
  this.routeData.unsubscribe();
}
transition() {
  this.router.navigate(['/stade-management'], {
      queryParams: {
          page: this.page,
          sort: this.predicate + ',' + (this.reverse ? 'asc' : 'desc')
      }
  });
  this.loadAll();
}
}
