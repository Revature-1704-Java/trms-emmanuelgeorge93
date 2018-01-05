package com.Revature.TRMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.TRMS.ConnectionUtil;
import com.Revature.TRMS.impl.Employee;

public class EmployeeDao {

	// Returns a list of all employees in table
	public List<Employee> getALLEmployee() {
		PreparedStatement ps = null;
		Employee dude = null;
		List<Employee> dudes = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE ORDER BY EID ASC";
			ps = conn.prepareStatement(sql);
			// Add any variables to PS
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int eid = rs.getInt("eID");
				String fname = rs.getString("Firstname");
				String lname = rs.getString("Lastname");
				String passwrd = rs.getString("passwrd");
				int superID = rs.getInt("superID");
				int dID = rs.getInt("dID");
				int bncoid = rs.getInt("bncoID");
				int eTYPE = rs.getInt("eTYPE");
				double amnt = rs.getDouble("amount");

				dude = new Employee(eid, fname, lname, passwrd, superID, dID, bncoid, eTYPE, amnt);
				dudes.add(dude);
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}

		return dudes;
	}// end of get all employees

	// Return a single employee using id and password
	// Mostly used for loging in as an employee
	public Employee getEmployee(int id, String pswrd) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee dude = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE Eid = ? and Passwrd = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, pswrd);

			rs = ps.executeQuery();
			while (rs.next()) {
				int eid = rs.getInt("eID");
				String fname = rs.getString("Firstname");
				String lname = rs.getString("Lastname");
				String passwrd = rs.getString("passwrd");
				int superID = rs.getInt("superID");
				int dID = rs.getInt("dID");
				int bncoid = rs.getInt("bncoID");
				int eTYPE = rs.getInt("eTYPE");
				double amnt = rs.getDouble("amount");

				dude = new Employee(eid, fname, lname, passwrd, superID, dID, bncoid, eTYPE, amnt);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dude;
	} // end of getEmployee/login

	// add an employee to table
	public void addEmployee(String first, String last, String pswrd, int sid, int did, int bncoid, int etyp,
			double amnt) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO EMPLOYEE (firstNAME, lastNAME, passwrd, superID, dID, bncoID, eTYPE, amount) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, first);
			ps.setString(2, last);
			ps.setString(3, pswrd);
			ps.setInt(4, sid);
			ps.setInt(5, did);
			ps.setInt(6, bncoid);
			ps.setInt(7, etyp);
			ps.setDouble(8, amnt);

			rs = ps.executeQuery();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	} // end of addEmployee

	// delete a specific employee
	public void deleteEmployee(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM EMPLOYEE WHERE EID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	} // end of deleteEmployee

	// update an employee with a specific Employeeid#
	// updates all fields except eid
	public void updateEmployee(String first, String last, String pswrd, int sid, int did, int bncoid, int etyp,
			double amnt, int eid) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE EMPLOYEE SET FIRSTNAME = ?, LASTNAME = ?, PASSWRD = ?, SUPERID = ?, DID = ?, BNCOID = ?, ETYPE = ?, AMOUNT = ? WHERE EID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, first);
			ps.setString(2, last);
			ps.setString(3, pswrd);
			ps.setInt(4, sid);
			ps.setInt(5, did);
			ps.setInt(6, bncoid);
			ps.setInt(7, etyp);
			ps.setDouble(8, amnt);
			ps.setInt(9, eid);

			rs = ps.executeQuery();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	} // end of updateEmployee

	// find a list of employees by did
	// used by department head to get list of all his employees
	public List<Employee> getEmployeesByDid(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee dude = null;
		List<Employee> dudes = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE did = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				int eid = rs.getInt("eID");
				String fname = rs.getString("Firstname");
				String lname = rs.getString("Lastname");
				String passwrd = rs.getString("passwrd");
				int superID = rs.getInt("superID");
				int dID = rs.getInt("dID");
				int bncoid = rs.getInt("bncoID");
				int eTYPE = rs.getInt("eTYPE");
				double amnt = rs.getDouble("amount");

				dude = new Employee(eid, fname, lname, passwrd, superID, dID, bncoid, eTYPE, amnt);
				dudes.add(dude);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dudes;
	} // end of get EmployeeByDid

	// find a list of employees by superid
	// used by supervisor to find everyone he supervises
	public List<Employee> getEmployeesBySuperid(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee dude = null;
		List<Employee> dudes = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE superid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				int eid = rs.getInt("eID");
				String fname = rs.getString("Firstname");
				String lname = rs.getString("Lastname");
				String passwrd = rs.getString("passwrd");
				int superID = rs.getInt("superID");
				int dID = rs.getInt("dID");
				int bncoid = rs.getInt("bncoID");
				int eTYPE = rs.getInt("eTYPE");
				double amnt = rs.getDouble("amount");

				dude = new Employee(eid, fname, lname, passwrd, superID, dID, bncoid, eTYPE, amnt);
				dudes.add(dude);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dudes;
	} // end of get EmployeeBysuperid

	// find a list of employees by bencoid
	// used by benco to find everyone he bencos idk what to call this
	public List<Employee> getEmployeesByBencoid(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee dude = null;
		List<Employee> dudes = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE bncoid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				int eid = rs.getInt("eID");
				String fname = rs.getString("Firstname");
				String lname = rs.getString("Lastname");
				String passwrd = rs.getString("passwrd");
				int superID = rs.getInt("superID");
				int dID = rs.getInt("dID");
				int bncoid = rs.getInt("bncoID");
				int eTYPE = rs.getInt("eTYPE");
				double amnt = rs.getDouble("amount");

				dude = new Employee(eid, fname, lname, passwrd, superID, dID, bncoid, eTYPE, amnt);
				dudes.add(dude);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dudes;
	} // end of get EmployeeBybencoid

	// an easier getemployee that does not need a password
	public Employee getEmployeeNopass(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee dude = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE Eid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				int eid = rs.getInt("eID");
				String fname = rs.getString("Firstname");
				String lname = rs.getString("Lastname");
				String passwrd = rs.getString("passwrd");
				int superID = rs.getInt("superID");
				int dID = rs.getInt("dID");
				int bncoid = rs.getInt("bncoID");
				int eTYPE = rs.getInt("eTYPE");
				double amnt = rs.getDouble("amount");

				dude = new Employee(eid, fname, lname, passwrd, superID, dID, bncoid, eTYPE, amnt);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dude;
	} // end of get EmployeeNopass
}
