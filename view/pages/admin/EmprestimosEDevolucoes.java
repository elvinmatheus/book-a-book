package view.pages.admin;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;

import view.Margin;
import view.Page;
import view.components.AdminMenu;
import view.components.Label;
import view.components.base.MenuFactory;
import view.pages.pagestemplate.SearchContentTemplate;
import view.pages.pagestemplate.SearchTemplate;

public class EmprestimosEDevolucoes implements Page {
    
    public final static String TITLE = "Empréstimos e Devoluções";
    @Override
    public String getTitle() { return TITLE; }

    final static int INFOVERTICALCONTENTMARGIN = 50;
    final static int INFOCONTENTLEFTMARGIN = 50;
    final static int SPACEBETWEENLABELS = 3;

    final static Color INFOBGCOLOR = new Color(196, 196, 196);

    @Override
    public void paint(JFrame frame) {
        BoxLayout bLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(bLayout);
        JComponent menubar = AdminMenu.withWrapper();
        String[] labelsText = new String[] {
            "Cód. do Livro:", "Matrícula Usuário:"
        };
        String[] topButtonText = new String[] {"Buscar"};
        JComponent searchContent = SearchContentTemplate.build(labelsText, topButtonText, false, false);
        String[] bottomButtonsText = new String[] {"Cancelar", "Emprestar/Devolver"};
        JComponent buttons = SearchContentTemplate.build(new String[0], bottomButtonsText, false, false);
        frame.add(menubar);
        frame.add(SearchTemplate.pathComponent("Circulação >> Empréstimos e Devoluções"));
        frame.add(searchContent);
        frame.add(info());
        frame.add(buttons);
    }

    private void addLabels(JComponent component) {
        Label title = new Label("Título:");
        Label authors = new Label("Autor(es):");
        Label publishmentdate = new Label("Data de Publicação:");
        Label username = new Label("Usuário:");
        Label status = new Label("Situação:");
        Label pending = new Label("Pendentes:");
        component.add(Margin.rigidVertical(INFOVERTICALCONTENTMARGIN));
        component.add(title);
        component.add(Margin.rigidVertical(SPACEBETWEENLABELS));
        component.add(authors);
        component.add(Margin.rigidVertical(SPACEBETWEENLABELS));
        component.add(publishmentdate);
        component.add(Margin.rigidVertical(SPACEBETWEENLABELS));
        component.add(username);
        component.add(Margin.rigidVertical(SPACEBETWEENLABELS));
        component.add(status);
        component.add(Margin.rigidVertical(SPACEBETWEENLABELS));
        component.add(pending);
    }

    private JComponent info() {
        JComponent wrapper2 = Box.createHorizontalBox();
        JComponent wrapper1 = Box.createHorizontalBox();
        JComponent content = Box.createVerticalBox();
        addLabels(content);
        content.add(Margin.rigidVertical(INFOVERTICALCONTENTMARGIN));
        wrapper1.add(Margin.rigidHorizontal(INFOCONTENTLEFTMARGIN));
        wrapper1.add(content);
        wrapper1.add(Box.createHorizontalGlue());
        wrapper1.setOpaque(true);
        wrapper1.setBackground(INFOBGCOLOR);
        wrapper2.add(Margin.rigidHorizontal(MenuFactory.WRAPPERHORIZONTALMARGIN));
        wrapper2.add(wrapper1);
        wrapper2.add(Margin.rigidHorizontal(MenuFactory.WRAPPERHORIZONTALMARGIN));
        return wrapper2;
    }
}