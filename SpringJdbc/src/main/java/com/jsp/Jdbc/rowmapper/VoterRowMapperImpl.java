package com.jsp.Jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jsp.Jdbc.entity.Voter;

@Component
public class VoterRowMapperImpl implements RowMapper<Voter>
{
	@Override
	public Voter mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Voter vt = new Voter();
		vt.setVoter_Id(rs.getInt(1));
		vt.setVoter_Name(rs.getString(2));
		vt.setVoter_Age(rs.getInt(3));
		vt.setVoter_Address(rs.getString(4));
		vt.setVoter_Gender(rs.getString(5));
		vt.setVoter_Mobile(rs.getString(6));
		
		return vt;
	}
}
