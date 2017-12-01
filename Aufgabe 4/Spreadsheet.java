public class Spreadsheet {
 int column;
 int row;
 int [][] a;   
 Spreadsheet(int columns , int rows) {
    this.column=columns;
    this.row=rows;
    this.a=new int[column][row]; 
 }
 void set(int column , int row, int value) {
     a[column][row]=value;
 }
 int get(int column , int row){
     return a[column][row];
 }
 void setSumCalculation(int resultColumn,int resultRow,int startColumn,int startRow,int endColumn,int endRow) {
 int sum=0;
 if(endRow==0){
   for(int i=0;i<endColumn;i++){
       sum=sum+Spreadsheet.get(startColumn+i,resultRow);  
    }
    a[resultColumn+1][resultRow]=sum;
    break;

 }else{
   for(int i=0;i<endColumn;i++){
       sum=sum+Spreadsheet.get(startColumn+i,resultRow);;  
    }
    a[resultColumn+1][resultRow]=sum;
    Spreadsheet.setSumCalculation(int resultColumn,int resultRow+1,int startColumn,int startRow+1,int endColumn,int endRow-1);  
 }
 for(int i=0;i<endRow;i++){
  
 }
}