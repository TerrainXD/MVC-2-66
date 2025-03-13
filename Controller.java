import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        this.view.setSubmitListener(new SubmitListener());
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] songDetails = view.getSongDetails();
            int duration = Integer.parseInt(songDetails[1]);
            String[] singerArray = songDetails[2].split(",");
            List<String> singers = new ArrayList<>();
            for (String singer : singerArray) {
                singers.add(singer.trim());
            }
            int score = model.calculateScore(singers, duration);
            view.displayScore(score); 
        }
    }

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
    }
}
