import { Adresa } from "./Adresa.";
import { Kontakt } from "./Kontakt";

export interface Pronalazac {
  neZeliDaBudeNaveden : boolean;
  ime : string;
  adresa : Adresa;
  kontakt : Kontakt;
}