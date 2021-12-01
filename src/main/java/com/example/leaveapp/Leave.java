package com.example.leaveapp;

public class Leave{
    int LeaveID;
    String LeaveType;
    String StartDate;
    String EndDate;
    String Reason;
    String EmpID;
    String LeaveStatus;


    public Leave(int leaveID, String leaveType, String startDate, String endDate, String reason, String empID, String leaveStatus) {
        this.LeaveID = leaveID;
        this.LeaveType = leaveType;
        this.StartDate = startDate;
        this.EndDate = endDate;
        this.Reason = reason;
         this.EmpID = empID;
       this.LeaveStatus = leaveStatus;
    }

    public String getLeaveStatus() {
        return LeaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        LeaveStatus = leaveStatus;
    }

    public int getLeaveID() {
        return LeaveID;
    }

    public void setLeaveID(int leaveID) {
        LeaveID = leaveID;
    }

    public String getLeaveType() {
            return LeaveType;
        }

        public void setLeaveType(String leaveType) {
            LeaveType = leaveType;
        }

        public String getStartDate() {
            return StartDate;
        }

        public void setStartDate(String startDate) {
            StartDate = startDate;
        }

        public String getEndDate() {
            return EndDate;
        }

        public void setEndDate(String endDate) {
            EndDate = endDate;
        }

        public String getReason() {
            return Reason;
        }

        public void setReason(String reason) {
            Reason = reason;
        }

        public String getEmpID() {
        return EmpID;
        }

         public void setEmpID(String empID) {
         EmpID = empID;
    }
    }

