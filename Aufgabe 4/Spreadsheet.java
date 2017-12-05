
import java.util.ArrayList;
import java.util.Arrays;

public class Spreadsheet {
	int[][] a;
	int columns, rows, scellnumer;
	//sumcells is an arraylist that contains all sumcells with their range
	ArrayList<int[]> sumcells;

	Spreadsheet(int columns, int rows) {
		this.columns = columns;
		this.rows = rows;
		this.a = new int[rows][columns];
		this.sumcells = new ArrayList<int[]>();
	}

	/*
	   requiers column>0 &&row>0 
	   modifies this.a[row-1][column-1] 
	   ensures this.a[row-1][column-1]=value;
	           for all sumcells if this.a[row-1][column-1]
	           between range of a sumcell
	           this.sumcell=sumoldvalue-oldvalue+value;
	 */
	void set(int column, int row, int value) {
		int oldvalue, sumoldvalue;
		oldvalue = this.get(column, row);
		this.a[row - 1][column - 1] = value;
		int size = this.sumcells.size();
		int[] e = new int[0];
		for (int i = 0; i <= size - 1; i++) {
			e = this.sumcells.get(i);
			if (e[3] <= row && e[5] >= row && e[2] <= column && column <= e[4]) {
				sumoldvalue = this.get(e[0], e[1]);
				this.set(e[0], e[1], sumoldvalue - oldvalue + value);
			}
		}
	}

	int get(int column, int row) {
		return this.a[row - 1][column - 1];
	}

	void setSumCalculation(int resultColumn, int resultRow, int startColumn, int startRow, int endColumn, int endRow) {
		int sum = 0;
		for (int i = startRow; i <= endRow; i++) {
			for (int j = startColumn; j <= endColumn; j++) {
				sum = sum + get(j, i);
			}
		}
		this.set(resultColumn, resultRow, sum);
		//add sum cell into arraylist
		int[] cellvalues = new int[6];
		cellvalues[0] = resultColumn;
		cellvalues[1] = resultRow;
		cellvalues[2] = startColumn;
		cellvalues[3] = startRow;
		cellvalues[4] = endColumn;
		cellvalues[5] = endRow;
		add(cellvalues);

	}

	// Fuegt einen Eintrag am Ende der Liste hinzu
	void add(int[] e) {
		this.sumcells.add(e);
	}

	// Entfernt den Eintrag an Position i
	void remove(int i) {
		this.sumcells.remove(i);
	}
}