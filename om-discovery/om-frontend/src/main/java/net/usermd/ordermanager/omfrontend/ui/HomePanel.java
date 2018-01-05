package net.usermd.ordermanager.omfrontend.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import net.usermd.ordermanager.omfrontend.dto.Cart;
import net.usermd.ordermanager.omfrontend.dto.CartsData;
import net.usermd.ordermanager.omfrontend.util.DiscoveryFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringUI(path = "/")
@Theme("valo")
public class HomePanel extends UI {
    public static final String DATA_ENDPOINT_NAME = "http://OM-DATA";
    @Autowired
    private DiscoveryFinder finder;
    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;
    private ListSelect<Long> cartsList;
    private static final String PREFIX = "http://";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalLayout layout = new HorizontalLayout();
        TabSheet mainAccordion = new Accordion();
        layout.addComponent(mainAccordion);

        cartsList = new ListSelect<>();
        cartsList.setItems(retrieveCarts());
        cartsList.setCaption("Carts");
        mainAccordion.addComponent(cartsList);

        ListSelect<Long> productView = new ListSelect<>();
        productView.setItems(retrieveCarts());
        productView.setCaption("Products");
        mainAccordion.addComponent(productView);
        Button addProduct = new Button();
        addProduct.setCaption("Add Product");
        layout.addComponent(addProduct);

        setContent(layout);
        setSizeFull();
    }

    private List<Long> retrieveCarts() {
        return Optional.ofNullable(restTemplate.getForObject(DATA_ENDPOINT_NAME + "/carts", CartsData.class))
                .map(CartsData::getCarts)
                .orElse(Collections.emptyList())
                .stream()
                .map(Cart::getId)
                .collect(Collectors.toList());
    }
}
