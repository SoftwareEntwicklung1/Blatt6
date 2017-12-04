
import java.util.ArrayList;
import java.util.Arrays;

public class Spreadsheet {
	int[][] a;
	int columns, rows, scellnumer;
	ArrayList<int[]> sumcells;

	Spreadsheet(int columns, int rows) {
		this.columns = columns;
		this.rows = rows;
		this.a = new int[rows][columns];
		this.scellnumer = 0;
		this.sumcells = new ArrayList<int[]>();

	}

	void set(int column, int row, int value) {
		this.a[row-1][column-1] = value;
		int cellnumber = this.scellnumer = scellnumer;
		int size = this.sumcells.size();
		int[] e = new int[0];
		if (cellnumber > 0) {
			//System.out.println(size);
			for (int i = 0; i <= size - 1; i++) {
				e = this.sumcells.get(i);
				//System.out.println(Arrays.toString(e));
				if (e[3] <= row && e[5] >= row && e[2] <= column && column <= e[4]) {
					this.setSumCalculation(e[0], e[1], e[2], e[3], e[4], e[5]);
				}
			}
		}

	}

	int get(int column, int row) {
		// System.out.println(this.a[row][column]);
		return this.a[row-1][column-1];
	}

	void setSumCalculation(int resultColumn, int resultRow, int startColumn, int startRow, int endColumn, int endRow) {
		int sum = 0;

		for (int i = startRow; i <= endRow; i++) {
			for (int j = startColumn; j <= endColumn; j++) {
				sum = sum + get(j, i);
			}
		}
		 this.set(resultColumn, resultRow, sum);
	//	this.a[resultRow-1][resultColumn-1] = sum;
		this.scellnumer = this.scellnumer + 1;
		int[] cellvalues = new int[6];
		cellvalues[0] = resultColumn;
		cellvalues[1] = resultRow;
		cellvalues[2] = startColumn;
		cellvalues[3] = startRow;
		cellvalues[4] = endColumn;
		cellvalues[5] = endRow;
		// System.out.println(this.scellnumer);
		add(cellvalues);

	//	System.out.println(this.sumcells.size());
		// for(int i = 0; i <= this.sumcells.size()-1; i++) {
		// System.out.print(Arrays.toString(this.sumcells.get(i)));
		// }

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