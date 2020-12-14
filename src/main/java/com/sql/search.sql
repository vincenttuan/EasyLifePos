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

-- B2B, B2C, C2C 的會員數量各有(Part I) ?
SELECT 'B2B' as ATTR, count(m.maccount) as 'COUNT'
FROM Member m, MemberAttr a, MemberAttrRef r
WHERE m.mid = r.mid AND a.aid = r.aid AND a.aname = 'B2B'
UNION ALL
SELECT 'B2C' as ATTR, count(m.maccount) as 'COUNT'
FROM Member m, MemberAttr a, MemberAttrRef r
WHERE m.mid = r.mid AND a.aid = r.aid AND a.aname = 'B2C'
UNION ALL
SELECT 'C2C' as ATTR, count(m.maccount) as 'COUNT'
FROM Member m, MemberAttr a, MemberAttrRef r
WHERE m.mid = r.mid AND a.aid = r.aid AND a.aname = 'C2C';

-- B2B, B2C, C2C 的會員數量各有(Part II) ?
SELECT a.aname, count(m.maccount) as 'COUNT'
FROM Member m, MemberAttr a, MemberAttrRef r
WHERE m.mid = r.mid AND a.aid = r.aid
GROUP BY a.aname;

-- B2B, B2C, C2C 哪一個會員數量最多
SELECT a.aname, count(m.maccount) as 'COUNT'
FROM Member m, MemberAttr a, MemberAttrRef r
WHERE m.mid = r.mid AND a.aid = r.aid
GROUP BY a.aname
ORDER BY COUNT DESC limit 1;
