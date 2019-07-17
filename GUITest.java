import buttonsUtil.*;
import bookInterface.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;

public class GUITest {
	private Map<String, JList<String>> _listMap = new HashMap<>();
	private JList<String> _toReadList;
	private JList<String> _finishedList;

	private Map<JTextField, JTextField> _fieldMap = new HashMap<>();

	private Map<String, BookShelf> _bookShelfMap = new HashMap<>();
	private BookShelf _toReadBookShelf = new BookShelf();
	private BookShelf _finishedBookShelf = new BookShelf();

	public Component createComponents() {
		for(int i = 0; i< 3; i++){
			JTextField keyField = new JTextField("Title");
			JTextField valueField = new JTextField("0");
			this._fieldMap.put(keyField, valueField);
		}


		DefaultListModel<String> toReadListModel = new DefaultListModel<String>();
		DefaultListModel<String> finishedListModel = new DefaultListModel<String>();

		_toReadList = new JList<String>(toReadListModel);
		_toReadList.setVisibleRowCount(10);
		_toReadList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane toReadScrollPane = new JScrollPane(_toReadList);
		toReadScrollPane.createVerticalScrollBar();
		toReadScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		_finishedList = new JList<String>(finishedListModel);
		_finishedList.setVisibleRowCount(10);
		_finishedList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane finishedScrollPane = new JScrollPane(_finishedList);
		finishedScrollPane.createVerticalScrollBar();
		finishedScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	
		_listMap.put("toRead", _toReadList);
		_listMap.put("finished", _finishedList);

		_bookShelfMap.put("toRead", _toReadBookShelf);
		_bookShelfMap.put("finished", _finishedBookShelf);


		JButton regButton = new JButton("Register");
		RegisterBookButtonAction regButtonListener = new RegisterBookButtonAction(_toReadList, _fieldMap, _toReadBookShelf);
		regButton.addActionListener( regButtonListener );
		regButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton toRead2Finished = new JButton(">");
		MoveElementButtonAction toRead2FinishedListener = new MoveElementButtonAction(_toReadList, _finishedList, _toReadBookShelf, _finishedBookShelf);
		toRead2Finished.addActionListener(toRead2FinishedListener);
		toRead2Finished.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton finished2ToRead = new JButton("<");
		MoveElementButtonAction finished2ToReadListener = new MoveElementButtonAction(_finishedList, _toReadList, _finishedBookShelf, _toReadBookShelf);
		finished2ToRead.addActionListener(finished2ToReadListener);
		finished2ToRead.setAlignmentX(Component.CENTER_ALIGNMENT);


		JButton delButton = new JButton("Delete");
		DeleteBookButtonAction delButtonListener = new DeleteBookButtonAction(_listMap, _bookShelfMap);
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
			fieldPane.add(Box.createRigidArea(new Dimension(20,30)));
			fieldPane.add(v);
			mainPane.add(fieldPane);
		});

		mainPane.add(Box.createRigidArea(new Dimension(10, 20)));
		mainPane.add(regButton);
		mainPane.add(Box.createRigidArea(new Dimension(10, 30)));

		JPanel scrollPane = new JPanel();
		scrollPane.add(Box.createRigidArea(new Dimension(20,300)));
		scrollPane.add(toReadScrollPane);
		scrollPane.add(Box.createRigidArea(new Dimension(10,30)));
		
		JPanel moveElementPanel = new JPanel();
		moveElementPanel.add(toRead2Finished);
		moveElementPanel.add(finished2ToRead);
		moveElementPanel.setLayout(new BoxLayout(moveElementPanel, BoxLayout.Y_AXIS));
		scrollPane.add(moveElementPanel);

		scrollPane.add(Box.createRigidArea(new Dimension(10,30)));
		scrollPane.add(finishedScrollPane);
		scrollPane.add(Box.createRigidArea(new Dimension(20,30)));
		scrollPane.setLayout(new BoxLayout(scrollPane, BoxLayout.X_AXIS));

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
