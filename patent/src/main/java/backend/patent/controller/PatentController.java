package backend.patent.controller;

import backend.patent.dto.ZahtevZaPriznanjePatentaCreationDto;
import backend.patent.dto.ZahtevZaPriznanjePatentaDisplayDto;
import backend.patent.service.PatentService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/patent")
public class PatentController {
    @Autowired
    private PatentService patentService;

    @PostMapping(value = "/create", consumes = "application/xml", produces = "application/xml")
    public int createZahtevZaPriznanjePatenta(@RequestBody ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        try {
            patentService.createZahtevZaPriznanjePatenta(zahtevZaPriznanjePatentaCreationDto);
            return Response.SC_OK;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping(value = "/all", produces = "application/xml")
    public List<ZahtevZaPriznanjePatentaDisplayDto> getZahteviZaPriznanjePatenta() {
        try {
            return (patentService.getAllZahteviZaPriznanjePatenta());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping(value = "/id/{id}", produces = "application/xml")
    public ZahtevZaPriznanjePatentaDisplayDto getZahtevZaPriznanjePatenta(@PathVariable("id") String id) {
        try {
            return (patentService.getZahteviZaPriznanjePatenta(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
