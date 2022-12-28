import { Adresa } from "./Adresa.";
import { Kontakt } from "./Kontakt";

export interface Punomocnik {
  vrstaPunomocnika : string;
  jeZajednickiPredstavnik : boolean;
  ime : string;
  adresa : Adresa;
  kontakt : Kontakt;
}