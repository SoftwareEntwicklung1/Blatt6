package homework;

public class StringProcs {


public static String extension(String Name){
	 char [] a=Name.toCharArray();
	 int ḱ=0;
	 for(int i=0;i<a.length;i++){
		 if(a[i]=='.'){
			  ḱ=i;
			  break;
			 
		 }
		 else{
			 return "";
		 }
	 }
	 char[] b=new char[a.length-ḱ];
	 for (int i=0;i<b.length-1;i++){
		 ḱ++;
		 b[i]=a[ḱ];
		 
	 }
	 String s=new String(b);
	 return s;
 }

public static String SwitchCommaAndDot(String Name){
	char [] a=Name.toCharArray();
	for(int i=0;i<a.length;i++){
		if(a[i]=='.'){
			a[i]=',';
		}
		if(a[i]==','){
			a[i]='.';
		}	
	}
	String s=new String(a);
	return s;
}



}
