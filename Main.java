import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main
{
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("the carter 3","lil wayne");

        album.addSong("money on my mind", 420);
        album.addSong("president carter", 420);
        album.addSong("lollipop", 420);
        album.addSong("Monday", 420);
        album.addSong("Hustling", 420);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("money on my mind",playList);
        albums.get(0).addToPlayList("president carter",playList);
        albums.get(0).addToPlayList("Monday",playList);
        albums.get(0).addToPlayList("Hustling",playList);

        play(playList);

    }

    private static void printMenu()
    {
        System.out.println("0 to close the program");
        System.out.println("1 to play next song");
        System.out.println("2 to play previous song");
        System.out.println("3 to replay the current song");
        System.out.println("4 to list the songs in the playlist");
        System.out.println("5 to print the menu");
        System.out.println("6 to remove song from the playlist");

    }

    private static void printList(LinkedList<Song> playList)
    {
        ListIterator<Song> listIterator = playList.listIterator();
        System.out.println("=====================================");
        while(listIterator.hasNext())
        {
            System.out.println(listIterator.next());
        }
        System.out.println("=====================================");

    }

    private static void play(LinkedList<Song> playList)
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0)
        {
            System.out.println("no songs in playlist");
            return;
        }
        else
        {
            System.out.println("Now playing..." + listIterator.next().toString());
            printMenu();
        }
        while(!quit)
        {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action)
            {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                case 1:
                    if(!forward)
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext())
                    {
                        System.out.println("now playing " + listIterator.next().toString());
                    }
                    else
                    {
                        System.out.println("we have reached the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward)
                    {
                        if(forward)
                        {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious())
                    {
                        System.out.println("now playing " + listIterator.previous().toString());

                    }
                    else
                    {
                        System.out.println("we are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward)
                    {
                        if (listIterator.hasPrevious())
                        {
                            System.out.println("now playing " + listIterator.previous().toString());
                            forward = false;
                        }
                        else
                        {
                            System.out.println("we are at the start of the list");
                        }
                    }
                    else
                    {
                        if (listIterator.hasNext())
                        {
                            System.out.println("now playing " + listIterator.next().toString());
                            forward = true;
                        }
                        else
                        {
                            System.out.println("we have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0)
                    {
                        listIterator.remove();
                        if(listIterator.hasNext())
                        {
                            System.out.println("now playing " + listIterator.next());
                        }
                        else if(listIterator.hasPrevious())
                        {
                            System.out.println("now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }
}
