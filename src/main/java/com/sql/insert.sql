INSERT INTO Member(mno, mnickname, maccount, mpassword, memail, mphone) 
    VALUES ('01', 'John', 'A01', '1234', 'John@com', '0920123456');
INSERT INTO Member(mno, mnickname, maccount, mpassword, memail, mphone) 
    VALUES ('02', 'Mary', 'A02', '1234', 'Mary@com', '0921111111');
INSERT INTO Member(mno, mnickname, maccount, mpassword, memail, mphone) 
    VALUES ('03', 'Helen', 'A03', '1234', 'Helen@com', '0922222222');
INSERT INTO Member(mno, mnickname, maccount, mpassword, memail, mphone) 
    VALUES ('04', 'Jo', 'A04', '1234', 'Jo@com', '0923333333');
INSERT INTO Member(mno, mnickname, maccount, mpassword, memail, mphone) 
    VALUES ('05', 'Admin', 'A05', '1234', 'admin@com', '0924444444');

INSERT INTO MemberAttr(aname) VALUE('B2C');
INSERT INTO MemberAttr(aname) VALUE('B2B');
INSERT INTO MemberAttr(aname) VALUE('C2C');

INSERT INTO MemberAttrRef(mid, aid) VALUE(1, 1);
INSERT INTO MemberAttrRef(mid, aid) VALUE(1, 2);
INSERT INTO MemberAttrRef(mid, aid) VALUE(2, 1);
INSERT INTO MemberAttrRef(mid, aid) VALUE(2, 3);
INSERT INTO MemberAttrRef(mid, aid) VALUE(3, 1);
INSERT INTO MemberAttrRef(mid, aid) VALUE(4, 1);
INSERT INTO MemberAttrRef(mid, aid) VALUE(5, 1);
INSERT INTO MemberAttrRef(mid, aid) VALUE(5, 2);
INSERT INTO MemberAttrRef(mid, aid) VALUE(5, 3);
