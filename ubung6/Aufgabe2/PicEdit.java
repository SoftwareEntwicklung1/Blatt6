import java.awt.Color;
public class PicEdit{

   public static double lum(Color a) {
       double b=a.getRed()*0.299+a.getGreen()*0.587+a.getBlue()*0.114;
       return b;
       
   }
   public static double averageLum(Picture a) {
       int w,h;
       double b=0;
       w=a.width();
       h=a.height();
       for(int i=0;i<w;i++){
           for(int j=0;j<h;j++){
            b=b+lum(get(i,j));
           }
        }
        b=b/w*h;
        return b;
    }
    public static Color changedColorSaturation(Color a,double change) {
        double l=lum(a);
        Color b=new Color(l+(a.getRed()-l)*change,l+(a.getGreen()-l)*change,l+(a.getBlue()-l)*change);
        return b;
    }
    public static void changeSaturation(Picture a,double change) {
        int w,h;
        w=a.width();
        h=a.height();
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                a.set(i,j,changedColorSaturation(get(i,j),change));
            }
         }
     }
     public static Picture rotatedLeft(Picture a) {
        int w,h;
        w=a.width();
        h=a.height();
        Picture b=new Picture(h,w);
        Colar[][] Array=new Colar[w][h];
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
              Array[i][j]=a.get(i,j);
            }
         }
         int g=0,k=0;
         for(int i=h;i>=0;i--){
            for(int j=0;j<w;j++){
             b.set(g, k, Array[j][i]);
             g++;
             if(g==w){g=0;}
            }
            k++;
         }
         return b;
         
     }
     public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        double a=averageLum(picture);
        System.out.println(a);
        double change;
        Picedit.changeSaturation(a,change);
        show();
        Picedit.rotatedLeft(a);
        show();
     }
}