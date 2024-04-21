package com.practicerestapi.restdemo.service.Impl;

import com.practicerestapi.restdemo.model.CloudVendor;
import com.practicerestapi.restdemo.repository.CloudVendorRespository;
import com.practicerestapi.restdemo.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRespository cloudVendorRespository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRespository);
        cloudVendor = new CloudVendor("1", "Amazon",
                "USA", "xxxxx");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRespository.class);

        when(cloudVendorRespository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Successfully Saved");
    }

    @Test
    void testUpdateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRespository.class);

        when(cloudVendorRespository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Successfully Updated");
    }


    @Test
    void testGetCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRespository.class);

        when(cloudVendorRespository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor("1").getVendorName())
                .isEqualTo(cloudVendor.getVendorName());
    }

    @Test
    void testGetByVendorName(){
        mock(CloudVendor.class);
        mock(CloudVendorRespository.class);

        when(cloudVendorRespository.findByVendorName("Amazon")).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
        );

        assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getVendorId())
                .isEqualTo(cloudVendor.getVendorId());
    }

    @Test
    void testGetAllCloudVendors() {
        mock(CloudVendor.class);
        mock(CloudVendorRespository.class);

        when(cloudVendorRespository.findAll()).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
        );

        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber())
                .isEqualTo(cloudVendor.getVendorPhoneNumber());
    }

    @Test
    void getDeleteCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRespository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(
                cloudVendorRespository).deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor("1"))
                .isEqualTo("Successfully Deleted");
    }
}