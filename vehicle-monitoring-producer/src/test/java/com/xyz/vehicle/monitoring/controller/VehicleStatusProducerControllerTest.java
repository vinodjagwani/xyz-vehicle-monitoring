package com.xyz.vehicle.monitoring.controller;


import com.xyz.vehicle.monitoring.dto.CurrentVehicleStatusData;
import com.xyz.vehicle.monitoring.facade.VehicleStatusProducerFacade;
import com.xyz.vehicle.monitoring.util.MockUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by vinodjagwani on 21/01/19.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(VehicleStatusProducerController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class VehicleStatusProducerControllerTest {



    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private VehicleStatusProducerFacade vehicleStatusProducerFacade;


    @Test
    public void sendCurrentVehicleStatusTest() throws Exception {
        final String mockResponse = MockUtils.getResource("mock/vehicle-status-data.json", String.class);
        doNothing().when(vehicleStatusProducerFacade).sendCurrentVehicleStatus(any(CurrentVehicleStatusData.class));
        this.mockMvc.perform(RestDocumentationRequestBuilders.post("/v1.0/vehicles/status/send")
                .content(mockResponse).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent())
                .andDo(print()).andDo(document("vehicle-current-status-data", Preprocessors.preprocessRequest(
                Preprocessors.prettyPrint()), Preprocessors.preprocessResponse(Preprocessors.prettyPrint())));
    }

}
