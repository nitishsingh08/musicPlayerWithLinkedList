public class Song {
    private String title;
    private Song next;
    
    public Song(String title) {
        this.title = title;
        this.next = null;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Song getNext() {
        return next;
    }
    
    public void setNext(Song next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return title;
    }
}

