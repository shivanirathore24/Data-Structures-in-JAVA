package chained_generics;

public class PairUse {
	 public static void main(String[] args){

		 Pair<String, Integer> pInner= new Pair<String, Integer>("abcd",100);
         Pair<Pair<String, Integer>, String> p= new Pair<>();
         p.setFirst(pInner);
         p.setSecond("Shiv");
         System.out.println(p.getFirst());
         System.out.println(p.getSecond());
         System.out.println(p.getFirst().getFirst());
         System.out.println(p.getFirst().getSecond());
	 }

}
