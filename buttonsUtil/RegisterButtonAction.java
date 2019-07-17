package buttonsUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class RegisterButtonAction implements ActionListener {
  private ArrayList<JTextField> _textfieldList;
  private JList<String> _list;

  public RegisterButtonAction(JList<String> list, List<JTextField> textfieldList) {
    this._list = list;
    this._textfieldList = (ArrayList<JTextField>) textfieldList;
  }

  public void actionPerformed(ActionEvent e) {
    DefaultListModel<String> listModel = (DefaultListModel<String>)this._list.getModel();
    this._textfieldList.forEach(t->{
      listModel.addElement(t.getText());
    });
    
  }
}