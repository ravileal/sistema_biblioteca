package br.com.ufc.aps.biblioteca.conexao;
import java.util.ArrayList;

public class Table {
	ArrayList<Row> listRows = null;

	public Table() {
		listRows = new ArrayList<>();
	}
	
	public Table(ArrayList<Row> listRows) {
		this.listRows = listRows;
	}
	
	public void setListRow(ArrayList<Row> row) {
		this.listRows = row;
	}
	
	public void addRow(Row row) {
		listRows.add(row);
	}
	
	public ArrayList<Row> getRepositorioRow() {
		return listRows;
	}
	
	public Row getFirstRow() {
		return listRows.get(0);
	}
	
	public Row getRow(int i) {
		return listRows.get(i);
	}
	
	public void remove(int i) {
		listRows.remove(i);
	}
	
	public void remove(Row row) {
		listRows.remove(row);
	}
	
	@Override
	public String toString() {
		if(listRows == null)
			return "";
		
		String res = "";
		
		for (Row row : listRows) 
			res += row.toString();
		
		return res;
	}
}
