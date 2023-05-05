import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// to do - repair that image shows in wrong order, and the last one usually is not full

public class ImagesDisplayer extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        NoobWebCrawler nwc = new NoobWebCrawler();
        Scanner inputOfUser = new Scanner(System.in);
        System.out.println("Type URL adress");
        String urlString = inputOfUser.nextLine();
//        String urlString = "https://kwejk.pl/przegladaj/3259227/0/galeria-ktora-moze-zrobi-ci-dzien.html";

        nwc.linkGenerate(urlString);
        HashSet<String> list =
                new HashSet<>(NoobWebCrawler.list);

        ArrayList<String> list2 = new ArrayList<>(list);

        Pane vbox = new VBox(20);
        Pane pane = new Pane();

        ScrollPane scroll = new ScrollPane();

        scroll.setContent(vbox);

        pane.getChildren().add(scroll);
        Scene scene = new Scene(pane);

        double width = 0;
        double height = 1000;


        for (int i = 0; i < list2.size(); i++)
        {
            if (list2.get(i).contains("jpg"))
            {
                Image image = new Image(list2.get(i));

                if (image.getHeight() > height)
                {
                    height = image.getHeight();
                    System.out.println(height);
                }
                if (image.getWidth() > width)
                {
                    width = image.getWidth();
                    System.out.println(width);
                }

                scroll.setPrefSize(width + 15, height - height / 5);
                vbox.getChildren().add(new ImageView(image));
            }
            if (list2.get(i).contains("mp4"))
            {
                Media media2 = new Media(list2.get(i));
                MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
//        mediaPlayer.setAutoPlay(true);
                MediaView mediaView2 = new MediaView(mediaPlayer2);
                if (width==0){
                width=800;}
                
//unknown code start

                Button playButton2 = new Button(">");
                playButton2.setOnAction(e ->
                {
                    if (playButton2.getText().equals(">"))
                    {
                        mediaPlayer2.play();
                        playButton2.setText("||");
                    } else
                    {
                        mediaPlayer2.pause();
                        playButton2.setText(">");
                    }
                });

                Button rewindButton2 = new Button("Repeat");
                rewindButton2.setOnAction(e -> mediaPlayer2.seek(Duration.ZERO));

                Slider slVolume2 = new Slider();
                slVolume2.setPrefWidth(150);
                slVolume2.setMaxWidth(Region.USE_PREF_SIZE);
                slVolume2.setMinWidth(30);
                slVolume2.setValue(50);
                mediaPlayer2.volumeProperty().bind(
                        slVolume2.valueProperty().divide(100));

//unknown code end
//        p1.setProgress(Duration.);

                HBox hBox2 = new HBox(10);
                hBox2.setAlignment(Pos.CENTER);
                hBox2.getChildren().addAll(playButton2, rewindButton2,
                        new Label("Volume"), slVolume2);

                vbox.getChildren().addAll(mediaView2, hBox2);
                scroll.setPrefSize(width + 15, height - height / 5);

            }

        }
        pane.getChildren().add(vbox);

        primaryStage.setTitle("Gallery Killer");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
