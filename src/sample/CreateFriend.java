/* Unit 7 Improving the Friends Book Create Friend class
By: Monica Bacatan
 */

package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriend {
    // Fields of Friend object
    // Fields are private so they can only be accessed within the CreateFriend class
    private static String name;
    private static String hobby;

    // Create FileReader, BufferedReader, and ArrayList to read objects in friends.txt file and add them to an ArrayList
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();


    // ArrayList method to add all Friend objects from the ListView into a text file
    public static ArrayList<Friend> createAllFriends(String fileName) throws IOException {
        // Create FileReader and BufferedReader to read each Friend object
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);

        // String line represents each new line in friends.txt file
        String line;

        // String friendString to represent each Friend object
        String friendString = "";


        // While loop reads each line that's not empty and adds the Friend object to a line in the friends.txt file
        while ((line = br.readLine()) != null) {
            // If statement to add each string input into the line until it reaches the semicolon, semicolon means it's at the end of an object
            if (!line.equals(";")) {
                friendString += line;
            }
            // Else statement for when it's at the end of an object
            else {
                // Parse the string and make it into a Friend object
                parseFriend(friendString);

                // Clear the friendString
                friendString = "";
            }
        }

        // Return the ArrayList
        return friends;
    }


    // Method to parse each Friend object and add it to the friends ArrayList
    private static void parseFriend(String string) {
        // position keeps track of the position in the friendString
        int position = 0;

        // Gets the input for name field
        String name = "";

        // Gets the input for hobby field
        String hobby = "";


        // For loops loops through each position in the friendString
        for (int i = 0; i < string.length(); i++) {
            // The fields for the Friend object are separated by a comma
            // If statement checks if the current position of the string is a comma
            if (string.substring(i, i + 1).equals(",")) {
                position = i;

                // Anything before the comma is the input for the name field
                name = string.substring(0, position);

                // Anything after the comma is the input for the hobby field
                hobby = string.substring(position + 1);
            }
        }

        // Add the Friend object to the friends ArrayList
        friends.add(new Friend(name, hobby));
    }

}
