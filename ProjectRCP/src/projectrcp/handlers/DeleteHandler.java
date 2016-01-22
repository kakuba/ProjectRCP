package projectrcp.handlers;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import projectrcp.model.BookTo;
import projectrcp.restClient.RestClient;

public class DeleteHandler extends AbstractHandler implements IHandler {
	
	private RestClient restClient = new RestClient();
	
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {

          ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();

          if (selection != null & selection instanceof IStructuredSelection) {
                 IStructuredSelection structuredSelection = (IStructuredSelection) selection;
                 for (Iterator<BookTo> iterator = structuredSelection.iterator(); iterator.hasNext();) {
                        BookTo book = iterator.next();
                        Long id = book.getId();
                        restClient.delete(id);
                        restClient.search("");
                 }
          }

          return null;
    }

}
