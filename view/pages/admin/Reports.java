package view.pages.admin;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

import model.handlers.ClearObserver;
import view.Margin;
import view.Page;
import view.components.AdminMenu;
import view.components.Button;
import view.components.LabeledTextField;
import view.components.base.MenuFactory;
import view.pages.pagestemplate.SearchContentTemplate;
import view.pages.pagestemplate.LayoutTemplate;

public class Reports implements Page {

    public final static String TITLE = "Relatórios";
    @Override
    public String getTitle() { return TITLE; }

    final static int CHOOSERMAXWIDTH = 200;
    final static int CHOOSERMAXHEIGHT = 20;
    final static int DATERANGEHORIZONTALGAP = 30;
    final static int SPACEBETWEENCHOOSERANDDATERANGE = 20;
    final static int SPACEBETWEENDATERANGEANDBUTTONS = 120;
    final static int SPACEBETWEENBUTTONS = 70;
    final static int LEFTRIGHTMAINCONTENTMARGIN = MenuFactory.WRAPPERHORIZONTALMARGIN;

    private List<JComponent> components = new ArrayList<>();

    @Override
    public void paint(JFrame frame) {
        JComponent menubar = AdminMenu.withWrapper();
        String path = "Administração >> Relatórios";
        JComponent content = this.content();
        LayoutTemplate.build(frame, menubar, content, path);
    }

    private JComboBox<String> chooser() {
        JComboBox<String> chooser = new JComboBox<String>();
        chooser.addItem("Selecione o relatório...");
        chooser.addItem("Livros emprestados");
        chooser.addItem("Livros devolvidos");
        chooser.addItem("Todos os livros");
        chooser.addItem("Usuários cadastrados");
        chooser.addItem("Usuários com atraso");
        chooser.setMaximumSize(new Dimension(CHOOSERMAXWIDTH, CHOOSERMAXHEIGHT));
        this.components.add(chooser);
        return chooser;
    }

    private JComponent selectDateRange() {
        JComponent component = Box.createHorizontalBox();
        LabeledTextField fieldFrom = new LabeledTextField("De:");
        LabeledTextField fieldUntil = new LabeledTextField("Até:");
        JCheckBox fullReportCheckbox = new JCheckBox("Relatório Completo");
        fullReportCheckbox.setOpaque(false);
        component.add(fieldFrom);
        component.add(Margin.rigidHorizontal(DATERANGEHORIZONTALGAP));
        component.add(fieldUntil);
        component.add(Margin.rigidHorizontal(DATERANGEHORIZONTALGAP));
        component.add(fullReportCheckbox);
        this.components.add(fieldFrom.getTextField());
        this.components.add(fieldUntil.getTextField());
        this.components.add(fullReportCheckbox);
        return component;
    }

    private JComponent buttons() {
        JComponent component = Box.createHorizontalBox();
        Button cancel = new Button("Cancelar", new ClearObserver<>(this.components));
        Button generate = new Button("Gerar");
        component.add(Box.createHorizontalGlue());
        component.add(cancel);
        component.add(Margin.rigidHorizontal(SPACEBETWEENBUTTONS));
        component.add(generate);
        component.add(Box.createHorizontalGlue());
        return component;
    }

    private JComponent content() {
        JComponent wrapper2 = Box.createHorizontalBox();
        JComponent wrapper1 = Box.createHorizontalBox();
        JComponent component = Box.createVerticalBox();
        JComboBox<String> chooser = this.chooser();
        JComponent selectDateRange = this.selectDateRange();
        JComponent buttons = this.buttons();
        component.add(Box.createVerticalGlue());
        component.add(chooser);
        component.add(Margin.rigidVertical(SPACEBETWEENCHOOSERANDDATERANGE));
        component.add(selectDateRange);
        component.add(Margin.rigidVertical(SPACEBETWEENDATERANGEANDBUTTONS));
        component.add(buttons);
        component.add(Box.createVerticalGlue());
        wrapper1.add(Box.createHorizontalGlue());
        wrapper1.add(component);
        wrapper1.add(Box.createHorizontalGlue());
        wrapper1.setOpaque(true);
        wrapper1.setBackground(SearchContentTemplate.MAINWRAPPERCOLOR);
        wrapper2.add(Margin.rigidHorizontal(LEFTRIGHTMAINCONTENTMARGIN));
        wrapper2.add(wrapper1);
        wrapper2.add(Margin.rigidHorizontal(LEFTRIGHTMAINCONTENTMARGIN));
        return wrapper2;
    }


}
