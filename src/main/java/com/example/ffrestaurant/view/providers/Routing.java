package com.example.ffrestaurant.view.providers;

import com.vaadin.flow.component.button.Button;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class Routing {
    @Contract(pure = true)
    public List<Button> Routes(String toFilter){
        List<Button> sus = new ArrayList<>();
        final Button b = new Button("Main");
        b.addClickListener(e -> b.getUI().ifPresent(ui -> ui.navigate("")));
        sus.add(b);
        final Button b2 = new Button("Admin");
        b2.addClickListener(e -> b2.getUI().ifPresent(ui -> ui.navigate("/admin")));
        sus.add(b2);
        return Collections.unmodifiableList(sus.stream().filter(e -> !e.getText().equalsIgnoreCase(toFilter)).collect(Collectors.toList()));
    }
}