package controller.handlers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import framework.App;
import model.Book;
import model.Library;
import model.Login;
import model.User;
import controller.commands.DisplayPopupCmd;
import controller.commands.RefreshCmd;

public class RefreshEmprestimoHandler implements ActionListener {
    
    private List<JTextField> fields;
    public RefreshEmprestimoHandler(List<JTextField> fields) {
        this.fields = fields;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        App app = App.get();
        String isbn = this.fields.get(0).getText();
        String matricula = this.fields.get(1).getText();
        /* Obrigatoriedade dos campos */
        if (isbn.length() == 0) {
            app.control().invoke(new DisplayPopupCmd("Campo Cód. do livro é obrigatório", JOptionPane.ERROR_MESSAGE));
            return;
        }
        if (matricula.length() == 0) {
            app.control().invoke(new DisplayPopupCmd("Campo Matrícula Usuário é obrigatório", JOptionPane.ERROR_MESSAGE));
            return;
        }
        /* Interpretação dos campos */
        int matriculaInt;
        try {
            matriculaInt = Integer.parseInt(matricula);
            if (matriculaInt < 0) { throw new NumberFormatException(); }
        } catch (NumberFormatException e) {
            app.control().invoke(new DisplayPopupCmd("Matrícula deve ser um número não negativo. Recebido: " + matricula, JOptionPane.ERROR_MESSAGE));
            return;
        }
        Library lib = app.getLibrary();
        Login login = app.getLogin();
        Book book = lib.findByISBN(isbn);
        User user = login.getUser(matriculaInt);
        app.control().invoke(new RefreshCmd("UserShow", user));
        app.control().invoke(new RefreshCmd("BookShow", book));
    }

  
}
