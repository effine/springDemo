/**
 * @author verphen
 * @date 2014年6月17日  下午4:45:55
 */

package com.verphen.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureDemo {
	Connector c = new Connector();
	Connection conn = null;

	// 带单个返回值存储过程调用
	public void handleSoleData() {
		try {
			conn = c.getConnection();
			String sql ="";
			CallableStatement call = conn.prepareCall(sql);
			// call.registerOutParameter(1, Types.INTEGER);
			call.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 带多个返回值存储过程调用
	public void handleBothData() {

		try {
			Connection conn = c.getConnection();
			CallableStatement call = conn.prepareCall("call pro_student()");
			call.execute();

			ResultSet rst = call.getResultSet();
			while (rst.next()) {
				System.out.println(rst.getInt(1) + "/t" + rst.getString(2)
						+ "/t" + rst.getInt(3) + "/t" + rst.getString(4) + "/t"
						+ rst.getDate(5) + "/t" + rst.getString(6));

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ProcedureDemo t = new ProcedureDemo();
		t.handleSoleData();
		// t.handleBothData();
	}
}
