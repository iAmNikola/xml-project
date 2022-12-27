package backend.patent.controller;

import backend.patent.dto.ZahtevZaPriznanjePatentaCreationDto;
import backend.patent.service.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/patent")
public class PatentController {
    @Autowired
    private PatentService patentService;

    @PostMapping(value = "/create", consumes = "application/xml", produces = "application/xml")
    public String createZahtevZaPriznanjePatenta(@RequestBody ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        patentService.createZahtevZaPriznanjePatenta(zahtevZaPriznanjePatentaCreationDto);
        System.out.println("alooooooooooo");
        return "radi";
    }
}
