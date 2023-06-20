package com.telran.bankapplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telran.bankapplication.dto.ClientAfterCreateDto;
import com.telran.bankapplication.dto.ClientCreateDto;
import com.telran.bankapplication.service.ClientService;
import com.telran.bankapplication.util.DtoCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
@DisplayName("ClientController test class")
class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private ClientService clientService;

    @Test
    @DisplayName("Test positive scenario forCreateNewClient")
    void testCreateNewClient() throws Exception {

        ClientCreateDto clientCreateDto = DtoCreator.getClientCreateDTO();
        ClientAfterCreateDto clientAfterCreateDto = DtoCreator.getClientCreateAfterDTO();
        Mockito.when(clientService.clientNewCreate(clientCreateDto)).thenReturn(clientAfterCreateDto);
        mockMvc.perform(post("/clients/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientCreateDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(clientAfterCreateDto.id()))
                .andExpect(jsonPath("$.status").value(clientAfterCreateDto.status()))
                .andExpect(jsonPath("$.taxCode").value(clientAfterCreateDto.taxCode()))
                .andExpect(jsonPath("$.firstName").value(clientAfterCreateDto.firstName()))
                .andExpect(jsonPath("$.lastName").value(clientAfterCreateDto.lastName()))
                .andExpect(jsonPath("$.email").value(clientAfterCreateDto.email()))
                .andExpect(jsonPath("$.address").value(clientAfterCreateDto.address()))
                .andExpect(jsonPath("$.phone").value(clientAfterCreateDto.phone()))
                .andExpect(jsonPath("$.dataClientCreated").value(clientAfterCreateDto.dataClientCreated().toString().substring(0, 10)))
                .andExpect(jsonPath("$.dataClientUpdated").value(clientAfterCreateDto.dataClientUpdated().toString().substring(0, 10)))
                .andExpect(jsonPath("$.manager").value(clientAfterCreateDto.manager()));

        Mockito.verify(clientService, Mockito.times(1)).clientNewCreate(clientCreateDto);
    }

    @DisplayName("Negative test scenario forCreateNewClient, if taxCode invalid")
    @Test
    void createNewManagerNotEnoughInputDataTest() throws Exception {
        ClientCreateDto clientCreateDto = DtoCreator.getClientCreateDTO();
        ClientCreateDto invalidClientCreateDto = new ClientCreateDto(
                null,
                clientCreateDto.firstName(),
                clientCreateDto.lastName(),
                clientCreateDto.email(),
                clientCreateDto.address(),
                clientCreateDto.phone(),
                clientCreateDto.managerLastName());

        mockMvc.perform(post("/clients/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidClientCreateDto)))
                .andExpect(status().isBadRequest());

        Mockito.verify(clientService, Mockito.never()).clientNewCreate(clientCreateDto);
    }


}
