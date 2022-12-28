import { Adresa } from "./Adresa.";
import { Kontakt } from "./Kontakt";

export interface Podnosilac {
  jePronalazac : boolean;
  drzavljanstvo : string;
  ime : string;
  adresa : Adresa;
  kontakt : Kontakt;
}