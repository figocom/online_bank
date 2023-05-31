package figo.devops.bogate.repository;

import figo.devops.bogate.domain.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Integer> {
    boolean existsByTerminalIdAndMerchantId(String terminalId, String merchantId);
    Terminal findByTerminalIdAndMerchantId(String terminalId, String merchantId);
}
