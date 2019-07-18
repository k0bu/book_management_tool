package buttonsUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

import bookInterface.*;

public class PopularityButtonAction implements ActionListener{
  private BookShelf _toReadBookShelf;
  private JList<String> _toReadList;

  public PopularityButtonAction(BookShelf toReadBookShelf, JList<String> toReadList){
    this._toReadBookShelf = toReadBookShelf;
    this._toReadList = toReadList;
  }

  public void actionPerformed(ActionEvent e){
    Recommend.popularity(this._toReadBookShelf.getBooks());
    this._toReadList.setModel(new ListModelUtil<String>().List2ListModel(this._toReadBookShelf.toStrings()));
  }
}