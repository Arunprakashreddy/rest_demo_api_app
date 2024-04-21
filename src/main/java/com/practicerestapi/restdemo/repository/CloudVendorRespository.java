package com.practicerestapi.restdemo.repository;

import com.practicerestapi.restdemo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRespository extends JpaRepository<CloudVendor,String> {
    List<CloudVendor> findByVendorName(String vendorName);
}
