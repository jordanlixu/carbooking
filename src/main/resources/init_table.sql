DROP TABLE IF EXISTS car;
CREATE TABLE car (
  carid varchar(50)  NOT NULL,
  model varchar(50) NOT NULL
);
INSERT INTO car VALUES ('888','BMW 650');
INSERT INTO car VALUES ('101','Toyota Camry');
INSERT INTO car VALUES ('102','Toyota Camry');
DROP TABLE IF EXISTS carbooking;
CREATE TABLE carbooking (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  phonenum varchar(50) NOT NULL,
  carid varchar(50) NOT NULL,
  starttime DATE  NOT NULL,
  endtime DATE  NOT NULL,
  deleteflag varchar(2) NOT NULL DEFAULT 'N',
  PRIMARY KEY (id)
);
INSERT INTO carbooking (phonenum, carid, starttime,endtime)
    VALUES ('13760405566', '888', parsedatetime('2020-04-05','yyyy-MM-dd'),
    parsedatetime('2020-04-07','yyyy-MM-dd'));