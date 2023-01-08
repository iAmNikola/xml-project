
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

  public addZahtev(zahtev: Object) : void {
    const xmlZahtev = JsonToXML.parse("zahtevZaPriznanjePatentaCreation", zahtev);
    const xmlResponse = this.http.post(this.url + 'create', xmlZahtev, { headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType: 'text' });
    xmlResponse.subscribe();
    //console.log(xmlResponse);
    //console.log(xmlZahtev);
  }
  public getAllZahtev() : ZahtevZaPriznanjePatenta[] {
    let zahteviZaPriznanjePatenta : ZahtevZaPriznanjePatenta[] = [];
    const xmlResponse = this.http.get(this.url + 'all', {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType: 'text'})
    .subscribe(data => {
      const parser = new xml2js.Parser({strict: true, trim: true});
      parser.parseString(data.toString(), (err, result) => {
        console.log(result);
        let zahtevi = result.List.item;
        for (var item of zahtevi) {
          let zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatenta;   
          zahtevZaPriznanjePatenta = this.convertResponseToZahtev(item);
          zahteviZaPriznanjePatenta.push(zahtevZaPriznanjePatenta);
        }
      })
    })
    return zahteviZaPriznanjePatenta;
  }

  public convertResponseToZahtev(item : any) : ZahtevZaPriznanjePatenta {
    

    const zahtev: ZahtevZaPriznanjePrvenstvaIzRanijihPrijava[] = [];

    for (let p of item.zahteviZaPriznanjePrvenstvaIzRanijihPrijava) {
      const jedanZahtev: ZahtevZaPriznanjePrvenstvaIzRanijihPrijava = {
        datumPodnosenjeRanijePrijave: p.datumPodnosenjeRanijePrijave,
        brojRanijePrijave: p.brojRanijePrijave,
        dvoslovnaOznakaDrzaveIliOrganizacije: p.dvoslovnaOznakaDrzaveIliOrganizacije
      }
      zahtev.push(jedanZahtev);
    }

    const ZahteviZaPriznanjePrvenstvaIzRanijihPrijava: ZahteviZaPriznanjePrvenstvaIzRanijihPrijava = {
      zahtev: zahtev
    }

    const prijava : Prijava = {
      vrstaPrijave : item.prijava[0].vrstaPrijave,
      brojPrvobitnePrijave : item.prijava[0].brojPrvobitnePrijave,
      datumPodnosenjaPrvobitnePrijave : item.prijava[0].datumPodnosenjaPrvobitnePrijave
    }

    const nazivPronalaska : NazivPronalaska = {
      nazivNaEngleskom : item.nazivPronalaska[0].nazivNaEngleskom,
      nazivNaSrpskom : item.nazivPronalaska[0].nazivNaSrpskom
    }

    const adresaPodnosilac : Adresa = {
      drzava : item.podnosilac[0].adresa[0].drzava[0],
      mesto : item.podnosilac[0].adresa[0].mesto[0],
      postanskiBroj : item.podnosilac[0].adresa[0].postanskiBroj[0],
      ulica : item.podnosilac[0].adresa[0].ulica[0],
    }

    const kontaktPodnosilac : Kontakt = {
      brojFaksa : item.podnosilac[0].kontakt[0].brojFaksa[0],
      brojTelefona : item.podnosilac[0].kontakt[0].brojTelefona[0],
      ePosta : item.podnosilac[0].kontakt[0].ePosta[0]
    }
    

    const nacinDostavljanja : NacinDostavljanja = {
      saglasnostZaDostavljanjeUElektronskojFormi : item.nacinDostavljanja[0].saglasnostZaDostavljanjeUElektronskojFormi[0],
      saglasnostZaDostavljanjeUPapirnojFormi : item.nacinDostavljanja[0].saglasnostZaDostavljanjeUPapirnojFormi[0],
    }
    

    const podnosilac : Podnosilac = {
      ime : item.podnosilac[0].ime[0],
      jePronalazac : item.podnosilac[0].jePronalazac[0],
      drzavljanstvo : item.podnosilac[0].drzavljanstvo[0],
      adresa : adresaPodnosilac,
      kontakt : kontaktPodnosilac
    }


    const kontaktPronalazac : Kontakt = {
      brojFaksa : item.pronalazac[0].kontakt[0].brojFaksa[0],
      brojTelefona : item.pronalazac[0].kontakt[0].brojTelefona[0],
      ePosta : item.pronalazac[0].kontakt[0].ePosta[0]
    }

    
    const adresaPronalazac : Adresa = {
      drzava : item.pronalazac[0].adresa[0].drzava[0],
      mesto : item.pronalazac[0].adresa[0].mesto[0],
      postanskiBroj : item.pronalazac[0].adresa[0].postanskiBroj[0],
      ulica : item.pronalazac[0].adresa[0].ulica[0],
    }


    const pronalazac : Pronalazac = {
      ime : item.pronalazac[0].ime[0],
      neZeliDaBudeNaveden : item.pronalazac[0].neZeliDaBudeNaveden[0],
      adresa : adresaPronalazac,
      kontakt : kontaktPronalazac
    }

    const kontaktPunomocnik : Kontakt = {
      brojFaksa : item.punomocnik[0].kontakt[0].brojFaksa[0],
      brojTelefona : item.punomocnik[0].kontakt[0].brojTelefona[0],
      ePosta : item.punomocnik[0].kontakt[0].ePosta[0]
    }

    const adresaPunomocnik : Adresa = {
      drzava : item.punomocnik[0].adresa[0].drzava[0],
      mesto : item.punomocnik[0].adresa[0].mesto[0],
      postanskiBroj : item.punomocnik[0].adresa[0].postanskiBroj[0],
      ulica : item.punomocnik[0].adresa[0].ulica[0],
    }

    const punomocnik : Punomocnik = {
      ime : item.punomocnik[0].ime[0],
      vrstaPunomocnika : item.punomocnik[0].vrstaPunomocnika[0],
      jeZajednickiPredstavnik : item.punomocnik[0].jeZajednickiPredstavnik[0],
      kontakt : kontaktPunomocnik,
      adresa : adresaPunomocnik
    }
    
    const adresaZaDostavljanje : Adresa = {
      drzava : item.adresaZaDostavljanje[0].drzava[0],
      mesto : item.adresaZaDostavljanje[0].mesto[0],
      postanskiBroj : item.adresaZaDostavljanje[0].postanskiBroj[0],
      ulica : item.adresaZaDostavljanje[0].ulica[0],
    }

    const zahtevZaPriznanjePatenta : ZahtevZaPriznanjePatenta = {
      brojPrijave : item.brojPrijave[0],
      datumPodnosenja : item.datumPodnosenja[0],
      datumPrijema : item.datumPrijema[0],
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