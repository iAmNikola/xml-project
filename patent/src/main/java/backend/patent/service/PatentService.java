package backend.patent.service;

import backend.patent.dto.ZahtevZaPriznanjePatentaCreationDto;
import backend.patent.jaxb.Converter;
import backend.patent.jaxb.ZahtevZaPriznanjePatenta;
import backend.patent.repository.ZahtevZaPriznanjePatentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatentService {

    private ZahtevZaPriznanjePatentaRepository patentRepository = new ZahtevZaPriznanjePatentaRepository();
    private Converter converter = new Converter();

    public void createZahtevZaPriznanjePatenta(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaDto) {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
