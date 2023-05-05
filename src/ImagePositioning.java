import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ImagePositioning extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Image image = new Image("https://i1.kwejk.pl/k/obrazki/2018/09/9qqn9ibkzQ8sJF3u.jpg");
        ImageView imV = new ImageView(image);
        imV.setX(250);

        Pane pane = new Pane();
        pane.getChildren().add(imV);
        Scene scene = new Scene(pane,1000,1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
