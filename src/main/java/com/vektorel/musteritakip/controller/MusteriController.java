package com.vektorel.musteritakip.controller;

import com.vektorel.musteritakip.dto.request.MusteriSaveDto;
import com.vektorel.musteritakip.dto.response.MusteriResponseDto;
import com.vektorel.musteritakip.repository.entity.Musteri;
import com.vektorel.musteritakip.service.MusteriService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.vektorel.musteritakip.constants.RestApiUrls.*;

@RestController // Bu sınıfın bir RestApi hizmeti sunacağını belirtir
@RequestMapping(VERSION+MUSTERI) // Kullanıcıların isterklerini yakalayacak adresi tanımlıyoruz.
@Api(value = "Müşteri İşlemleri Servisi")
@Slf4j
public class MusteriController {

    // Otomatik nesne oluşturma
    @Autowired
    MusteriService musteriService;

    /**
     * Bu Method Çağırıldığında (http://localhost:9090/v1/musteri/save)
     * Dikkat edilmesi gereken konu;
     * Bu Method bir POST methodtur yani browser e yazarak çalıştıramazsınız.
     * @param ad
     * @param soyad
     * @param adres
     * @return
     */
    @PostMapping(SAVE)
    @ApiOperation(value = "Müşteri Kayıt")
    public ResponseEntity<Void> save(String ad,String soyad,String adres){
       musteriService.save(Musteri.builder().ad(ad).soyad(soyad).adres(adres).build());
        return ResponseEntity.ok().build();

    }

    /**
     * NOT!!! burada istemcilere tarafından istenilecek parametlerelerin
     * JsonArray şeklinde talep edilebilmesi için öncelikle talep edilen
     * sınıf başına @RequestBody annotasyonu getirilmelidir.
     * Eğer var ise ilgili sınıf içinde bulunan zorunlulukların aktif olarak
     * kontrol edilmesi için @Valid annotasyonu eklenmelidir.
     * @param dto
     * @return
     */
    @PostMapping("/savedto")
    @ApiOperation(value = "Dto ile Müşteri Kayıt etmek")
    public ResponseEntity<Void> saveDto(@RequestBody @Valid MusteriSaveDto dto){
        // NOT!!! Lütfen DTO kayıt işlemlerini controller içinde yapmayın.
        // DB kayıt işlemleri için kullanılarak kısım servislerdir.
        musteriService.save(dto);
        return  ResponseEntity.ok().build();
    }

    @GetMapping(FINDALL)
    @ApiOperation(value = "Tüm Müşterileri Listeleme")
    public ResponseEntity<List<Musteri>> findAll(){
        return ResponseEntity.ok(musteriService.findAll());
    }

    @GetMapping("/findallresponse")
    @ApiOperation(value = "Tüm Müşterilerin DTO şeklinde dönülmesi")
    public ResponseEntity<List<MusteriResponseDto>> findAllResponse(){
        return ResponseEntity.ok(musteriService.findAllRespose());
    }

    @GetMapping("/findallad")
    @ApiOperation(value = "Tüm Müşterilerin DTO şeklinde dönülmesi")
    public ResponseEntity<List<Musteri>> findAllAd(String ad){
        return ResponseEntity.ok(musteriService.findAllName(ad));
    }


}
