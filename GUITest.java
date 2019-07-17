import buttonsUtil.*;
import bookInterface.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class GUITest {

	private DefaultListModel<String> _listModel;
	private JList<String> _list;
	private Map<JTextField, JTextField> _fieldMap = new HashMap<>();
	private BookShelf _bookShelf = new BookShelf();


	public Component createComponents() {
		JTextField keyField = new JTextField("Title");
		JTextField valueField = new JTextField("0");
		this._fieldMap.put(keyField, valueField);

		_listModel = new DefaultListModel<String>();

		_list = new JList<String>(_listModel);
		_list.setVisibleRowCount(10);
		_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane = new JScrollPane(_list);
		scrollPane.createVerticalScrollBar();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

	
		JButton regButton = new JButton("Register");
		RegisterBookButtonAction regButtonListener = new RegisterBookButtonAction(_list, _fieldMap, _bookShelf);
		regButton.addActionListener( regButtonListener );

		regButton.setAlignmentX(Component.CENTER_ALIGNMENT);


		JButton delButton = new JButton("Delete");
		DeleteBookButtonAction delButtonListener = new DeleteBookButtonAction(this._list, this._bookShelf);
		delButton.addActionListener( delButtonListener );

		JButton quitButton = new JButton("Quit");
		QuitButtonAction quitButtonListener = new QuitButtonAction();
		quitButton.addActionListener( quitButtonListener );

		JPanel subPane1 = new JPanel();
		subPane1.setLayout(new GridLayout(1, 0));
		subPane1.add(delButton);
		subPane1.add(Box.createRigidArea(new Dimension(30, 10)));
		subPane1.add(quitButton);

		JPanel mainPane = new JPanel();
		mainPane.setBorder(BorderFactory.createEmptyBorder( 320, 320, 320, 320 ));
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
		this._fieldMap.forEach((k,v)->{
			JPanel fieldPane = new JPanel();
			fieldPane.setLayout(new BoxLayout(fieldPane, BoxLayout.X_AXIS));
			fieldPane.add(k);
			fieldPane.add(Box.createRigidArea(new Dimension(10,20)));
			fieldPane.add(v);
			mainPane.add(fieldPane);
		});

		mainPane.add(Box.createRigidArea(new Dimension(10, 20)));
		mainPane.add(regButton);
		mainPane.add(Box.createRigidArea(new Dimension(10, 30)));
		mainPane.add(scrollPane);
		mainPane.add(Box.createRigidArea(new Dimension(10, 20)));
		mainPane.add(subPane1);

		return mainPane;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("TestList");
		GUITest app = new GUITest();
		Component contents = app.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
