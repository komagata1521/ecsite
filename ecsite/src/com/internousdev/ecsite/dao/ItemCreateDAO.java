package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateDAO {

	public int AddItem(String itemNane, String itemPrice, String itemStock) {
		DBConnector db = new DBConnector();
		DateUtil date = new DateUtil();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "INSERT INTO item_info_transaction(item_name, item_price, item_stock, insert_date, update_date) "
					+"VALUES(?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itemNane);
			ps.setString(2, itemPrice);
			ps.setString(3, itemStock);
			ps.setString(4, date.getDate());
			ps.setString(5, date.getDate());

			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
