package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaRentalManager implements MediaRentalManagerInt{
	ArrayList<Customer> customers;
	ArrayList<Media> media;
	int value;


	public MediaRentalManager() {
		customers = new ArrayList<Customer>();
		media = new ArrayList<Media>();
		this.value = 2;
	}
	@Override
	public void addCustomer(String name, String address, String plan) {
		Customer newCusto = new Customer(name, address, plan);

		customers.add(newCusto);

	}

	@Override
	public void addMovie(String title, int copiesAvailable, String rating) {
		Movie newMovie = new Movie(title, copiesAvailable, rating);

		media.add(newMovie);

	}

	@Override
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		Album newAlbum = new Album(title, copiesAvailable, artist, songs);

		media.add(newAlbum);

	}

	@Override
	public void setLimitedPlanLimit(int value) {
		this.value = value;
		

	}

	@Override
	public String getAllCustomersInfo() {

		Collections.sort(customers);

		String result = "***** Customers' Information *****\n"; 
		for(Customer indx : customers) {
			result += ((Customer) indx).toString();
		}
		return result;
	}

	@Override
	public String getAllMediaInfo() {

		Collections.sort(media);

		String result = "***** Media Information *****\n";
		for(Media indx : media) {
			if(indx instanceof Movie) {
				result += ((Movie) indx).toString();
			} else {
				result += ((Album) indx).toString();
			}
		}
		return result;

	}

	@Override
	public boolean addToQueue(String customerName, String mediaTitle) {
		Boolean added = true;
		for(Customer indx : customers) {
			if(indx.getName().equals(customerName)){

				if(indx.getQueue().contains(mediaTitle)) {
					added = false;
				} else {
					indx.getQueue().add(mediaTitle);
					added = true;
				} 
			} 
		}
		return added;
	}

	@Override
	public boolean removeFromQueue(String customerName, String mediaTitle) {
		Boolean removed = false;
		for(Customer indx : customers) {
			if(indx.getName().equals(customerName)){

				if(indx.getQueue().contains(mediaTitle)) {
					indx.getQueue().remove(mediaTitle);
					removed = true;
				}
			} 
		}
		return removed;
	}

	@Override
	public String processRequests() {
		Collections.sort(customers);
		String results = "";
		for(Customer customer : customers) {
			for(String queued : customer.getQueue()) {
				for(Media medias : media) {
					if(medias.getTitle().equals(queued) && medias.getAvail() > 0) {
						if(customer.getPlan().equals("UNLIMITED") || ((customer.getPlan().equals("LIMITED") && (value - customer.getRented().size()) > 0 ))) {

							customer.getRented().add(queued);

							medias.removeCopy();

							results += "Sending " + queued + " to " + customer.getName() + "\n";
						}	
					}
				}
			}
			for(String rented : customer.getRented()) {
				removeFromQueue(customer.getName(), rented);
			}
		}
		return results;
	}

	@Override	
	public boolean returnMedia(String customerName, String mediaTitle) {
		Boolean returned = false;
		for(Customer customer : customers) {
			if(customerName.equals(customer.getName())) {
				customer.getRented().remove(mediaTitle);

				for(Media medias : media) {
					if(medias.getTitle().equals(mediaTitle)) {
						medias.addCopy();
					}
				}
				returned = true;
			}
		}
		return returned;
	}

	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		Collections.sort(media);

		ArrayList<String> satisfied = new ArrayList<String>();

		if(title == null && rating == null && artist == null && songs == null) {
			for(Media medias : media) {
				satisfied.add(medias.getTitle());
			}
		} else {

			for(Media medias : media) {
				if(title != null && medias.getTitle().equals(title)) {
					satisfied.add(medias.getTitle());

				} else if(medias instanceof Movie) {
					if(rating != null && ((Movie) medias).getRating().equals(rating)) {
						satisfied.add(medias.getTitle());
					}
				} else if(medias instanceof Album){
					if(artist != null && ((Album) medias).getArtist().equals(artist)) {
						satisfied.add(medias.getTitle());
					} else if(songs != null && ((Album) medias).getSongs().indexOf(songs) != -1) {
						satisfied.add(medias.getTitle());
					}
				} 
			}
		}
		return satisfied;
	}

}
