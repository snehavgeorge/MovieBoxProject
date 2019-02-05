package com.movie;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MovieBox {



    private  String cn,mn,buydate;
    int movieType;

    public MovieBox(String cn, String mn, String buydate, int movieType) {
        this.cn = cn;
        this.mn = mn;
        this.buydate = buydate;
        this.movieType = movieType;
    }

    public String getCustomerName(){
        return this.cn;
    }

    public String getMobileNumber(){
        return this.mn;
    }

    public String getBuyDate(){
        return this.buydate;
    }

    public int getMovieType(){


        return this.movieType;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int user_choice = 0;
        ArrayList<MovieBox> customerDetails = new ArrayList <MovieBox>();
        String cname = null,bdate = null;
        int mtype = 0;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        double totalPrice = 0;

        do {
            System.out.println();
            System.out.println("1) Buy a new Movie");
            System.out.println("2) Return the Movie");
            System.out.println("3) Quit");
            System.out.println();
            System.out.print("Enter choice [1-3]: ");
            user_choice = s.nextInt();
            switch (user_choice) {
                case 1:
                    System.out.println("Enter customer name");
                    String cn = s.next();
                    System.out.println("Enter Mobile Number");
                    String mn = s.next();
                    System.out.println("Enter the Date(dd/MM/yyyy)");
                    String buydate = s.next();
                    System.out.println("Select Movie Type");

                    System.out.println("1) Regular Movie");
                    System.out.println("2) Children's Movie");
                    System.out.println("3) New releases Movie");
                    System.out.print("Enter choice [1-3]: ");
                    int movieType = s.nextInt();
                    MovieBox movieBOX = new MovieBox(cn, mn, buydate, movieType);
                    customerDetails.add(movieBOX);
                    if(movieType == 1){
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                    }

                    break;

                case 2:
                    System.out.println("Enter Mobile Number");
                    String mobile = s.next();
                    System.out.println("Enter the Date(dd/MM/yyyy)");
                    String returndate = s.next();
                    for (MovieBox t : customerDetails) {

                            cname = t.getCustomerName();
                            mtype = t.getMovieType();
                            bdate = t.getBuyDate();
                        if (t.getMobileNumber().equals(mobile)) {

                            System.out.println("Customer Name: " + t.getCustomerName() + "\nMobile Number: " + t.getMobileNumber() + "\nBuy Date: " + t.getBuyDate() + "\nMovie Type : " + t.getMovieType());
                            System.out.println();

                            //calculating the number of days
                            Date d1 = null;
                            Date d2 = null;
                            long diffDays = 0;
                            try {
                                d1 = format.parse(bdate);
                                d2 = format.parse(returndate);
                                long diff = d2.getTime() - d1.getTime();
                                diffDays = diff / (24 * 60 * 60 * 1000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            System.out.println("Number of days :" + diffDays);

                            //calculating the price
                            if (mtype == 1) {
                                if (diffDays > 2) {
                                    totalPrice = (2 * 2) + ((diffDays - 2) * 1.5);
                                } else {
                                    totalPrice = (2 * diffDays);
                                }
                            } else if (mtype == 2) {
                                totalPrice = 1.5 * diffDays;
                            } else if (mtype == 3) {
                                totalPrice = 3 * diffDays;
                            }

                            System.out.println("Hello " + cname + " Total Price is " + totalPrice);


                        }

                    }
                    break;

                case 3:
                    System.exit(0);
            }
        }
        while (user_choice != '4');

    }



}

