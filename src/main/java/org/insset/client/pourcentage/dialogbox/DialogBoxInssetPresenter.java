/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.pourcentage.dialogbox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 *
 * @author insset
 */
public class DialogBoxInssetPresenter extends DialogBox{
    
    public DialogBoxInssetPresenter(String titre, String demande1, String demande2, String reponse) {
        super();
        this.setText(titre);
        formateBox(demande1, demande2, reponse);
    }
    
    private void formateBox(String demande, String demande1, String reponse) {

//         Create the popup dialog box
        setAnimationEnabled(true);
        final Button closeButton = new Button("Close");
        // We can set the id of a widget by accessing its Element
        closeButton.getElement().setId("closeButton");

        //Add a handler to close the DialogBox
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                hide();
            }
        });

        final Label textToServerLabel = new Label(demande);
        final Label textToServerLabel1= new Label(demande1);
        final HTML serverResponseLabel = new HTML(reponse);
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<b>Demande envoyé au server :</b>"));
        dialogVPanel.add(textToServerLabel);
        dialogVPanel.add(textToServerLabel1);
        dialogVPanel.add(new HTML("<br><b>Reponse :</b>"));
        dialogVPanel.add(serverResponseLabel);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        setWidget(dialogVPanel);
        center();
        closeButton.setFocus(true);
    }
}
