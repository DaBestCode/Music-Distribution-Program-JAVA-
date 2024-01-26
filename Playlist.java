//Assignment #: Arizona State University Spring 2023 CSE205 #9
//Name: Pruthvi Nandan Janga
//StudentID: 1225338491
//Lecture: TU TH(4:30PM-5:45PM)
//Description:The Playlist lesson has an occurrence variable to begin with that marks the head of the list.

//The Playlist lesson has eight strategies (barring constructors) as sketched out within the UML chart simply  must implement:

//The head() strategy returns the primary song on the playlist. (Note: DOES NOT return invalid when there are no tunes within the playlist, instead head returns Song.END).
//The include() strategy includes a tune to the conclusion of the current playlist.
//The measure() calculates the number of melodies in a playlist (Note: Don't  utilize an occasion variable to store the estimate. Calculate the measure on-the-fly)
//The remove() strategy expels a tune (by providing a Tune 
//The listSongs() strategy records all the melodies. Returns "No melodies in playlist." in case the playlist is empty. Something else the frame of the string returned ought to be
//SonginnTotal melodies: [tune count].
//The getPosition(Song) strategy gets the position of a tune within the playlist (returns -1 in case the tune cannot be found within the playlist).
public class Playlist {

    private Song first; // declaring instance vaeiable of Song to identify the first song of the list or the head
    private String name;//declaring name variable to acces the song name
    // declaring the constructor of playlist class to access the class
    public Playlist() {
    	//instantiating the variables with respective elements in the constructor
    	name = "library";
        this.first = Song.END; // instantiating the first song of the list with Song.END
    }
    //constructor with String name as input to set the name of the song
    public Playlist(String name) {
    	//to set the name of the song as given
        this.name = name;
        first = Song.END;
    }
    //method used to return the name of the song
    public String getName() {
    	//returning the name of the song
        return name;
    }
    //method used to return the provided elements of the firt song of the list 
    public Song head() {
    	//returning the first song
        return first;
    }
    //add method is used to add a song to the end of the current playlist
    public void add(Song song) {
    	//checking if the the first song is not equal to the song at the end of the list 
        if (first.equals(Song.END)==false) {
        	//placing the current inputted song at the first of the list
        	Song currentSong = first;
        	//checking if the next song is not equal to the song atbthe end of the playlist
            while (!currentSong.next.equals(Song.END)) {
                currentSong = currentSong.next;
            }
            currentSong.next = song;
        } else {
        	first = song;
        }
    }
    //method used to remove the first song from the playlist
    public Song removeFirst() {
    	//checking if the first song is not the same as the song at the end of the playlist
        if (first.equals(Song.END)==false) {
        	Song removedSong = first;
            first = first.next;
            //returning the removed song after checking if the playlist is empty
            return removedSong;
        }
        //if the playlist is empty it returns the song at the end of the playlist
        return Song.END;
    }
   //method used to determine the size of the playlist
    public int size() {
   //initiating size variable to zero
        int size = 0;
   //instantiating current song to the first in the playllist
        Song currentSong = first;
   //checking if the current song is equal to the song at the end of the list
        while (currentSong.equals(Song.END)==false) {
            size++;
            currentSong = currentSong.next;
        }
        return size;
    }
   //method used to remove the given song determined by the user
    public int remove(Song song) {
   //checking if first song is equal to the song at the end of the playlist
        if (first.equals(Song.END)) {
            return -1;
        }
        else if (first.equals(song)) {
            first = first.next;
            return 0;
        }
        else {
        //instantiating current song to the first in the playlist
        Song currentSong = first;
        int pos=0;
        //checking if the next song after the current song is equal to the song at the end of the list
        while (!currentSong.next.equals(Song.END)) {
        //incrementing position
            pos=pos+1;
            if (currentSong.next.equals(song)==true) {
                currentSong.next = currentSong.next.next;
                return pos;
            }
           //instantiating current song to the next song to reduce the playlist size
            currentSong = currentSong.next;
        }
        return -1;
        }
    }
   //method used to determine the postion of the song in the playlist
    public int getPosition(Song song) {
        int pos = 0;
        Song current = first;
   //checking if the current song is same as the song at the end of the playlist
        while (!current.equals(Song.END)) {
            if (current.equals(song)==true) {
                return pos;
            }
    //incrementing the postion by one
            pos=pos+1;
            current = current.next;
        }
        return -1;
    }
   //method used to list the songs in the order placed in the playlist
    public String listSongs() {
    //checking if the first song is equal to the song at the end of the playlist
        if (first.equals(Song.END)==true) {
            return "No songs in playlist.";
        }
     //using a string  builder to add all the elements of the song required
     //using a string might be an issue and messy to add all the elements
        StringBuilder sb = new StringBuilder();
        int count = 0;
        Song currentSong = first;
      //checking if the current song is equal to the song at the end of the playlist
        for (; !currentSong.equals(Song.END); currentSong = currentSong.next) {
       //appending the current song into the string builder
       sb.append(currentSong.toString() + "\n\n");
       //incrmenting the count by one
       count++;
    }

        sb.append("Total songs: " + count + ".");
        return sb.toString();
    }
}

