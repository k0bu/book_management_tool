
//package book_manager.buttonsUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

import book_manager.bookInterface.*;
import book_manager.buttonsUtil.*;

public class InterestButtonAction implements ActionListener{
  private BookShelf _toReadBookShelf;
  private JList<String> _toReadList;

  public InterestButtonAction(BookShelf toReadBookShelf, JList<String> toReadList){
    this._toReadBookShelf = toReadBookShelf;
    this._toReadList = toReadList;
  }

  public void actionPerformed(ActionEvent e){
    var list = Recommend.interest(this._toReadBookShelf.getBooks());
    List<Element> item = new ArrayList<>();
    ((Iterable<Book>) list).forEach(i -> {
      item.add((Element)i);
    });
    this._toReadBookShelf.setAggregation(item);
    this._toReadList.setModel(new ListModelUtil<String>().List2ListModel(this._toReadBookShelf.toStrings()));
  }
}