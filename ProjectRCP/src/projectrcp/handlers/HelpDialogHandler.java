package projectrcp.handlers;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class HelpDialogHandler implements IHandler {

//	protected HelpDialogHandler(IShellProvider parentShell) {
//		super(parentShell);
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	  @Override
//	  protected Control createDialogArea(Composite parent) {
//	    Composite container = (Composite) super.createDialogArea(parent);
//	    Button button = new Button(container, SWT.PUSH);
//	    button.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
//	        false));
//	    button.setText("Press me");
//	    button.addSelectionListener(new SelectionAdapter() {
//	      @Override
//	      public void widgetSelected(SelectionEvent e) {
//	        System.out.println("Pressed");
//	      }
//	    });
//
//	    return container;
//	  }
//	  
//	  @Override
//	  protected void configureShell(Shell newShell) {
//	    super.configureShell(newShell);
//	    newShell.setText("Selection dialog");
//	  }
//
//	  @Override
//	  protected Point getInitialSize() {
//	    return new Point(450, 300);
//	  }

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
