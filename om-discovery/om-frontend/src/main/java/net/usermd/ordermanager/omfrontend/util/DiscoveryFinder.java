package net.usermd.ordermanager.omfrontend.util;

import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@AllArgsConstructor
public class DiscoveryFinder {
    private DiscoveryClient client;

    public String getUrlForApp(String appName) {
        List<ServiceInstance> instanceList = client.getInstances(appName);
        if (instanceList.isEmpty()) {
            throw new NoSuchElementException("cannot reach discovery client");
        }
        ServiceInstance instance = instanceList.get(0);
        return instance.getServiceId();
    }
}
