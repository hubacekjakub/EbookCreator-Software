/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainWindow;

import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Hubacek
 */
public class StyleManager {


    void setBold(JTextPane jTextPane1) {
        SimpleAttributeSet setToApply = new SimpleAttributeSet();
        int start = jTextPane1.getSelectionStart();
        int end = jTextPane1.getSelectionEnd();
        AttributeSet informationSet = jTextPane1.getStyledDocument().getCharacterElement(start).getAttributes();

        if (StyleConstants.isBold(informationSet)) {
            StyleConstants.setBold(setToApply, false);

        } else {
            StyleConstants.setBold(setToApply, true);
        }
        jTextPane1.getStyledDocument().setCharacterAttributes(start, end - start, setToApply, false);
    }

    void setItalic(JTextPane jTextPane1) {
        SimpleAttributeSet setToApply = new SimpleAttributeSet();
        int start = jTextPane1.getSelectionStart();
        int end = jTextPane1.getSelectionEnd();
        AttributeSet informationSet = jTextPane1.getStyledDocument().getCharacterElement(start).getAttributes();

        if (StyleConstants.isItalic(informationSet)) {
            StyleConstants.setItalic(setToApply, false);

        } else {
            StyleConstants.setItalic(setToApply, true);
        }
        jTextPane1.getStyledDocument().setCharacterAttributes(start, end - start, setToApply, false);
    }

    void setUnderline(JTextPane jTextPane1) {
        SimpleAttributeSet setToApply = new SimpleAttributeSet();
        int start = jTextPane1.getSelectionStart();
        int end = jTextPane1.getSelectionEnd();
        AttributeSet informationSet = jTextPane1.getStyledDocument().getCharacterElement(start).getAttributes();

        if (StyleConstants.isUnderline(informationSet)) {
            StyleConstants.setUnderline(setToApply, false);

        } else {
            StyleConstants.setUnderline(setToApply, true);
        }
        jTextPane1.getStyledDocument().setCharacterAttributes(start, end - start, setToApply, false);
    }

    void setAlignCenter(JTextPane jTextPane1) {
        SimpleAttributeSet setToApply = new SimpleAttributeSet();
        int start = jTextPane1.getSelectionStart();
        int end = jTextPane1.getSelectionEnd();
        StyleConstants.setAlignment(setToApply, StyleConstants.ALIGN_CENTER);
        jTextPane1.getStyledDocument().setParagraphAttributes(start, end - start, setToApply, true);
    }

    void setAlignRight(JTextPane jTextPane1) {
        SimpleAttributeSet setToApply = new SimpleAttributeSet();
        int start = jTextPane1.getSelectionStart();
        int end = jTextPane1.getSelectionEnd();
        StyleConstants.setAlignment(setToApply, StyleConstants.ALIGN_RIGHT);
        jTextPane1.getStyledDocument().setParagraphAttributes(start, end - start, setToApply, true);
    }

    void setAlignLeft(JTextPane jTextPane1) {
        SimpleAttributeSet setToApply = new SimpleAttributeSet();
        int start = jTextPane1.getSelectionStart();
        int end = jTextPane1.getSelectionEnd();
        StyleConstants.setAlignment(setToApply, StyleConstants.ALIGN_LEFT);
        jTextPane1.getStyledDocument().setParagraphAttributes(start, end - start, setToApply, true);
    }
    void setHeadline(JTextPane jTextPane1){
        SimpleAttributeSet setToApply = new SimpleAttributeSet();
        int start = jTextPane1.getSelectionStart();
        int end = jTextPane1.getSelectionEnd();
        StyleConstants.setFontSize(setToApply, 22);
        StyleConstants.setBold(setToApply, true);
        jTextPane1.getStyledDocument().setCharacterAttributes(start, end - start, setToApply, false);
    }
    void setHeadline2(JTextPane jTextPane1){
        SimpleAttributeSet setToApply = new SimpleAttributeSet();
        int start = jTextPane1.getSelectionStart();
        int end = jTextPane1.getSelectionEnd();
        StyleConstants.setFontSize(setToApply, 18);
        StyleConstants.setBold(setToApply, true);
        jTextPane1.getStyledDocument().setCharacterAttributes(start, end - start, setToApply, false);
    }

}
