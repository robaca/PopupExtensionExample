package de.codecentric;

import com.github.wolfie.popupextension.PopupExtension;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ViewWithPopup extends VerticalLayout implements View {

	private Button button;

	public ViewWithPopup(String title) {
		addComponent(new Label(title));
		
		button = new Button("Open Popup");
		final PopupExtension popupExtension = PopupExtension.extend(button);
		popupExtension.setOffset(100, 50);
		popupExtension.setContent(new Label("POPUP CONTENT"));

		button.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				popupExtension.toggle();
			}
		});
		addComponent(button);
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

}
