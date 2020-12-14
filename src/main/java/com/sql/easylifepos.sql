CREATE TABLE IF NOT EXISTS Member ( -- (會員資料檔)
    mid int NOT NULL AUTO_INCREMENT, -- (序號-系統會自動給定)
    mno varchar(20) NOT NULL, -- (會員編號)
    mnickname varchar(20) NOT NULL, -- (會員暱稱)
    maccount varchar(100) NOT NULL, -- (會員帳號)
    mpassword varchar(50) NOT NULL, -- (會員密碼)
    memail varchar(50) NOT NULL, -- (會員Email)
    mphone varchar(50) NOT NULL, -- (會員手機)
    createtime timestamp default current_timestamp, -- (建檔時間-系統會自動給定)
    PRIMARY KEY (mid)
);

CREATE TABLE IF NOT EXISTS MemberAttr ( -- (會員屬性資料檔)
    aid int NOT NULL AUTO_INCREMENT, -- (序號-系統會自動給定)
    aname varchar(20) NOT NULL, -- (會員屬性名稱)
    PRIMARY KEY (aid)
);

CREATE TABLE IF NOT EXISTS MemberAttrRef ( -- (會員屬性關聯資料檔)
    rid int NOT NULL AUTO_INCREMENT, -- (序號-系統會自動給定)
    mid int NOT NULL, -- (會員序號)
    aid int NOT NULL, -- (會員屬性序號)
    PRIMARY KEY (rid)
);




