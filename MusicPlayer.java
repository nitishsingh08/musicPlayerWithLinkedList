import java.util.Scanner;

public class MusicPlayer {
    private Playlist playlist;
    private Scanner scanner;
    
    public MusicPlayer() {
        this.playlist = new Playlist();
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        int choice;
        
        do {
            displayMenu();
            choice = getChoice();
            processChoice(choice);
        } while (choice != 7);
        
        System.out.println("Thank you for using Music Player!");
        scanner.close();
    }
    
    private void displayMenu() {
        System.out.println("\n=== Music Playlist Menu ===");
        System.out.println("1. Add Song");
        System.out.println("2. Delete Song");
        System.out.println("3. Play Next");
        System.out.println("4. Play Previous");
        System.out.println("5. Show Playlist");
        System.out.println("6. Show Current Song");
        System.out.println("7. Exit");
        System.out.print("Enter choice: ");
    }
    
    private int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number (1-7)");
            scanner.next();
            System.out.print("Enter choice: ");
        }
        return scanner.nextInt();
    }
    
    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                addSong();
                break;
            case 2:
                deleteSong();
                break;
            case 3:
                playNext();
                break;
            case 4:
                playPrevious();
                break;
            case 5:
                showPlaylist();
                break;
            case 6:
                showCurrentSong();
                break;
            case 7:
                // Exit - do nothing, will exit the loop
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 7.");
        }
    }
    
    private void addSong() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter song title: ");
        String title = scanner.nextLine().trim();
        
        if (!title.isEmpty()) {
            playlist.addSong(title);
        } else {
            System.out.println("Song title cannot be empty.");
        }
    }
    
    private void deleteSong() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty. Nothing to delete.");
            return;
        }
        
        scanner.nextLine(); // Consume newline
        System.out.print("Enter song title to delete: ");
        String title = scanner.nextLine().trim();
        
        if (playlist.deleteSong(title)) {
            System.out.println("Deleted: " + title);
        } else {
            System.out.println("Song not found: " + title);
        }
    }
    
    private void playNext() {
        System.out.println(playlist.playNext());
    }
    
    private void playPrevious() {
        System.out.println(playlist.playPrevious());
    }
    
    private void showPlaylist() {
        System.out.println(playlist.showPlaylist());
    }
    
    private void showCurrentSong() {
        System.out.println(playlist.showCurrentSong());
    }
    
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.start();
    }
}
