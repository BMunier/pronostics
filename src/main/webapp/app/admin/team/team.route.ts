import { Route } from '@angular/router';

import { TeamComponent } from './team.component';

export const teamRoute: Route = {
    path: 'team',
    component: TeamComponent,
    data: {
        pageTitle: 'team.page.title'
    }
};
