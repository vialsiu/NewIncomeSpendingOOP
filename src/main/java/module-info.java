module org.example.oopjavafxuserdetailsdao {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.oopjavafxuserdetailsdao.GUI to javafx.fxml;
    opens org.example.oopjavafxuserdetailsdao to javafx.fxml;

    exports org.example.oopjavafxuserdetailsdao;
    exports org.example.oopjavafxuserdetailsdao.GUI;
}
