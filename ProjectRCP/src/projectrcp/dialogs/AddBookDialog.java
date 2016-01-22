package projectrcp.dialogs;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import projectrcp.model.BookTo;

public class AddBookDialog extends TitleAreaDialog {

	private Text text1;
	private Text text2;
	private BookTo book;

	public BookTo getBook() {
		return book;
	}

	public AddBookDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		setTitle("Add a new Book");
		setMessage("Please enter the data of the new Book", IMessageProvider.INFORMATION);
		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		parent.setLayout(layout);
		Label label1 = new Label(parent, SWT.NONE);
		label1.setText("Title");
		text1 = new Text(parent, SWT.BORDER);
		Label label2 = new Label(parent, SWT.NONE);
		label2.setText("Authors");
		text2 = new Text(parent, SWT.BORDER);
		return parent;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		((GridLayout) parent.getLayout()).numColumns++;

		Button button = new Button(parent, SWT.PUSH);
		button.setText("OK");
		button.setFont(JFaceResources.getDialogFont());
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (text1.getText().length() != 0 && text2.getText().length() != 0) {
					book = new BookTo(text1.getText(), text2.getText());
					close();

				} else {
					setErrorMessage("Please enter all data");
				}
			}
		});
	}
}
