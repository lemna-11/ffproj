package com.example.ffrestaurant.view.endpoints;

import com.example.ffrestaurant.view.providers.Routing;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainPage extends AppLayout {
    public MainPage(){
        // this is just dependency injection for people sick of
        // dependency injection magic

        H1 title = new H1("Main:");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "var(--lumo-space-m)");
        addToNavbar(title);
        Routing.Routes("main")
                .forEach(this::addToNavbar);
        TextField sussiest = new TextField("Sussiest");
        addToDrawer(sussiest);
    }
}
