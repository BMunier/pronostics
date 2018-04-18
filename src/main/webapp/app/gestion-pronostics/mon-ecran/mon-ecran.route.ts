import { Route } from '@angular/router';
import { MonEcranComponent } from './mon-ecran.component';

export const monEcranRoute: Route = {
    path: 'mon-ecran',
    component: MonEcranComponent,
    data: {
        pageTitle: 'Mon écran titre'
    }
};