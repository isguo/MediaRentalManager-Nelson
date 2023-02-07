package mediaRentalManager;

public class Media implements Comparable<Media> {
	String title;
	int copiesAvailable;
	
	public Media(String title, int copiesAvailable) {
		this.title = title;
		this.copiesAvailable = copiesAvailable;
	}

	public String getTitle() {
		return title;
	}
	
	public int getAvail() {
		return copiesAvailable;
	}
	
	public void removeCopy() {
		copiesAvailable -= 1;
	}
	
	public void addCopy() {
		copiesAvailable += 1;
	}
	
	@Override
	public int compareTo(Media compareTitle) {

		return title.compareTo(compareTitle.getTitle());
	}
	
	
    
}
