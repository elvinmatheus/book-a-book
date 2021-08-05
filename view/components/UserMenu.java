package view.components;

import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JMenuBar;

import framework.App;
import controller.commands.NavigateCmd;
import view.components.base.MenuFactory;
import view.pages.user.Profile;
import view.pages.user.SearchBooksUser;

public class UserMenu extends JMenuBar {

    /** Define como construir o menu de um usuário (User) */

    private Button pesquisa(App app) {
        ActionListener handler = e -> app.control().invoke(new NavigateCmd(new SearchBooksUser()));
        Button button = MenuFactory.createButton("Pesquisa Bibliográfica", handler);
        return button;
    }

    private Button perfil(App app) {
        ActionListener handler = e -> app.control().invoke(new NavigateCmd(new Profile()));
        Button button = MenuFactory.createButton("Perfil", handler);
        return button;
    }

    private Button ajuda() {
        Button button = MenuFactory.helpButton();
        return button;
    }

    private Button sair(App app) {
        Button button = MenuFactory.exitButton(app);
        return button;
    }

    public UserMenu(App app) {
        BoxLayout bLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(bLayout);
        Button searchBttn = this.pesquisa(app);
        Button profileBttn = this.perfil(app);
        Button helpBttn = this.ajuda();
        Button exitBttn = this.sair(app);
        this.add(searchBttn);
        this.add(profileBttn);
        this.add(helpBttn);
        this.add(Box.createHorizontalGlue());
        this.add(exitBttn);
        this.setBackground(MenuFactory.MENUCOLOR);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(Integer.MAX_VALUE, this.getPreferredSize().height);
    }

    public static JComponent withWrapper(App app) {
        return MenuFactory.wrap(new UserMenu(app));
    }
}
