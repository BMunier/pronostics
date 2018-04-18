import { Routes } from '@angular/router';

import {
    monEcranRoute
} from './';
import { userDialogRoute } from '../admin';
import { UserRouteAccessService } from '../shared';

const GEST_PRONO_ROUTES = [
    monEcranRoute
];

export const gestPronoState: Routes =[{
    path: '',
    data: {
        authorities: ['ROLE_ADMIN']
    },
    canActivate: [UserRouteAccessService],
    children: GEST_PRONO_ROUTES
},
    ...userDialogRoute
];