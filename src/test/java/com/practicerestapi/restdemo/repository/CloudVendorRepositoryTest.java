package com.practicerestapi.restdemo.repository;

import com.practicerestapi.restdemo.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    private CloudVendorRespository cloudVendorRespository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1","Amazon",
                "USA","xxxxx");
        cloudVendorRespository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor = null;
        cloudVendorRespository.deleteAll();
    }

    // Test case Success

    @Test
    void testFindByVendorName_Found(){
        List<CloudVendor> cloudVendorList = cloudVendorRespository.findByVendorName("Amazon");
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }

    // Test case Failure
    @Test
    void testFindVendorNot_Found(){
        List<CloudVendor> cloudVendorList = cloudVendorRespository.findByVendorName("GCP");
        assertThat(cloudVendorList.isEmpty()).isTrue();
    }
}
