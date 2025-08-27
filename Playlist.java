public class Playlist {
    private Song head;
    private Song currentSong;
    private int size;
    
    public Playlist() {
        this.head = null;
        this.currentSong = null;
        this.size = 0;
    }
    
    // Add a new song to the end of the playlist
    public void addSong(String title) {
        Song newSong = new Song(title);
        
        if (head == null) {
            head = newSong;
            currentSong = newSong;
        } else {
            Song current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newSong);
        }
        size++;
        System.out.println("Added: " + title);
    }
    
    // Delete a song by title
    public boolean deleteSong(String title) {
        if (head == null) {
            return false;
        }
        
        // If the song to delete is the head
        if (head.getTitle().equals(title)) {
            head = head.getNext();
            if (currentSong != null && currentSong.getTitle().equals(title)) {
                currentSong = head;
            }
            size--;
            return true;
        }
        
        // Find the song to delete
        Song current = head;
        while (current.getNext() != null && !current.getNext().getTitle().equals(title)) {
            current = current.getNext();
        }
        
        if (current.getNext() != null) {
            // If we're deleting the current song, move to next
            if (currentSong != null && current.getNext().getTitle().equals(currentSong.getTitle())) {
                currentSong = current.getNext().getNext();
            }
            current.setNext(current.getNext().getNext());
            size--;
            return true;
        }
        
        return false;
    }
    
    // Play next song
    public String playNext() {
        if (currentSong == null) {
            if (head != null) {
                currentSong = head;
                return "Now Playing: " + currentSong.getTitle();
            }
            return "Playlist is empty";
        }
        
        if (currentSong.getNext() != null) {
            currentSong = currentSong.getNext();
            return "Now Playing: " + currentSong.getTitle();
        } else {
            // Loop back to the beginning
            currentSong = head;
            return "Now Playing: " + currentSong.getTitle();
        }
    }
    
    // Play previous song
    public String playPrevious() {
        if (currentSong == null) {
            if (head != null) {
                currentSong = head;
                return "Now Playing: " + currentSong.getTitle();
            }
            return "Playlist is empty";
        }
        
        // Find the previous song
        if (head == currentSong) {
            // If current song is head, go to the last song
            Song last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            currentSong = last;
        } else {
            Song previous = head;
            while (previous.getNext() != currentSong) {
                previous = previous.getNext();
            }
            currentSong = previous;
        }
        
        return "Now Playing: " + currentSong.getTitle();
    }
    
    // Show the entire playlist
    public String showPlaylist() {
        if (head == null) {
            return "Playlist is empty";
        }
        
        StringBuilder playlist = new StringBuilder("Playlist: ");
        Song current = head;
        
        while (current != null) {
            playlist.append(current.getTitle());
            if (current.getNext() != null) {
                playlist.append(" -> ");
            }
            current = current.getNext();
        }
        
        return playlist.toString();
    }
    
    // Show current song
    public String showCurrentSong() {
        if (currentSong == null) {
            return "No song is currently playing";
        }
        return "Current Song: " + currentSong.getTitle();
    }
    
    // Get playlist size
    public int getSize() {
        return size;
    }
    
    // Check if playlist is empty
    public boolean isEmpty() {
        return head == null;
    }
}
