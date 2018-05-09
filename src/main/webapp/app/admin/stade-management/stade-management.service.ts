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

    update(stade: Stade): Observable<HttpResponse<Stade>> {
        return this.http.put<Stade>(this.resourceUrl, stade, { observe: 'response' });
    }

    find(id: string): Observable<HttpResponse<Stade>> {
        return this.http.get<Stade>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
    delete(id: string): Observable<HttpResponse<any>> {
        return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
    query(req?: any): Observable<HttpResponse<Stade[]>> {
        const options = createRequestOption(req);
        return this.http.get<Stade[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

}
