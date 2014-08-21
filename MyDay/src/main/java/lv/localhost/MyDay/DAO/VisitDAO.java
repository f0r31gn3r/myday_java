package lv.localhost.MyDay.DAO;

import lv.localhost.MyDay.Model.Visit;
import lv.localhost.MyDay.common.DBException;

public interface VisitDAO {
	
	boolean createVisit(Visit v) throws DBException;
	
}
