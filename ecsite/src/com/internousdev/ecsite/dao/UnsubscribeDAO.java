package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UnsubscribeDTO;
import com.internousdev.ecsite.util.DBConnector;;

public class UnsubscribeDAO {

	public int deleteUserInfo(String loginUserId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int deleteCount = 0;
		String sql = "DELETE FROM login_user_transaction WHERE login_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);

			deleteCount = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteCount;
	}

	public ArrayList<UnsubscribeDTO> infoDeleteConfirm(String loginId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<UnsubscribeDTO> unsubscribeDTO = new ArrayList<UnsubscribeDTO>();

		String sql = "SELECT * FROM user_buy_item_transaction WHERE user_master_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				UnsubscribeDTO dto = new UnsubscribeDTO();
				dto.setId(rs.getString("id"));
				dto.setItemTransactionId(rs.getString("item_transaction_id"));
				dto.setUserMasterId(rs.getString("user_master_id"));
				dto.setInsertDate(rs.getString("insert_date"));
				unsubscribeDTO.add(dto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return unsubscribeDTO;
		}
}
