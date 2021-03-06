package ch.keepcalm.web.country.endpoint;

import ch.keepcalm.web.country.repository.CountryRepository;
import ch.keepcalm.web.country.ws.GetCountryRequest;
import ch.keepcalm.web.country.ws.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by marcelwidmer on 03.05.17.
 */
@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://keepcalm.ch/web/country/ws";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}
