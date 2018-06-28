/**
 * Created by kunqi on 6/28/18.
 */
public class GenericClass<T> {
    private T generic;

    public GenericClass(T gn){
        this.generic = gn;
    }

    public static void main(String[] args){
        GenericClass gene = new GenericClass(1);
        System.out.println(gene.generic);
    }

}
