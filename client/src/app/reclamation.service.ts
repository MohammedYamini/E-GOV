import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse, Reclamation } from './reclamation.module';

@Injectable({
    providedIn: 'root',
})
export class ReclamationService {
    api = 'http://127.0.0.1:9090';

    constructor(private httpClient: HttpClient) { }

    public createReclamation(reclamation: Reclamation): Observable<HttpResponse<ApiResponse>> {
        return this.httpClient.post<ApiResponse>(`${this.api}/store/reclamation`, reclamation, { observe: 'response' });
    }

    public indexReclamation(): Observable<Reclamation[]>{
        return this.httpClient.get<Reclamation[]>(`${this.api}/all/reclamations`);
    }

    public deleteReclamation(id: number){
        return this.httpClient.delete(`${this.api}/delete/reclamation/${id}`)
    }

    public ViewReclamation(id: number): Observable<HttpResponse<ApiResponse>> {
        return this.httpClient.get<ApiResponse>(`${this.api}/reclamation/${id}`, { observe: 'response' });
    }
}
