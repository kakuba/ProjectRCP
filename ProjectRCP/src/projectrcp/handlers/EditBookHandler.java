package projectrcp.handlers;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import projectrcp.dialogs.EditBookDialog;
import projectrcp.model.BookTo;
import projectrcp.model.ModelProvider;

public class EditBookHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection != null & selection instanceof IStructuredSelection) {
			
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			for (Iterator<BookTo> iterator = structuredSelection.iterator(); iterator.hasNext();) {
				BookTo bookToChange = iterator.next();

				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				EditBookDialog dialog = new EditBookDialog(shell, bookToChange);

				if (dialog.open() == Window.OK) {
					bookToChange.setTitle(dialog.getBook().getTitle());
					bookToChange.setAuthors(dialog.getBook().getAuthors());
					
					ModelProvider.INSTANCE.updateBook(bookToChange);
				}
			}
		}
		return null; 
	}

}
