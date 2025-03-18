DROP TABLE IF EXISTS `tblproject`;

CREATE TABLE `tblproject` (
  `PR_ProjectId` int(11) NOT NULL,
  `PR_CustomerId` int(11) DEFAULT NULL,
  `projectUuid` binary(255) DEFAULT NULL,
  PRIMARY KEY (`PR_ProjectId`),
  UNIQUE KEY  (`PR_CustomerId`)
)