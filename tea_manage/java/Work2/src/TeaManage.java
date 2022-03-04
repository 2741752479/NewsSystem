import java.sql.*;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Date;
public class TeaManage {
   //public static Map<String,String> map=new HashMap<String,String>();//
    public static void main(String[] args) throws SQLException {
        System.out.println("按1录入产品信息");
        System.out.println("按2查询产品信息");
        System.out.println("按3购买产品信息");
        System.out.println("按0退出");
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        while(s!=0){
            switch (s){
                //录入信息
                case 1:{
                    System.out.println("请输入需要录入的商品个数");
                    int n=sc.nextInt();
                   /* for(int i=0;i<n;i++) {
                       // Big[] a = new Big[n];//创建大包装，以数组a[n]记录
                        //Small[] c = new Small[n * 10];//创建小包装，以数组c[10*n]记录
                        record(n,a);
                    }*/
                    record(n);
                    System.out.println("按1录入产品信息");
                    System.out.println("按2查询产品信息");
                    System.out.println("按3购买产品信息");
                    System.out.println("按0退出");
                    s=sc.nextInt();
                    break;
                }
                /*购买：*/
                case 2:{
                    System.out.println("输入你要买的商品编号");
                    String str=sc.nextLine();
                    boolean serb= Boolean.parseBoolean("select buy from small where id like"+str);//从数据库中找出商品是否卖出,将数据库中int变bool
                    if(serb) {
                        Date date = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        String t = formatter.format(date);//记录商品购买时间
                        String sql4 = "update small set time =" + t + "buy =" + 0 + "where id=" + str;//购买完商品后，更新数据库，增加购买时间，改变商品数量（变为0）
                    }
                    else {
                        System.out.println("商品已卖出");
                    }
                    System.out.println("按1录入产品信息");
                    System.out.println("按2查询产品信息");
                    System.out.println("按3购买产品信息");
                    System.out.println("按0退出");
                    s=sc.nextInt();
                    break;
                }
                //信息查询
                case 3:{
                    System.out.println("输入你要查询的商品编号");
                    String str=sc.nextLine();
                    String sql5="select *from relate  where small_id like"+str;//用relate表，根据小商品编号找到大商品编号,之后数据库操作输出
                    boolean serb= Boolean.parseBoolean("select buy from small where id like"+str);//判断数据库中小商品是否被卖出，被卖出就为false
                    if(!serb){
                        String sql6="select time from small where id like"+str;//如果被卖出，就从数据库找出购买时间,之后数据库操作输出
                    }
                    System.out.println("按1录入产品信息");
                    System.out.println("按2查询产品信息");
                    System.out.println("按3购买产品信息");
                    System.out.println("按0退出");
                    s=sc.nextInt();
                    break;
                }
            }
        }

    }
    public static void record(int n) /*throws SQLException*/ {
      /*  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb4", "root", "123456");
        Statement statement = connection.createStatement();
        //HashMap<String,Integer> hm= new HashMap<String,Integer>();*/
        String []b=new String[4];
        //System.out.println("");
        for(int i=0;i<n;i++) {
            System.out.println("请分别输入大包装的id,name,adress,produce");
            for(int j=0;j<4;j++){
                Scanner scanner=new Scanner(System.in);
                b[j]=scanner.nextLine();
            }
            Big a = new Big(b[0],b[1],b[2],b[3]);//对每个大包装赋值后，再使用数据库操作，存入大包装数据
            String sql = "insert into big(id, name, adress,produce)values(?, ?, ?, ?)";//此后在用数据库操作，将大商品存入数据库中
            /*PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
            preparedStatement1.setString(1,a[i].getId());
            preparedStatement1.setObject(2,a[i].getName());
            preparedStatement1.setObject(3,a[i].getAdress());
            preparedStatement1.setObject(4,a[i].getProduce());*/
            String bigsql="select id from big";//再从数据库中查找到大商品编号
            for(int k=0;k<10;k++){
                String smallsal= String.valueOf(System.currentTimeMillis()*100000+'0');//将得到的数据转成字符串.生成不重复的随机数：因为任何时刻与1970年的时间距离是唯一的
                String sql1="insert into small(id,buy) values("+smallsal+1+")";//将生成的小商品的编号存入数据库中small表。并让小商品数量为1
                String sql2="insert into relate(big_id,small_id) values("+bigsql+smallsal+")";//将大商品和小商品的编号存入relate表
            }
           /* statement.close();
            connection.close();*/
        }

    }
}
