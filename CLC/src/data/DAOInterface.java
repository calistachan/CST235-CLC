package data;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<I> {
	
	public void createItem(I item) throws SQLException;
	
	public I readItem(int id) throws SQLException;
	
	public List<I> readList() throws SQLException;
	
	public void updateItem(I item) throws SQLException;
	
	public void deleteItem(int id) throws SQLException;
}
