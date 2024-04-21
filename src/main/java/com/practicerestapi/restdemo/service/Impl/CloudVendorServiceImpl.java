package com.practicerestapi.restdemo.service.Impl;

import com.practicerestapi.restdemo.exception.CloudVendorNotFoundException;
import com.practicerestapi.restdemo.model.CloudVendor;
import com.practicerestapi.restdemo.repository.CloudVendorRespository;
import com.practicerestapi.restdemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRespository cloudVendorRespository;

    public CloudVendorServiceImpl(CloudVendorRespository cloudVendorRespository) {
        this.cloudVendorRespository = cloudVendorRespository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        //More Business Logic
        cloudVendorRespository.save(cloudVendor);
        return "Successfully Saved";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        //More Business Logic
        cloudVendorRespository.save(cloudVendor);
        return "Successfully Updated";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        //More Business Logic
        cloudVendorRespository.deleteById(cloudVendorId);
        return "Successfully Deleted";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        //More Business Logic
        if(cloudVendorRespository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        return cloudVendorRespository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        //More Business Logic
        return cloudVendorRespository.findAll();
    }

    @Override
    public List<CloudVendor> getByVendorName(String cloudVendor){
        return cloudVendorRespository.findByVendorName(cloudVendor);
    }
}
