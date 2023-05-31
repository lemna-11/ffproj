package com.example.ffrestaurant.view.endpoints;

import com.example.ffrestaurant.view.providers.NavigationBar;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainPage extends AppLayout {
    public MainPage(){
        addToNavbar(NavigationBar.title("Main"));
        // this is just dependency injection for people sick of
        // dependency injection magic
        NavigationBar.Routes("main")
                .forEach(this::addToNavbar);
        TextField sussiest = new TextField("Sussiest");
        addToDrawer(sussiest);
    }
}
