package projectrcp.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import projectrcp.model.BookTo;

public class BookCommentsView extends ViewPart {
	public BookCommentsView() {
		// TODO Auto-generated constructor stub
	}

	private Label label;
	@Override
	public void createPartControl(Composite parent) {
		label = new Label(parent, SWT.BORDER);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false)); 
		ISelectionListener listener = new ISelectionListener() {
			public void selectionChanged(IWorkbenchPart part, ISelection sel) {
				if (!(sel instanceof IStructuredSelection))
					return;
				IStructuredSelection ss = (IStructuredSelection) sel;
				Object o = ss.getFirstElement();
				if (o instanceof BookTo){
					label.setText(o.toString());
					
					
				}
			}
		};
		getSite().getPage().addSelectionListener(listener);
		

	}
	
//	public void dispose() {
//        getSite().getPage().removeSelectionListener(listener);
//     }// a co z tym??

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
