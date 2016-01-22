package projectrcp.model;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class BookFilter extends ViewerFilter {
	
	private String searchString;
	
	public void  setSearchFilter(String s) {
		this.searchString = ".*" + s + ".*";
	}
	
	
	
	public String getSearchString() {
		return searchString;
	}



	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}



	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchString == null || searchString.length() == 0) {
			return true;
		}
		BookTo b = (BookTo) element;
		if (b.getTitle().matches(searchString)) {
			return true;
		}
		if (b.getAuthors().matches(searchString)) {
			return true;
		}
		return false;
	}

}
