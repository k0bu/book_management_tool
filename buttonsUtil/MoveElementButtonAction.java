package buttonsUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

import bookInterface.BookShelf;

public class MoveElementButtonAction implements ActionListener{
  JList<String> _fromList;
  JList<String> _toList;
  BookShelf _fromShelf;
  BookShelf _toShelf;


  public MoveElementButtonAction(JList<String> fromList, JList<String> toList, BookShelf fromShelf, BookShelf toShelf){
    this._fromList = fromList;
    this._toList = toList;
    this._fromShelf = fromShelf;
    this._toShelf = toShelf;
  }

  public void actionPerformed(ActionEvent e){
    ListItemMove.move(this._fromList,this._toList, this._fromShelf, this._toShelf);
  }
}