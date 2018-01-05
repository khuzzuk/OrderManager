package net.usermd.cartfrontend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;

@Service
public class RegisteredUserService implements UserDetailsService {
    private String userServiceName = "users-service";
    private DiscoveryClient discoveryClient;
    private RestTemplate restTemplate;

    @Autowired
    public RegisteredUserService(DiscoveryClient discoveryClient,
                                 @LoadBalanced RestTemplate restTemplate) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("START getting user from remote repo");
        String url;
        try {
            url = discoveryClient.getInstances(userServiceName).get(0).getUri().toURL().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User service cannot be reached");
        }
        RegisteredUser user = restTemplate.getForObject(url +
                "/registeredUsers/search/getByUsername?userName=" +
                username, RegisteredUser.class);
        System.out.println("END getting user from remote repo");
        System.out.println(user);
        return user;
    }
}
