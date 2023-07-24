package com.zmslabs.minet.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zmslabs.minet.model.OrdersDTO;
import com.zmslabs.minet.model.OrdersResponseDTO;
import com.zmslabs.minet.service.OrdersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {OrdersController.class})
@ExtendWith(SpringExtension.class)
class OrdersControllerTest {
    @Autowired
    private OrdersController ordersController;

    @MockBean
    private OrdersService ordersService;


    @Test
    void testBuyAssets() throws Exception {
        when(ordersService.buyAssets(Mockito.<OrdersDTO>any()))
                .thenReturn(new OrdersResponseDTO("Not all who wander are lost", "Code"));

        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.setAssetId(1L);
        ordersDTO.setPrice(10.0d);
        ordersDTO.setQuantity(1);
        ordersDTO.setUserId(1L);
        String content = (new ObjectMapper()).writeValueAsString(ordersDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/orders/buy")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(ordersController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"message\":\"Not all who wander are lost\",\"code\":\"Code\"}"));
    }

    @Test
    void testSellAssets() throws Exception {
        when(ordersService.sellAssets(Mockito.<OrdersDTO>any()))
                .thenReturn(new OrdersResponseDTO("Not all who wander are lost", "Code"));

        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.setAssetId(1L);
        ordersDTO.setPrice(10.0d);
        ordersDTO.setQuantity(1);
        ordersDTO.setUserId(1L);
        String content = (new ObjectMapper()).writeValueAsString(ordersDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/orders/sell")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(ordersController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Not all who wander are lost\",\"code\":\"Code\"}"));
    }
}

