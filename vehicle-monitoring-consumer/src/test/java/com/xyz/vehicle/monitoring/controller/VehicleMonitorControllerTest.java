package com.xyz.vehicle.monitoring.controller;


import com.querydsl.core.types.Predicate;
import com.xyz.vehicle.monitoring.entity.mysql.CustomerEntity;
import com.xyz.vehicle.monitoring.entity.mysql.VehicleEntity;
import com.xyz.vehicle.monitoring.service.mysql.VehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleMonitorController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class VehicleMonitorControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private VehicleService vehicleService;


    @Test
    public void getAllVehicleStatusTest() throws Exception {
        final VehicleEntity entity = getVehicleEntity();
        final Page<VehicleEntity> page = new PageImpl<>(Collections.singletonList(entity));
        when(vehicleService.findAll(any(Predicate.class), any(Pageable.class))).thenReturn(page);
        this.mockMvc.perform(get("/v1.0/vehicles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numberOfElements", equalTo(1)))
                .andDo(print()).andDo(document("query-vehicle-status-list", preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()), responseFields(fieldWithPath("content[].vehicleId")
                                .description("Vehicle Id"),
                        fieldWithPath("content[].status").description("Status"),
                        fieldWithPath("content[].registrationNo").description("Registration No"),
                        fieldWithPath("content[].createdTime").description("Creation Time"),
                        fieldWithPath("content[].customerEntity.createdTime").description("Creation Time"),
                        fieldWithPath("content[].customerEntity.customerId").description("Customer ID"),
                        fieldWithPath("content[].customerEntity.customerName").description("Customer Name"),
                        fieldWithPath("content[].customerEntity.address").description("Address"),
                        fieldWithPath("pageable").description("Pageable"),
                        fieldWithPath("last").description("Last"),
                        fieldWithPath("sort.sorted").description("Sort"),
                        fieldWithPath("sort.unsorted").description("Unsorted"),
                        fieldWithPath("sort.empty").description("Sort Empty"),
                        fieldWithPath("empty").description("Empty"),
                        fieldWithPath("totalElements").description("totalElements"),
                        fieldWithPath("totalPages").description("totalPages"),
                        fieldWithPath("size").description("size"),
                        fieldWithPath("number").description("number"),
                        fieldWithPath("sort").description("sort"),
                        fieldWithPath("first").description("first"),
                        fieldWithPath("numberOfElements").description("numberOfElements"))));
    }


    private VehicleEntity getVehicleEntity() {
        VehicleEntity entity = new VehicleEntity();
        entity.setCustomerEntity(new CustomerEntity());
        entity.setStatus(true);
        entity.setVehicleId(1L);
        return entity;
    }
}
