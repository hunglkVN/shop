package com.vn.ShopService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "EFILE_2")
public class Efile implements Cloneable {
    @Id
    @Column(name = "ID", nullable = false, length = 100)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "PROCEDURE_ID", length = 100)
    private Long procedureId;

    @Column(name = "TITLE", length = 250)
    private String title;

    @Column(name = "CODE", length = 100)
    private String code;

    @Column(name = "PROCEDURE_CODE")
    private String procedureCode;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "STATUS_ID")
    private Long statusId;

    @Column(name = "STATUS_NAME")
    private String statusName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SEND_TIME")
    private Date sendTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RECEIPT_TIME")
    private Date receiptTime;

    @Column(name = "IS_ACTIVE")
    private Long isActive;

    @Column(name = "IS_DELETE")
    private Long isDelete;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "USER_CREATE_ID")
    private Long userCreateId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "USER_UPDATE_ID")
    private Long userUpdateId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RELEASE_TIME")
    private Date releaseTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FINISH_TIME")
    private Date finishTime;

    @Column(name = "SUB_STATUS_ID")
    private Long subStatusId;

    @Column(name = "SUB_STATUS_NAME")
    private String subStatusName;

    @Column(name = "DEPT_ID")
    private Long deptId;

    @Column(name = "DEPT_NAME")
    private String deptName;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "REF_NAME")
    private String refName;

    @Column(name = "REF_PHONE")
    private String refPhone;

    @Column(name = "REF_POSITION")
    private String refPosition;

    @Column(name = "CONTACT_NAME")
    private String contactName;

    @Column(name = "CONTACT_PHONE")
    private String contactPhone;

    @Column(name = "CONTACT_EMAIL")
    private String contactEmail;

    @Column(name = "CONTACT_POSITION")
    private String contactPosition;

    @Column(name = "TYPE_CERTIFICATE_ID")
    private Long typeCertificateId;

    @Column(name = "CERTIFICATE_DATE_PROPOSE")
    private Date certificateDatePropose;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DEADLINE_DAY")
    private Date deadlineDay;

    @Column(name = "CUSTOMER_NUMBER")
    private String customerNumber;

    @Column(name = "REGISTER_NUMBER")
    private String registerNumber;

    @Column(name = "CERTIFICATE_NUMBER")
    private String certificateNumber;

    @Column(name = "CONSIDER_STATUS")
    private Long considerStatus;

    @Column(name = "EFILE_REF")
    private String efileRef;

    @Column(name = "CERTIFICATE_STANDARD")
    private Long certificateStandard;

    @Column(name = "CERTIFICATE_ENTERPRISE")
    private Long certificateEnterprise;

    @Column(name = "NUM_OF_EMPLOYEES")
    private Long numOfEmployees;

    @Column(name = "IN_SHIFTS")
    private Long inShifts;

    @Column(name = "NUM_OF_EMPLOYEES_MAIN")
    private Long numOfEmployeeMain;

    @Column(name = "NUM_OF_EMPLOYEES_REGISTER")
    private Long numOfEmployeesRegister;

    @Column(name = "ORTHER_CERTIFICATION_SYS")
    private String ortherCertificationSys;

    @Column(name = "CONTRACT_NUMBER")
    private String contractNumber;

    @Column(name = "CONTRACT_DATE")
    private Date contractDate;

    @Column(name = "BILL_NUMBER")
    private String billNumber;

    @Column(name = "BILL_DATE")
    private Date billDate;

    @Column(name = "BILL_OF_LADING_NUM")
    private String billOfLadingNum;

    @Column(name = "BILL_OF_LADING_DATE")
    private Date billOfLadingDate;

    @Column(name = "RESULT_MAINTAIN")
    private Long  resultMaintain;

    @Column(name = "CONTENT_MAINTAIN")
    private String contentMaintain;

    @Column(name = "RESULT_KHD")
    private Long resultKhd;

    @Column(name = "EFILE_CONTRACT_REF")
    private String efileContractRef;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}


