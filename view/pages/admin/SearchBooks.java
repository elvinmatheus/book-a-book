package view.pages.admin;

import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;

import model.handlers.ClearHandler;
import model.handlers.SearchBooksHandler;
import view.Page;
import view.components.AdminMenu;
import view.pages.pagestemplate.SearchContentTemplate;
import view.pages.pagestemplate.LayoutTemplate;

public class SearchBooks implements Page {
    
    public final static String TITLE = "Pesquisa >> Livros";
    @Override
    public String getTitle() { return TITLE; }

    @Override
    public void paint(JFrame frame) {
        JComponent menubar = AdminMenu.withWrapper();
        String[] labelsText = new String[] {"Título:", "Autor:"};
        String[] buttonsText = new String[] {"Cancelar", "Buscar"};
        SearchContentTemplate template = new SearchContentTemplate(labelsText, buttonsText, null, true);
        JComponent content = template.build();
        ActionListener cancelHandler = new ClearHandler<>(template.getClearableFields());
        ActionListener searchHandler = new SearchBooksHandler(template.getTextFields(), template.getCheckBoxs());
        ActionListener[] handlers = new ActionListener[] {cancelHandler, searchHandler};
        template.setHandlers(handlers);
        String path = "Pesquisa >> Livros";
        LayoutTemplate.build(frame, menubar, content, path);
    }

}
