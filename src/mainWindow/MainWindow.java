
package mainWindow;

import convertor.Convertor;
import convertor.Metadata;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.AbstractAction;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import mainWindow.dialogs.*;

/**
 *
 * @author Hubacek
 */
public class MainWindow extends javax.swing.JFrame {

    TagManager spravceZnacek;
    StyleManager spravceStylu;
    JToolBar tools;

    String newLine = System.lineSeparator();

    Metadata metadata = new Metadata();
    String workingDirectory = null;
    String kindlegenDirectory = null;
    String outputDirectory = null;

    StyleAction boldAction;
    StyleAction italicAction;
    StyleAction underlineAction;
    
    StyleAction alignCenterAction;
    StyleAction alignLeftAction;
    StyleAction alignRighttAction;
    boolean menuDisabled= false;


    public MainWindow() {
        initComponents();
        tools = new JToolBar("Toolbar", JToolBar.HORIZONTAL);
        setMenuAndToolbar();
        disableMenuAndToolBar();
        setLocationInMiddle(this);
        jTextPane1.grabFocus();
        setText();
        //jSplitPane1.setResizeWeight(0.5);
        spravceZnacek = new TagManager();
        spravceStylu = new StyleManager();
        jTextPane2.setEditable(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveEbookMenuItem = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        leftPanel = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        chapterButton = new javax.swing.JButton();
        miniChapterButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        souborMenu = new javax.swing.JMenu();
        stylyMenu = new javax.swing.JMenu();
        nastaveniMenu = new javax.swing.JMenu();

        saveEbookMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        saveEbookMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Export24.gif"))); // NOI18N
        saveEbookMenuItem.setText("Uložit ebook");
        saveEbookMenuItem.setToolTipText("");
        saveEbookMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEbookMenuItemActionPerformed(evt);
            }
        });

        jMenu4.setText("jMenu4");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton4.setBackground(new java.awt.Color(102, 255, 102));
        jButton4.setText("editace");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        chapterButton.setText("Kapitola");
        chapterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chapterButtonActionPerformed(evt);
            }
        });

        miniChapterButton.setText("Podkapitola");
        miniChapterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miniChapterButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Prvky e-knihy");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chapterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(miniChapterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chapterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(miniChapterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        getContentPane().add(leftPanel, java.awt.BorderLayout.LINE_START);

        jScrollPane1.setViewportView(jTextPane1);

        jTabbedPane1.addTab("Stylovaný text", jScrollPane1);

        jScrollPane2.setViewportView(jTextPane2);

        jTabbedPane1.addTab("Text s pomocnými značkami", jScrollPane2);

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        souborMenu.setText("Soubor");
        jMenuBar1.add(souborMenu);

        stylyMenu.setText("Styly");
        jMenuBar1.add(stylyMenu);

        nastaveniMenu.setText("Nastavení");
        jMenuBar1.add(nastaveniMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(menuDisabled){
            enableMenuAndToolBar();
            String get = jTextPane1.getText();
            jTextPane2.setText("");
            jTextPane2.setText(get);
        }else{
            disableMenuAndToolBar();
        }
        

    }//GEN-LAST:event_jButton4ActionPerformed

    private void saveEbookMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEbookMenuItemActionPerformed
        if (metadata.isRequiredSet()) {
            Convertor convert = new Convertor(jTextPane2.getText(), metadata);
            convert.setPaths(workingDirectory, kindlegenDirectory, outputDirectory);
            boolean status = convert.convert();

        } else {
            JOptionPane.showMessageDialog(centerPanel, "Je potřeba doplnit informace. Menu Nastavení -> Informace o knize", "Chybí metadata", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_saveEbookMenuItemActionPerformed

    private void chapterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chapterButtonActionPerformed
        spravceStylu.setHeadline(jTextPane1);
        applyStyleTags("headline");

    }//GEN-LAST:event_chapterButtonActionPerformed

    private void miniChapterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miniChapterButtonActionPerformed
        spravceStylu.setHeadline2(jTextPane1);
        applyStyleTags("headline2");
    }//GEN-LAST:event_miniChapterButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton chapterButton;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton miniChapterButton;
    private javax.swing.JMenu nastaveniMenu;
    private javax.swing.JMenuItem saveEbookMenuItem;
    private javax.swing.JMenu souborMenu;
    private javax.swing.JMenu stylyMenu;
    // End of variables declaration//GEN-END:variables





    private void applyStyleTags(String style) {
        jTextPane2.setEditable(true);
        int size = jTextPane1.getSelectionEnd() - jTextPane1.getSelectionStart();

        int newSelectionStart = spravceZnacek.addTag(jTextPane1.getSelectionStart(), "[" + style + "]");
        jTextPane2.setSelectionStart(newSelectionStart);
        spravceZnacek.addTag(jTextPane1.getSelectionEnd(), "[/" + style + "]");

        int newSelectionEnd = newSelectionStart + size;
        jTextPane2.setSelectionEnd(newSelectionEnd);
        jTextPane2.replaceSelection("[" + style + "]" + jTextPane2.getSelectedText() + "[/" + style + "]");
        jTextPane2.setEditable(false);
    }



    private void setMenuAndToolbar() {
        //menu Soubor
        FileAction newFileAction = new FileAction("Nový soubor", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/New24.gif")), "New file", 'N', -1);
        FileAction saveFileAction = new FileAction("Uložit...", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Save24.gif")), "Save file", 'S', 1);
        FileAction openFileAction = new FileAction("Otevřít...", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Open24.gif")), "Open file", 'O', 0);
        FileAction closeFileAction = new FileAction("Odstranit metadata", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Delete24.gif")), "Close file", 'W', 2);


        //zarovnání textu
        alignCenterAction = new StyleAction("Zarovnání na střed", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/text/AlignCenter24.gif")), "Align center", 'E', "align-center");
        alignLeftAction = new StyleAction("Zarovnání doleva", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/text/AlignLeft24.gif")), "Align left", 'L', "align-left");
        alignRighttAction = new StyleAction("Zarovnání doprava", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/text/AlignRight24.gif")), "Align right", 'R', "align-right");

        boldAction = new StyleAction("Zarovnání na střed", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/text/Bold24.gif")), "Bold", 'B', "bold");
        italicAction = new StyleAction("Zarovnání doleva", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/text/Italic24.gif")), "Italic", 'I', "italic");
        underlineAction = new StyleAction("Zarovnání doprava", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/text/Underline24.gif")), "Underline", 'U', "underline");

        SettingAction settingPathAction = new SettingAction("Nastavení programu", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Preferences24.gif")), "Nastavení cest", "path");
        SettingAction settingMetadataAction = new SettingAction("Informace o knize", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Help24.gif")), "Nastavení metadat", "metadata");
        SettingAction settingFontAction = new SettingAction("Nastavení písma", new ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/History24.gif")), "Nastavení písma", "font");

        tools.add(newFileAction);
        tools.add(openFileAction);
        tools.add(saveFileAction);
        tools.add(closeFileAction);
        tools.addSeparator();
        tools.add(boldAction);
        tools.add(italicAction);
        tools.add(underlineAction);
        tools.addSeparator();
        tools.add(alignLeftAction);
        tools.add(alignCenterAction);
        tools.add(alignRighttAction);
        tools.addSeparator();
        tools.add(settingPathAction);
        tools.add(settingMetadataAction);
        tools.add(settingFontAction);

        souborMenu.add(newFileAction);
        souborMenu.add(openFileAction);
        souborMenu.add(saveFileAction);
        souborMenu.addSeparator();
        souborMenu.add(saveEbookMenuItem);

        stylyMenu.add(boldAction);
        stylyMenu.add(italicAction);
        stylyMenu.add(underlineAction);
        stylyMenu.addSeparator();
        stylyMenu.add(alignLeftAction);
        stylyMenu.add(alignCenterAction);
        stylyMenu.add(alignRighttAction);

        nastaveniMenu.add(settingPathAction);
        nastaveniMenu.add(settingMetadataAction);
        nastaveniMenu.add(settingFontAction);

        this.getContentPane().add(tools, BorderLayout.NORTH);
    }
    
    private void setLocationInMiddle(Component comp) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth()-comp.getWidth())/2);
        int y = (int) ((screenSize.getHeight()-comp.getHeight())/2);
        comp.setLocation(x,y);
    }
    
    private void disableMenuAndToolBar() {
        
        miniChapterButton.setEnabled(false);
        chapterButton.setEnabled(false);
        
        boldAction.setEnabled(false);
        italicAction.setEnabled(false);
        underlineAction.setEnabled(false);

        alignCenterAction.setEnabled(false);
        alignLeftAction.setEnabled(false);
        alignRighttAction.setEnabled(false);
        saveEbookMenuItem.setEnabled(false);
        menuDisabled=true;
        
    }

    private void enableMenuAndToolBar() {
        miniChapterButton.setEnabled(true);
        chapterButton.setEnabled(true);

        boldAction.setEnabled(true);
        italicAction.setEnabled(true);
        underlineAction.setEnabled(true);

        alignCenterAction.setEnabled(true);
        alignLeftAction.setEnabled(true);
        alignRighttAction.setEnabled(true);
        saveEbookMenuItem.setEnabled(true);
        menuDisabled=false;

    }

    private void saveDataToFile(File selectedFile) {
        try {
            File file = selectedFile;
            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file);
            String[] lines = jTextPane1.getText().split(System.lineSeparator());

            for (String line : lines) {
                out.println(line);
            }
            out.close();
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(centerPanel, "Data se nepodařilo uložit");
        }
    }

    private void loadDataFromFile(File selectedFile) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(selectedFile));
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = br.readLine()) != null) {
                stringBuilder.append(line + System.lineSeparator());
            }
            jTextPane1.setText(stringBuilder.toString());
            br.close();
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(centerPanel, "Data se nepodařilo načíst");
        }
    }

    private void clearText() {
        jTextPane1.setText("");
        jTextPane2.setText("");
        spravceZnacek.list.clear();
    }

    private void setText() {
        String content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed magna arcu, fringilla ac dui vel, ullamcorper pharetra est."
                + System.lineSeparator() + System.lineSeparator() + " Donec tristique elit id nibh sagittis tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                + " Praesent ac laoreet odio. Sed gravida enim eget augue aliquet, non luctus lorem facilisis. Phasellus egestas nisl nunc,"
                + " euismod commodo massa venenatis eget. Morbi eu leo eu leo blandit lacinia. Integer in elit fermentum nibh sagittis aliquet."
                + System.lineSeparator() + System.lineSeparator() + "Praesent vestibulum nulla fermentum quam adipiscing, et pulvinar magna faucibus. Nunc quis tortor pellentesque,"
                + " molestie nibh ut, fermentum velit. Nullam lorem est, venenatis non ipsum eu, ullamcorper vehicula ante. Duis aliquam venenatis magna,"
                + " porta consectetur enim porta quis. Maecenas quis urna posuere, sagittis felis auctor, bibendum risus. Duis commodo, arcu vel auctor tristique."
                + System.lineSeparator() + System.lineSeparator() + "Justo lorem dictum quam, vitae feugiat velit erat a velit. Curabitur bibendum quam ut convallis pretium."
                + " Fusce lacinia interdum justo, nec lobortis nisl aliquet ut. Nulla at velit eros. Nam pulvinar interdum dolor. Lorem ipsum dolor sit amet,"
                + " consectetur adipiscing elit. Ut fermentum neque in mi egestas, in varius tellus aliquam. Ut imperdiet id lorem ut iaculis."
                + " Nam semper sem quis nisi tristique, ac mollis turpis iaculis. In a tempor sapien. Proin auctor dui sapien, nec faucibus augue tincidunt ac.";
        jTextPane1.setText(content);
        jTextPane2.setText(content);
    }

    private void setMetadata() {
        MetadataDialog metadataWindow = new MetadataDialog(this, true, metadata.getRequired(), metadata.getOptional());
        setLocationInMiddle(metadataWindow);
        metadataWindow.setVisible(true);
        if (metadataWindow.getReturnValue() == MetadataDialog.APPROVE) {
            metadata.setRequiredData(metadataWindow.getRequiredData());
            metadata.setOptionalData(metadataWindow.getOptionalData());
        } else {
            System.out.println("fail");
        }
    }

    private void setPaths() {
        SettingDialog settingWindow = new SettingDialog(this, true, workingDirectory, kindlegenDirectory, outputDirectory);
                setLocationInMiddle(settingWindow);
        settingWindow.setVisible(true);
        if (settingWindow.getReturnValue() == SettingDialog.APPROVE) {
            this.workingDirectory = settingWindow.getWorkingPathLabel();
            this.kindlegenDirectory = settingWindow.getKindlegenPathLabel();
            this.outputDirectory = settingWindow.getOutputPathLabel();
        }
    }

    private void setFont() {
        FontChooserDialog fontSettingWindow = new FontChooserDialog(this, true);
        setLocationInMiddle(fontSettingWindow);
        fontSettingWindow.setVisible(true);
        if (fontSettingWindow.getReturnValue() == SettingDialog.APPROVE) {

        }
    }

    

    class StyleAction extends AbstractAction {

        String tag = "";

        public StyleAction(String text, Icon icon, String description, char accelerator, String tag) {
            super(text, icon);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(accelerator, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            putValue(SHORT_DESCRIPTION, description);
            this.tag = tag;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                switch (tag) {
                    case "bold":
                        spravceStylu.setBold(jTextPane1);
                        applyStyleTags(tag);
                        break;
                    case "italic":
                        spravceStylu.setItalic(jTextPane1);
                        applyStyleTags(tag);
                        break;
                    case "underline":
                        spravceStylu.setUnderline(jTextPane1);
                        applyStyleTags(tag);
                        break;
//                    case "normal":
//                        spravceStylu.setNormal(jTextPane1);  
//                        break;
                    case "align-center":
                        spravceStylu.setAlignCenter(jTextPane1);
                        applyStyleTags(tag);
                        break;
                    case "align-right":
                        spravceStylu.setAlignRight(jTextPane1);
                        applyStyleTags(tag);
                        break;
                    case "align-left":
                        spravceStylu.setAlignLeft(jTextPane1);
                        applyStyleTags(tag);
                        break;

                    default:
                        
                }

            } catch (HeadlessException ex) {
                System.out.println("Dialog zrušen..");
            }
        }
    }

    class SettingAction extends AbstractAction {

        String action = "";

        public SettingAction(String text, Icon icon, String description, String action) {
            super(text, icon);
            this.action = action;
            putValue(SHORT_DESCRIPTION, description);
            //putValue(, enabled);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                switch (action) {
                    case "font":
                        setFont();
                        break;
                    case "metadata":
                        setMetadata();
                        break;
                    case "path":
                        setPaths();
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception ex) {
                JOptionPane.showConfirmDialog(centerPanel, "Vyskytla se chyba, zkute restartovat program.");
            }
        }

    }

    class FileAction extends AbstractAction {
        // -1 clear
        //  0 load
        //  1 save
        //  2 delete metadata and clear 

        int option = 0;

        public FileAction(String text, Icon icon, String description, char accelerator, int option) {
            super(text, icon);

            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(accelerator, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            putValue(SHORT_DESCRIPTION, description);
            this.option = option;
            //putValue(, enabled);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (option < 0) {
                    jTextPane1.setText("");
                    jTextPane2.setText("");
                } else if (option == 2) {
                    metadata.clear();
                    clearText();
                } else {
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileFilter(new FileNameExtensionFilter("TXT files", "txt"));
                    int returnVal = (option == 0) ? chooser.showOpenDialog(centerPanel) : chooser.showSaveDialog(centerPanel);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        if (option == 0) {
                            loadDataFromFile(chooser.getSelectedFile());
                        } else {
                            saveDataToFile(chooser.getSelectedFile());
                        }

                    } else {
                        //Dialog zru�en
                    }

                }
            } catch (HeadlessException ex) {
                System.out.println("Dialog zrušen..");
            }
        }

    }
}
