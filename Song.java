//Assignment #: Arizona State University Spring 2023 CSE205 #9
//Name: Pruthvi Nandan Janga
//StudentID: 1225338491
//Lecture: TU TH(4:30PM-5:45PM)
//Description:The Song class  represents a song in a playlist and has two instance variables: 
 //The name of the song  (title), the name of the artist who created the song (artist) and a reference to the next song in the playlist (next). The constructor specifies the track name and //artist. END is used instead of null to return an empty object.

public class Song {
    private String title;
    private String artist;
    public Song next;
    public static final Song END = new Song();

    public Song(String title, String artist){
        this.title = title;
        this.artist = artist;
        next = END;
    }

    // This is used to construct the END Table.
    private Song() {
        title = "";
        artist = "";
        next = this;
    }

    public boolean equals(Song other) {
        if (this.title.equals(other.title) 
         && this.artist.equals(other.artist))
            return true;
        return false;
    }

    public String toString(){
        return "Title: " + title + "\tArtist: " + artist;
    }
}
