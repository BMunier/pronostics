import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { SERVER_API_URL } from '../../app.constants';
import { Pays } from './pays.model';
import { createRequestOption } from '../model/request-util';
import { tap } from 'rxjs/operators';

@Injectable()
export class PaysService {

    private paysUrl = SERVER_API_URL + 'pays/tous';

    constructor(private http: HttpClient){}

    getPays(): Observable<Pays[]> {
        return this.http.get<Pays[]>(this.paysUrl);
    }
}