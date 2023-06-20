package com.telran.bankapplication.mapper;

import com.telran.bankapplication.dto.ClientAfterCreateDto;
import com.telran.bankapplication.dto.ClientCreateDto;
import com.telran.bankapplication.entity.Client;
import com.telran.bankapplication.util.DtoCreator;
import com.telran.bankapplication.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test class ClientMapper")
class ClientMapperTest {
    private final ClientMapper clientMapper = new ClientMapperImpl();
    private final Client client = EntityCreator.getClientEntity();

    @Test
    @DisplayName("Positive test. Create client: ClientCreateDto - Client")
    void testPositiveToCreateEntity() {
        ClientCreateDto clientCreateDto = DtoCreator.getClientCreateDTO();
        Assertions.assertEquals(client, clientMapper.toCreateEntity(clientCreateDto));
    }

    @Test
    @DisplayName("Negative test. Create client: ClientCreateDto - Client, DTO = null")
    void testNegativeToCreateEntityDtoNull() {
        Assertions.assertNull(clientMapper.toCreateEntity(null));
    }

    @Test
    @DisplayName("Positive test. Create client : Client - ClientAfterCreateDto")
    void testPositiveToAfterCreateDto() {
        ClientAfterCreateDto expectedDto = DtoCreator.getClientCreateAfterDTO();
        ClientAfterCreateDto actualDTO = clientMapper.toAfterCreateDto(client);

        Assertions.assertEquals(expectedDto.id(), actualDTO.id());
        Assertions.assertEquals(expectedDto.status(), actualDTO.status());
        Assertions.assertEquals(expectedDto.taxCode(), actualDTO.taxCode());
        Assertions.assertEquals(expectedDto.firstName(), actualDTO.firstName());
        Assertions.assertEquals(expectedDto.lastName(), actualDTO.lastName());
        Assertions.assertEquals(expectedDto.email(), actualDTO.email());
        Assertions.assertEquals(expectedDto.address(), actualDTO.address());
        Assertions.assertEquals(expectedDto.phone(), actualDTO.phone());
        Assertions.assertEquals(expectedDto.dataClientCreated(), actualDTO.dataClientCreated());
        Assertions.assertEquals(expectedDto.dataClientUpdated(), actualDTO.dataClientUpdated());
        Assertions.assertEquals(expectedDto.manager(), actualDTO.manager());
    }
    @Test
    @DisplayName("Negative test. Create client : Client - ClientAfterCreateDto, client = null")
    void testNegativeToAfterCreateDtoClientNull() {
        Assertions.assertNull(clientMapper.toAfterCreateDto(null));
    }
 }