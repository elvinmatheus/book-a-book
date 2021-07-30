package view.components;

import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

import view.Margin;
import view.components.fixed.LimitedJTextField;
import view.pages.Home;

public class ForgotPassword {


    final static int SPACEBETWEENBUTTONANDFIELD = 10;
    final static int SPACEBETWEENLABELANDFIELD = 10;
    final static int MINFIELDWIDTH = 200;
    final static int MAXFIELDWIDTH = 300;
    final static int DIALOGMARGIN = 20;

    public static Button getButton(JFrame frame) {
        ActionListener handler = e -> ForgotPassword.show(frame);
        Button forgotPasswordBttn = new Button("Esqueceu a senha?", handler, Home.FORGOTPASSWORDCOLOR, Home.HEADERRIGHTCOLOR);
        return forgotPasswordBttn;
    }

    public static void show(JFrame frame) {
        String title = "Esqueceu a senha?";
        String message = "Digite um email no campo abaixo para receber instruções sobre mudança de senha";
        LimitedJTextField field = new LimitedJTextField(MINFIELDWIDTH, MAXFIELDWIDTH);
        Button send = new Button("Enviar");
        JDialog dialog = new JDialog(frame, title);
        Label label = new Label(message);
        JComponent wrapper = Box.createVerticalBox();
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        field.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        send.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        wrapper.add(label);
        wrapper.add(Margin.rigidVertical(SPACEBETWEENLABELANDFIELD));
        wrapper.add(field);
        wrapper.add(Margin.rigidVertical(SPACEBETWEENBUTTONANDFIELD));
        wrapper.add(send);
        dialog.add(Margin.horizontal(Margin.vertical(wrapper, DIALOGMARGIN), DIALOGMARGIN));
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }
}
