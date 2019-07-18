package buttonsUtil;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GenerateTextFieldButtonAction implements ActionListener {
  private JPanel _fieldPanel;
  private Map<JTextField, JTextField> _textFieldMap;

  public GenerateTextFieldButtonAction(JPanel panel, Map<JTextField, JTextField> textFieldMap) {
    this._fieldPanel = panel;
    this._textFieldMap = textFieldMap;
  }

  public void actionPerformed(ActionEvent e) {
    JTextField keyField = new JTextField("Title");
    JTextField valueField = new JTextField("0");
    this._textFieldMap.put(keyField, valueField);
    
    JPanel fieldPaneX = new JPanel();
		fieldPaneX.setLayout(new BoxLayout(fieldPaneX, BoxLayout.X_AXIS));
		fieldPaneX.add(keyField);
		fieldPaneX.add(Box.createRigidArea(new Dimension(40,30)));
    fieldPaneX.add(valueField);
    
    this._fieldPanel.add(fieldPaneX);

    this._fieldPanel.revalidate();
  }
}