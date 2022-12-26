import { Component, NgModule } from '@angular/core';
import { FormBuilder, FormArray } from '@angular/forms';
import * as JsonToXML from "js2xmlparser";

@Component({
  selector: 'app-p-input-form-page',
  templateUrl: './p-input-form-page.component.html',
  styleUrls: ['./p-input-form-page.component.css']
})

export class PInputFormPageComponent {
  
  constructor(private fb: FormBuilder) {}
  
  inputForm = this.fb.group({
    naziv_pronalaska : this.fb.group({
      naziv_na_srpskom : [''],
      naziv_na_engleskom : ['']
    }),
    podnosilac : this.fb.group({
      '@' : this.fb.group({
        je_pronalazac : [false],
        drzavljanstvo : ['']
      }),
      ime : [''],
      adresa : this.fb.group({
        ulica : [''],
        broj : [''],
        postanski_broj : [''],
        mesto : [''],
        drzava : ['']
      }),
      kontakt : this.fb.group ({
        broj_telefona : [''],
        broj_faksa : [''],
        e_posta : ['']
      })
    }),
    pronalazac : this.fb.group({
      '@' : this.fb.group({
        ne_zeli_da_bude_naveden : [false]
      }),
      ime : [''],
      adresa : this.fb.group({
        ulica : [''],
        broj : [''],
        postanski_broj : [''],
        mesto : [''],
        drzava : ['']
      }),
      kontakt : this.fb.group ({
        broj_telefona : [''],
        broj_faksa : [''],
        e_posta : ['']
      })
    }),
    punomocnik : this.fb.group({
      '@' : this.fb.group({
        vrsta_punomocnika : ['prijem'],
        je_zajednicki_predstavnik : [false],
      }),
      ime : [''],
      adresa : this.fb.group({
        ulica : [''],
        broj : [''],
        postanski_broj : [''],
        mesto : [''],
        drzava : ['']
      }),
      kontakt : this.fb.group ({
        broj_telefona : [''],
        broj_faksa : [''],
        e_posta : ['']
      })
    }),
    adresa_za_dostavljanje : this.fb.group({
      ulica : [''],
      broj : [''],
      postanski_broj : [''],
      mesto : [''],
      drzava : ['']
    }),
    nacin_dostavljanja : this.fb.group({
      saglasnost_za_dostavljanje_u_elektronskoj_formi : [false],
      saglasnost_za_dostavljanje_u_papirnoj_formi : [false]
    }),
    prijava : this.fb.group({
      vrsta_prijave : ['izdvojena'],
      broj_prvobitne_prijave : [''],
      datum_podnosenja_prvobitne_prijave: ['']
    }),
    zahtevi_za_priznanje_prvenstva_iz_ranijih_prijava : this.fb.array([])
  });

  
  get zahteviZaPriznanjePrvenstvaIzRanijihPrijava() {
    return (this.inputForm.get("zahtevi_za_priznanje_prvenstva_iz_ranijih_prijava") as FormArray);
  }

  dodajZahtev() : void {
    const zahtev = this.fb.group({
      zahtev : this.fb.group({
        datum_podnosenje_ranije_prijave : [''],
        broj_ranije_prijave : [''],
        dvoslovna_oznaka_drzave_ili_organizacije : ['']
      })
    });
    this.zahteviZaPriznanjePrvenstvaIzRanijihPrijava.push(zahtev);
    console.log(this.inputForm.value)
  }

  ukloniZahtev(index: number) {
    this.zahteviZaPriznanjePrvenstvaIzRanijihPrijava.removeAt(index);
  }

  submitForm() {
    console.log(this.inputForm.value)
    const xmlZahtev = JsonToXML.parse("zahtev_za_priznanje_patenta", this.inputForm.value);
    console.log(xmlZahtev)
    // const xmlOdgovor = this.httpClient.post(this.url + '/resenja-zahteva/add-resenje-zahteva', xmlZahtev, {headers: new HttpHeaders().set('Content-Type', 'application/xml'), responseType:'text'});
    // return xmlOdgovor;
  }
}
