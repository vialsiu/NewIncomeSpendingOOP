package org.example.oopjavafxuserdetailsdao.GUI;

import org.example.oopjavafxuserdetailsdao.DAOs.MySqlUserDao;
import org.example.oopjavafxuserdetailsdao.DAOs.UserDaoInterface;
import org.example.oopjavafxuserdetailsdao.DTOs.User;
import org.example.oopjavafxuserdetailsdao.Exceptions.DaoException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/// Controller defines event listeners that capture events generated
/// by the GUI. (i.e. onButtonClick etc.)
/// The event listeners (event handlers) contain code that will
/// update the state of the UI and/or the state of teh Model containing
/// the underlying data.

public class UserController {

    // reference to the user Model (one User object)
    // The Controller must be able to access the model in order to
    // change data in response to user GUI actions.
    private UserModel userModel;

    // The @FXML annotation will allow the UI Controls from the  FXML file
    // to be assigned to these reference variables automatically.
    // (Dependency Injection).
    @FXML
    public TextField username_inputted;
    @FXML
    public TextField password_inputted;
    @FXML
    public TextField user_id;
    @FXML
    public TextField first_name;
    @FXML
    public TextField last_name;
    @FXML
    public TextField password;
    @FXML
    public TextField username;
    @FXML
    public Button getUserDetailsButton;
    @FXML
    public Button clearAllButton;
    @FXML
    private Label messageLabel;

    /// Constructor for this Controller (required by JavaFX to create the controller.)
    public UserController() {
    }

    /// The Constructor is called first, then @FXML fields are populated,
    /// then initialize() is called. Constructor has no access to FXML fields,
    /// but initialize() does due to the sequence of execution.
    @FXML
    private void initialize() {
        System.out.println("Initializing controller - initialize() called. (not used in this sample)");
    }

    /// Event Listener i.e. a method that is called when some GUI event
    /// happens. This method is called when the user clicks on the "Get User Details"
    /// Button control.  The method is identified in the Button definition
    /// in the  user-view.fxml file.
    @FXML
    public void getUserDetailsButtonClicked() {

        messageLabel.setText("getUserDetails() was called."); // for info purposes

        UserDaoInterface IUserDao = new MySqlUserDao();  //"IUserDao" -> "I" stands for Interface

        // Get the username and password values from the GUI
        String usernameInputted = username_inputted.getText();
        String passwordInputted = password_inputted.getText();
        if (username != null && password != null) {   // more validation needed - messages for user if either is null
            try {
                // Get User (Domain Object) based on user inputted  username & password
                User user = IUserDao.findUserByUsernamePassword(usernameInputted, passwordInputted);

                if (user == null) {
                    messageLabel.setText("User not found.");
                } else {
                    /// instantiate the Model for this Controller, passing
                    /// in the User object to initialize the UserModel fields.
                    this.userModel = new UserModel(user);  // create Model with User

                    /// get data from the UserModel and populate the
                    /// UI TextField controls.
                    /// (It may seem that it would be easier to just use data from the User object,
                    /// but we want to use the UserModel as the central 'source of truth' where
                    /// the user data for this view is represented and updated)
                    user_id.setText(String.valueOf(userModel.getId()));
                    first_name.setText(userModel.getFirstName());
                    last_name.setText(userModel.getLastName());
                    username.setText(userModel.getUsername());
                    password.setText(userModel.getPassword());
                }
            } catch (DaoException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void onClearAllButtonClick() {
            username_inputted.clear();
            password_inputted.clear();
            user_id.clear();
            first_name.clear();
            last_name.clear();
            username.clear();
            password.clear();
            messageLabel.setText("User details have been cleared.");
    }
}
