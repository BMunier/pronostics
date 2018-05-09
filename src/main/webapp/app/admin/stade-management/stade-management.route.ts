import { Route, Routes, Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivate } from '@angular/router';

import { StadeManagementComponent } from './stade-management.component';
import { Injectable } from '@angular/core';
import { JhiPaginationUtil } from 'ng-jhipster';
import { StadeManagementDialogComponent, StadeDialogComponent } from './stade-management-dialog.component';

@Injectable()
export class StadeResolvePagingParams implements Resolve<any> {
	constructor(private paginationUtil: JhiPaginationUtil) { }
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

export const stadeMgmntRoute: Route =
	{
		path: 'stade-management',
		component: StadeManagementComponent,
		resolve: {
			'pagingParams': StadeResolvePagingParams
		},
		data: {
			pageTitle: 'stadeManagement.home.title'
		}
	};

export const StadeDialogRoute: Routes = [
	{
		path: 'stade-management-new',
		component: StadeDialogComponent,
		outlet: 'popup'
	},
	{
		path: 'stade-management/:id/edit',
		component: StadeDialogComponent,
		outlet: 'popup'
	},
	{
		path: 'stade-management/:id/delete',
		component: StadeDialogComponent,
		outlet: 'popup'
	}
];
