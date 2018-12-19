import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class PlayList {

    private static boolean quit = false;

    private static Scanner in = new Scanner(System.in);

    private static Song[] songs = new Song[99];
    private static Song[] order = new Song[99];

    private static int numSongs;

    public static void main(String[] args) {

	//the for loop for user input

        for (numSongs = 0; numSongs < 3; numSongs++) {
            System.out.println("-------Song " + numSongs + "-------");
            System.out.print("Title: ");
            String title = in.nextLine();
            System.out.print("Artist: ");
            String artist = in.nextLine();
            System.out.print("Play Time(mm:ss): ");
            String[] h1 = in.nextLine().split(":");
            int playTime = (Integer.parseInt(h1[0]) * 60) + (Integer.parseInt(h1[1]));
            System.out.print("File Path:  ");
            String filePath = in.nextLine();
            songs[numSongs] = new Song(title, artist, playTime, filePath);
            songs[numSongs].playSong();
            System.out.println("-------------------");
        }

	//the for loop to sort the songs

        Song largest = songs[0];
        int y = 0;

        for (int x = 0; x < numSongs; x++) {
            if (songs[x].getPlayTime() > largest.getPlayTime()) {
                largest = songs[x];

                Song[] temp = new Song[99];
                if (numSongs >= 0) System.arraycopy(order, 0, temp, 1, numSongs);

                y++;

                order[0] = songs[x];

            } else {
                order[y] = songs[x];

                y++;
            }
        }

	//prints the final output
        System.out.println("Playlist===========================================================================================================");
        System.out.println("  Title           Artist          Time            Path");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");

        for (int x = numSongs - 1; x >= 0; x--) {
            System.out.print(x + 1 + " ");
            System.out.println(order[x]);
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------");

        double averagePlayTime = 0;

        for (int x = numSongs - 1; x >= 0; x--) {
            averagePlayTime += order[x].getPlayTime();
        }

        DecimalFormat df = new DecimalFormat("#####.##");

        System.out.println("The average play time is: " + df.format(averagePlayTime / numSongs));
        System.out.println("-------------------------------------------------------------------------------------------------------------------");

        Song closest = order[0];

        for (int x = numSongs - 1; x >= 0; x--) {
            if (Math.abs(240 - order[x].getPlayTime()) < Math.abs(240 - closest.getPlayTime())) {
                closest = order[x];
            }
        }

        System.out.println("The song closest to four minutes is: " + closest.getTitle());
        System.out.println("===================================================================================================================");
    }
}
