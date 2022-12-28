package backend.patent.service;

import backend.patent.dto.ZahtevZaPriznanjePatentaCreationDto;
import backend.patent.dto.ZahtevZaPriznanjePatentaDisplayDto;
import backend.patent.jaxb.Converter;
import backend.patent.jaxb.ZahtevZaPriznanjePatenta;
import backend.patent.repository.ZahtevZaPriznanjePatentaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatentService {

    private ZahtevZaPriznanjePatentaRepository patentRepository = new ZahtevZaPriznanjePatentaRepository();
    private Converter converter = new Converter();

    public void createZahtevZaPriznanjePatenta(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaDto) throws Exception {
        List<ZahtevZaPriznanjePatenta> zahtevi = patentRepository.getAll();
        int maxId = -1;
        int id;
        for (ZahtevZaPriznanjePatenta zahtev : zahtevi) {
            if (!zahtev.getBrojPrijave().contains("P")) continue;
            id = Integer.parseInt(zahtev.getBrojPrijave().split("-")[1]);
            if (id > maxId) {
                maxId = id;
            }
        }
        maxId++;
        ZahtevZaPriznanjePatenta zahtev = converter.convertFromCreationDTO(zahtevZaPriznanjePatentaDto);
        zahtev.setBrojPrijave("P-" + String.format("%06d", maxId));
        patentRepository.save(zahtev);
    }

    public List<ZahtevZaPriznanjePatentaDisplayDto> getAllZahteviZaPriznanjePatenta() throws Exception {
        return converter.convertZahtevZaPriznanjePatentaList(patentRepository.getAll());
    }

    public ZahtevZaPriznanjePatentaDisplayDto getZahteviZaPriznanjePatenta(String id) throws Exception {
        return converter.convertToDisplayDto(patentRepository.findById(id));
    }
}
