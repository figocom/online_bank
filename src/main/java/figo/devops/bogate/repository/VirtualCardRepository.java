package figo.devops.bogate.repository;

import figo.devops.bogate.domain.VirtualCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirtualCardRepository extends JpaRepository<VirtualCard, Integer> {
}
