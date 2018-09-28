import java.util.Scanner;

/**
 * TODO: DESCRIBE YOUR PROJECT HERE
 * I am using this project for Text manipulation as per the
 * requirements of the user.
 *
 * @author Amrish Nayak, nayak6@purdue.edu
 * @version 02/09/18
 */
public class TextFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Print hello message
        System.out.println("Welcome to TextFilter!");

        // Value to keep track of if the user wants to keep filtering text
        boolean keepFiltering;

        do {
            // Print options for the user to select
            System.out.println("Please select one of the following filtering options: \n");
            System.out.println("1. Filter Word\n" +
                    "2. Find-And-Replace\n" +
                    "3. Censor Information");

            // Save their choice
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                // PART 1 - Censoring Words


                String passage = "";  // The text to be filtered
                System.out.println("Please enter the passage you would like filtered: ");

                // TODO: PART 1 - Ask the user for a passage to censor
                passage=scanner.nextLine();
                while (passage.isEmpty()){
                    passage=scanner.nextLine();
                }




                String word;  // The word to be censored from the text phrase
                System.out.println("Please enter the word you would like to censor: ");
                word=scanner.nextLine();
                while (word.isEmpty()){
                    word=scanner.nextLine();
                }

                // TODO: PART 1 - Ask the user for a word to censor






                System.out.println("Uncensored: ");
                System.out.println(passage);

                int m;
                m=word.length();
                int pasp=passage.length();
                StringBuilder sb= new StringBuilder(passage);
                String t=passage;
                String p="";
                for(int i=0;i<m;i++){
                    p=p+"X";
                }
                if (word.contains(" ")){
                    passage=passage.replaceAll(word,p);

                }
                else {
                    for (int i = 0; i < passage.length(); i++) {
                        if (passage.charAt(i) == ' ' || passage.charAt(i) == '!' || passage.charAt(i) == '?' || passage.charAt(i) == ',' || passage.charAt(i) == '.') {
                            if ((i-m)>=0) {


                                t = passage.substring((i - m), i);
                                if (t.equals(word)) {
                                    if((i-m)>0) {
                                        char ch = passage.charAt((i - m) - 1);
                                        if (!Character.isLetter(ch)) {
                                            sb = sb.replace((i - m), i, p);
                                            passage = sb.toString();
                                        }
                                    }else {
                                        sb = sb.replace((i - m), i, p);
                                        passage = sb.toString();
                                    }
                                }
                            }


                        }
                        if(passage.endsWith(word)){
                            sb=sb.replace((pasp-m),pasp,p);
                            passage=sb.toString();
                        }
                    }
                }

                // TODO: PART 1 - Implement your parsing here





                System.out.println("Censored: ");
                System.out.println(passage);


            } else if (choice == 2) {

                // PART 2 - Replacing Words


                String passage = "";  // The text to be filtered
                System.out.println("Please enter the passage you would like filtered: ");


                // TODO: PART 2 - Ask the user for a passage to filter
                passage=scanner.nextLine();
                while (passage.isEmpty()){
                    passage=scanner.nextLine();
                }



                String replace;  // The word to be filtered from the text phrase
                System.out.println("Please enter the word you would like to replace: ");

                //TODO: PART 2 - Ask the user for a word to replace
                replace=scanner.nextLine();
                while (replace.isEmpty()){
                    replace=scanner.nextLine();
                }


                String insert;  // The word to be inserted in the text phrase
                System.out.println("Please enter word you would like to insert: ");

                //TODO: PART 2 - Ask the user for a word to insert
                insert=scanner.nextLine();
                while (insert.isEmpty()){
                    insert=scanner.nextLine();
                }


                System.out.println("Uncensored: ");
                System.out.println(passage);

                int m;
                m=replace.length();
                int pasp=passage.length();
                StringBuilder sb= new StringBuilder(passage);
                String t=passage;
//                String p="";
//                for(int i=0;i<m;i++){
//                    p=p+"X";
//                }
                if (replace.contains(" ")){
                    passage=passage.replaceAll(replace,insert);

                }
                else {
                    for (int i = 0; i < passage.length(); i++) {
                        if (passage.charAt(i) == ' ' || passage.charAt(i) == '!' || passage.charAt(i) == '?' || passage.charAt(i) == ',' || passage.charAt(i) == '.') {
                           if((i-m)>=0) {
                               t = passage.substring((i - m), i);
                               if (t.equals(replace)) {
                                   sb = sb.replace((i - m), i, insert);
                                   passage = sb.toString();
                               }
                           }


                        }
                        if(passage.endsWith(replace)){
                            sb=sb.replace((pasp-m),pasp,insert);
                            passage=sb.toString();
                        }
                    }
                }


                // TODO: PART 2 - Implement your parsing here


                System.out.println("Censored: ");
                System.out.println(passage);



            } else if (choice == 3) {

                // PART 3 - Censoring Personal Information


                /*
                 * DO NOT ALTER THIS CODE! This formatting is imperative to the completion of this task.
                 *
                 * Keep asking for input until the user enters an empty line
                 * If they enter an empty line and the phrase is empty, keep waiting for input
                 */
                String passage = "";  // String for holding text to be filtered

                System.out.println("Please enter the phrase you would like to censor information from: ");

                while (true) {

                    // Obtain a line from the user
                    String temp = scanner.nextLine();

                    if (!passage.isEmpty() && temp.isEmpty()) {
                        //System.out.println("BREAK");
                        break;

                    } else if (passage.isEmpty() && temp.isEmpty()) {
                        //System.out.println("continue");
                        continue;

                    }


                    // Add the contents of temp into the phrase
                    passage += temp;


                    // Append a newline character to each line for parsing
                    // This will separate each line the user enters
                    // To understand how input is formatted in Part 3, please refer to the handout.
                    passage += '\n';
                }

                // Print the uncensored passage
                System.out.println("Uncensored: ");
                System.out.println(passage);



                // TODO: PART 3 - Implement your parsing here
                StringBuilder ts=new StringBuilder(passage);

                int m=0;
                int n=0;
                int ln=0;

                String tn=passage;
                while(true){
                if(tn.contains("Name:")) {
                    n = passage.indexOf("Name:", n);
                    n=n+7;
                    m= passage.indexOf('\n',n);
                    ln=tn.indexOf("Name: ",ln);
                    ln=ln+5;
                    tn = tn.substring(ln);
                    //System.out.println("N"+n);
                 if (n!=6) {
                     for (int i = n; i < m - 1; i++) {
                         char ch = passage.charAt(i);
                         if (ch != ' ') {
                             ts.setCharAt(i, '*');
                             passage = ts.toString();
                         }
                     }
                 }
                }
                else {
                    break;
                }


                }//while name
                boolean tf=true;
                int m1=0;
                int n2=0;
                int n3=0;
                int n4=0;
                String mt=passage;
                while(tf) {

                    if (mt.contains("Email:")) {
                         m1= passage.indexOf("Email:",m1);
                         m1=m1+8;

                         n2 = passage.indexOf('\n',m1);
                        n4=passage.lastIndexOf('.',n2);
                         n3 =mt.indexOf("Email:",n3);
                         n3=n3+1;
                         mt= mt.substring(n3);
                       // System.out.println(mt);
                    }
                    else {
                        tf=false;
                        break;
                    }
                   // System.out.println("E"+m1);
                    if(m1!=7){
                            for (int j = m1; j < n4; j++) {
                                if (passage.charAt(j) == '@') {
                                    j++;
                                } else {
                                    ts.setCharAt(j, '*');
                                    passage = ts.toString();

                                }
                            }
                    }

                    //System.out.println(passage);

                }//while email
                String abc=passage;
                int a=0;
                int b=0;
                int c=0;
                while(true) {
                    if (abc.contains("Phone:")) {
                        a = passage.indexOf("Phone: ",a);
                        a=a+7;
                        b=passage.indexOf('\n',a);
                        c=abc.indexOf("Phone: ", c);
                        c=c+1;
                        abc=abc.substring(c);

                       // System.out.println("P"+a);
                        if(a!=6) {
                            for (int k = a; k < b - 4; k++) {
                                if (passage.charAt(k) != '-') {
                                    ts.setCharAt(k, '*');
                                    passage = ts.toString();
                                }

                            }
                        }

                    }else {
                        break;
                    }
                }//while phone


                // Print the censored passage
                System.out.println("Censored: ");
                System.out.println(passage);

            } else {

                // They entered a number that was not 1, 2 or 3
                System.out.println("The option you chose was invalid!");

            }


            System.out.println("Would you like to keep filtering? Yes/No");

            // TODO: PART 4 - Update the value of keepGoing accordingly
           String ans;
           boolean keep;
           ans= scanner.nextLine();
           ans=ans.toLowerCase();
           while(ans.isEmpty()){
               ans= scanner.nextLine();
               ans=ans.toLowerCase();
           }
           if(ans.equals("yes")){
               keep=true;

           }
           else {
               keep=false;
           }


            // TODO: PART 4 - Replace the line below with your code
            keepFiltering = keep;

        } while (keepFiltering);

        System.out.println("Thank you for using TextFilter!");

    }

}

