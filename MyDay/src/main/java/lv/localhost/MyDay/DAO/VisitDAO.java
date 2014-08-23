package lv.localhost.MyDay.DAO;

import lv.localhost.MyDay.Model.Visit;
import lv.localhost.MyDay.common.DBException;

public interface VisitDAO {
	
	/**
	 * This method will attempt to insert a Visit into the database.   
	 * The method will throw an DBException if errors during execution are encountered 
	 * 
	 * @param Visit object to insert into database
	 * @return true if visit inserted successfully
	 */
	
	boolean createVisit(Visit v) throws DBException;
	
}
