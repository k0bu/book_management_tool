package buttonsUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

import bookInterface.*;

public class RegisterBookButtonAction implements ActionListener {
  private Map<JTextField, JTextField> _textFieldMap;
  //private ArrayList<JTextField> _textfieldList;
  private JList<String> _list;
  private BookShelf _agg; //aggregation

  //Maybe there is necessity in implementing List for JTextfield for each parametres, 
  //to have them each separated. 

  public RegisterBookButtonAction(JList<String> list, Map<JTextField, JTextField> textFieldMap, BookShelf agg) {
    this._list = list;
    this._textFieldMap = (HashMap<JTextField, JTextField>) textFieldMap;
    this._agg = agg;
  }

  public void actionPerformed(ActionEvent e) {
    DefaultListModel<String> listModel = (DefaultListModel<String>)this._list.getModel();

      //Need to instantiate element to append. It can not be Generics to be able to do that.
    Book b = new Book();
    //Fix this to Map<String, String> so that it can be taken as constructor's parametre
    this._textFieldMap.forEach((k,v)->{
      b.addParametre(k.getText(), v.getText());
    });

    this._agg.addElement(b);
    listModel.addElement(b.toString());

    System.out.println("REGISTERED TO toReadList:");
    System.out.println(this._agg.toString());
    //Below code is unnecessary.
    //this._list.setModel(listModel);
  }
}