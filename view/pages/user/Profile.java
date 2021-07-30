package view.pages.user;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import model.App;
import model.User;
import model.UserData;
import view.Margin;
import view.Page;
import view.components.Button;
import view.components.Label;
import view.components.layout.StretchLayout;
import view.pages.Home;

public class Profile implements Page {

    public final static String TITLE = "Perfil";
    @Override
    public String getTitle() { return TITLE; }

    final static Color PROFILEMENUGRAY = new Color(178, 178, 178);
    final static Color PROFILEMENULIGHTGRAY = new Color(238, 236, 236);
    final static Color PROFILEMENULABELCOLOR = new Color(0, 0, 0);
    public final static Color HEADERWELCOMECOLOR = new Color(214, 224, 235);

    final static Font PROFILETITLEFONT = new Font("sansserif", Font.PLAIN, 36);
    final static Font PROFILEBUTTONFONT = new Font("sansserif", Font.PLAIN, 28);
    final static Font CONTENTTITLEFONT = new Font("sansserif", Font.PLAIN, 30);
    public final static Font WELCOMEFONT = new Font("sansserif", Font.PLAIN, 28);

    final static int PROFILEMENUWIDTH = 191;
    final static int PROFILETITLEMARGIN = 6;
    final static int PROFILEBUTTONVERTICALMARGIN = 10;
    final static int PROFILEBUTTONHORIZONTALMARGIN = 25;

    final static int CONTENTTOPMARGIN = 20;
    final static int CONTENTLEFTMARGIN = 18;
    final static int CONTENTTITLEBOTTOMMARGIN = 10;

    final static Border PROFILEMENUBORDER = BorderFactory.createLineBorder(PROFILEMENUGRAY, 1);
    final static Border PROFILEMENUBUTTONBORDER = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(225, 225, 225), 1), BorderFactory.createEmptyBorder(PROFILEBUTTONVERTICALMARGIN, PROFILEBUTTONHORIZONTALMARGIN, PROFILEBUTTONVERTICALMARGIN, PROFILEBUTTONHORIZONTALMARGIN));

    @Override
    public void paint(JFrame frame) {
        App app = App.get();
        User user = app.getLogin().getUser();
        UserData data = user.getData();
        JComponent menubar = Home.header(frame, false, data.name);
        // Página incompleta por enquanto!
        JComponent content = this.mainWrapper();
        frame.add(menubar);
        frame.add(content);
        frame.add(Home.foot());
    }

    public JComponent mainContent() {
        App app = App.get();
        User user = app.getLogin().getUser();
        UserData data = user.getData();
        JComponent content = Box.createVerticalBox();
        JComponent profileData = Margin.glueRight(new Label("Dados pessoais", null, null, CONTENTTITLEFONT));
        JComponent emailLabel = Margin.glueRight(new Label("Email: " + data.email));
        JComponent contactLabel = Margin.glueRight(new Label("Contato: " + data.contact));
        profileData.setBackground(Color.blue);
        content.add(Margin.rigidVertical(CONTENTTOPMARGIN));
        content.add(profileData);
        content.add(Margin.rigidVertical(CONTENTTITLEBOTTOMMARGIN));
        content.add(emailLabel);
        content.add(contactLabel);
        content.add(Box.createVerticalGlue());
        JComponent wrapper = Box.createHorizontalBox();
        wrapper.add(Margin.rigidHorizontal(CONTENTLEFTMARGIN));
        wrapper.add(content);
        wrapper.add(Box.createHorizontalGlue());
        return wrapper;
    }
    
    public JComponent mainWrapper() {
        JComponent wrapper = Box.createHorizontalBox();
        wrapper.add(this.leftMenu());
        wrapper.add(this.mainContent());
        return wrapper;
    }

    public JComponent leftMenu() {
        JComponent menu = new JPanel();
        StretchLayout layoutManager = new StretchLayout(menu, StretchLayout.Y_AXIS);
        menu.setLayout(layoutManager);
        Label profileLabel = new Label("Perfil", PROFILEMENULABELCOLOR, PROFILEMENUGRAY, PROFILETITLEFONT);
        profileLabel.setHorizontalAlignment(SwingConstants.CENTER);
        profileLabel.setBorder(new EmptyBorder(PROFILETITLEMARGIN, PROFILETITLEMARGIN, PROFILETITLEMARGIN, PROFILETITLEMARGIN));
        Button myList = new Button("Minha lista", null, PROFILEMENULABELCOLOR, PROFILEMENULIGHTGRAY, PROFILEBUTTONFONT);
        Button pending = new Button("Meus empréstimos", null, PROFILEMENULABELCOLOR, PROFILEMENULIGHTGRAY, PROFILEBUTTONFONT);
        Button settings = new Button("Configurações", null, PROFILEMENULABELCOLOR, PROFILEMENULIGHTGRAY, PROFILEBUTTONFONT);
        /* Pintamos as bordas */
        myList.setBorder(PROFILEMENUBUTTONBORDER); myList.setBorderPainted(true);
        pending.setBorder(PROFILEMENUBUTTONBORDER); pending.setBorderPainted(true);
        settings.setBorder(PROFILEMENUBUTTONBORDER); settings.setBorderPainted(true);
        menu.add(profileLabel);
        menu.add(myList);
        menu.add(pending);
        menu.add(settings);
        menu.add(Box.createVerticalGlue());
        menu.setBorder(PROFILEMENUBORDER);
        return menu;
    }
    
}
