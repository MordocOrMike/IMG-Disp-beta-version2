public class LinkCutter
{
    public static void main(String[] args)
    {
        String link = "https://kwejk.pl/przegladaj/3259227/20/galeria-ktora-moze-zrobi-ci-dzien.html";
//        link = link.replace("/" + 6 + "/", "/" + 150 + "/");
//        System.out.println(link);


        int startIndeks = 0;
        int numIndex = 0;
        int endIndex = 0;

        char openingtSlash = ' ';
        char pageNumber = ' ';
        char closingSlash = ' ';
        String pageNumberString = "0";
        System.out.println(link+" link1");

        for (int i = 0; i < link.length(); i++)
        {
//            openingtSlash = link.charAt(i);
//            pageNumber = link.charAt(i + 1);
//            closingSlash = link.charAt(i + 1);

//            if (openingtSlash == '/' && closingSlash == '/' && Character.isDigit(pageNumber))
//            {
//                startIndeks = i;
//                numIndex = i + 1;
//                endIndex = i + 2;
//                pageNumberString=pageNumber+"";
//
//                break;
//            }

            if (link.charAt(i) == '/' && link.charAt(i + 2) == '/' && Character.isDigit(link.charAt(i + 1)))
            {
//                startIndeks = i;
//                numIndex = i + 1;
//                endIndex = i + 2;
//                pageNumberString=pageNumber+"";
                link = link.replace("/" + link.charAt(i + 1) + "/", "/" + 0 + "/");
                System.out.println(link + " 20 cos");

                break;
            }
        }

//        System.out.println(startIndeks);
//        System.out.println(numIndex);
//        System.out.println(endIndex);
        System.out.println(link +" link 2");
//
//        System.out.println(openingtSlash + "" + pageNumber + closingSlash);
//        String leftPartOfLink = link.substring(0, numIndex);
//        String rightPartOfLink = link.substring(numIndex + 1);
//
//        System.out.println(leftPartOfLink);
//        System.out.println(rightPartOfLink);
//
//        for (int i = 0; i < 20; i++)
//        {
//           link = link.replace("/" + pageNumberString + "/", "/" + i + "/");
//            pageNumberString = i+"";
//            System.out.println(link);
//        }

    }
}
