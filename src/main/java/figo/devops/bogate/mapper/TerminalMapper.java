package figo.devops.bogate.mapper;

import figo.devops.bogate.domain.Terminal;
import figo.devops.bogate.dto.TerminalAddDTO;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {MapstructUtils.class}

)
public interface TerminalMapper {
     Terminal toEntity(TerminalAddDTO dto);
}
