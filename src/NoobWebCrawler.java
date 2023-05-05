import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

//git doesnt cooperate!
public class NoobWebCrawler
{
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
//        Scanner inputOfUser = new Scanner(System.in);
//        System.out.println("Type URL adress");
//        String urlString = inputOfUser.nextLine();
        String urlString = "https://kwejk.pl/przegladaj/3259227/0/galeria-ktora-moze-zrobi-ci-dzien.html";
        String example ="https://i1.kwejk.pl/k/obrazki";

        // this part of code change part '/number/' into '/0/', but presently works only for digits (0-9)
        //to do - transform into method and develop to works with higher value than 9
        for (int i = 0; i < urlString.length(); i++)
        {
            if (urlString.charAt(i) == '/' && urlString.charAt(i + 2) == '/' && Character.isDigit(urlString.charAt(i + 1)))
            {
                urlString = urlString.replace("/" + urlString.charAt(i + 1) + "/", "/" + "0" + "/");
                break;
            }
        }


//        HashSet<String> listWithoutDuplicate = new HashSet<>();
// hashset nie uwzglednia duplikatow
        int counterOfPages = 0;
        boolean switcher = true;

        while (switcher)
        {


            try
            {
                URL url = new URL(urlString);
                Scanner input = new Scanner(url.openStream());
                int current = 0;
                while (input.hasNext())
                {
                    String line = input.nextLine();
                    current = line.indexOf("https://i1.kwejk.pl/k/obrazki", current); //if searched phase exist in line, then current = index of phrase begin, if not - current = -1
//
                    while (current > 0)
                    {
//https://i1.kwejk.pl/k/obrazki/2018/09/CByMuzwCnomkh9oc.mp4
                        int endIndex = line.indexOf("\"", current); //start with current, end with ", cause every link end with "
                        if (endIndex > 0 && !line.contains("thumb") && !line.contains("jpg?") && !line.contains("mobile") )
                        {

                            list.add(line.substring(current, endIndex));
                            current = line.indexOf("http:", endIndex);

                        } else
                            current = -1;
                    }
                }
            } catch (Exception ex)
            {
                switcher = false;
                System.out.println("Fail: " + ex.getMessage());
            }


            urlString = urlString.replace("/" + counterOfPages + "/", "/" + (++counterOfPages) + "/");

        }

        HashSet<String> list2 =
                new HashSet<>(list);

        System.out.println(list2.toString());

//        for (int i = 0; i < list2.size(); i++)
//        {
//            System.out.println(list2.get(i));
//        }

    }

    HashSet<String> removeDuplicatesFromList(ArrayList<String> arrayList)
    {
        HashSet<String> hashSet =
                new HashSet<>(arrayList);

        return hashSet;
    }
    void linkGenerate(String urlString)
    {
        int counterOfPages = 0;
        boolean switcher = true;

        while (switcher)
        {


            try
            {
                URL url = new URL(urlString);
                Scanner input = new Scanner(url.openStream());
                int current = 0;
                while (input.hasNext())
                {
                    String line = input.nextLine();
                    current = line.indexOf("https://i1.kwejk.pl/k/obrazki", current); //if searched phase exist in line, then current = index of phrase begin, if not - current = -1
//
                    while (current > 0)
                    {
//
                        int endIndex = line.indexOf("\"", current); //start with current, end with ", cause every link end with "
                        if (endIndex > 0 && !line.contains("thumb") && !line.contains("jpg?") && !line.contains("mobile") && (line.contains("jpg")||line.contains("mp4")))
                        {

                            list.add(line.substring(current, endIndex));
                            current = line.indexOf("http:", endIndex);

                        } else
                            current = -1;
                    }
                }
            } catch (Exception ex)
            {
                switcher = false;

            }


            urlString = urlString.replace("/" + counterOfPages + "/", "/" + (++counterOfPages) + "/");

        }


    }

}
