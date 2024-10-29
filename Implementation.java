import java.util.ArrayList;

public class Implementation{
    ArrayList<Integer>al=new ArrayList<>();
    public void add(int val){
        al.add(val);
        upheapfy(al.size()-1);
    }
    private void upheapfy(int ci){
        int pi=(ci-1)/2;
        if(al.get(pi)>al.get(ci)){
            swap(pi,ci);
            upheapfy(pi);
        }
    }
    public void swap(int i,int j){
        int ith=al.get(i);
        int jth=al.get(j);
        al.set(i,jth);
        al.set(j,ith);
    }
    public int size(){
        return al.size();
    }
    public int getMin(){
        return al.get(0);
    }
    public int remove(){
        swap(0,al.size()-1);
        int rv=al.remove(al.size()-1);
        downheafy(0);
        return rv;
    }
    private void downheafy(int pi){
        int ci1=2*pi+1;
        int ci2=2*pi+2;
        int mini=pi;
        if(ci1<al.size()&&al.get(mini)>al.get(ci1)){
            mini=ci1;
        }
        if(ci2<al.size()&&al.get(mini)>al.get(ci2)){
           mini=ci2;
        }
        if(mini!=pi){
            swap(pi,mini);
            downheafy(mini);  //add-log(n)  remove-log(n)
        }
    }
}