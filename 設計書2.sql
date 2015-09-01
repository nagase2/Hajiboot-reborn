CREATE TABLE Role (
 roleId CHAR(10) NOT NULL PRIMARY KEY,
 roleName CHAR(10),
 deleteflag BIT(1),
 updatedDate DATE,
 createdDate DATE,
 createdUser bigint,
 updatedUser bigint
);


CREATE TABLE RoleGroup (
 roleGroupId CHAR(10) NOT NULL PRIMARY KEY,
 roleGroupName CHAR(10),
 deleteflag BIT(1),
 updatedDate DATE,
 createdDate DATE,
 createdUser bigint,
 updatedUser bigint
);


CREATE TABLE RoleGroupRole (
 roleGroupRoleId CHAR(10) NOT NULL PRIMARY KEY,
 roleGroupId CHAR(10),
 roleId CHAR(10),
 deleteflag BIT(1),
 updatedDate DATE,
 createdDate DATE,
 createdUser bigint,
 updatedUser bigint
);


CREATE TABLE UserAccount (
 id NUMERIC(10) NOT NULL PRIMARY KEY,
 loginId VARCHAR(100),
 password VARCHAR(100),
 address VARCHAR(500),
 age INT,
 sirName CHAR(10),
 familyName CHAR(10),
 deleteFlag BIT(1),
 updatedDate DATE,
 createdDate DATE,
 createdUser bigint,
 updatedUser bigint
);


CREATE TABLE UserRoleGroup (
 userRoleGroupId CHAR(10) NOT NULL PRIMARY KEY,
 userId CHAR(10),
 roleGroupId CHAR(10),
 deleteflag BIT(1),
 updatedDate DATE,
 createdDate DATE,
 createdUser bigint,
 updatedUser bigint
);


