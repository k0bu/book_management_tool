package buttonsUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class GenerateTextFieldButtonAction implements ActionListener{
  private Map<JTextField, JTextField> _textFieldMap;


  public GenerateTextFieldButtonAction(Map<JTextField, JTextField> textFieldMap){
    this._textFieldMap = textFieldMap;
  }

  public void actionPerformed(ActionEvent e){

  }
}