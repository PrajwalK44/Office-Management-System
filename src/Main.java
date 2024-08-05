import Controller.Controller;
import Model.Model;
import View.View;

public class Main {
    public static void main(String[] args) {
        View v =new View();
        Model m =new Model();
        new Controller(m, v);
    }
}