import { Component, NgModule } from '@angular/core';
import { FormBuilder, FormArray } from '@angular/forms';
import { PatentService } from 'src/app/classes/PatentService'
import * as JsonToXML from "js2xmlparser";

@Component({
  selector: 'app-p-input-form-page',
  templateUrl: './p-input-form-page.component.html',
  styleUrls: ['./p-input-form-page.component.css']
})

export class PInputFormPageComponent {
  
  constructor(
    private fb: FormBuilder,
    private ps: PatentService
    ) {}
  
  inputForm = this.fb.group({
    nazivPronalaska : this.fb.group({
      nazivNaSrpskom : [''],
      nazivNaEngleskom : ['']
    }),
    podnosilac : this.fb.group({
      '@' : this.fb.group({
        jePronalazac : [false],
        drzavljanstvo : ['']
      }),
      ime : [''],
      adresa : this.fb.group({
        ulica : [''],
        postanskiBroj : [''],
        mesto : [''],
        drzava : ['']
      }),
      kontakt : this.fb.group ({
        brojTelefona : [''],
        brojFaksa : [''],
        ePosta : ['']
      })
    }),
    pronalazac : this.fb.group({
      '@' : this.fb.group({
        neZeliDaBudeNaveden : [false]
      }),
      ime : [''],
      adresa : this.fb.group({
        ulica : [''],
        postanskiBroj : [''],
        mesto : [''],
        drzava : ['']
      }),
      kontakt : this.fb.group ({
        brojTelefona : [''],
        brojFaksa : [''],
        ePosta : ['']
      })
    }),
    punomocnik : this.fb.group({
      '@' : this.fb.group({
        vrstaPunomocnika : ['prijem'],
        jeZajednickiPredstavnik : [false],
      }),
      ime : [''],
      adresa : this.fb.group({
        ulica : [''],
        postanskiBroj : [''],
        mesto : [''],
        drzava : ['']
      }),
      kontakt : this.fb.group ({
        brojTelefona : [''],
        brojFaksa : [''],
        ePosta : ['']
      })
    }),
    adresaZaDostavljanje : this.fb.group({
      ulica : [''],
      postanskiBroj : [''],
      mesto : [''],
      drzava : ['']
    }),
    nacinDostavljanja : this.fb.group({
      saglasnostZaDostavljanjeUElektronskojFormi : [false],
      saglasnostZaDostavljanjeUPapirnojFormi : [false]
    }),
    prijava : this.fb.group({
      vrstaPrijave : ['izdvojena'],
      brojPrvobitnePrijave : [''],
      datumPodnosenjaPrvobitnePrijave: ['']
    }),
    zahteviZaPriznanjePrvenstvaIzRanijihPrijava : this.fb.array([])
  });

  
  get zahteviZaPriznanjePrvenstvaIzRanijihPrijava() {
    return (this.inputForm.get("zahteviZaPriznanjePrvenstvaIzRanijihPrijava") as FormArray);
  }

  dodajZahtev() : void {
    const zahtev = this.fb.group({
      zahtev : this.fb.group({
        datumPodnosenjeRanijePrijave : [''],
        brojRanijePrijave : [''],
        dvoslovnaOznakaDrzaveIliOrganizacije : ['']
      })
    });
    this.zahteviZaPriznanjePrvenstvaIzRanijihPrijava.push(zahtev);
    console.log(this.inputForm.value)
  }

  ukloniZahtev(index: number) {
    this.zahteviZaPriznanjePrvenstvaIzRanijihPrijava.removeAt(index);
  }

  submitForm() {
    this.ps.addZahtev(this.inputForm.value);
  }
}
