import { Adresa } from "./Adresa.";
import { NacinDostavljanja } from "./NacinDostavljanja";
import { NazivPronalaska } from "./NazivPronalaska";
import { Podnosilac } from "./Podnosilac";
import { Prijava } from "./Prijava";
import { Pronalazac } from "./Pronalazac";
import { Punomocnik } from "./Punomocnik";
import { ZahteviZaPriznanjePrvenstvaIzRanijihPrijava } from "./ZahteviZaPriznanjePrvenstvaIzRanijihPrijava";

export interface ZahtevZaPriznanjePatenta {
  brojPrijave : string;
  datumPrijema : string;
  datumPodnosenja : string;
  nazivPronalaska : NazivPronalaska;
  podnosilac : Podnosilac;
  pronalazac : Pronalazac;
  punomocnik : Punomocnik;
  adresaZaDostavljanje : Adresa;
  nacinDostavljanja : NacinDostavljanja;
  prijava : Prijava;
  zahteviZaPriznanjePrvenstvaIzRanijihPrijava : ZahteviZaPriznanjePrvenstvaIzRanijihPrijava;
}
