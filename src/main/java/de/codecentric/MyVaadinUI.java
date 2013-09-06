package de.codecentric;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
@PreserveOnRefresh
public class MyVaadinUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "de.codecentric.PepWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        setContent(layout);

        VerticalLayout menu = new VerticalLayout();
        menu.setWidth("100px");
        layout.addComponent(menu);

        Panel content = new Panel();
        content.setSizeFull();
        layout.addComponent(content);
        layout.setExpandRatio(content, 1f);

        final Navigator navigator = new Navigator(this, content);

        menu.addComponent(new Button("view1", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                navigator.navigateTo("view1");
            }
        }));
        menu.addComponent(new Button("view2", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                navigator.navigateTo("view2");
            }
        }));

        navigator.addView("view1", new ViewWithPopup("View 1"));
        navigator.addView("view2", new ViewWithPopup("View 2"));
        navigator.navigateTo("view1");
    }

}
