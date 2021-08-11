package view.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;

public class Button extends JButton {

    public Button(String text) {
        this(text, null);
    }
    public Button(String text, ActionListener handler) {
        this(text, handler, null, null);
        this.setBorderPainted(true);
    }
    public Button(String text, ActionListener handler, Color foreground, Color background) {
        super(text);
        if (foreground != null) this.setForeground(foreground);
        if (background != null) this.setBackground(background);
        if (handler != null) this.addActionListener(handler);
        this.setOpaque(true);
        this.setBorderPainted(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public Button(String text, Action action, Color foreground, Color background) {
        this(text, (Action)null, foreground, background, null);
    }

    public Button(String text, Action action, Color foreground, Color background, Font font) {
        this(text, (ActionListener)null, foreground, background);
        if (action != null) this.setAction(action);
        if (font != null) this.setFont(font);
    }


    
}
