package figo.devops.bogate.service;

import figo.devops.bogate.domain.Terminal;
import figo.devops.bogate.dto.TerminalAddDTO;
import figo.devops.bogate.dto.TerminalRemoveDTO;
import figo.devops.bogate.exception.RestException;
import figo.devops.bogate.mapper.TerminalMapper;
import figo.devops.bogate.repository.TerminalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TerminalServiceImpl implements TerminalService{
    private final TerminalRepository repository;
    private final TerminalMapper mapper;
    @Override
    public void addTerminal(TerminalAddDTO params) {
        boolean b = repository.existsByTerminalIdAndMerchantId(params.getTerminalId(), params.getMerchantId());
        if (b) {
            log.info("Terminal Id and Merchant Id already exists!");
            throw  RestException.alreadyExists("Terminal Id and Merchant Id already exists!");
        } else {
            repository.save(mapper.toEntity(params));
            log.info("Terminal Id and Merchant Id added successfully!");
        }
    }

    @Override
    public void removeTerminal(TerminalRemoveDTO params) {
        boolean b = repository.existsByTerminalIdAndMerchantId(params.getTerminalId(), params.getMerchantId());
        if (b) {
            Terminal  terminal = repository.findByTerminalIdAndMerchantId(params.getTerminalId(), params.getMerchantId());
            repository.delete(terminal);
            log.info("Terminal Id and Merchant Id removed successfully!");
        } else {
            log.info("Terminal Id and Merchant Id not found!");
            throw RestException.notFound("Terminal Id and Merchant Id not found!");
        }
    }
}
