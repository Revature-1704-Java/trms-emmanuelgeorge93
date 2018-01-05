package com.Revature.TRMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.TRMS.ConnectionUtil;
import com.Revature.TRMS.impl.Reimbursement;

public class ReimbursementDao {

	// get a list of all Reimbursement forms
	public List<Reimbursement> getALLReimbursement() {
		PreparedStatement ps = null;
		Reimbursement reimForm = null;
		List<Reimbursement> reimList = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reimbursement ORDER BY EID ASC";
			ps = conn.prepareStatement(sql);
			// Add any variables to PS
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int rid = rs.getInt("rID");
				int eid = rs.getInt("eID");
				int eventid = rs.getInt("eventID");
				int ereason = rs.getInt("eREASON");
				String eventdate = rs.getString("eventDATE");
				int gid = rs.getInt("gID");
				String egrade = rs.getString("eGRADE");
				String esubmit = rs.getString("eSUBMIT");
				double excdamount = rs.getDouble("excdAMOUNT");
				int excdreason = rs.getInt("excdREASON");
				double ramount = rs.getDouble("rAMOUNT");
				int eventdesc = rs.getInt("eventDESC");
				int rdreason = rs.getInt("rDREASON");
				int departStatus = rs.getInt("departmentStatus");
				int superStatus = rs.getInt("superStatus");
				int bencoStatus = rs.getInt("bencoStatus");

				reimForm = new Reimbursement(rid, eid, eventid, ereason, eventdate, gid, egrade, esubmit, excdamount, excdreason,
						ramount, eventdesc, rdreason, departStatus, superStatus, bencoStatus);
				reimList.add(reimForm);
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}

