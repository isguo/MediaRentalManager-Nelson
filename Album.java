package mediaRentalManager;

public class Album extends Media{
	//title, number of copies available, an artist and the songs
	
	String artist;
	String songs;
	
	
	public Album(String title, int copiesAvailable, String artist, String songs) {
		super(title, copiesAvailable);

		this.artist = artist;
		this.songs = songs;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getSongs() {
		return songs;
	}
	@Override
	public String toString() {
		//Title: Bad, Copies Available: 2, Artist: Mike J, Songs: Mirror, Far Away
		//Title: Gone with the Wind, Copies Available: 2, Rating: PG
        return("Title: " + title + ", Copies Available: "+ copiesAvailable + ", Artist: " + artist + ", Songs: " + songs + "\n");
    }
}
