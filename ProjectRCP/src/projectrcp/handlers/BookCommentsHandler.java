package projectrcp.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

public class BookCommentsHandler extends AbstractHandler implements IHandler {

	@Override
	  public Object execute(ExecutionEvent event) throws ExecutionException {
	    try {
	      HandlerUtil.getActiveWorkbenchWindowChecked(event).
	        getActivePage().showView("ProjectRCP.bookCommentsView");
	    } catch (PartInitException e) {
	      e.printStackTrace();
	    }
	    return null;
	  }

}
