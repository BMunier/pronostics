import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { SERVER_API_URL } from '../../app.constants';
import { Stade } from './stade.model';
import { createRequestOption } from '../../shared/model/request-util';

@Injectable()
export class StadeMgmntService {
    private resourceUrl = SERVER_API_URL + 'api/stades';

    constructor(private http: HttpClient) { }

    create(stade: Stade): Observable<HttpResponse<Stade>> {
        return this.http.post<Stade>(this.resourceUrl, stade, { observe: 'response' });
    }

    update(user: Stade): Observable<HttpResponse<Stade>> {
        return this.http.put<Stade>(this.resourceUrl, user, { observe: 'response' });
    }

    find(): Observable<HttpResponse<Stade>> {
        return this.http.get<Stade>(`${this.resourceUrl}`, { observe: 'response' });
    }
    delete(login: string): Observable<HttpResponse<any>> {
        return this.http.delete(`${this.resourceUrl}/${login}`, { observe: 'response' });
    }
    query(req?: any): Observable<HttpResponse<Stade[]>> {
        const options = createRequestOption(req);
        return this.http.get<Stade[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

}
