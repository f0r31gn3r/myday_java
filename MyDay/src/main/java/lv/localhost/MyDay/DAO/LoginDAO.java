package lv.localhost.MyDay.DAO;

import java.sql.Date;
import java.util.List;

import lv.localhost.MyDay.common.DBException;
import lv.localhost.MyDay.Model.Login;

public interface LoginDAO {

	public List<Login> getAllAccounts() throws DBException;
//
//	public String getUserNameByID(int id) throws DBException;
//
//	public int getIDByUsername(String username) throws DBException;
//
//	public Date getCreatedByID(int id) throws DBException;
//
//	public Date getLastVisitedByID(int id) throws DBException;
//
//	public Date getCreatedByUserName(String username) throws DBException;
//
//	public Date getLastVisitedByUserName(String username) throws DBException;
//
//	public void newAccount(Login login) throws DBException;
}
