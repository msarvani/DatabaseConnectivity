/*
 * package com.foodhub.database.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.netflix.appinfo.InstanceInfo; import
 * com.netflix.discovery.DiscoveryClient;
 * 
 * @RestController public class ServiceInstanceRestController {
 * 
 * @Autowired private DiscoveryClient discoveryClient;
 * 
 * public List<InstanceInfo> serviceInstancesByApplicationName(@PathVariable
 * String applicationName) { return
 * this.discoveryClient.getInstancesById(applicationName); }
 * 
 * }
 */