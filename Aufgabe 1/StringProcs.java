
public class StringProcs {
	public static String extension(String f) {
		int punktpos;
		punktpos = f.lastIndexOf(".");
		if (punktpos == -1) {
			return "";
		}
		return f.substring(punktpos + 1, f.length());
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