		return reimList;
	}// end of get all reimbursement forms

	// get a list of all Reimbursement forms for a given id
	// used for when an employee logs in, when a department head, supervisor or
	// benco inspect an employee
	// can see all reimbursements associated with specific employee
	public List<Reimbursement> getALLforOneReimbursement(int id) {
		PreparedStatement ps = null;
		Reimbursement reimForm = null;
		List<Reimbursement> reimList = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reimbursement WHERE EID = ? ORDER BY EID ASC";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int rid = rs.getInt("rID");
				int eid = rs.getInt("eID");
				int eventid = rs.getInt("eventID");
				int ereason = rs.getInt("eREASON");
				String eventdate = rs.getString("eventDATE");
				int gid = rs.getInt("gID");
				String egrade = rs.getString("eGRADE");
				String esubmit = rs.getString("eSUBMIT");
				double excdamount = rs.getDouble("excdAMOUNT");
				int excdreason = rs.getInt("excdREASON");
				double ramount = rs.getDouble("rAMOUNT");
				int eventdesc = rs.getInt("eventDESC");
				int rdreason = rs.getInt("rDREASON");
				int departStatus = rs.getInt("departmentStatus");
				int superStatus = rs.getInt("superStatus");
				int bencoStatus = rs.getInt("bencoStatus");

				reimForm = new Reimbursement(rid, eid, eventid, ereason, eventdate, gid, egrade, esubmit, excdamount, excdreason,
						ramount, eventdesc, rdreason, departStatus, superStatus, bencoStatus);
				reimList.add(reimForm);
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}

		return reimList;
	}// end of getALLforOneReimbursement

	// get a single reimbursement form
	// used when inspecting a single reimbursement in details page
	public Reimbursement getReimbursement(int id) {
		PreparedStatement ps = null;
		Reimbursement reimForm = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE RID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int rid = rs.getInt("rID");
				int eid = rs.getInt("eID");
				int eventid = rs.getInt("eventID");
				int ereason = rs.getInt("eREASON");
				String eventdate = rs.getString("eventDATE");
				int gid = rs.getInt("gID");
				String egrade = rs.getString("eGRADE");
				String esubmit = rs.getString("eSUBMIT");
				double excdamount = rs.getDouble("excdAMOUNT");
				int excdreason = rs.getInt("excdREASON");
				double ramount = rs.getDouble("rAMOUNT");
				int eventdesc = rs.getInt("eventDESC");
				int rdreason = rs.getInt("rDREASON");
				int departStatus = rs.getInt("departmentStatus");
				int superStatus = rs.getInt("superStatus");
				int bencoStatus = rs.getInt("bencoStatus");

				reimForm = new Reimbursement(rid, eid, eventid, ereason, eventdate, gid, egrade, esubmit, excdamount, excdreason,
						ramount, eventdesc, rdreason, departStatus, superStatus, bencoStatus);
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}

		return reimForm;
	}// end of get reimbursement

	// add a reimbursement
	// note departmentStatus, superStatus and bencoStatus are all set to specific
	// values
	// departmentStatus and superStatus are set to 1 to mimic pre-approval, they
	// only have to deny
	// bencoStatus is set to deny, benco has do work so he must do that before he
	// approves or at least look at the reimbursement before approving
	public void addReimbursement(int eid, int eventid, int ereason, String eventdate, int gid, int egrade,
			double ramount, int eventdesc) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO REIMBURSEMENT (eID, eventID, eREASON, eventDATE, gID, eGRADE, rAMOUNT, eventDESC, departmentStatus, superStatus, bencoStatus) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			ps.setInt(2, eventid);
			ps.setInt(3, ereason);
			ps.setString(4, eventdate);
			ps.setInt(5, gid);
			ps.setInt(6, egrade);
			ps.setDouble(7, ramount);
			ps.setInt(8, eventdesc);
			ps.setInt(9, 1);
			ps.setInt(10, 1);
			ps.setInt(11, 0);

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
	} // end of addReimbursement

	// delete a specific reimbursement
	public void deleteReimbursement(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM REIMBURSEMENT WHERE RID = ?";
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
	} // end of deleteReimbursement

	// update a Reimbursement
	// this updates the entire reimbursement except for the rid which it searches by
	// this could be used by leads to correct mistakes on form and by employee to do
	// the same thing
	// may implement alternate version so employee cannot change eid, gid(not sure),
	// eventid(not sure), excdamount, excdreason, ramount(not sure), rdreason, and
	// statuses for leads
	// concerns with this method provides a way for employee to manip the
	// reimbursement system by changing values like approval statuses, or amounts
	// for reimbursements
	// being able to change grade formats or grade itself may be harmful to
	// integrety of reimbursement as well,
	// being able to change eid could be problematic with it we have to worry about
	// mistaken id and malicous abuse
	// without it employee would not beable to fix error in input
	//
	// FFI: set statues to deny so when a reimbursement is updated it must be
	// re-approved by all leads
	// create second update with restricted input
	public void updateReimbursement(int rid, int eid, int eventid, int ereason, String eventdate, int gid,
			String egrade, double excdamount, int excdreason, double ramount, int eventdesc, int rdreason,
			int departmentStatus, int superStatus, int bencoStatus) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE REIMBURSEMENT SET EID = ?, EVENTID = ?, EREASON = ?, EVENTDATE = ?, GID = ?, EGRADE = ?, EXCDAMOUNT = ?, EXCDREASON = ?, RAMOUNT = ?, EVENTDESC = ?, RDREASON = ?, DEPARTMENTSTATUS = ?, SUPERSTATUS = ?, BENCOSTATUS = ? WHERE RID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			ps.setInt(2, eventid);
			ps.setInt(3, ereason);
			ps.setString(4, eventdate);
			ps.setInt(5, gid);
			ps.setString(6, egrade);
			ps.setDouble(7, excdamount);
			ps.setInt(8, excdreason);
			ps.setDouble(9, ramount);
			ps.setInt(10, eventdesc);
			ps.setInt(11, rdreason);
			ps.setInt(12, departmentStatus);
			ps.setInt(13, superStatus);
			ps.setInt(14, bencoStatus);
			ps.setInt(15, rid);

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
	} // end of updateReimbursement

	// update a Reimbursement status FOR department head on specific reimbursement
	public void departmentStatus(int rid, int bflag) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE REIMBURSEMENT SET DEPARTMENTSTATUS = ? WHERE RID = ?";
			ps = conn.prepareStatement(sql);
			if (bflag == 1) {
				ps.setInt(1, 1);
			} else {
				ps.setInt(1, 0);
			}

			ps.setInt(2, rid);

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
	} // end of departmentStatus

	// update a Reimbursement status FOR super by specific reimbursement
	public void superStatus(int rid, int bflag) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE REIMBURSEMENT SET SUPERSTATUS = ? WHERE RID = ?";
			ps = conn.prepareStatement(sql);
			if (bflag == 1) {
				ps.setInt(1, 1);
			} else {
				ps.setInt(1, 0);
			}

			ps.setInt(2, rid);

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
	} // end of superStatus

	// update a Reimbursement status FOR benco search for spefic reimbursment
	public void bencoStatus(int rid, int bflag) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE REIMBURSEMENT SET BENCOSTATUS = ? WHERE RID = ?";
			ps = conn.prepareStatement(sql);
			if (bflag == 1) {
				ps.setInt(1, 1);
			} else {
				ps.setInt(1, 0);
			}

			ps.setInt(2, rid);

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
	} // end of bencoStatus

	// get a single reimbursement form's amount of coverage from event table
	// reimbursments event id is used to search event table for an events coverage
	public double getCoverage(int id) {
		PreparedStatement ps = null;
		double coverage = 0;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT rCOVERAGE FROM EVENT WHERE EVENTID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				coverage = rs.getDouble("rCOVERAGE");

			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}

		return coverage;
	}// end of get getCoverage

}// end of Dao
