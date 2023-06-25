/* Unit 7 Improving the Friends Book Controller class
By: Monica 
 */

package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;


public class Controller {
    public TextField textGetName;
    public TextField textGetHobby;
    public ListView<Friend> friendsList = new ListView<>();
    public Button btnCreateFriend;
    public static ArrayList<Friend> testList = new ArrayList<>();  // testList keeps track of all Friends entered in the text field
    public static ArrayList<String> nameCheckList = new ArrayList<>();  // nameCheckList only keeps track of names entered, it checks for duplicate names
    public static String getTextName;  // String holds user's input for the name field of Friend object


    // Method to create a Friend and add it to friendsList ArrayList
    public void createFriend(ActionEvent actionEvent) throws IOException {
        // getTextName represents the user's input for the name field
        // Name field is what is checked for duplicates
        getTextName = textGetName.getText();

        // Create a Friend object to represent each object added with the Create Friend button
        Friend friend = new Friend(textGetName.getText(), textGetHobby.getText());

        // If statement for if the nameCheckList ArrayList does not contain the name of the Friend object that the user enters
        // This means to Friend name is not a duplicate
        if (!nameCheckList.contains(getTextName)) {
            // Add the name of the Friend object to nameCheckList ArrayList
            nameCheckList.add(getTextName);

            // Add the Friend object to testList ArrayList
            testList.add(friend);

            // Add user input for each Friend object to the friendsList ListView
            friendsList.getItems().add(new Friend(textGetName.getText(), textGetHobby.getText()));
        }

        // Clear text fields
        textGetName.clear();
        textGetHobby.clear();
    }

    // Method to save a Friend to friendsList ArrayList
    public void saveFriend(ActionEvent actionEvent) throws IOException {
        // Create ObservableList to add Friend objects in friendsList to myList
        ObservableList<Friend> myList = friendsList.getItems();

        // For each loop add Friend objects in myList to testList
        for (Friend f : myList) {
            testList.add(f);
        }

        // For each loop writes each Friend object into the text file using the writeToFile method
        for (Friend f : myList) {
            f.writeToFile();
        }

        // Clear friendsList
        friendsList.getItems().clear();
    }

    // Method to load a Friend into friends.txt file
    public void loadFriend(ActionEvent actionEvent) throws IOException {
        // Clear all objects in friendsList
        friendsList.getItems().clear();

        // Create new ArrayList and add the objects from friends.txt file into the friends ArrayList
        ArrayList<Friend> friends = CreateFriend.createAllFriends("friends.txt");

        // For each loop to add each Friend object from the friends ArrayList into friendsList ListView
        for (Friend f : friends) {
            friendsList.getItems().add(f);
        }
    }

}
