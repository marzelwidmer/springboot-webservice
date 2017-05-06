package ch.keepcalm.web.country.controller;

import ch.keepcalm.web.country.repository.CountryRepository;
import ch.keepcalm.web.country.ws.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marcelwidmer on 06.05.17.
 */
@RestController
@RequestMapping(value = "/api/country", produces = "application/hal+json")
@Slf4j
public class CountryController {

    private CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }



    @GetMapping(value = "{name}")
    public ResponseEntity getCountry(@PathVariable String name) {
        Country country = countryRepository.findCountry(name);
        return new ResponseEntity(country, HttpStatus.OK);
    }

}
