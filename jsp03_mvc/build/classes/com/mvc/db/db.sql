
DROP SEQUENCE MVCBOARDSEQ;
DROP TABLE MVCBOARD;

CREATE SEQUENCE MVCBOARDSEQ;
CREATE TABLE MVCBOARD(
	SEQ NUMBER PRIMARY KEY,
	WRITER VARCHAR2(1000) NOT NULL,
	TITLE VARCHAR2(2000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	REGDATE DATE NOT NULL
);
