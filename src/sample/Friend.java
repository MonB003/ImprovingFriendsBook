/* Unit 7 Improving the Friends Book Friend class
By: Monica Bacatan
 */

package sample;

import java.io.*;

public class Friend {
    // Fields for Friend object
    String name;
    String hobby;

    // Constructor for Friend object
    Friend(String name, String hobby) {
        this.name = name;
        this.hobby = hobby;
    }

    // Getters to get fields
    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }


    // toString Method that returns the name and hobby of Friend
    public String toString() {
        return "Name: " + name + "  Hobby: " + hobby;
    }


    // Write Friend object into friend.txt file
    public void writeToFile() throws IOException {
        // Create a FileReader to read the friends.txt file
        FileWriter fw = new FileWriter("friends.txt", true);

        // Create a BufferedWriter
        BufferedWriter bw = new BufferedWriter(fw);

        // BufferedWriter writes each Friend object into friends.txt file
        bw.write(name + ",\r");
        bw.write(hobby + "\r");
        bw.write(";\r");
        bw.close();
    }

}
