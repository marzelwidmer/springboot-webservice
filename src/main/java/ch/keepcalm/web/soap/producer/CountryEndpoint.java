package ch.keepcalm.web.soap.producer;

import ch.keepcalm.web.soap.repository.CountryRepository;
import ch.keepcalm.web.soap.service.GetCountryRequest;
import ch.keepcalm.web.soap.service.GetCountryResponse;
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
    private static final String NAMESPACE_URI = "http://keepcalm.ch/web/soap/service";

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
