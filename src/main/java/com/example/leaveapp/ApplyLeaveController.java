package com.example.leaveapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplyLeaveController {
    @FXML
    private DatePicker EndDate;
    @FXML
    private ChoiceBox<String> txtLeaveType;

    private String[] Leavetype = {"Casual Leave", "Anual Leave"};

    @FXML
    private TableView<Leave> TblLeave;

    @FXML
    private TableColumn<Leave, Integer> colID;

    @FXML
    private TableColumn<Leave, String> colLeaveStatus;

    @FXML
    private TextField Reason;

    @FXML
    private TextField txtEmpID;

    @FXML
    private DatePicker StartDate;

    @FXML
    private Button Submit;

    @FXML
    public void initialize() {
        txtLeaveType.getItems().addAll(Leavetype);
        Connect();


    }


    Connection c;
    PreparedStatement pst;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Leave", "root", "");
            System.out.println("Connection succeed");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }
    }


    @FXML
    void SaveButtonAction(ActionEvent event) {
        Connect();

        String leavetype = txtLeaveType.getValue();
        LocalDate startDate = StartDate.getValue();
        LocalDate endDate = EndDate.getValue();
        String reason = Reason.getText();
        String empid = txtEmpID.getText();
        String leaveStatus = "Pending";

        try {
            pst = (PreparedStatement) c.prepareStatement("insert into leavetbl(LeaveType, StartDate, EndDate, Reason,EmpID,LeaveStatus)values (?,?,?,?,?,?)");
            pst.setString(1, leavetype);
            pst.setString(2, String.valueOf(startDate));
            pst.setString(3, String.valueOf(endDate));
            pst.setString(4, reason);
            pst.setString(5, empid);
            pst.setString(6, leaveStatus);


            int status = pst.executeUpdate();

            if (status == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Leave");
                alert.setContentText("Leave Request sent Successfully");
                alert.showAndWait();
                Refresh();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    ObservableList<Leave> leaves = FXCollections.observableArrayList();

    public void Refresh() {
        txtLeaveType.setValue("");
        StartDate.setPromptText("");
        EndDate.setPromptText("");
        Reason.setText("");
        leaves.clear();
        loadData();

    }
    private void loadData() {
        try {

            ResultSet rs = c.createStatement().executeQuery("select LeaveID , LeaveType, StartDate, Reason,EndDate, EmpID,LeaveStatus from leavetbl");
            while (rs.next()) {
                leaves.add(new Leave(rs.getInt("LeaveID"), rs.getString("LeaveType"),
                        rs.getString("StartDate"), rs.getString("EndDate"),rs.getString("Reason"),
                        rs.getString("EmpID"), rs.getString("LeaveStatus")));
            }
            colID.setCellValueFactory(new PropertyValueFactory<>("leaveID"));
            colLeaveStatus.setCellValueFactory(new PropertyValueFactory<>("leaveStatus"));



            TblLeave.setItems(leaves );



        } catch (SQLException ex) {
            Logger.getLogger(LeaveRequestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
