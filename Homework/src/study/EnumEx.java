package study;

import java.util.ArrayList;

public class EnumEx {

   // κΈ°μ‘΄? ??λ₯? ? ??? λ°©λ²
   public static final String MALE = "MALE";
   public static final String FEMALE = "FEMALE";

   public static void main(String[] args) {
//    String gender1;
//      
//     gender1 = EnumExample.MALE;
//     gender1 = EnumExample.FEMALE;
//
//     //MALE, FEMALE?΄ ?? ?? κ°μ΄ ? ?Ή ?  ? 
//     //μ»΄ν?Ό? ??¬κ°? ?μ§? ??. -> λ¬Έμ ?  λ°μ.
//     gender1 = "boy";
      Gender1 gender1 = Gender1.MALE;
      Gender2 gender2 = Gender2.MALE;
      ArrayList <Object> a = new ArrayList<Object>();
      a.add(gender1);
      a.add(gender2);
      System.out.println(0);
      gender1 = Gender1.MALE;
      gender1.setColor("brown");
      System.out.println(gender1.color);
      System.out.println(1);
      // gender2 = Gender.FEMALE;
      System.out.println(2);
      // System.out.println(gen1der2);
      System.out.println(a.get(0) instanceof Gender1);
      System.out.println(a.get(1) instanceof Gender1);
      System.out.println(gender1.color);
      System.out.println(gender1.a);
      // μ»΄ν?Ό ? ???μ§? ?? ?? κ°μ μ²΄ν¬?  ? ??.
      // Enum?Όλ‘? ? ?? ??κ°λ§ ? ?Ή λ°μ ? ??.
      // gender2 = "boy";
   }

   enum Gender1 {
      MALE("red", 3), FEMALE("blue", 4);

      public String color;
      int a;

      Gender1(String color, int a) {
         System.out.println("Call Constructor " + this);
         this.a = a;
         this.color = color;
      }

      public String getColor() {
         return color;
      }

      public void setColor(String color) {
         this.color = color;
      }

   }

   enum Gender2 {
      MALE("purple", 3), FEMALE("black", 4);

      
      public String color;
      int a;

      Gender2(String color, int a) {
         System.out.println("Call Constructor " + this);
         this.a = a;
         this.color = color;
      }
      
      public String getColor() {
         return color;
      }

      public void setColor(String color) {
         this.color = color;
      }
      
   }
}
//enum classλ₯? ?΄?©?΄ Gender?Ό? ?λ‘μ΄ ???€? ???? ? ???€.