DROP TABLE IF EXISTS `tblcustomer`;

CREATE TABLE `tblcustomer` (
  `CR_CustomerId` int(11) NOT NULL,
  `customerUuid` binary(255) DEFAULT NULL,
  `CR_Email` varchar(255) NOT NULL,
  `CR_FirstName` varchar(255) NOT NULL,
  `CR_LastName` varchar(255) NOT NULL,
  `CR_Mobile` varchar(255) NOT NULL,
  `CR_ProjectInfo` int(11) DEFAULT NULL,
  PRIMARY KEY (`CR_CustomerId`),
  FOREIGN KEY (`CR_ProjectInfo`) REFERENCES `tblproject` (`PR_CustomerId`)
)