
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as JsonToXML from "js2xmlparser";

@Injectable({
  providedIn: 'root'
})
export class PatentService {
  constructor(private http: HttpClient) { }

  url = "http://localhost:4201/patent/"

  public addZahtev(zahtev: Object) {
    const xmlZahtev = JsonToXML.parse("zahtevZaPriznanjePatentaCreationDto", zahtev);
    const xmlResponse = this.http.post(this.url + 'create', xmlZahtev, { headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType: 'text' });
    xmlResponse.subscribe();
    //console.log(xmlResponse);
    //console.log(xmlZahtev);
  }
}