///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.insset.client.pourcentage;
//
//import com.google.gwt.core.client.GWT;
//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.uibinder.client.UiBinder;
//import com.google.gwt.uibinder.client.UiField;
//import com.google.gwt.user.client.Window;
//import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.google.gwt.user.client.ui.Composite;
//import com.google.gwt.user.client.ui.HTMLPanel;
//import com.google.gwt.user.client.ui.Label;
//import com.google.gwt.user.client.ui.ResetButton;
//import com.google.gwt.user.client.ui.SubmitButton;
//import com.google.gwt.user.client.ui.TextBox;
//import org.insset.client.pourcentage.dialogbox.DialogBoxInssetPresenter;
//import org.insset.client.service.PourcentageService;
//import org.insset.client.service.PourcentageServiceAsync;
//import org.insset.shared.FieldVerifier;
//
///**
// *
// * @author insset
// */
//public class pourcentagePresenter extends Composite{
//    
//
//    @UiField
//    public ResetButton boutonClear;
//    @UiField
//    public SubmitButton boutonCalculerPrixFinal;
//    @UiField
//    public TextBox valPrix;
//     @UiField
//    public TextBox valTaux;
//    @UiField
//    public Label errorLabel;
//
//    /**
//     * The message displayed to the user when the server cannot be reached or
//     * returns an error.
//     */
//    private static final String SERVER_ERROR = "An error occurred while "
//            + "attempting to contact the server. Please check your network "
//            + "connection and try again.";
//
//    /**
//     * Create a remote service proxy to talk to the server-side Greeting
//     * service.
//     */
//    private final PourcentageServiceAsync service = GWT.create(PourcentageService.class);
//
//    interface AddUiBinder extends UiBinder<HTMLPanel, pourcentagePresenter> {
//    }
//
//    /**
//     * Create UiBinder for the view
//     */
//    private static AddUiBinder ourUiBinder = GWT.create(AddUiBinder.class);
//
//    /**
//     * Constructeur
//     */
//     public pourcentagePresenter() {
//        initWidget(ourUiBinder.createAndBindUi(this));
//        initHandler();
//    }
//
//    /**
//     * Methode qui innitialise les handler pour les cliques sur les boutons
//     */
//    protected void initHandler() {
//        boutonClear.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                valPrix.setText("");
//                valTaux.setText("");
//                errorLabel.setText("");
//            }
//        });
//        boutonCalculerPrixFinal.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                CalculPrixFinal();
//            }
//
//        });
//    }
//
//    private void CalculPrixFinal()  {
//        Float valuePrix = null;
//        Integer valueTaux = null;
//        try {
//            valuePrix = Float.parseFloat(valPrix.getText());
//            valueTaux = Integer.parseInt(valTaux.getText());
//            
//        } catch (NumberFormatException e) {
//            errorLabel.addStyleName("serverResponseLabelError");
//            errorLabel.setText("Format incorect");
//            return;
//        }
//        if ((!FieldVerifier.isValidDecimal(valueTaux))) {
//            errorLabel.addStyleName("serverResponseLabelError");
//            errorLabel.setText("Format incorect");
//            return;
//        }
//        service.CalculPrixFinal(Float.parseFloat(valPrix.getText()), Integer.parseInt(valTaux.getText()), new AsyncCallback<Float>() {
//            @Override
//            public void onFailure(Throwable caught) {
//                // Show the RPC error message to the user
//            }
//
//            public void onSuccess(String result) {
//                errorLabel.setText(" ");
//                new DialogBoxInssetPresenter("Calcul du prix final", valPrix.getText(),valTaux.getText(), result);
//            }
//
//            @Override
//            public void onSuccess(Float result) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//    }
//}
