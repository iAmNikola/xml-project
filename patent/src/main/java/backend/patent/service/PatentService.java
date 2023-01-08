package backend.patent.service;

import backend.patent.dto.ZahtevZaPriznanjePatentaCreationDto;
import backend.patent.dto.ZahtevZaPriznanjePatentaDisplayDto;
import backend.patent.jaxb.Converter;
import backend.patent.jaxb.ZahtevZaPriznanjePatenta;
import backend.patent.util.PDFTransformer;
import org.apache.commons.io.FileUtils;
import backend.patent.repository.ZahtevZaPriznanjePatentaRepository;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class PatentService {

    private ZahtevZaPriznanjePatentaRepository patentRepository = new ZahtevZaPriznanjePatentaRepository();
    private Converter converter = new Converter();
    private PDFTransformer pdfTransformer = new PDFTransformer();

    public void createZahtevZaPriznanjePatenta(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaDto) throws Exception {
        List<ZahtevZaPriznanjePatenta> zahtevi = patentRepository.getAll();
        int maxId = -1;
        int id;
        for (ZahtevZaPriznanjePatenta zahtev : zahtevi) {
            id = Integer.parseInt(zahtev.getBrojPrijave());
            if (id > maxId) {
                maxId = id;
            }
        }
        maxId++;
        ZahtevZaPriznanjePatenta zahtev = converter.convertFromCreationDTO(zahtevZaPriznanjePatentaDto);
        zahtev.setBrojPrijave(String.format("%06d", maxId));
        patentRepository.save(zahtev);
    }

    public List<ZahtevZaPriznanjePatentaDisplayDto> getAllZahteviZaPriznanjePatenta() throws Exception {
        return converter.convertZahtevZaPriznanjePatentaList(patentRepository.getAll());
    }

    public ZahtevZaPriznanjePatentaDisplayDto getZahteviZaPriznanjePatenta(String id) throws Exception {
        return converter.convertToDisplayDto(patentRepository.findById(id));
    }

    public ByteArrayInputStream getPdfZahtev(String id) {

        ByteArrayInputStream byteArrayInputStream;

        try {

            pdfTransformer.generateHTML(patentRepository.findById(id));
            pdfTransformer.generatePDF(id);

            File pdfFile = new File("gen/pdf/" + id + ".pdf");
            File htmlFile = new File("gen/html/" + id + ".html");
            byteArrayInputStream = new ByteArrayInputStream(FileUtils.readFileToByteArray(pdfFile));
            pdfFile.delete();
            htmlFile.delete();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return byteArrayInputStream;
    }

    public String getHtmlZahtev(String id) {

        String fileContent = null;

        try {

            pdfTransformer.generateHTML(patentRepository.findById(id));

            File htmlFile = new File("gen/html/" + id + ".html");
            fileContent = FileUtils.readFileToString(htmlFile, StandardCharsets.UTF_8);
            htmlFile.delete();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return fileContent;
    }
}
