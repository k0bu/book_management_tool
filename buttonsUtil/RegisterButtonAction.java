package buttonsUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class RegisterButtonAction implements ActionListener {
  private JTextField _textfield;
  private JList<String> _list;

  public RegisterButtonAction(JList<String> list, JTextField textfield) {
    this._list = list;
    this._textfield = textfield;
  }

  public void actionPerformed(ActionEvent e) {
    DefaultListModel<String> listModel = (DefaultListModel<String>)this._list.getModel();
    listModel.addElement(this._textfield.getText());
  }
}