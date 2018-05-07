import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';
import { Team } from './team.model';
import { createRequestOption } from '../../shared/model/request-util';

@Injectable()
export class TeamsService {

    constructor(private http: HttpClient) { }

    query(req: any): Observable<HttpResponse<Team[]>> {
        const params: HttpParams = createRequestOption(req);

        const requestURL = SERVER_API_URL + 'api/teams';

        return this.http.get<Team[]>(requestURL, {
            params,
            observe: 'response'
        });
    }
}
