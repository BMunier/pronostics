import { Route, Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';

import { TeamComponent } from './team.component';

import { Injectable } from '@angular/core';
import { JhiPaginationUtil } from 'ng-jhipster';

@Injectable()
export class TeamResolvePagingParams implements Resolve<any>
    {
        constructor(private paginationUtil: JhiPaginationUtil) {}
        resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
            const page = route.queryParams['page'] ? route.queryParams['page'] : '1';
            const sort = route.queryParams['sort'] ? route.queryParams['sort'] : 'id,asc';
            return {
                page: this.paginationUtil.parsePage(page),
                predicate: this.paginationUtil.parsePredicate(sort),
                ascending: this.paginationUtil.parseAscending(sort)
            };
        }
    }

export const teamRoute: Route =
    {
		path: 'team',
		component: TeamComponent,
		resolve: {
			'pagingParams': TeamResolvePagingParams
		},
		data: {
			pageTitle: 'stadeManagement.home.title'
	    }   
    };
