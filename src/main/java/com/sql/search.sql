SELECT * FROM Member;
SELECT * FROM MemberAttr; 
SELECT * FROM MemberAttrRef; 

-- B2B 的有哪些帳號 ?
SELECT m.maccount, a.aname 
FROM Member m, MemberAttr a, MemberAttrRef r
WHERE m.mid = r.mid AND a.aid = r.aid AND a.aname = 'B2B';

-- B2B 的會員數量 ?
SELECT 'B2B' as ATTR, count(m.maccount) as 'COUNT'
FROM Member m, MemberAttr a, MemberAttrRef r
WHERE m.mid = r.mid AND a.aid = r.aid AND a.aname = 'B2B';