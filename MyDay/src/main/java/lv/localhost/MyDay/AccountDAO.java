package lv.localhost.MyDay;

public interface AccountDAO {

	String getByName(String name) throws DBException;
}
