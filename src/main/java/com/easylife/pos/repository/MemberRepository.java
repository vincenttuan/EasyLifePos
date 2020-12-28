package com.easylife.pos.repository;

import com.easylife.pos.entity.Member;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Member> queryAll() {
        String sql = "SELECT * FROM Member";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Member.class));
    }
    
    
}
