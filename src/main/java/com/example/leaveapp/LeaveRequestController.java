package com.example.leaveapp;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class LeaveRequestController {
        @FXML
        private TableView<Leave> Leavetbl;

        @FXML
        private TableColumn<Leave, String> colReason;

        @FXML
        private TableColumn<Leave, String> colEmpID;


        @FXML
        private TableColumn<Leave, Integer> colID;

        @FXML
        private TableColumn<Leave, String> colLeaveStatus;


        @FXML
        private TableColumn<Leave, String> colLeaveType;

        @FXML
        private TableColumn<Leave, String> colStartDate;

        @FXML
        private TableColumn<Leave, String> colEndDate;
        @FXML
        private Button btnApprove;

        @FXML
        private Button btnReject;

        @FXML
        private Button btnReport;

        @FXML
        private Button btnSubmit;
        @FXML
        private TextField txtEmpID;

        @FXML
        private TextField txtEndDate;

        @FXML
        private TextField txtLeaveType;

        @FXML
        private TextField txtStartDate;

        @FXML
        private TextField txtReason;


        ObservableList<Leave> leaverequests = FXCollections.observableArrayList();
        @FXML
        private URL location;
        Connection c;
        PreparedStatement pst;

        public Connection Connect() {
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Leave", "root", "");

                        System.out.println("Connection succeed");
                } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                        System.out.println("Connection failed");
                }return null;
        }


                         @FXML
                        void OnActionGenerateReport(ActionEvent event) {
                        Task<Void> task = new Task<Void>() {
                                @Override
                                protected Void call() throws Exception {
                                        HashMap parameters = new HashMap();
                                        JasperPrint jp = JasperFillManager.fillReport("LeaveRequestReport.jasper",parameters,JDBConnector.getConnection());
                                        JasperViewer viewer = new JasperViewer(jp,false);
                                        viewer.setVisible(true);
                                        return null;
                                }
                        };
                        ExecutorService service = Executors.newCachedThreadPool();
                        service.execute(task);
                        service.shutdown();
                }


@FXML
ObservableList<Leave> leaves = FXCollections.observableArrayList();
        public void initialize() {
                Connect();
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
                        colLeaveType.setCellValueFactory(new PropertyValueFactory<>("leaveType"));
                        colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
                        colEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
                        colReason.setCellValueFactory(new PropertyValueFactory<>("reason"));
                        colEmpID.setCellValueFactory(new PropertyValueFactory<>("empID"));
                        colLeaveStatus.setCellValueFactory(new PropertyValueFactory<>("leaveStatus"));



                        Leavetbl.setItems(leaves );



                } catch (SQLException ex) {
                        Logger.getLogger(LeaveRequestController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        public void Refresh(){
                leaves.clear();
                loadData();
        }
        @FXML
        void handleMouseAction(MouseEvent event){
                Leave leavet = Leavetbl.getSelectionModel().getSelectedItem();

                txtEmpID.setText(String.valueOf(leavet.getEmpID()));
                txtLeaveType.setText(leavet.getLeaveType());
                txtStartDate.setText(leavet.getStartDate());
                txtEndDate.setText(leavet.getEndDate());
                txtReason.setText(leavet.getReason());

        }

        @FXML
        void SaveButtonAction(ActionEvent event) {
                try{
                        Connect();
                        String value1 = txtEmpID.getText();
                        String value2= "Approved";


                        String sql = "update leavetbl set LeaveStatus ='" + value2 + "' where EmpID='" + value1 + "'" ;

                        pst = (PreparedStatement) c.prepareStatement(sql);
                        int a = pst.executeUpdate();
                        if (a == 1) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Success");
                                alert.setHeaderText("Leave Details");
                                alert.setContentText("Leave Details Updated Successfully");
                                alert.showAndWait();

                        } Refresh();

                } catch (Exception e) {
                        e.printStackTrace();
                }

        }
        @FXML
        void RejectButtonAction(ActionEvent event){
                try {
                        Connect();
                        String value1 = txtEmpID.getText();
                        String value2= "Rejected";


                        String sql = "update leavetbl set LeaveStatus ='" + value2 + "' where EmpID='" + value1 + "'" ;

                        pst = (PreparedStatement) c.prepareStatement(sql);
                        int a = pst.executeUpdate();
                        if (a == 1) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Success");
                                alert.setHeaderText("Leave Details");
                                alert.setContentText("Leave Details Updated Successfully");
                                alert.showAndWait();

                        }   Refresh();

                } catch (Exception e) {
                        e.printStackTrace();
                }

        }
        }










