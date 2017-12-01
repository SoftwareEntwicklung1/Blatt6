
public class StringProcs {
    
    
    public static String extension(String Name){
         char [] a=Name.toCharArray();
         int k=0;
         for(int i=0;i<a.length;i++){
             if(a[i]=='.'){
                  k=i;
                  break;
                 
             }
             else{
                 return "";
             }
         }
         char[] b=new char[a.length-k];
         for (int i=0;i<b.length-1;i++){
             k++;
             b[i]=a[k];
             
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
    
    public static int letterCount(String Name){
        char [] a=Name.toCharArray();
        int s=0;
        for(int i=0;i<a.length;i++){
            if(Character.isLetter(a[i])){
              s++;
            }
        }
        return s;

    }
    public static int wordCount(String Name){
        char [] a=Name.toCharArray();
        int s=0;
        for(int i=0;i<a.length-1;i++){
            if(Character.isLetter(a[i])&&!Character.isLetter(a[i+1])){
              s++;
            }
        }
        if(Character.isLetter(a[a.length-1])){
            s++;
        }
        return s;

    }
    }