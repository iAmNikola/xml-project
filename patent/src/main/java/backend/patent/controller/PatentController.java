package backend.patent.controller;

import backend.patent.dto.ZahtevZaPriznanjePatentaCreationDto;
import backend.patent.dto.ZahtevZaPriznanjePatentaDisplayDto;
import backend.patent.service.PatentService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
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
    @GetMapping(value = "/{id}", produces = "application/xml")
    public ZahtevZaPriznanjePatentaDisplayDto getZahtevZaPriznanjePatenta(@PathVariable("id") String id) {
        try {
            return (patentService.getZahteviZaPriznanjePatenta(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/{id}/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getDocumentPdf(@PathVariable String id) {

        ByteArrayInputStream byteFile = patentService.getPdfZahtev(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=review-" + id + ".pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(byteFile));
    }

    @GetMapping(path = "/{id}/html", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getDocumentHtml(@PathVariable String id) {
        return new ResponseEntity<>(patentService.getHtmlZahtev(id), HttpStatus.OK);
    }
}
