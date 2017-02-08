import java.util.*;
import java.lang.Math.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class Person 
{
public int id,borr,ss,i,order_no_of_copies,aflag,ndr;
int countb = 0,countb1=0;
String booksearch,name,orderbookname;
public String [] bname={"C","C++","java","C#","python","ruby","VB"};
public int[] no_of_copies={20,18,15,11,10,9,10};
//private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//public String [] orderbookname=new String[50];
//public int [] order_no_of_copies=new int[50];

public void getdata()
{
Scanner s=new Scanner(System.in);
System.out.println("Enter (1)student/(2)staff");
ss=s.nextInt();
Scanner q=new Scanner(System.in);
System.out.println("Enter id");
id=q.nextInt();
Scanner sss=new Scanner(System.in);
System.out.println("Enter name");
name=sss.nextLine();

}
public int search()
{
Scanner s=new Scanner(System.in);
    System.out.println("enter the book you need");
    booksearch= s.nextLine();
    for(i=0;i<7;i++)
    {
    if ((booksearch.equalsIgnoreCase(bname[i])))
        {
    if((no_of_copies[i] > 0))
    {
    System.out.println (" book available in library");
    aflag=i;
    break;
    }
    else
    {
    System.out.println("book taken by others.So curently not available");
    aflag=i+10;
    break;
    }
        }
       
    }
    if(i==7)
{
    System.out.println("book not available in library");
        System.out.println("we will order and u will get the book in a week");
        orderbookname=booksearch;
        System.out.println("Enter no of copies needed");
        Scanner scan=new Scanner(System.in);
        order_no_of_copies=scan.nextInt();
        System.out.println("Order placed:Book name"+orderbookname);
        System.out.println("no of copies"+order_no_of_copies);  
        return 99;
}
return aflag;
}
public Date borrow()
{   
switch(ss)
{
case 1:
String s = "only three books can be borrowed as a STUDENT";
    System.out.println(s);
    
    int j=search();
     if (j<7)
        {
            for (int i = 0; i < 7; i++)
            {
                if ((booksearch.equalsIgnoreCase(bname[i])) && (no_of_copies[i] > 0))
                {
                if(countb<3)
                {
                System.out.println("book can b borrowed");
                    no_of_copies[i] = no_of_copies[i] - 1;
                    countb++;
                    System.out.println("no of copies remaining is"+ no_of_copies[i]);
                    
                    System.out.println("Book issued on");
                    dmy();
                     
                   
                       System.out.println("enter1 to continue");
                        Scanner qa=new Scanner(System.in);
                        int borr=qa.nextInt();
                        if(borr==1)
                        {
                         Date ddd=borrow();
                       }
                    else
                    {
                         break;
                    }
                    /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date1 = new Date();
                    System.out.println(dateFormat.format(date1));
                    return date1;*/
                }
                else
                {
                       System.out.println("only three books can b borrowed,id full");
                       
                    }
                
               }
            
        }    
    }
   
    break;
case 2:
String s1 = "4 books can be borrowed as STAFF";
    System.out.println(s1);
    
    int k=search();
    
     if (k<7)
        {
            for (int i = 0; i < 7; i++)
            {
               if ((booksearch.equalsIgnoreCase(bname[i])) && (no_of_copies[i] > 0))
               {
                if(countb1<4)
                {
                System.out.println("book can b borrowed");
                    no_of_copies[i] = no_of_copies[i] - 1;
                    countb1++;
                    System.out.println("no of copies remaining is"+ no_of_copies[i]);
                    
                    System.out.println("Book issued on");
                    dmy();
                  
                       System.out.println("enter1 to continue");
                        Scanner qq=new Scanner(System.in);
                        
                        int borr=qq.nextInt();
                       if(borr==1)
                       {
                         Date ddd=borrow();
                       }
                       else
                       {
                        break;
                       }
                    /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date1 = new Date();
                    System.out.println(dateFormat.format(date1));
                    return date1;*/
                }
                else
                {
                      System.out.println("4 books can b borrowed,id full");
                    }
                
                }
            
        }    
    }
   
    break;
    default:
    System.out.println("Invalid");
    }
return null;
}
Date dmy()
{
DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date1 = new Date();
    System.out.println(dateFormat.format(date1));
    return date1;
}

void renew(String renewal){
for (int i = 0; i <7; i++)
    {
if (renewal.equalsIgnoreCase(bname[i]))
{
    Date tody=dmy();
    
DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

   //Calendar c =Calendar.getInstance(); 
    System.out.println("enter no of days aftr taking book");
    Scanner scb=new Scanner(System.in);
    ndr=scb.nextInt();
    /*c.add(Calendar.DATE,ndr);
    System.out.println(dateFormat.format(c.getTime()));*/

Date today=new Date();
long ltime=today.getTime()+5*24*60*60*1000;
Date today8=new Date(ltime);
System.out.println("ur renewal date:");
System.out.println(today8);

        int dif=ndr*2;
    System.out.println("Fine is $");
    System.out.println(dif);
    break;
}
if(i==7)
{
System.out.println("error");
int dif=0;
}
}

}
   
void returnbook()
{
System.out.println("Enter book to return");
Scanner sq=new Scanner(System.in);
String rebook=sq.nextLine();
for (int i = 0; i < 6; i++)
{
if (rebook.equals(bname[i]))
{
renew(rebook);
System.out.print("Book returned on");
Date ret=dmy();
System.out.println(ret);
no_of_copies[i]= no_of_copies[i]+1;
}
if(i==7)
{System.out.println("error");
}
}
}







//Libmain.java:



/**
* @param args
*/
public static void main(String[] args) {
// TODO Auto-generated method stub
Person p=new Person();
int choice;
do{
        Scanner sm=new Scanner(System.in);
         System.out.println("enter work in lib");
         System.out.println("1.search 2.borrow 3.renew 4.return");
          choice=sm.nextInt();

          switch(choice)
         {
          case 1:
         System.out.println("book search");
        p.getdata();
p.search();
          break;

          case 2:
         System.out.println("borrow book");
         p.getdata();
       Date datt=p.borrow();
          break;

         case 3:
         System.out.println("renew book");
         p.getdata();
System.out.println("enter book to renew");
Scanner bbb=new Scanner(System.in);
String renewal=bbb.nextLine();
p.renew(renewal);
          break;
  
       case 4:
        System.out.println("return book");
        p.getdata();
p.returnbook();
         break;
}
}while(choice<5);
}

}