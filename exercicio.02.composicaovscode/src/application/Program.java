package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        Comment c1 = new Comment("Tenha uma boa viajem");
        Comment c2 = new Comment("Aproveite");
        Post p1 = new Post(sdf.parse("11/03/2025 09:53:44"), "Viajem á Nova Zelandia", "Vou visitar esse país maravilhoso", 12);

        p1.addComment(c1);
        p1.addComment(c2);

        //Post numero 2
        Comment c3 = new Comment("Boa viajem");
        Comment c4 = new Comment("Poxa!!,, que legal que esta indo!");
        Post p2 = new Post(sdf.parse("20/12/2025 20:00:55"), "Viajando para New York", "Vou Realizar um sonho de infancia", 50);

        p2.addComment(c3);
        p2.addComment(c4);

        System.out.println(p1);
        System.out.println();
        System.out.println(p2);
        
    }
}
