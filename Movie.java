package mediaRentalManager;

public class Movie extends Media{
	//title, a number of copies available and a rating
	String rating;
	
	
	public Movie(String title, int copiesAvailable, String rating) {
		super(title, copiesAvailable);
		
		this.rating = rating;
		
	}
	
	public String getRating() {
		return rating;
	}
	
//	@Override
	public String toString() {
		//Title: Bad, Copies Available: 2, Artist: Mike J, Songs: Mirror, Far Away
		//Title: Gone with the Wind, Copies Available: 2, Rating: PG
        return("Title: " + title + ", Copies Available: "+ copiesAvailable + ", Rating: " + rating + "\n");
    }
}
