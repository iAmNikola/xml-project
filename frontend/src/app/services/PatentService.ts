
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as JsonToXML from "js2xmlparser";
import { ZahtevZaPriznanjePatenta } from '../classes/ZahtevZaPriznanjePatenta';
import { ZahtevZaPriznanjePrvenstvaIzRanijihPrijava } from '../classes/ZahtevZaPriznanjePrvenstvaIzRanijihPrijava';
import * as xml2js from 'xml2js';
import { ZahteviZaPriznanjePrvenstvaIzRanijihPrijava } from '../classes/ZahteviZaPriznanjePrvenstvaIzRanijihPrijava';
import { Prijava } from '../classes/Prijava';
import { NazivPronalaska } from '../classes/NazivPronalaska';
import { Adresa } from '../classes/Adresa.';
import { Kontakt } from '../classes/Kontakt';
import { NacinDostavljanja } from '../classes/NacinDostavljanja';
import { Podnosilac } from '../classes/Podnosilac';
import { Pronalazac } from '../classes/Pronalazac';
import { Punomocnik } from '../classes/Punomocnik';

@Injectable({
  providedIn: 'root'
})
export class PatentService {
  constructor(private http: HttpClient) { }

  url = "http://localhost:4201/patent/"

  public addZahtev(zahtev: Object) {
    const xmlZahtev = JsonToXML.parse("zahtevZaPriznanjePatentaCreation", zahtev);
    const xmlResponse = this.http.post(this.url + 'create', xmlZahtev, { headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType: 'text' });
    xmlResponse.subscribe();
    //console.log(xmlResponse);
    //console.log(xmlZahtev);
  }
  public getAllZahtev() {
    let zahteviZaPriznanjePatenta : ZahtevZaPriznanjePatenta[];
    const xmlResponse = this.http.get(this.url + '/patent/all', {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType: 'text'})
    .subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        let zahtevi = result.List.item;
        for (var zahtev of zahtevi) {
          let zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatenta;   
          zahtevZaPriznanjePatenta = this.convertResponseToZahtev(zahtev);
          zahteviZaPriznanjePatenta.push(zahtevZaPriznanjePatenta);
        }
      })
    })
  }
  public convertResponseToZahtev(responseItem : any) : ZahtevZaPriznanjePatenta {
    

    const zahtev: ZahtevZaPriznanjePrvenstvaIzRanijihPrijava[] = [];

    for (let p of responseItem.zahteviZaPriznanjePrvenstvaIzRanijihPrijava[0].zahtev) {
      const jedanZahtev: ZahtevZaPriznanjePrvenstvaIzRanijihPrijava = {
        datumPodnosenjeRanijePrijave: p.datumPodnosenjeRanijePrijave[0],
        brojRanijePrijave: p.brojRanijePrijave[0],
        dvoslovnaOznakaDrzaveIliOrganizacije: p.dvoslovnaOznakaDrzaveIliOrganizacije[0]
      }
      zahtev.push(jedanZahtev);
    }

    const ZahteviZaPriznanjePrvenstvaIzRanijihPrijava: ZahteviZaPriznanjePrvenstvaIzRanijihPrijava = {
      zahtev: zahtev
    }

    const prijava : Prijava = {
      vrstaPrijave : responseItem.prijava.vrstaPrijave,
      brojPrvobitnePrijave : responseItem.prijava.brojPrvobitnePrijave,
      datumPodnosenjaPrvobitnePrijave : responseItem.prijava.datumPodnosenjaPrvobitnePrijave
    }

    const nazivPronalaska : NazivPronalaska = {
      nazivNaEngleskom : responseItem.nazivPronalaska[0].engleskiNaziv[0],
      nazivNaSrpskom : responseItem.nazivPronalaska[0].srpskiNaziv[0]
    }

    const adresaPodnosilac : Adresa = {
      drzava : responseItem.podnosilac[0].adresa[0].drzava[0],
      mesto : responseItem.podnosilac[0].adresa[0].mesto[0],
      postanskiBroj : responseItem.podnosilac[0].adresa[0].postanskiBroj[0],
      ulica : responseItem.podnosilac[0].adresa[0].ulica[0],
    }

    const kontaktPodnosilac : Kontakt = {
      brojFaksa : responseItem.podnosilac[0].kontakt[0].brojFaksa[0],
      brojTelefona : responseItem.podnosilac[0].kontakt[0].brojTelefona[0],
      ePosta : responseItem.podnosilac[0].kontakt[0].ePosta[0]
    }
    

    const nacinDostavljanja : NacinDostavljanja = {
      saglasnostZaDostavljanjeUElektronskojFormi : responseItem.nacinDostavljanja[0].saglasnostZaDostavljanjeUElektronskojFormi[0],
      saglasnostZaDostavljanjeUPapirnojFormi : responseItem.nacinDostavljanja[0].saglasnostZaDostavljanjeUPapirnojFormi[0],
    }
    

    const podnosilac : Podnosilac = {
      ime : responseItem.podnosilac[0].ime[0],
      jePronalazac : responseItem.podnosilac[0].jePronalazac[0],
      drzavljanstvo : responseItem.podnosilac[0].drzavljanstvo[0],
      adresa : adresaPodnosilac,
      kontakt : kontaktPodnosilac
    }


    const kontaktPronalazac : Kontakt = {
      brojFaksa : responseItem.pronalazac[0].kontakt[0].brojFaksa[0],
      brojTelefona : responseItem.pronalazac[0].kontakt[0].brojTelefona[0],
      ePosta : responseItem.pronalazac[0].kontakt[0].ePosta[0]
    }

    
    const adresaPronalazac : Adresa = {
      drzava : responseItem.pronalazac[0].adresa[0].drzava[0],
      mesto : responseItem.pronalazac[0].adresa[0].mesto[0],
      postanskiBroj : responseItem.pronalazac[0].adresa[0].postanskiBroj[0],
      ulica : responseItem.pronalazac[0].adresa[0].ulica[0],
    }


    const pronalazac : Pronalazac = {
      ime : responseItem.pronalazac[0].ime[0],
      neZeliDaBudeNaveden : responseItem.pronalazac[0].neZeliDaBudeNaveden[0],
      adresa : adresaPronalazac,
      kontakt : kontaktPronalazac
    }

    const kontaktPunomocnik : Kontakt = {
      brojFaksa : responseItem.punomocnik[0].kontakt[0].brojFaksa[0],
      brojTelefona : responseItem.punomocnik[0].kontakt[0].brojTelefona[0],
      ePosta : responseItem.punomocnik[0].kontakt[0].ePosta[0]
    }

    const adresaPunomocnik : Adresa = {
      drzava : responseItem.punomocnik[0].adresa[0].drzava[0],
      mesto : responseItem.punomocnik[0].adresa[0].mesto[0],
      postanskiBroj : responseItem.punomocnik[0].adresa[0].postanskiBroj[0],
      ulica : responseItem.punomocnik[0].adresa[0].ulica[0],
    }

    const punomocnik : Punomocnik = {
      ime : responseItem.punomocnik[0].ime[0],
      vrstaPunomocnika : responseItem.punomocnik[0].vrstaPunomocnika[0],
      jeZajednickiPredstavnik : responseItem.punomocnik[0].jeZajednickiPredstavnik[0],
      kontakt : kontaktPunomocnik,
      adresa : adresaPunomocnik
    }
    
    const adresaZaDostavljanje : Adresa = {
      drzava : responseItem.adresaZaDostavljanje[0].drzava[0],
      mesto : responseItem.adresaZaDostavljanje[0].mesto[0],
      postanskiBroj : responseItem.adresaZaDostavljanje[0].postanskiBroj[0],
      ulica : responseItem.adresaZaDostavljanje[0].ulica[0],
    }

    const zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatenta = {
      brojPrijave : responseItem.brojPrijave[0],
      datumPodnosenja : responseItem.datumPodnosenja[0],
      datumPrijema : responseItem.datumPrijema[0],
      nazivPronalaska : nazivPronalaska,
      podnosilac : podnosilac,
      pronalazac : pronalazac,
      punomocnik : punomocnik,
      adresaZaDostavljanje : adresaZaDostavljanje,
      nacinDostavljanja : nacinDostavljanja,
      prijava : prijava,
      zahteviZaPriznanjePrvenstvaIzRanijihPrijava : ZahteviZaPriznanjePrvenstvaIzRanijihPrijava
    }

    return zahtevZaPriznanjePatenta;
  }
}