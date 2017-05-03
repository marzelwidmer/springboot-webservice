package ch.keepcalm.web.repository;

import ch.keepcalm.web.model.Consultationprotocol;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by marcelwidmer on 24.02.17.
 */
@RepositoryRestResource(collectionResourceRel = "/consultationprotocol", path = "/consultationprotocol")
public interface ConsultationprotocolRepository extends PagingAndSortingRepository<Consultationprotocol, String> {
}
